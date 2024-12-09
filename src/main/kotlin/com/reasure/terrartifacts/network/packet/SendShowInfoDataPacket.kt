package com.reasure.terrartifacts.network.packet

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.data.attachment.ShowInfoData
import io.netty.buffer.ByteBuf
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload

class SendShowInfoDataPacket(val data: ShowInfoData) : CustomPacketPayload {
    override fun type(): CustomPacketPayload.Type<SendShowInfoDataPacket> = TYPE

    companion object {
        val TYPE = CustomPacketPayload.Type<SendShowInfoDataPacket>(Terrartifacts.modLoc("send_show_info_data"))

        val STREAM_CODEC: StreamCodec<ByteBuf, SendShowInfoDataPacket> = StreamCodec.composite(
            ShowInfoData.STREAM_CODEC, SendShowInfoDataPacket::data,
            ::SendShowInfoDataPacket
        )
    }
}