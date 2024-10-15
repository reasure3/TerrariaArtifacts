package com.reasure.terrartifacts.datagen.client

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.block.ModBlocks
import com.reasure.terrartifacts.block.TinkerersWorkshopBlock
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.PackOutput
import net.minecraft.util.StringRepresentable
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.properties.Property
import net.neoforged.neoforge.client.model.generators.BlockStateProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper

class ModBlockStateProvider(output: PackOutput, exFileHelper: ExistingFileHelper) :
    BlockStateProvider(output, Terrartifacts.ID, exFileHelper) {

    override fun registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.EXAMPLE_BLOCK)

        horizontalBlockWithProperty(ModBlocks.TINKERERS_WORKSHOP, TinkerersWorkshopBlock.PART)
    }

    private fun <T : Comparable<T>> horizontalBlockWithProperty(
        block: Block,
        property: Property<T>,
        postfix: (T) -> String
    ) {
        val name = BuiltInRegistries.BLOCK.getKey(block).path
        horizontalBlock(block) { state: BlockState ->
            models().getExistingFile(Terrartifacts.modLoc("$name${postfix(state.getValue(property))}"))
        }
        generateItem(block)
    }

    private fun <T> horizontalBlockWithProperty(
        block: Block,
        property: Property<T>
    ) where T : Comparable<T>, T : StringRepresentable =
        horizontalBlockWithProperty(block, property) { "_${it.serializedName}" }

    private fun simpleBlockWithItem(block: Block) = simpleBlockWithItem(block, cubeAll(block))
    private fun generateItem(block: Block) =
        itemModels().basicItem(Terrartifacts.modLoc(BuiltInRegistries.BLOCK.getKey(block).path))
}