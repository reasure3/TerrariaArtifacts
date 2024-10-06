package com.reasure.terrartifacts.event

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.data.ModDataAttachments
import com.reasure.terrartifacts.network.PlayerLoggedInS2CPacket
import com.reasure.terrartifacts.network.SendAttackDamageS2CPacket
import com.reasure.terrartifacts.network.SendEntityKillCountS2CPacket
import com.reasure.terrartifacts.network.SendPlayerKillCountS2CPacket
import com.reasure.terrartifacts.network.SendShowInfoDataPacket
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.server.level.ServerPlayer
import net.minecraft.stats.Stats
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.common.util.FakePlayer
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent
import net.neoforged.neoforge.event.entity.player.PlayerEvent
import net.neoforged.neoforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent
import net.neoforged.neoforge.network.PacketDistributor

@Suppress("unused")
@EventBusSubscriber(modid = Terrartifacts.ID, bus = EventBusSubscriber.Bus.GAME)
object PlayerEvents {
    @SubscribeEvent
    fun onPlayerLogin(event: PlayerLoggedInEvent) {
        val player = event.entity
        if (player is ServerPlayer && player !is FakePlayer) {
            PacketDistributor.sendToPlayer(player, PlayerLoggedInS2CPacket())
            PacketDistributor.sendToPlayer(
                player,
                SendShowInfoDataPacket(player.getData(ModDataAttachments.SHOW_INFO).copy())
            )
        }
    }

    @SubscribeEvent
    fun onPlayerDeath(event: PlayerEvent.Clone) {
        if (event.isWasDeath) {
            if (event.original.hasData(ModDataAttachments.SHOW_INFO)) {
                val old = event.original.getData(ModDataAttachments.SHOW_INFO)
                event.entity.setData(ModDataAttachments.SHOW_INFO, old.copy())
            }
            if (event.original.hasData(ModDataAttachments.PLAYER_KILL_COUNT)) {
                val old = event.original.getData(ModDataAttachments.PLAYER_KILL_COUNT)
                event.entity.setData(ModDataAttachments.PLAYER_KILL_COUNT, old.toMap())
            }
        }
    }

    @SubscribeEvent
    fun onPlayerTryAttack(event: LivingDamageEvent.Pre) {
        val player = event.source.entity as? ServerPlayer ?: return

        val target = event.entity
        if (target is Player) {
            PacketDistributor.sendToPlayer(
                player, SendPlayerKillCountS2CPacket(
                    target.scoreboardName, player.getData(
                        ModDataAttachments.PLAYER_KILL_COUNT
                    ).getOrDefault(target.uuid, 0)
                )
            )
        } else {
            PacketDistributor.sendToPlayer(
                player,
                SendEntityKillCountS2CPacket(
                    BuiltInRegistries.ENTITY_TYPE.getKey(target.type),
                    player.stats.getValue(Stats.ENTITY_KILLED.get(target.type))
                )
            )
        }
    }

    @SubscribeEvent
    fun onPlayerAttackAfter(event: LivingDamageEvent.Post) {
        val player = event.source.entity as? ServerPlayer ?: return
        if (event.newDamage > 0.0f) {
            PacketDistributor.sendToPlayer(
                player, SendAttackDamageS2CPacket(player.level().gameTime, event.newDamage)
            )
        }
    }

    @SubscribeEvent
    fun onPlayerKillEntity(event: LivingDeathEvent) {
        val player = event.source.entity as? ServerPlayer ?: return

        val target = event.entity
        if (target is Player) {
            val targetUuid = target.uuid
            val old = player.getData(ModDataAttachments.PLAYER_KILL_COUNT).toMutableMap()
            val killCount = old.getOrDefault(targetUuid, 0) + 1
            old[targetUuid] = killCount
            player.setData(ModDataAttachments.PLAYER_KILL_COUNT, old)

            PacketDistributor.sendToPlayer(player, SendPlayerKillCountS2CPacket(target.scoreboardName, killCount))
        } else if (target is LivingEntity) {
            PacketDistributor.sendToPlayer(
                player,
                SendEntityKillCountS2CPacket(
                    BuiltInRegistries.ENTITY_TYPE.getKey(target.type),
                    player.stats.getValue(Stats.ENTITY_KILLED.get(target.type)) + 1
                )
            )
        }
    }
}