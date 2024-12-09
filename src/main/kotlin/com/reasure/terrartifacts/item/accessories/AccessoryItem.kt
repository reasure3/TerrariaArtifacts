package com.reasure.terrartifacts.item.accessories

import com.reasure.terrartifacts.util.ComponentUtil.withIcon
import net.minecraft.network.chat.Component
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag

open class AccessoryItem(
    properties: Properties,
    val tooltipKeys: List<String> = listOf()
) : Item(properties) {
    override fun appendHoverText(
        stack: ItemStack,
        context: TooltipContext,
        tooltipComponents: MutableList<Component>,
        tooltipFlag: TooltipFlag
    ) {
        tooltipComponents.addAll(tooltipKeys.map { Component.translatable(it).withIcon() })
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag)
    }
}