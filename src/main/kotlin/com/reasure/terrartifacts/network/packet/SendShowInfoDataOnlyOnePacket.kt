package com.reasure.terrartifacts.network.packet

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.item.accessories.informational.InfoType
import io.netty.buffer.ByteBuf
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload

class SendShowInfoDataOnlyOnePacket(val type: InfoType, val value: Boolean) : CustomPacketPayload {
    override fun type(): CustomPacketPayload.Type<SendShowInfoDataOnlyOnePacket> = TYPE

    companion object {
        val TYPE =
            CustomPacketPayload.Type<SendShowInfoDataOnlyOnePacket>(Terrartifacts.modLoc("send_show_info_only_one_data"))

        val STREAM_CODEC: StreamCodec<ByteBuf, SendShowInfoDataOnlyOnePacket> = StreamCodec.composite(
            InfoType.STREAM_CODEC, SendShowInfoDataOnlyOnePacket::type,
            ByteBufCodecs.BOOL, SendShowInfoDataOnlyOnePacket::value,
            ::SendShowInfoDataOnlyOnePacket
        )
    }
}