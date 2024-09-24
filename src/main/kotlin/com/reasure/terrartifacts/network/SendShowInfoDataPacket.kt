package com.reasure.terrartifacts.network

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.data.ShowInfoData
import io.netty.buffer.ByteBuf
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload

class SendShowInfoDataPacket(val data: ShowInfoData) : CustomPacketPayload {
    override fun type(): CustomPacketPayload.Type<SendShowInfoDataPacket> = TYPE

    fun encode(buffer: ByteBuf) {
        data.run {
            buffer.writeBoolean(showTime)
            buffer.writeBoolean(showWeather)
            buffer.writeBoolean(showFishingPower)
            buffer.writeBoolean(showDirection)
            buffer.writeBoolean(showDepth)
            buffer.writeBoolean(showEnemyCount)
            buffer.writeBoolean(showKillCount)
            buffer.writeBoolean(showMoonPhase)
        }
    }

    companion object {
        fun decode(buffer: ByteBuf) = SendShowInfoDataPacket(
            ShowInfoData(
                buffer.readBoolean(),
                buffer.readBoolean(),
                buffer.readBoolean(),
                buffer.readBoolean(),
                buffer.readBoolean(),
                buffer.readBoolean(),
                buffer.readBoolean(),
                buffer.readBoolean()
            )
        )

        val TYPE = CustomPacketPayload.Type<SendShowInfoDataPacket>(Terrartifacts.modLoc("send_show_info_data"))

        val STREAM_CODEC: StreamCodec<ByteBuf, SendShowInfoDataPacket> =
            StreamCodec.ofMember(SendShowInfoDataPacket::encode, SendShowInfoDataPacket::decode)
    }
}