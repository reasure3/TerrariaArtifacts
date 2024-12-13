package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.ComponentUtil.withIcon
import com.reasure.terrartifacts.util.TranslationKeys
import io.netty.buffer.ByteBuf
import net.minecraft.network.chat.Component
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec
import net.minecraft.util.ByIdMap
import net.minecraft.util.StringRepresentable
import net.minecraft.util.StringRepresentable.StringRepresentableCodec
import java.util.function.IntFunction

enum class WatchType(private val id: Int, private val _name: String, val tooltip: Component) : StringRepresentable {
    NONE(0, "none", Component.empty()),
    HOUR(1, "hour", Component.translatable(TranslationKeys.TOOLTIP_TIME_HOUR_ITEM).withIcon()),
    HALF_HOUR(2, "half_hour", Component.translatable(TranslationKeys.TOOLTIP_TIME_HALF_HOUR_ITEM).withIcon()),
    MINUTE(3, "minute", Component.translatable(TranslationKeys.TOOLTIP_TIME_MINUTE_ITEM).withIcon());

    override fun getSerializedName(): String = _name

    companion object {
        val CODEC: StringRepresentableCodec<WatchType> = StringRepresentable.fromEnum(WatchType::values)

        private val BY_ID: IntFunction<WatchType> = ByIdMap.continuous(
            WatchType::id, WatchType.entries.toTypedArray(),
            ByIdMap.OutOfBoundsStrategy.ZERO
        )

        val STREAM_CODEC: StreamCodec<ByteBuf, WatchType> = ByteBufCodecs.idMapper(BY_ID, WatchType::id)
    }
}