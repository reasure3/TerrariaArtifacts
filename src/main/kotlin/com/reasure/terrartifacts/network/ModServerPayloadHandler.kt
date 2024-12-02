package com.reasure.terrartifacts.network

import com.reasure.terrartifacts.data.ModDataAttachments
import com.reasure.terrartifacts.network.packet.SendShowInfoDataPacket
import net.minecraft.network.chat.Component
import net.neoforged.neoforge.network.handling.IPayloadContext

class ModServerPayloadHandler {
    object ReceiveShowInfoData {
        fun handle(clientPacket: SendShowInfoDataPacket, context: IPayloadContext) {
            context.enqueueWork {
                val player = context.player()
                player.setData(ModDataAttachments.SHOW_INFO, clientPacket.data.copy())
            }.exceptionally { error ->
                context.disconnect(Component.literal(error.message.toString()))
                return@exceptionally null
            }
        }
    }
}