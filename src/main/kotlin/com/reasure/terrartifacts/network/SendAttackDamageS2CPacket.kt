package com.reasure.terrartifacts.network

import com.reasure.terrartifacts.Terrartifacts
import io.netty.buffer.ByteBuf
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload

class SendAttackDamageS2CPacket(
    val attackTime: Long,
    val attackDamage: Float
) : CustomPacketPayload {
    fun encode(byteBuf: ByteBuf) {
        byteBuf.writeLong(attackTime)
        byteBuf.writeFloat(attackDamage)
    }

    override fun type(): CustomPacketPayload.Type<SendAttackDamageS2CPacket> = TYPE

    companion object {
        fun decode(byteBuf: ByteBuf) = SendAttackDamageS2CPacket(
            byteBuf.readLong(),
            byteBuf.readFloat()
        )

        val TYPE =
            CustomPacketPayload.Type<SendAttackDamageS2CPacket>(Terrartifacts.modLoc("send_attack_damage"))

        val STREAM_CODEC: StreamCodec<ByteBuf, SendAttackDamageS2CPacket> =
            StreamCodec.ofMember(SendAttackDamageS2CPacket::encode, SendAttackDamageS2CPacket::decode)
    }
}