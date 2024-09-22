package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.network.chat.Component
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag

class GPSItem(properties: Properties) : AbstractInformationalItem(properties), IWatch, ICompass, IDepthMeter {
    override fun shouldUseInfoPacket(): Boolean = false

    override fun watchType(): WatchType = WatchType.MINUTE

    override fun appendHoverText(
        stack: ItemStack,
        context: TooltipContext,
        tooltipComponents: MutableList<Component>,
        tooltipFlag: TooltipFlag
    ) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag)
        tooltipComponents.add(Component.translatable(TranslationKeys.MINUTE_TOOLTIP_KEY))
        tooltipComponents.add(Component.translatable(TranslationKeys.COMPASS_TOOLTIP_KEY))
        tooltipComponents.add(Component.translatable(TranslationKeys.DEPTH_METER_TOOLTIP_KEY))
    }
}