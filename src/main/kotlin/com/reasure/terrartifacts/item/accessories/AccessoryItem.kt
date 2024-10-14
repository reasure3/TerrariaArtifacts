package com.reasure.terrartifacts.item.accessories

import com.reasure.terrartifacts.item.BaseItem
import com.reasure.terrartifacts.item.ModRarity
import net.minecraft.world.item.Rarity

open class AccessoryItem(
    properties: Properties = Properties(),
    rarity: Rarity = ModRarity.WHITE,
    maxStack: Int = 1,
    tooltipKeys: List<String> = listOf()
) : BaseItem(properties.stacksTo(maxStack), rarity, tooltipKeys)