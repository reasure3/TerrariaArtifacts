package com.reasure.terrartifacts.client

import com.reasure.terrartifacts.Terrartifacts
import net.minecraft.client.Minecraft
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.client.event.ClientTickEvent

@EventBusSubscriber(modid = Terrartifacts.ID, bus = EventBusSubscriber.Bus.GAME, value = [Dist.CLIENT])
object GameClient {
    @SubscribeEvent
    fun clientTick(event: ClientTickEvent.Post) {
        val mc = Minecraft.getInstance()
        val player = mc.player ?: return
        InformationHandler.updateInfo(player)
    }
}