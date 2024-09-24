package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.network.chat.Component
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag

class TallyCounterItem(properties: Properties) : AbstractInformationalItem(properties), IKillCountInfo {
    override fun shouldUseInfoPacket(): Boolean = true

    override fun appendHoverText(
        stack: ItemStack,
        context: TooltipContext,
        tooltipComponents: MutableList<Component>,
        tooltipFlag: TooltipFlag
    ) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag)
        tooltipComponents.add(Component.translatable(TranslationKeys.TOOLTIP_TALLY_COUNTER))
    }
}