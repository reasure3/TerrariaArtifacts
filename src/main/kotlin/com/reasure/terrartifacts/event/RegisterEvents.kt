package com.reasure.terrartifacts.event

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.client.handler.ModClientPayloadHandler
import com.reasure.terrartifacts.data.ShowInfoData
import com.reasure.terrartifacts.network.ModServerPayloadHandler
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler

@EventBusSubscriber(modid = Terrartifacts.ID, bus = EventBusSubscriber.Bus.MOD)
object RegisterEvents {
    @SubscribeEvent
    fun register(event: RegisterPayloadHandlersEvent) {
        val registrar = event.registrar("1")

        registrar.playBidirectional(
            ShowInfoData.TYPE,
            ShowInfoData.STREAM_CODEC,
            DirectionalPayloadHandler(
                ModClientPayloadHandler.ShowInfo::handle,
                ModServerPayloadHandler.ShowInfo::handle
            )
        )
    }
}