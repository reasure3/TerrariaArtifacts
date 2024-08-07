package com.reasure.terrartifacts.network

import com.reasure.terrartifacts.client.data.ClientShowInfoData
import com.reasure.terrartifacts.data.ModDataAttachments
import com.reasure.terrartifacts.data.ShowInfoData
import net.minecraft.network.chat.Component
import net.neoforged.neoforge.network.handling.IPayloadContext

class ShowInfoDataHandler {
    object Client {
        fun handle(serverData: ShowInfoData, context: IPayloadContext) {
            context.enqueueWork {
                ClientShowInfoData.copyFrom(serverData)
            }.exceptionally { error ->
                context.disconnect(Component.literal(error.message.toString()))
                return@exceptionally null
            }
        }
    }

    object Server {
        fun handle(clientData: ShowInfoData, context: IPayloadContext) {
            context.enqueueWork {
                val player = context.player()
                player.getData(ModDataAttachments.SHOW_INFO).copyFrom(clientData)
            }.exceptionally { error ->
                context.disconnect(Component.literal(error.message.toString()))
                return@exceptionally null
            }
        }
    }
}