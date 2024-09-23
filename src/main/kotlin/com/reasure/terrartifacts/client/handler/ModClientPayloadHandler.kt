package com.reasure.terrartifacts.client.handler

import com.reasure.terrartifacts.client.data.ClientShowInfoData
import com.reasure.terrartifacts.network.PlayerLoggedInS2CPacket
import com.reasure.terrartifacts.network.SendShowInfoDataPacket
import net.minecraft.network.chat.Component
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn
import net.neoforged.neoforge.network.handling.IPayloadContext

@OnlyIn(Dist.CLIENT)
class ModClientPayloadHandler {
    object SendShowInfoData {
        fun handle(serverPacket: SendShowInfoDataPacket, context: IPayloadContext) {
            context.enqueueWork {
                ClientShowInfoData.copyFrom(serverPacket.data)
            }.exceptionally { error ->
                context.disconnect(Component.literal(error.message.toString()))
                return@exceptionally null
            }
        }
    }

    object OnLoggedIn {
        fun handle(@Suppress("unused") serverData: PlayerLoggedInS2CPacket, context: IPayloadContext) {
            context.enqueueWork {
                InformationHandler.reset()
            }
        }
    }
}