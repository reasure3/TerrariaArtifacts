package com.reasure.terrartifacts.datagen.client

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.block.ModBlocks
import com.reasure.terrartifacts.block.TinkerersWorkshopBlock
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.StringRepresentable
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.properties.Property
import net.neoforged.neoforge.client.model.generators.BlockStateProvider
import net.neoforged.neoforge.client.model.generators.ModelFile
import net.neoforged.neoforge.common.data.ExistingFileHelper

class ModBlockStateProvider(output: PackOutput, exFileHelper: ExistingFileHelper) :
    BlockStateProvider(output, Terrartifacts.ID, exFileHelper) {

    override fun registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.EXAMPLE_BLOCK)

        horizontalBlockWithProperty(ModBlocks.TINKERERS_WORKSHOP, TinkerersWorkshopBlock.PART)
        inventoryItem(ModBlocks.TINKERERS_WORKSHOP)
    }

    private fun <T : Comparable<T>> horizontalBlockWithProperty(
        block: Block,
        property: Property<T>,
        suffix: (T) -> String
    ) = horizontalBlock(block) { state: BlockState ->
        uncheckedFile(blockLoc(block).withSuffix(suffix(state.getValue(property))))
    }

    private fun <T> horizontalBlockWithProperty(
        block: Block,
        property: Property<T>
    ) where T : Comparable<T>, T : StringRepresentable =
        horizontalBlockWithProperty(block, property) { "_${it.serializedName}" }

    private fun simpleBlockWithItem(block: Block) = simpleBlockWithItem(block, cubeAll(block))

    private fun simpleBlockItem(block: Block, model: (Block) -> ModelFile) = simpleBlockItem(block, model(block))
    private fun inventoryItem(block: Block) =
        simpleBlockItem(block) { models().getExistingFile(blockLoc(block).withSuffix("_inventory")) }

    private fun blockLoc(block: Block) = BuiltInRegistries.BLOCK.getKey(block).withPrefix("block/")

    private fun uncheckedFile(loc: ResourceLocation) = ModelFile.UncheckedModelFile(loc)
}