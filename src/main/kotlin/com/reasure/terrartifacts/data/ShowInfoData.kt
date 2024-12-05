package com.reasure.terrartifacts.data

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
data class ShowInfoData(private val infoMap: EnumMap<InfoType, Boolean>) {
    operator fun get(type: InfoType) = infoMap[type] ?: false

    operator fun set(type: InfoType, value: Boolean) {
        infoMap[type] = value
    }

    companion object {
        fun create() = ShowInfoData(EnumMap(InfoType.entries.associateWith { true }))

        val CODEC: Codec<ShowInfoData> = Codec.unboundedMap(
            Codec.STRING.xmap(InfoType::valueOf, InfoType::name), // Key of Map
            Codec.BOOL // Value of Map
        ).xmap(
            { map -> ShowInfoData(EnumMap(map)) },
            { data -> data.infoMap }
        )

        val STREAM_CODEC: StreamCodec<ByteBuf, ShowInfoData> = object : StreamCodec<ByteBuf, ShowInfoData> {
            override fun decode(buf: ByteBuf): ShowInfoData {
                val size = ByteBufCodecs.VAR_INT.decode(buf)
                val map = EnumMap(InfoType.entries.associateWith { true })
                repeat(size) {
                    val type = InfoType.entries.getOrNull(ByteBufCodecs.VAR_INT.decode(buf))
                        ?: throw IllegalArgumentException("Invalid InfoType Index")
                    val value = ByteBufCodecs.BOOL.decode(buf)
                    map[type] = value
                }
                return ShowInfoData(map)
            }

            override fun encode(buf: ByteBuf, data: ShowInfoData) {
                val entries = data.infoMap.entries
                ByteBufCodecs.VAR_INT.encode(buf, entries.size)
                entries.forEach { (type, value) ->
                    ByteBufCodecs.VAR_INT.encode(buf, type.ordinal)
                    ByteBufCodecs.BOOL.encode(buf, value)
                }
            }
        }
    }
}