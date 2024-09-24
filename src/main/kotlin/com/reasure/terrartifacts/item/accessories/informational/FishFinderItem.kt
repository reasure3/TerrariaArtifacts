package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.network.chat.Component
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag

class FishFinderItem(properties: Properties) : AbstractInformationalItem(properties), IWeatherInfo, IFishingPowerInfo,
    IMoonPhaseInfo {
    override fun shouldUseInfoPacket(): Boolean = false

    override fun appendHoverText(
        stack: ItemStack,
        context: TooltipContext,
        tooltipComponents: MutableList<Component>,
        tooltipFlag: TooltipFlag
    ) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag)
        tooltipComponents.add(Component.translatable(TranslationKeys.TOOLTIP_WEATHER_RADIO))
        tooltipComponents.add(Component.translatable(TranslationKeys.TOOLTIP_FISHERMAN_POCKET_GUIDE))
        tooltipComponents.add(Component.translatable(TranslationKeys.TOOLTIP_SEXTANT))
    }
}