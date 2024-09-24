package com.reasure.terrartifacts.network

import com.reasure.terrartifacts.Terrartifacts
import io.netty.buffer.ByteBuf
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload

class SendPlayerKillCountS2CPacket(
    val targetPlayerName: String,
    val killCount: Int
) : CustomPacketPayload {
    fun encode(buffer: ByteBuf) {
        ByteBufCodecs.STRING_UTF8.encode(buffer, targetPlayerName)
        buffer.writeInt(killCount)
    }

    override fun type(): CustomPacketPayload.Type<SendPlayerKillCountS2CPacket> = TYPE

    companion object {
        fun decode(buffer: ByteBuf): SendPlayerKillCountS2CPacket {
            val name = ByteBufCodecs.STRING_UTF8.decode(buffer)
            val kill = buffer.readInt()
            return SendPlayerKillCountS2CPacket(name, kill)
        }

        val TYPE =
            CustomPacketPayload.Type<SendPlayerKillCountS2CPacket>(Terrartifacts.modLoc("send_player_kill_count"))

        val STREAM_CODEC: StreamCodec<ByteBuf, SendPlayerKillCountS2CPacket> =
            StreamCodec.ofMember(SendPlayerKillCountS2CPacket::encode, SendPlayerKillCountS2CPacket::decode)
    }
}