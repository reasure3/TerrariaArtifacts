package com.reasure.terrartifacts.network

import com.reasure.terrartifacts.Terrartifacts
import io.netty.buffer.ByteBuf
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload
import net.minecraft.resources.ResourceLocation

class SendEntityKillCountS2CPacket(
    val targetEntity: ResourceLocation,
    val killCount: Int
) : CustomPacketPayload {
    fun encode(byteBuf: ByteBuf) {
        ResourceLocation.STREAM_CODEC.encode(byteBuf, targetEntity)
        byteBuf.writeInt(killCount)
    }

    override fun type(): CustomPacketPayload.Type<SendEntityKillCountS2CPacket> = TYPE

    companion object {
        fun decode(byteBuf: ByteBuf): SendEntityKillCountS2CPacket {
            val loc = ResourceLocation.STREAM_CODEC.decode(byteBuf)
            val killCount = byteBuf.readInt()
            return SendEntityKillCountS2CPacket(loc, killCount)
        }

        val TYPE =
            CustomPacketPayload.Type<SendEntityKillCountS2CPacket>(Terrartifacts.modLoc("send_entity_kill_count"))

        val STREAM_CODEC: StreamCodec<ByteBuf, SendEntityKillCountS2CPacket> =
            StreamCodec.ofMember(SendEntityKillCountS2CPacket::encode, SendEntityKillCountS2CPacket::decode)
    }
}