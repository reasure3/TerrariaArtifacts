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

enum class InfoType(private val id: Int, private val _name: String, val messageKey: String, val tooltip: Component) :
    StringRepresentable {
    TIME(
        0, "time",
        TranslationKeys.BUTTON_MESSAGE_TOGGLE_TIME,
        Component.empty()
    ),
    WEATHER(
        1, "weather",
        TranslationKeys.BUTTON_MESSAGE_TOGGLE_WEATHER,
        Component.translatable(TranslationKeys.TOOLTIP_WEATHER_ITEM).withIcon()
    ),
    FISHING_POWER(
        2, "fishing_power",
        TranslationKeys.BUTTON_MESSAGE_TOGGLE_FISHING_POWER,
        Component.translatable(TranslationKeys.TOOLTIP_FISHING_POWER_ITEM).withIcon()
    ),
    POSITION(
        3, "position",
        TranslationKeys.BUTTON_MESSAGE_TOGGLE_POSITION,
        Component.translatable(TranslationKeys.TOOLTIP_POSITION_ITEM).withIcon()
    ),
    DEPTH(
        4, "depth",
        TranslationKeys.BUTTON_MESSAGE_TOGGLE_DEPTH,
        Component.translatable(TranslationKeys.TOOLTIP_DEPTH_ITEM).withIcon()
    ),
    ENEMY_COUNT(
        5, "enemy_count",
        TranslationKeys.BUTTON_MESSAGE_TOGGLE_ENEMY_COUNT,
        Component.translatable(TranslationKeys.TOOLTIP_ENEMY_COUNT_ITEM).withIcon()
    ),
    KILL_COUNT(
        6, "kill_count",
        TranslationKeys.BUTTON_MESSAGE_TOGGLE_KILL_COUNT,
        Component.translatable(TranslationKeys.TOOLTIP_KILL_COUNT_ITEM).withIcon()
    ),
    MOON_PHASE(
        7, "moon_phase",
        TranslationKeys.BUTTON_MESSAGE_TOGGLE_MOON_PHASE,
        Component.translatable(TranslationKeys.TOOLTIP_MOON_PHASE_ITEM).withIcon()
    ),
    MOVEMENT_SPEED(
        8, "movement_speed",
        TranslationKeys.BUTTON_MESSAGE_TOGGLE_MOVEMENT_SPEED,
        Component.translatable(TranslationKeys.TOOLTIP_MOVEMENT_SPEED_ITEM).withIcon()
    ),
    TREASURE(
        9, "treasure",
        TranslationKeys.BUTTON_MESSAGE_TOGGLE_TREASURE,
        Component.translatable(TranslationKeys.TOOLTIP_TREASURE_ITEM).withIcon()
    ),
    RARE_CREATURE(
        10, "rare_creatures",
        TranslationKeys.BUTTON_MESSAGE_TOGGLE_RARE_CREATURES,
        Component.translatable(TranslationKeys.TOOLTIP_RARE_CREATURES_ITEM).withIcon()
    ),
    DPS(
        11, "dps",
        TranslationKeys.BUTTON_MESSAGE_TOGGLE_DPS,
        Component.translatable(TranslationKeys.TOOLTIP_DPS_ITEM).withIcon()
    );

    override fun getSerializedName(): String = _name

    companion object {
        val CODEC: StringRepresentableCodec<InfoType> = StringRepresentable.fromEnum(::values)

        private val BY_ID: IntFunction<InfoType> = ByIdMap.continuous(
            InfoType::id, entries.toTypedArray(),
            ByIdMap.OutOfBoundsStrategy.ZERO
        )

        val STREAM_CODEC: StreamCodec<ByteBuf, InfoType> = ByteBufCodecs.idMapper(BY_ID, InfoType::id)
    }
}