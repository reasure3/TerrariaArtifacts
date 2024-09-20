package com.reasure.terrartifacts.datagen.client

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.block.ModBlocks
import com.reasure.terrartifacts.item.ModItems
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.PackOutput
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder
import net.neoforged.neoforge.client.model.generators.ItemModelProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper

class ModItemModelProvider(output: PackOutput, exFileHelper: ExistingFileHelper) :
    ItemModelProvider(output, Terrartifacts.ID, exFileHelper) {
    override fun registerModels() {
        blockItem(ModBlocks.EXAMPLE_BLOCK)
        basicItem(ModItems.COPPER_WATCH)
        basicItem(ModItems.TIN_WATCH)
        basicItem(ModItems.SILVER_WATCH)
        basicItem(ModItems.TUNGSTEN_WATCH)
        basicItem(ModItems.GOLD_WATCH)
        basicItem(ModItems.PLATINUM_WATCH)
    }

    private fun blockItem(block: Block): ItemModelBuilder {
        val name = BuiltInRegistries.BLOCK.getKey(block).path
        return withExistingParent(name, modLoc("block/${name}"))
    }
}