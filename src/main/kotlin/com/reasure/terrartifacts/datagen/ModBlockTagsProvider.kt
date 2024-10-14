package com.reasure.terrartifacts.datagen

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.block.ModBlocks
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.tags.BlockTags
import net.neoforged.neoforge.common.data.BlockTagsProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class ModBlockTagsProvider(
    output: PackOutput,
    registries: CompletableFuture<HolderLookup.Provider>,
    exFileHelper: ExistingFileHelper?
) : BlockTagsProvider(output, registries, Terrartifacts.ID, exFileHelper) {
    override fun addTags(provider: HolderLookup.Provider) {
        tag(BlockTags.MINEABLE_WITH_AXE)
            .add(ModBlocks.TINKERERS_WORKSHOP)
    }
}