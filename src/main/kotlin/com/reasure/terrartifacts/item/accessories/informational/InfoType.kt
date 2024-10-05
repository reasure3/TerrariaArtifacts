package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.network.chat.Component

enum class InfoType(val id: String, val message: Component) {
    TIME(
        "time",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_TIME)
    ),
    WEATHER(
        "weather",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_WEATHER)
    ),
    FISHING_POWER(
        "fishing_power",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_FISHING_POWER)
    ),
    POSITION(
        "position",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_POSITION)
    ),
    DEPTH(
        "depth",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_DEPTH)
    ),
    ENEMY_COUNT(
        "enemy_count",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_ENEMY_COUNT)
    ),
    KILL_COUNT(
        "kill_count",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_KILL_COUNT)
    ),
    MOON_PHASE(
        "moon_phase",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_MOON_PHASE)
    ),
    MOVEMENT_SPEED(
        "movement_speed",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_MOVEMENT_SPEED)
    ),
    TREASURE(
        "treasure",
        Component.translatable(TranslationKeys.BUTTON_MESSAGE_TOGGLE_TREASURE)
    ),
    RARE_CREATURE(
        "rare_creatures",
        Component.translatable(TranslationKeys.TOOLTIP_LIFEFORM_ANALYZER)
    )
}