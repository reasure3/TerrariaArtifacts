package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import io.netty.buffer.ByteBuf
import net.minecraft.network.chat.Component
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec
import net.minecraft.util.ByIdMap
import net.minecraft.util.StringRepresentable
import net.minecraft.util.StringRepresentable.StringRepresentableCodec
import java.util.function.IntFunction

enum class InfoType(private val id: Int, private val _name: String, val message: Component) :
    StringRepresentable {
    TIME(
        0, "time",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_TIME)
    ),
    WEATHER(
        1, "weather",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_WEATHER)
    ),
    FISHING_POWER(
        2, "fishing_power",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_FISHING_POWER)
    ),
    POSITION(
        3, "position",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_POSITION)
    ),
    DEPTH(
        4, "depth",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_DEPTH)
    ),
    ENEMY_COUNT(
        5, "enemy_count",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_ENEMY_COUNT)
    ),
    KILL_COUNT(
        6, "kill_count",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_KILL_COUNT)
    ),
    MOON_PHASE(
        7, "moon_phase",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_MOON_PHASE)
    ),
    MOVEMENT_SPEED(
        8, "movement_speed",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_MOVEMENT_SPEED)
    ),
    TREASURE(
        9, "treasure",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_TREASURE)
    ),
    RARE_CREATURE(
        10, "rare_creatures",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_RARE_CREATURES)
    ),
    DPS(
        11, "dps",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_DPS)
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