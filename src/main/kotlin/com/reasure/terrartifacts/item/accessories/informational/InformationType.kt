package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.network.chat.Component

enum class InformationType(val id: String, val message: Component) {
    TIME(
        "time",
        Component.translatable(TranslationKeys.TIME_BUTTON_MESSAGE)
    ),
    WEATHER(
        "weather",
        Component.translatable(TranslationKeys.WEATHER_BUTTON_MESSAGE)
    ),
    FISHING_POWER(
        "fishing_power",
        Component.translatable(TranslationKeys.FISHING_POWER_BUTTON_MESSAGE)
    ),
    DIRECTION(
        "direction",
        Component.translatable(TranslationKeys.DIRECTION_BUTTON_MESSAGE)
    ),
    DEPTH(
        "depth",
        Component.translatable(TranslationKeys.DEPTH_BUTTON_MESSAGE)
    )
}