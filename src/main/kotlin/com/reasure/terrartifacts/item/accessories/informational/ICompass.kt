package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.client.player.LocalPlayer
import net.minecraft.network.chat.Component

interface ICompass {
    companion object {
        fun getInformation(player: LocalPlayer): Component {
            return Component.translatable(
                TranslationKeys.INFO_DIRECTION_KEY,
                String.format("%.1f", player.x),
                String.format("%.1f", player.z)
            ).withStyle(AbstractInformationalItem.ICON)
        }
    }
}