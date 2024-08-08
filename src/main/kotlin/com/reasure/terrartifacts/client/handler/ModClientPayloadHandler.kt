package com.reasure.terrartifacts.client.handler

import com.reasure.terrartifacts.client.data.ClientShowInfoData
import com.reasure.terrartifacts.data.ShowInfoData
import net.minecraft.network.chat.Component
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn
import net.neoforged.neoforge.network.handling.IPayloadContext

@OnlyIn(Dist.CLIENT)
class ModClientPayloadHandler {
    object ShowInfo {
        fun handle(serverData: ShowInfoData, context: IPayloadContext) {
            context.enqueueWork {
                ClientShowInfoData.copyFrom(serverData)
            }.exceptionally { error ->
                context.disconnect(Component.literal(error.message.toString()))
                return@exceptionally null
            }
        }
    }
}