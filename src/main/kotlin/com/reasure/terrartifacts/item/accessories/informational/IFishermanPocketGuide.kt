package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.client.player.LocalPlayer
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.ai.attributes.Attributes

interface IFishermanPocketGuide {
    companion object {
        fun getInformation(player: LocalPlayer): Component {
            val luck = player.attributes.getValue(Attributes.LUCK)
            return Component.translatable(
                TranslationKeys.INFO_FISHING_POWER,
                String.format("%.1f", luck)
            ).withStyle(AbstractInformationalItem.ICON)
        }
    }
}