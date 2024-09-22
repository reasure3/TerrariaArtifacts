package com.reasure.terrartifacts.data

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.item.accessories.informational.InformationType
import io.netty.buffer.ByteBuf
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload

/**
 * 플레이어가 정보 악세서리 소지 시, 해당 정보를 보여줄지 여부를 저장
 *
 * 인벤토리 화면에서 플레이어가 직접 수정 가능
 */
data class ShowInfoData(
    val showTime: Boolean,
    val showWeather: Boolean,
    val showFishingPower: Boolean,
    val showDirection: Boolean,
    val showDepth: Boolean
) : CustomPacketPayload {
    operator fun get(type: InformationType) = when (type) {
        InformationType.TIME -> showTime
        InformationType.WEATHER -> showWeather
        InformationType.FISHING_POWER -> showFishingPower
        InformationType.DIRECTION -> showDirection
        InformationType.DEPTH -> showDepth
    }

    fun encode(buffer: ByteBuf) {
        buffer.writeBoolean(showTime)
        buffer.writeBoolean(showWeather)
        buffer.writeBoolean(showFishingPower)
        buffer.writeBoolean(showDirection)
        buffer.writeBoolean(showDepth)
    }

    companion object {
        fun create(): ShowInfoData = ShowInfoData(
            showTime = true,
            showWeather = true,
            showFishingPower = true,
            showDirection = true,
            showDepth = true
        )

        val CODEC: Codec<ShowInfoData> = RecordCodecBuilder.create { instance ->
            instance.group(
                Codec.BOOL.fieldOf("showTime").forGetter(ShowInfoData::showTime),
                Codec.BOOL.fieldOf("showWeather").forGetter(ShowInfoData::showWeather),
                Codec.BOOL.fieldOf("showFishingPower").forGetter(ShowInfoData::showFishingPower),
                Codec.BOOL.fieldOf("showDirection").forGetter(ShowInfoData::showDirection),
                Codec.BOOL.fieldOf("showDepth").forGetter(ShowInfoData::showDepth)
            ).apply(instance, ::ShowInfoData)
        }

        fun decode(buffer: ByteBuf): ShowInfoData = ShowInfoData(
            buffer.readBoolean(),
            buffer.readBoolean(),
            buffer.readBoolean(),
            buffer.readBoolean(),
            buffer.readBoolean()
        )

        val TYPE = CustomPacketPayload.Type<ShowInfoData>(Terrartifacts.modLoc("show_info_data"))

        val STREAM_CODEC: StreamCodec<ByteBuf, ShowInfoData> =
            StreamCodec.ofMember(ShowInfoData::encode, ShowInfoData::decode)
    }

    override fun type(): CustomPacketPayload.Type<out CustomPacketPayload> = TYPE
}