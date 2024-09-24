package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraft.world.level.Level

interface IMoonPhaseInfo {
    companion object {
        fun getInformation(level: Level): Component {
            if (level.dimensionType().natural) {
                val phase = ((level.dayTime / 24000) % 8).toInt()
                return when (phase) {
                    0 -> Component.translatable(TranslationKeys.INFO_MOON_PHASE_FULL_MOON)
                    1 -> Component.translatable(TranslationKeys.INFO_MOON_PHASE_WANING_GIBBOUS)
                    2 -> Component.translatable(TranslationKeys.INFO_MOON_PHASE_LAST_QUARTER)
                    3 -> Component.translatable(TranslationKeys.INFO_MOON_PHASE_WANING_CRESCENT)
                    4 -> Component.translatable(TranslationKeys.INFO_MOON_PHASE_NEW_MOON)
                    5 -> Component.translatable(TranslationKeys.INFO_MOON_PHASE_WAXING_CRESCENT)
                    6 -> Component.translatable(TranslationKeys.INFO_MOON_PHASE_FIRST_QUARTER)
                    7 -> Component.translatable(TranslationKeys.INFO_MOON_PHASE_WAXING_GIBBOUS)
                    else -> Component.translatable(TranslationKeys.INFO_NO_MOON_PHASE).withStyle(ChatFormatting.GRAY)
                }.withStyle(AbstractInformationalItem.ICON)
            }

            return when (level.dimension()) {
                Level.NETHER -> Component.translatable(TranslationKeys.INFO_NETHER_MOON_PHASE)
                Level.END -> Component.translatable(TranslationKeys.INFO_END_MOON_PHASE)
                else -> Component.translatable(TranslationKeys.INFO_NO_MOON_PHASE)
            }.withStyle(AbstractInformationalItem.ICON.withColor(ChatFormatting.GRAY))
        }
    }
}