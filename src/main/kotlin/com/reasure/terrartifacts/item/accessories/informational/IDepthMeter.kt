package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.client.player.LocalPlayer
import net.minecraft.network.chat.Component

interface IDepthMeter {
    companion object {
        fun getInformation(player: LocalPlayer): Component {
            return Component.translatable(
                TranslationKeys.INFO_DEPTH_KEY,
                String.format("%.1f", player.y)
            ).withStyle(AbstractInformationalItem.ICON)
        }
    }
}