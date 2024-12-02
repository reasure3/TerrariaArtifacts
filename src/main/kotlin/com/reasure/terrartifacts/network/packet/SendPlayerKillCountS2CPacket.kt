package com.reasure.terrartifacts.network.packet

import com.reasure.terrartifacts.Terrartifacts
import io.netty.buffer.ByteBuf
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload

class SendPlayerKillCountS2CPacket(
    val targetPlayerName: String,
    val killCount: Int
) : CustomPacketPayload {
    override fun type(): CustomPacketPayload.Type<SendPlayerKillCountS2CPacket> = TYPE

    companion object {
        val TYPE =
            CustomPacketPayload.Type<SendPlayerKillCountS2CPacket>(Terrartifacts.modLoc("send_player_kill_count"))

        val STREAM_CODEC: StreamCodec<ByteBuf, SendPlayerKillCountS2CPacket> = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, SendPlayerKillCountS2CPacket::targetPlayerName,
            ByteBufCodecs.VAR_INT, SendPlayerKillCountS2CPacket::killCount,
            ::SendPlayerKillCountS2CPacket
        )
    }
}