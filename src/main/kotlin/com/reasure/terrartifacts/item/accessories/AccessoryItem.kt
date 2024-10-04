package com.reasure.terrartifacts.item.accessories

import com.reasure.terrartifacts.item.ModRarity
import net.minecraft.network.chat.Component
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Rarity
import net.minecraft.world.item.TooltipFlag

open class AccessoryItem(
    properties: Properties = Properties(),
    rarity: Rarity = ModRarity.WHITE,
    maxStack: Int = 1,
    tooltipKeys: List<String> = listOf()
) : Item(properties.stacksTo(maxStack).rarity(rarity)) {
    internal val tooltips: List<Component> = tooltipKeys.map { Component.translatable(it) }.toList()

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