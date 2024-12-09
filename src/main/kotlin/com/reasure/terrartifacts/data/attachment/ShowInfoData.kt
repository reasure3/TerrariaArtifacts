package com.reasure.terrartifacts.data.attachment

import com.mojang.serialization.Codec
import com.reasure.terrartifacts.item.accessories.informational.InfoType
import io.netty.buffer.ByteBuf
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec
import java.util.*

/**
 * 플레이어가 정보 악세서리 소지 시, 해당 정보를 보여줄지 여부를 저장
 *
 * 인벤토리 화면에서 플레이어가 직접 수정 가능
 *
 * Target: Player
 * @see ModDataAttachments
 */
data class ShowInfoData(val infoMap: EnumMap<InfoType, Boolean>) {
    operator fun get(type: InfoType) = infoMap[type] ?: true

    operator fun set(type: InfoType, value: Boolean) {
        infoMap[type] = value
    }

    companion object {
        fun create() = ShowInfoData(createMap())

        private fun createMap() = EnumMap(InfoType.entries.associateWith { true })

        val CODEC: Codec<ShowInfoData> = Codec.unboundedMap(
            InfoType.CODEC, // Key of Map
            Codec.BOOL // Value of Map
        ).xmap(
            { map -> ShowInfoData(EnumMap(map)) },
            { data -> data.infoMap }
        )

        private val MAP_CODEC: StreamCodec<ByteBuf, EnumMap<InfoType, Boolean>> = ByteBufCodecs.map(
            { createMap() },
            InfoType.STREAM_CODEC, ByteBufCodecs.BOOL,
            InfoType.entries.size
        )

        val STREAM_CODEC: StreamCodec<ByteBuf, ShowInfoData> = StreamCodec.composite(
            MAP_CODEC, ShowInfoData::infoMap,
            ::ShowInfoData,
        )
    }
}