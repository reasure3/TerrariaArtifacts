package com.reasure.terrartifacts.event

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.data.ModDataAttachments
import net.minecraft.server.level.ServerPlayer
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.common.util.FakePlayer
import net.neoforged.neoforge.event.entity.player.PlayerEvent
import net.neoforged.neoforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent
import net.neoforged.neoforge.network.PacketDistributor

@EventBusSubscriber(modid = Terrartifacts.ID, bus = EventBusSubscriber.Bus.GAME)
object GameEvents {
    @SubscribeEvent
    fun onPlayerLogin(event: PlayerLoggedInEvent) {
        val player = event.entity
        if (player is ServerPlayer && player !is FakePlayer) {
            PacketDistributor.sendToPlayer(player, player.getData(ModDataAttachments.SHOW_INFO))
        }
    }

    @SubscribeEvent
    fun onPlayerDeath(event: PlayerEvent.Clone) {
        if (event.isWasDeath && event.original.hasData(ModDataAttachments.SHOW_INFO)) {
            event.entity.getData(ModDataAttachments.SHOW_INFO)
                .copyFrom(event.original.getData(ModDataAttachments.SHOW_INFO))
        }
    }
}