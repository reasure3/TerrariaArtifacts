package com.reasure.terrartifacts.client.handler

import com.reasure.terrartifacts.ServerModConfig
import com.reasure.terrartifacts.client.data.ClientDamageTracker
import com.reasure.terrartifacts.client.data.ClientHasInfoItemData
import com.reasure.terrartifacts.client.data.ClientShowInfoData
import com.reasure.terrartifacts.data.datamap.ModDataMaps
import com.reasure.terrartifacts.item.accessories.informational.InfoType
import com.reasure.terrartifacts.item.accessories.informational.WatchType
import com.reasure.terrartifacts.util.ComponentUtil.disabled
import com.reasure.terrartifacts.util.ComponentUtil.withGray
import com.reasure.terrartifacts.util.ComponentUtil.withIcon
import com.reasure.terrartifacts.util.LevelUtil.getNearbyEntityCount
import com.reasure.terrartifacts.util.LevelUtil.getPrecipitationAt
import com.reasure.terrartifacts.util.TimeUtil
import com.reasure.terrartifacts.util.TranslationKeys
import kotlinx.coroutines.CoroutineScope
import net.minecraft.client.player.LocalPlayer
import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.util.Mth
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.monster.Enemy
import net.minecraft.world.level.Level
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.phys.AABB
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference

object InfoComponentHandler {
    private val noEnemyCountComponent: Component =
        Component.translatable(TranslationKeys.INFO_NO_ENEMY_COUNT).disabled()

    private val defaultKillCountComponent: Component =
        Component.translatable(TranslationKeys.INFO_NO_KILL_COUNT).disabled()

    private val noTreasureComponent: Component =
        Component.translatable(TranslationKeys.INFO_NO_TREASURE).disabled()

    private val noRareCreatureComponent: Component =
        Component.translatable(TranslationKeys.INFO_NO_RARE_CREATURE).disabled()

    private var killCountComponent: Component = defaultKillCountComponent

    private var enemyCountComponent: Component = noEnemyCountComponent

    private var treasureComponent: Component = noTreasureComponent

    private var rareCreatureComponent: Component = noRareCreatureComponent


    fun reset() {
        killCountComponent = defaultKillCountComponent
        enemyCountComponent = noEnemyCountComponent
        treasureComponent = noTreasureComponent
        rareCreatureComponent = noRareCreatureComponent
    }

    private fun getTimeComponent(level: Level, type: WatchType): Component {
        val formattedTime = TimeUtil.formatTime(level.dayTime, type)
        val amPmComponent =
            if (TimeUtil.isMorning(level.dayTime))
                Component.translatable(TranslationKeys.TIME_MORNING)
            else
                Component.translatable(TranslationKeys.TIME_AFTERNOON)
        return Component.translatable(TranslationKeys.INFO_TIME, amPmComponent, formattedTime).withIcon()
    }

    private fun getWeatherComponent(level: Level, pos: BlockPos): Component {
        val weather = if (level.isThundering) {
            when (level.getPrecipitationAt(pos)) {
                Biome.Precipitation.NONE -> Component.translatable(TranslationKeys.WEATHER_CLEAR)
                Biome.Precipitation.RAIN -> Component.translatable(TranslationKeys.WEATHER_THUNDER)
                Biome.Precipitation.SNOW -> Component.translatable(TranslationKeys.WEATHER_THUNDER)
            }
        } else if (level.isRaining) {
            when (level.getPrecipitationAt(pos)) {
                Biome.Precipitation.NONE -> Component.translatable(TranslationKeys.WEATHER_CLEAR)
                Biome.Precipitation.RAIN -> Component.translatable(TranslationKeys.WEATHER_RAIN)
                Biome.Precipitation.SNOW -> Component.translatable(TranslationKeys.WEATHER_SNOW)
            }
        } else if (level.dimension() == Level.OVERWORLD) Component.translatable(TranslationKeys.WEATHER_CLEAR)
        else Component.translatable(TranslationKeys.WEATHER_CLOUDY)

        return Component.translatable(
            TranslationKeys.INFO_WEATHER,
            weather,
            (level.rainLevel * 100).toInt(),
            (level.thunderLevel * 100).toInt()
        ).withIcon()
    }

    private fun getFishingPowerComponent(player: LocalPlayer): Component {
        val luck = player.attributes.getValue(Attributes.LUCK)
        return Component.translatable(
            TranslationKeys.INFO_FISHING_POWER,
            String.format("%.1f", luck)
        ).withIcon()
    }

    private fun getPositionComponent(player: LocalPlayer): Component {
        return Component.translatable(
            TranslationKeys.INFO_POSITION,
            player.blockX,
            player.blockZ
        ).withIcon()
    }

    private fun getDepthComponent(player: LocalPlayer): Component {
        return Component.translatable(
            TranslationKeys.INFO_DEPTH,
            player.blockY
        ).withIcon()
    }

    private fun updateEnemyCountComponent(player: LocalPlayer) {
        val distance = ServerModConfig.SERVER.radarDetectDistance
        val count = player.getNearbyEntityCount(distance) { entity ->
            entity is Enemy
        }
        enemyCountComponent = if (count == 0) noEnemyCountComponent
        else Component.translatable(TranslationKeys.INFO_ENEMY_COUNT, count).withIcon()
    }

    fun updateKillCountComponent(targetName: Component, kill: Int) {
        killCountComponent = Component.translatable(TranslationKeys.INFO_KILL_COUNT, targetName, kill).withIcon()
    }

    private fun getMoonPhaseComponent(level: Level): Component {
        if (level.dimensionType().natural) {
            val phase = ((level.dayTime / 24000) % 8).toInt()
            return when (phase) {
                0 -> Component.translatable(TranslationKeys.INFO_MOON_PHASE_FULL_MOON)
                1 -> Component.translatable(TranslationKeys.INFO_MOON_PHASE_WANING_GIBBOUS)
                2 -> Component.translatable(TranslationKeys.INFO_MOON_PHASE_LAST_QUARTER)
                3 -> Component.translatable(TranslationKeys.INFO_MOON_PHASE_WANING_CRESCENT)
                4 -> Component.translatable(TranslationKeys.INFO_MOON_PHASE_NEW_MOON)
                5 -> Component.translatable(TranslationKeys.INFO_MOON_PHASE_WAXING_CRESCENT)
                6 -> Component.translatable(TranslationKeys.INFO_MOON_PHASE_FIRST_QUARTER)
                7 -> Component.translatable(TranslationKeys.INFO_MOON_PHASE_WAXING_GIBBOUS)
                else -> Component.translatable(TranslationKeys.INFO_NO_MOON_PHASE).withGray()
            }.withIcon()
        }

        return when (level.dimension()) {
            Level.NETHER -> Component.translatable(TranslationKeys.INFO_NETHER_MOON_PHASE)
            Level.END -> Component.translatable(TranslationKeys.INFO_END_MOON_PHASE)
            else -> Component.translatable(TranslationKeys.INFO_NO_MOON_PHASE)
        }.disabled()
    }

    private fun getMovementSpeedComponent(player: LocalPlayer): Component {
        val speed = (Mth.length(
            player.x - player.xOld,
            player.y - player.yOld,
            player.z - player.zOld
        ) * 20).toInt()
        return Component.translatable(TranslationKeys.INFO_MOVEMENT_SPEED, speed).apply {
            if (speed == 0) disabled()
            else withIcon()
        }
    }

    private fun updateTreasureComponent(level: Level, pos: BlockPos) {
        val maxRare = AtomicInteger(-1)
        val detectedBlockState = AtomicReference(Blocks.AIR.defaultBlockState())
        val distance = ServerModConfig.SERVER.treasureDetectDistance
        level.getBlockStates(
            AABB(
                pos.x - distance, pos.y - distance, pos.z - distance,
                pos.x + distance, pos.y + distance, pos.z + distance
            )
        ).forEach { block ->
            val data = block.blockHolder.getData(ModDataMaps.RARE_BLOCK_DATA) ?: return@forEach
            if (data.value > maxRare.get()) {
                maxRare.set(data.value)
                detectedBlockState.set(block)
            }
        }
        val detectedBlock = detectedBlockState.get()
        treasureComponent = if (maxRare.get() == -1) {
            noTreasureComponent
        } else {
            Component.translatable(TranslationKeys.INFO_TREASURE, detectedBlock.block.name).withIcon()
        }
    }

    private fun updateRareCreatureComponent(player: LocalPlayer, pos: BlockPos) {
        val maxRare = AtomicInteger(-1)
        val detectedCreature = AtomicReference<Entity>()
        val distance = ServerModConfig.SERVER.rareCreatureDetectDistance
        player.level().getEntities(
            player, AABB(
                pos.x - distance, pos.y - distance, pos.z - distance,
                pos.x + distance, pos.y + distance, pos.z + distance
            )
        ) { entity ->
            entity is LivingEntity
        }.forEach { entity ->
            @Suppress("DEPRECATION")
            val data = entity.type.builtInRegistryHolder().getData(ModDataMaps.RARE_ENTITY_DATA) ?: return@forEach
            if (data.rarity > maxRare.get()) {
                maxRare.set(data.rarity)
                detectedCreature.set(entity)
            }
        }
        rareCreatureComponent = if (maxRare.get() == -1) noRareCreatureComponent
        else Component.translatable(TranslationKeys.INFO_RARE_CREATURE, detectedCreature.get().name).withIcon()
    }

    private fun getDpsComponent(): Component {
        val dps = ClientDamageTracker.dps
        return if (dps < 0.0001f) Component.translatable(TranslationKeys.INFO_NO_DPS).disabled()
        else Component.translatable(TranslationKeys.INFO_DPS, String.format("%.1f", dps)).withIcon()
    }

    fun updateHugeInfoComponent(player: LocalPlayer) {
        launchFindInfo(InfoType.ENEMY_COUNT) {
            updateEnemyCountComponent(player)
        }
        launchFindInfo(InfoType.TREASURE) {
            updateTreasureComponent(player.level(), player.onPos)
        }
        launchFindInfo(InfoType.RARE_CREATURE) {
            updateRareCreatureComponent(player, player.onPos)
        }
    }

    private fun canDisplay(type: InfoType) = ClientShowInfoData[type] && ClientHasInfoItemData[type]
    private fun launchFindInfo(type: InfoType, block: suspend CoroutineScope.() -> Unit) {
        if (canDisplay(type)) CoroutineHandler.launchWithPool(type.serializedName, block)
    }

    operator fun get(type: InfoType, player: LocalPlayer): Component = when (type) {
        InfoType.TIME -> getTimeComponent(player.level(), ClientHasInfoItemData.displayTimeType())
        InfoType.WEATHER -> getWeatherComponent(player.level(), player.onPos)
        InfoType.FISHING_POWER -> getFishingPowerComponent(player)
        InfoType.POSITION -> getPositionComponent(player)
        InfoType.DEPTH -> getDepthComponent(player)
        InfoType.ENEMY_COUNT -> enemyCountComponent
        InfoType.KILL_COUNT -> killCountComponent
        InfoType.MOON_PHASE -> getMoonPhaseComponent(player.level())
        InfoType.MOVEMENT_SPEED -> getMovementSpeedComponent(player)
        InfoType.TREASURE -> treasureComponent
        InfoType.RARE_CREATURE -> rareCreatureComponent
        InfoType.DPS -> getDpsComponent()
    }
}