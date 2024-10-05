package com.reasure.terrartifacts.event

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.client.handler.ModClientPayloadHandler
import com.reasure.terrartifacts.data.ModDataMaps
import com.reasure.terrartifacts.network.ModServerPayloadHandler
import com.reasure.terrartifacts.network.PlayerLoggedInS2CPacket
import com.reasure.terrartifacts.network.SendEntityKillCountS2CPacket
import com.reasure.terrartifacts.network.SendPlayerKillCountS2CPacket
import com.reasure.terrartifacts.network.SendShowInfoDataPacket
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler
import net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent

@Suppress("unused")
@EventBusSubscriber(modid = Terrartifacts.ID, bus = EventBusSubscriber.Bus.MOD)
object RegisterEvents {
    @SubscribeEvent
    fun registerPayload(event: RegisterPayloadHandlersEvent) {
        val registrar = event.registrar("1")

        registrar.playToClient(
            PlayerLoggedInS2CPacket.TYPE,
            PlayerLoggedInS2CPacket.STREAM_CODEC,
            ModClientPayloadHandler.OnLoggedIn::handle
        )

        registrar.playBidirectional(
            SendShowInfoDataPacket.TYPE,
            SendShowInfoDataPacket.STREAM_CODEC,
            DirectionalPayloadHandler(
                ModClientPayloadHandler.ReceiveShowInfoData::handle,
                ModServerPayloadHandler.ReceiveShowInfoData::handle
            )
        )

        registrar.playToClient(
            SendPlayerKillCountS2CPacket.TYPE,
            SendPlayerKillCountS2CPacket.STREAM_CODEC,
            ModClientPayloadHandler.ReceivePlayerKillCount::handle
        )

        registrar.playToClient(
            SendEntityKillCountS2CPacket.TYPE,
            SendEntityKillCountS2CPacket.STREAM_CODEC,
            ModClientPayloadHandler.ReceiveEntityKillCount::handle
        )
    }

    @SubscribeEvent
    fun registerDataMapTypes(event: RegisterDataMapTypesEvent) {
        event.register(ModDataMaps.RARE_BLOCK_DATA)
    }
}