package com.reasure.terrartifacts.network

import com.reasure.terrartifacts.data.ModDataAttachments
import com.reasure.terrartifacts.data.ShowInfoData
import net.minecraft.network.chat.Component
import net.neoforged.neoforge.network.handling.IPayloadContext

class ModServerPayloadHandler {
    object ShowInfo {
        fun handle(clientData: ShowInfoData, context: IPayloadContext) {
            context.enqueueWork {
                val player = context.player()
                player.setData(ModDataAttachments.SHOW_INFO, clientData.clone())
                println("saved data show info: ${clientData.showTime}")
            }.exceptionally { error ->
                context.disconnect(Component.literal(error.message.toString()))
                return@exceptionally null
            }
        }
    }
}