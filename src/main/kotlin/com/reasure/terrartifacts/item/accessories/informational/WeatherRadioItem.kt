package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.network.chat.Component
import net.minecraft.world.item.Item.Properties
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag

class WeatherRadioItem(properties: Properties) : AbstractInformationalItem(properties, InformationType.WEATHER),
    IWeatherRadio {
    override fun shouldUseInfoPacket(): Boolean = false

    override fun appendHoverText(
        stack: ItemStack,
        context: TooltipContext,
        tooltipComponents: MutableList<Component>,
        tooltipFlag: TooltipFlag
    ) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag)
        tooltipComponents.add(Component.translatable(TranslationKeys.WEATHER_RADIO_TOOLTIP_KEY))
    }
}