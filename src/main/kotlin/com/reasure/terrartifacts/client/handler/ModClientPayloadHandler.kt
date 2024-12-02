package com.reasure.terrartifacts.client.handler

import com.reasure.terrartifacts.client.data.ClientDamageTracker
import com.reasure.terrartifacts.client.data.ClientShowInfoData
import com.reasure.terrartifacts.network.packet.*
import net.minecraft.network.chat.Component
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn
import net.neoforged.neoforge.network.handling.IPayloadContext

@OnlyIn(Dist.CLIENT)
class ModClientPayloadHandler {
    object ReceiveShowInfoData {
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
        fun handle(serverPacket: PlayerLoggedInS2CPacket, context: IPayloadContext) {
            context.enqueueWork {
                InfoItemHandler.reset()
            }.exceptionally { error ->
                context.disconnect(Component.literal(error.message.toString()))
                return@exceptionally null
            }
        }
    }

    object ReceivePlayerKillCount {
        fun handle(serverPacket: SendPlayerKillCountS2CPacket, context: IPayloadContext) {
            context.enqueueWork {
                InfoItemHandler.receiveKillCount(serverPacket.targetPlayerName, serverPacket.killCount)
            }.exceptionally { error ->
                context.disconnect(Component.literal(error.message.toString()))
                return@exceptionally null
            }
        }
    }

    object ReceiveEntityKillCount {
        fun handle(serverPacket: SendEntityKillCountS2CPacket, context: IPayloadContext) {
            context.enqueueWork {
                InfoItemHandler.receiveKillCount(serverPacket.targetEntity, serverPacket.killCount)
            }.exceptionally { error ->
                context.disconnect(Component.literal(error.message.toString()))
                return@exceptionally null
            }
        }
    }

    object ReceiveAttackDamage {
        fun handle(serverPacket: SendAttackDamageS2CPacket, context: IPayloadContext) {
            context.enqueueWork {
                ClientDamageTracker.addDamageEntry(serverPacket.attackTime, serverPacket.attackDamage)
            }.exceptionally { error ->
                context.disconnect(Component.literal(error.message.toString()))
                return@exceptionally null
            }
        }
    }
}