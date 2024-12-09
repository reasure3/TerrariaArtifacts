package com.reasure.terrartifacts.network

import com.reasure.terrartifacts.data.attachment.ModDataAttachments
import com.reasure.terrartifacts.network.packet.SendShowInfoDataOnlyOnePacket
import com.reasure.terrartifacts.network.packet.SendShowInfoDataPacket
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.player.Player
import net.neoforged.neoforge.network.handling.IPayloadContext

object ModServerPayloadHandler {
    private fun handlePacket(context: IPayloadContext, handler: (Player) -> Unit) {
        context.enqueueWork {
            handler(context.player())
        }.exceptionally { error ->
            context.disconnect(Component.literal(error.message.toString()))
            return@exceptionally null
        }
    }

    object ReceiveShowInfoData {
        fun handle(clientPacket: SendShowInfoDataPacket, context: IPayloadContext) =
            handlePacket(context) { player ->
                player.setData(ModDataAttachments.SHOW_INFO, clientPacket.data.copy())
            }

        fun handle(clientPacket: SendShowInfoDataOnlyOnePacket, context: IPayloadContext) =
            handlePacket(context) { player ->
                player.getData(ModDataAttachments.SHOW_INFO)[clientPacket.type] = clientPacket.value
            }
    }
}