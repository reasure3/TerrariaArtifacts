package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys.TIME_BUTTON_MESSAGE
import com.reasure.terrartifacts.util.TranslationKeys.WEATHER_BUTTON_MESSAGE
import net.minecraft.network.chat.Component

enum class InformationType(val message: Component) {
    TIME(Component.translatable(TIME_BUTTON_MESSAGE)),
    WEATHER(Component.translatable(WEATHER_BUTTON_MESSAGE))
}