package com.reasure.terrartifacts.event

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.data.ShowInfoData
import com.reasure.terrartifacts.network.ShowInfoDataHandler
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler

@EventBusSubscriber(modid = Terrartifacts.ID, bus = EventBusSubscriber.Bus.MOD)
object ModEvents {
    @SubscribeEvent
    fun register(event: RegisterPayloadHandlersEvent) {
        val registrar = event.registrar("1")

        registrar.playBidirectional(
            ShowInfoData.TYPE,
            ShowInfoData.STREAM_CODEC,
            DirectionalPayloadHandler(ShowInfoDataHandler.Client::handle, ShowInfoDataHandler.Server::handle)
        )
    }
}