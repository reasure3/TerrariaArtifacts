package com.reasure.terrartifacts.client.handler

import com.reasure.terrartifacts.ServerModConfig
import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.client.data.ClientHasInfoItemData
import com.reasure.terrartifacts.data.ModDataMaps
import com.reasure.terrartifacts.item.accessories.informational.InfoType
import com.reasure.terrartifacts.item.accessories.informational.WatchType
import com.reasure.terrartifacts.util.LevelUtil.getNearbyEntityCount
import com.reasure.terrartifacts.util.LevelUtil.getPrecipitationAt
import com.reasure.terrartifacts.util.TimeUtil
import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.ChatFormatting
import net.minecraft.client.player.LocalPlayer
import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import net.minecraft.network.chat.Style
import net.minecraft.util.Mth
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.monster.Enemy
import net.minecraft.world.level.Level
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.AABB
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference

object InfoComponentHandler {
    val ICON = Style.EMPTY.withFont(Terrartifacts.modLoc("terraria"))

    private var killCountComponent: Component = defaultKillCountComponent()

    fun reset() {
        killCountComponent = defaultKillCountComponent()
    }

    fun getTimeComponent(level: Level, type: WatchType): Component {
        val formattedTime = TimeUtil.formatTime(level.dayTime, type)
        val amPmComponent =
            if (TimeUtil.isMorning(level.dayTime))
                Component.translatable(TranslationKeys.TIME_MORNING)
            else
                Component.translatable(TranslationKeys.TIME_AFTERNOON)
        return Component.translatable(TranslationKeys.INFO_TIME, amPmComponent, formattedTime).withIcon()
    }

    fun getWeatherComponent(level: Level, pos: BlockPos): Component {
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

    fun getFishingPowerComponent(player: LocalPlayer): Component {
        val luck = player.attributes.getValue(Attributes.LUCK)
        return Component.translatable(
            TranslationKeys.INFO_FISHING_POWER,
            String.format("%.1f", luck)
        ).withIcon()
    }

    fun getPositionComponent(player: LocalPlayer): Component {
        return Component.translatable(
            TranslationKeys.INFO_POSITION,
            player.blockX,
            player.blockZ
        ).withIcon()
    }

    fun getDepthComponent(player: LocalPlayer): Component {
        return Component.translatable(
            TranslationKeys.INFO_DEPTH,
            player.blockY
        ).withIcon()
    }

    fun getEnemyCountComponent(player: LocalPlayer): Component {
        val distance = ServerModConfig.SERVER.radarDetectDistance
        val count = player.getNearbyEntityCount(distance) { entity ->
            entity is Enemy
        }
        if (count == 0) return Component.translatable(TranslationKeys.INFO_NO_ENEMY_COUNT).disabled()
        return Component.translatable(TranslationKeys.INFO_ENEMY_COUNT, count).withIcon()
    }

    fun updateKillCountComponent(targetName: Component, kill: Int) {
        killCountComponent = Component.translatable(TranslationKeys.INFO_KILL_COUNT, targetName, kill).withIcon()
    }

    fun getMoonPhaseComponent(level: Level): Component {
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

    fun getMovementSpeedComponent(player: LocalPlayer): Component {
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

    fun getTreasureComponent(level: Level, pos: BlockPos): Component {
        val maxRare = AtomicInteger(0)
        val detectedBlockState = AtomicReference<BlockState>(Blocks.AIR.defaultBlockState())
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
        if (!detectedBlock.`is`(Blocks.AIR)) {
            return Component.translatable(TranslationKeys.INFO_TREASURE, detectedBlock.block.name).withIcon()
        }
        return Component.translatable(TranslationKeys.INFO_NO_TREASURE).disabled()
    }

    private fun defaultKillCountComponent() = Component.translatable(TranslationKeys.INFO_NO_KILL_COUNT).disabled()

    private fun MutableComponent.withIcon(): MutableComponent = withStyle(ICON)
    private fun MutableComponent.withGray(): MutableComponent = withStyle(ChatFormatting.GRAY)
    private fun MutableComponent.disabled(): MutableComponent = withIcon().withGray()

    operator fun get(type: InfoType, player: LocalPlayer): Component = when (type) {
        InfoType.TIME -> getTimeComponent(player.level(), ClientHasInfoItemData.displayTimeType())
        InfoType.WEATHER -> getWeatherComponent(player.level(), player.onPos)
        InfoType.FISHING_POWER -> getFishingPowerComponent(player)
        InfoType.POSITION -> getPositionComponent(player)
        InfoType.DEPTH -> getDepthComponent(player)
        InfoType.ENEMY_COUNT -> getEnemyCountComponent(player)
        InfoType.KILL_COUNT -> killCountComponent
        InfoType.MOON_PHASE -> getMoonPhaseComponent(player.level())
        InfoType.MOVEMENT_SPEED -> getMovementSpeedComponent(player)
        InfoType.TREASURE -> getTreasureComponent(player.level(), player.onPos)
    }
}