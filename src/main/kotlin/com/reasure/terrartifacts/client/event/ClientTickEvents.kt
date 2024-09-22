package com.reasure.terrartifacts.client.event

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.client.handler.InformationHandler
import net.minecraft.client.Minecraft
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.client.event.ClientTickEvent

@Suppress("unused")
@EventBusSubscriber(modid = Terrartifacts.ID, bus = EventBusSubscriber.Bus.GAME, value = [Dist.CLIENT])
object ClientTickEvents {
    @SubscribeEvent
    fun clientTick(event: ClientTickEvent.Post) {
        val mc = Minecraft.getInstance()
        val player = mc.player ?: return
        InformationHandler.updateInfo(player)
    }
}