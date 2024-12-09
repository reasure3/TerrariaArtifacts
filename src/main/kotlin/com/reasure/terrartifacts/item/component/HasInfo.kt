package com.reasure.terrartifacts.item.component

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import com.reasure.terrartifacts.item.accessories.informational.InfoType
import com.reasure.terrartifacts.item.accessories.informational.WatchType
import io.netty.buffer.ByteBuf
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec
import java.util.*

/**
 * Target: Item
 */
data class HasInfo(val infoMap: EnumMap<InfoType, Boolean>, val watchType: WatchType = WatchType.NONE) {
    operator fun get(type: InfoType): Boolean {
        val hasInfoData = infoMap[type] ?: DEFAULT_VALUE
        if (hasInfoData && type == InfoType.TIME) {
            return watchType != WatchType.NONE
        }
        return hasInfoData
    }

    operator fun get(type: WatchType) = (infoMap[InfoType.TIME] ?: DEFAULT_VALUE) && watchType == type

    operator fun set(type: InfoType, value: Boolean) {
        infoMap[type] = value
    }

    companion object {
        private const val DEFAULT_VALUE = false

        fun create(vararg infoType: InfoType, watchType: WatchType = WatchType.NONE): HasInfo {
            val map = createMap()
            for (type in infoType) {
                map[type] = true
            }
            return HasInfo(map, watchType)
        }

        fun all() = HasInfo(EnumMap(InfoType.entries.associateWith { true }), WatchType.MINUTE)

        private fun createMap() = EnumMap(InfoType.entries.associateWith { DEFAULT_VALUE })

        private val INFO_CODEC: Codec<EnumMap<InfoType, Boolean>> = Codec.unboundedMap(
            InfoType.CODEC,
            Codec.BOOL
        ).xmap(
            { map -> createMap().apply { putAll(map) } }, // Decoding
            { enumMap -> enumMap.filterValues { it != DEFAULT_VALUE } }  // Encoding
        )

        val CODEC: Codec<HasInfo> = RecordCodecBuilder.create { instance ->
            instance.group(
                INFO_CODEC.fieldOf("info_types_to_display").forGetter(HasInfo::infoMap),
                WatchType.CODEC.optionalFieldOf("watch_type", WatchType.NONE).forGetter(HasInfo::watchType)
            ).apply(instance, ::HasInfo)
        }

        private val MAP_CODEC: StreamCodec<ByteBuf, EnumMap<InfoType, Boolean>> = ByteBufCodecs.map(
            { createMap() },
            InfoType.STREAM_CODEC, ByteBufCodecs.BOOL,
            InfoType.entries.size
        )

        val STREAM_CODEC: StreamCodec<ByteBuf, HasInfo> = StreamCodec.composite(
            MAP_CODEC, HasInfo::infoMap,
            WatchType.STREAM_CODEC, HasInfo::watchType,
            ::HasInfo,
        )
    }
}
