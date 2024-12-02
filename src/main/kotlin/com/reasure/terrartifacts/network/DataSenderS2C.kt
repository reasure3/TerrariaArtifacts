package com.reasure.terrartifacts.network

import com.reasure.terrartifacts.data.ModDataAttachments
import com.reasure.terrartifacts.network.packet.*
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.server.level.ServerPlayer
import net.minecraft.stats.Stats
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.neoforged.neoforge.network.PacketDistributor

object DataSenderS2C {
    fun sendPlayerLoggedIn(player: ServerPlayer) {
        PacketDistributor.sendToPlayer(player, PlayerLoggedInS2CPacket.INSTANCE)
    }

    fun sendShowInfo(player: ServerPlayer) {
        PacketDistributor.sendToPlayer(
            player,
            SendShowInfoDataPacket(player.getData(ModDataAttachments.SHOW_INFO).copy())
        )
    }

    fun sendAttackDamage(newDamage: Float, player: ServerPlayer) {
        PacketDistributor.sendToPlayer(
            player, SendAttackDamageS2CPacket(player.level().gameTime, newDamage)
        )
    }

    fun sendPlayerKillCount(target: Player, player: ServerPlayer) {
        val killCount = player.getData(ModDataAttachments.PLAYER_KILL_COUNT).getOrDefault(target.uuid, 0)
        PacketDistributor.sendToPlayer(player, SendPlayerKillCountS2CPacket(target.name.string, killCount))
    }

    fun sendEntityKillCount(target: LivingEntity, player: ServerPlayer, hasKilled: Boolean = false) {
        val killCount = player.stats.getValue(Stats.ENTITY_KILLED.get(target.type)) + if (hasKilled) 1 else 0
        PacketDistributor.sendToPlayer(
            player,
            SendEntityKillCountS2CPacket(BuiltInRegistries.ENTITY_TYPE.getKey(target.type), killCount)
        )
    }
}