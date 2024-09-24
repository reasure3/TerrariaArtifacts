package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.network.chat.Component
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag

class GPSItem(properties: Properties) : AbstractInformationalItem(properties), ITimeInfo, IDirectionInfo, IDepthInfo {
    override fun shouldUseInfoPacket(): Boolean = false

    override fun watchType(): WatchType = WatchType.MINUTE

    override fun appendHoverText(
        stack: ItemStack,
        context: TooltipContext,
        tooltipComponents: MutableList<Component>,
        tooltipFlag: TooltipFlag
    ) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag)
        tooltipComponents.add(Component.translatable(TranslationKeys.TOOLTIP_WATCH_MINUTE))
        tooltipComponents.add(Component.translatable(TranslationKeys.TOOLTIP_COMPASS))
        tooltipComponents.add(Component.translatable(TranslationKeys.TOOLTIP_DEPTH_METER))
    }
}