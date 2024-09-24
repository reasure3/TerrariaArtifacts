package com.reasure.terrartifacts.item.accessories.informational

import net.minecraft.network.chat.Component
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag

class WatchItem(properties: Properties, private val watchType: WatchType) :
    AbstractInformationalItem(properties), ITimeInfo {

    override fun shouldUseInfoPacket(): Boolean = true

    override fun watchType(): WatchType = this.watchType

    override fun appendHoverText(
        stack: ItemStack,
        context: TooltipContext,
        tooltipComponents: MutableList<Component>,
        tooltipFlag: TooltipFlag
    ) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag)
        tooltipComponents.add(watchType.tooltip)
    }
}