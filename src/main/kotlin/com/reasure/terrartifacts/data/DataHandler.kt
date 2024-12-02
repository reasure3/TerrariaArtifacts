package com.reasure.terrartifacts.data

import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.entity.player.Player

object DataHandler {
    fun updatePlayerKillCount(target: Player, player: ServerPlayer) {
        val targetUuid = target.uuid
        val old = player.getData(ModDataAttachments.PLAYER_KILL_COUNT).toMutableMap()
        old[targetUuid] = old.getOrDefault(targetUuid, 0) + 1
        player.setData(ModDataAttachments.PLAYER_KILL_COUNT, old)
    }
}