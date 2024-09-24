package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.client.player.LocalPlayer
import net.minecraft.network.chat.Component

interface IDepthInfo {
    companion object {
        fun getInformation(player: LocalPlayer): Component {
            return Component.translatable(
                TranslationKeys.INFO_DEPTH,
                player.blockY
            ).withStyle(AbstractInformationalItem.ICON)
        }
    }
}