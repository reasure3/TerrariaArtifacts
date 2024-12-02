package com.reasure.terrartifacts.network.packet

import com.reasure.terrartifacts.Terrartifacts
import io.netty.buffer.ByteBuf
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload

class SendAttackDamageS2CPacket(
    val attackTime: Long,
    val attackDamage: Float
) : CustomPacketPayload {
    override fun type(): CustomPacketPayload.Type<SendAttackDamageS2CPacket> = TYPE

    companion object {
        val TYPE =
            CustomPacketPayload.Type<SendAttackDamageS2CPacket>(Terrartifacts.modLoc("send_attack_damage"))

        val STREAM_CODEC: StreamCodec<ByteBuf, SendAttackDamageS2CPacket> = StreamCodec.composite(
            ByteBufCodecs.VAR_LONG, SendAttackDamageS2CPacket::attackTime,
            ByteBufCodecs.FLOAT, SendAttackDamageS2CPacket::attackDamage,
            ::SendAttackDamageS2CPacket
        )
    }
}