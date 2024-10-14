package com.reasure.terrartifacts.item

import com.reasure.terrartifacts.util.ComponentUtil.withIcon
import net.minecraft.network.chat.Component
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Rarity
import net.minecraft.world.item.TooltipFlag

open class BaseItem(
    properties: Properties = Properties(),
    rarity: Rarity = ModRarity.WHITE,
    tooltipKeys: List<String> = listOf()
) : Item(properties.rarity(rarity)) {
    private val tooltips: List<Component> = tooltipKeys.map { Component.translatable(it).withIcon() }.toList()

    override fun appendHoverText(
        stack: ItemStack,
        context: TooltipContext,
        tooltipComponents: MutableList<Component>,
        tooltipFlag: TooltipFlag
    ) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag)
        tooltipComponents.addAll(tooltips)
    }
}