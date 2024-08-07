package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys.HALF_HOUR_TOOLTIP_KEY
import com.reasure.terrartifacts.util.TranslationKeys.HOUR_TOOLTIP_KEY
import com.reasure.terrartifacts.util.TranslationKeys.MINUTE_TOOLTIP_KEY
import net.minecraft.network.chat.Component


enum class WatchType(val tooltip: Component) {
    HOUR(Component.translatable(HOUR_TOOLTIP_KEY)),
    HALF_HOUR(Component.translatable(HALF_HOUR_TOOLTIP_KEY)),
    MINUTE(Component.translatable(MINUTE_TOOLTIP_KEY)),
}