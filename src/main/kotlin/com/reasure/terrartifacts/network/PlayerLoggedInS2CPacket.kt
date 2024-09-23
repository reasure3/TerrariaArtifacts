package com.reasure.terrartifacts.network

import com.reasure.terrartifacts.Terrartifacts
import io.netty.buffer.ByteBuf
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload

class PlayerLoggedInS2CPacket() : CustomPacketPayload {
    override fun type(): CustomPacketPayload.Type<PlayerLoggedInS2CPacket> = TYPE

    fun encode(buffer: ByteBuf) {}

    companion object {
        fun decode(buffer: ByteBuf): PlayerLoggedInS2CPacket = PlayerLoggedInS2CPacket()

        val TYPE = CustomPacketPayload.Type<PlayerLoggedInS2CPacket>(Terrartifacts.modLoc("player_logged_in"))

        val STREAM_CODEC: StreamCodec<ByteBuf, PlayerLoggedInS2CPacket> =
            StreamCodec.ofMember(PlayerLoggedInS2CPacket::encode, PlayerLoggedInS2CPacket::decode)
    }
}