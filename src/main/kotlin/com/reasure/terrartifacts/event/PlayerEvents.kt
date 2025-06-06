package com.reasure.terrartifacts.event

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.data.DataHandler
import com.reasure.terrartifacts.data.attachment.ModDataAttachments
import com.reasure.terrartifacts.data.attachment.ShowInfoData
import com.reasure.terrartifacts.item.component.ModDataComponents
import com.reasure.terrartifacts.network.DataSenderS2C
import net.minecraft.network.chat.Component
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.TooltipFlag
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.attachment.AttachmentType
import net.neoforged.neoforge.common.util.FakePlayer
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent
import net.neoforged.neoforge.event.entity.player.PlayerEvent
import net.neoforged.neoforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent
import java.util.*
import kotlin.math.max

@Suppress("unused")
@EventBusSubscriber(modid = Terrartifacts.ID, bus = EventBusSubscriber.Bus.GAME)
object PlayerEvents {
    @SubscribeEvent
    fun onPlayerLogin(event: PlayerLoggedInEvent) {
        val player = event.entity
        println("PlayerLoggedInEvent: $player")
        if (player is ServerPlayer && player !is FakePlayer) {
            DataSenderS2C.sendShowInfo(player)
        }
    }

    @SubscribeEvent
    fun onPlayerDeath(event: PlayerEvent.Clone) {
        if (event.isWasDeath) {
            copyToNewEntity(ModDataAttachments.SHOW_INFO, event.original, event.entity, ShowInfoData::copy)
            copyToNewEntity(
                ModDataAttachments.PLAYER_KILL_COUNT,
                event.original,
                event.entity,
                Map<UUID, Int>::toMutableMap
            )
        }
    }

    private fun <T> copyToNewEntity(
        dataType: AttachmentType<T>,
        original: Entity,
        newEntity: Entity,
        copyFunction: (T) -> T = { old -> old }
    ) {
        if (original.hasData(dataType)) {
            val oldData = original.getData(dataType)
            newEntity.setData(dataType, copyFunction(oldData)!!)
        }
    }

    @SubscribeEvent
    fun onPlayerTryAttack(event: LivingDamageEvent.Pre) {
        val player = event.source.entity as? ServerPlayer ?: return
        val target = event.entity
        if (target is Player) {
            DataSenderS2C.sendPlayerKillCount(target, player)
        } else {
            DataSenderS2C.sendEntityKillCount(target, player)
        }
    }

    @SubscribeEvent
    fun onPlayerAttackAfter(event: LivingDamageEvent.Post) {
        val player = event.source.entity as? ServerPlayer ?: return
        if (event.newDamage > 0.0f) {
            DataSenderS2C.sendAttackDamage(event.newDamage, player)
        }
    }

    @SubscribeEvent
    fun onPlayerKillEntity(event: LivingDeathEvent) {
        val player = event.source.entity as? ServerPlayer ?: return

        when (val target = event.entity) {
            is Player -> {
                DataHandler.updatePlayerKillCount(target, player)
                DataSenderS2C.sendPlayerKillCount(target, player)
            }

            is LivingEntity -> DataSenderS2C.sendEntityKillCount(target, player, true)
        }
    }

    // TODO: Convert it to AttributeItemTooltipEvent (in 1.21.+)
    @SubscribeEvent
    fun addItemTooltip(event: ItemTooltipEvent) {
        event.itemStack.get(ModDataComponents.HAS_INFO)?.run {
            addToTooltip(event.context, { tooltip -> addTooltip(event.toolTip, tooltip, event.flags) }, event.flags)
        }
    }

    private fun addTooltip(tooltips: MutableList<Component>, tooltip: Component, flags: TooltipFlag) {
        if (flags.isAdvanced) {
            val index = max(0, tooltips.lastIndex - 1)
            tooltips.add(index, tooltip)
        } else {
            tooltips.add(tooltip)
        }
    }
}