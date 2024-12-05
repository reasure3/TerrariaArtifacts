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

        val STREAM_CODEC: StreamCodec<ByteBuf, SendShowInfoDataOnlyOnePacket> =
            object : StreamCodec<ByteBuf, SendShowInfoDataOnlyOnePacket> {
                override fun decode(buf: ByteBuf): SendShowInfoDataOnlyOnePacket {
                    val infoType = InfoType.entries.getOrNull(ByteBufCodecs.VAR_INT.decode(buf))
                        ?: throw IllegalArgumentException("Invalid InfoType Index")
                    val show = ByteBufCodecs.BOOL.decode(buf)
                    return SendShowInfoDataOnlyOnePacket(infoType, show)
                }

                override fun encode(buf: ByteBuf, data: SendShowInfoDataOnlyOnePacket) {
                    ByteBufCodecs.VAR_INT.encode(buf, data.type.ordinal)
                    ByteBufCodecs.BOOL.encode(buf, data.value)
                }
            }
    }
}