package com.reasure.terrartifacts.datagen

import com.reasure.terrartifacts.block.ModBlocks
import com.reasure.terrartifacts.block.TinkerersWorkshopBlock
import com.reasure.terrartifacts.block.properties.HorizontalPart
import net.minecraft.core.HolderLookup
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.level.block.Block

class ModBlockLootTableProvider(registries: HolderLookup.Provider) :
    BlockLootSubProvider(setOf(), FeatureFlags.REGISTRY.allFlags(), registries) {
    override fun generate() {
        dropSelf(ModBlocks.EXAMPLE_BLOCK)
        add(
            ModBlocks.TINKERERS_WORKSHOP,
            createSinglePropConditionTable(
                ModBlocks.TINKERERS_WORKSHOP,
                TinkerersWorkshopBlock.PART,
                HorizontalPart.LEFT
            )
        )
    }

    override fun getKnownBlocks(): MutableIterable<Block> =
        ModBlocks.BLOCKS.entries.map { it.value() }.toMutableList()
}