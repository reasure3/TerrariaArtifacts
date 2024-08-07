package com.reasure.terrartifacts.datagen.client

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.block.ModBlocks
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.client.model.generators.BlockStateProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper

class ModBlockStateProvider(output: PackOutput, exFileHelper: ExistingFileHelper) :
    BlockStateProvider(output, Terrartifacts.ID, exFileHelper) {

    override fun registerStatesAndModels() {
        simpleBlock(ModBlocks.EXAMPLE_BLOCK)
    }
}