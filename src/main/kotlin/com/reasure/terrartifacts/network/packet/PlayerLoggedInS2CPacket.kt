package com.reasure.terrartifacts.network.packet

import com.reasure.terrartifacts.Terrartifacts
import io.netty.buffer.ByteBuf
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload

class PlayerLoggedInS2CPacket : CustomPacketPayload {
    override fun type(): CustomPacketPayload.Type<PlayerLoggedInS2CPacket> = TYPE

    companion object {
        val INSTANCE = PlayerLoggedInS2CPacket()

        val TYPE = CustomPacketPayload.Type<PlayerLoggedInS2CPacket>(Terrartifacts.modLoc("player_logged_in"))

        val STREAM_CODEC: StreamCodec<ByteBuf, PlayerLoggedInS2CPacket> = StreamCodec.unit(INSTANCE)
    }
}