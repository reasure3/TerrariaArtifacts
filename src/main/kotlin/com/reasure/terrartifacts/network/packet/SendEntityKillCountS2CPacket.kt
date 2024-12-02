package com.reasure.terrartifacts.network.packet

import com.reasure.terrartifacts.Terrartifacts
import io.netty.buffer.ByteBuf
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload
import net.minecraft.resources.ResourceLocation

class SendEntityKillCountS2CPacket(
    val targetEntity: ResourceLocation,
    val killCount: Int
) : CustomPacketPayload {
    override fun type(): CustomPacketPayload.Type<SendEntityKillCountS2CPacket> = TYPE

    companion object {
        val TYPE =
            CustomPacketPayload.Type<SendEntityKillCountS2CPacket>(Terrartifacts.modLoc("send_entity_kill_count"))

        val STREAM_CODEC: StreamCodec<ByteBuf, SendEntityKillCountS2CPacket> = StreamCodec.composite(
            ResourceLocation.STREAM_CODEC, SendEntityKillCountS2CPacket::targetEntity,
            ByteBufCodecs.VAR_INT, SendEntityKillCountS2CPacket::killCount,
            ::SendEntityKillCountS2CPacket
        )
    }
}