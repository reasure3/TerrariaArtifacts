package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys.TOOLTIP_WATCH_HALF_HOUR
import com.reasure.terrartifacts.util.TranslationKeys.TOOLTIP_WATCH_HOUR
import com.reasure.terrartifacts.util.TranslationKeys.TOOLTIP_WATCH_MINUTE
import net.minecraft.network.chat.Component


enum class WatchType(val tooltip: Component) {
    HOUR(Component.translatable(TOOLTIP_WATCH_HOUR)),
    HALF_HOUR(Component.translatable(TOOLTIP_WATCH_HALF_HOUR)),
    MINUTE(Component.translatable(TOOLTIP_WATCH_MINUTE)),
}