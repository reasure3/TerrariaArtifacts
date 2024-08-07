package com.reasure.terrartifacts.client

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.client.gui.overlay.InfoHudOverlay
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent
import net.neoforged.neoforge.client.gui.VanillaGuiLayers

@EventBusSubscriber(modid = Terrartifacts.ID, bus = EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
object ModClient {
    @SubscribeEvent
    fun registerOverlay(event: RegisterGuiLayersEvent) {
        event.registerAbove(VanillaGuiLayers.SCOREBOARD_SIDEBAR, InfoHudOverlay.OVERLAY_ID, InfoHudOverlay())
    }
}