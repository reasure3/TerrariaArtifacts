package com.reasure.terrartifacts.client.handler

import com.reasure.terrartifacts.client.data.ClientDamageTracker
import com.reasure.terrartifacts.client.data.ClientShowInfoData
import com.reasure.terrartifacts.network.packet.*
import net.minecraft.network.chat.Component
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn
import net.neoforged.neoforge.network.handling.IPayloadContext

@OnlyIn(Dist.CLIENT)
object ModClientPayloadHandler {
    private fun handlePacket(context: IPayloadContext, handler: () -> Unit) {
        context.enqueueWork {
            handler()
        }.exceptionally { error ->
            context.disconnect(Component.literal(error.message.toString()))
            return@exceptionally null
        }
    }

    object ReceiveShowInfoData {
        fun handle(serverPacket: SendShowInfoDataPacket, context: IPayloadContext) = handlePacket(context) {
            ClientShowInfoData.copyFrom(serverPacket.data)
        }

        fun handle(serverPacket: SendShowInfoDataOnlyOnePacket, context: IPayloadContext) = handlePacket(context) {
            ClientShowInfoData[serverPacket.type] = serverPacket.value
        }
    }

    object OnLoggedIn {
        fun handle(serverPacket: PlayerLoggedInS2CPacket, context: IPayloadContext) = handlePacket(context) {
            InfoItemHandler.reset()
        }
    }

    object ReceivePlayerKillCount {
        fun handle(serverPacket: SendPlayerKillCountS2CPacket, context: IPayloadContext) = handlePacket(context) {
            InfoItemHandler.receiveKillCount(serverPacket.targetPlayerName, serverPacket.killCount)
        }
    }

    object ReceiveEntityKillCount {
        fun handle(serverPacket: SendEntityKillCountS2CPacket, context: IPayloadContext) = handlePacket(context) {
            InfoItemHandler.receiveKillCount(serverPacket.targetEntity, serverPacket.killCount)
        }
    }

    object ReceiveAttackDamage {
        fun handle(serverPacket: SendAttackDamageS2CPacket, context: IPayloadContext) = handlePacket(context) {
            ClientDamageTracker.addDamageEntry(serverPacket.attackTime, serverPacket.attackDamage)
        }
    }
}