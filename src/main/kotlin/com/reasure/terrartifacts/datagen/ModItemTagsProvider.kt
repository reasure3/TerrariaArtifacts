package com.reasure.terrartifacts.datagen

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.item.ModItems
import com.reasure.terrartifacts.item.accessories.AccessoryItem
import com.reasure.terrartifacts.util.ModTags
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class ModItemTagsProvider(
    output: PackOutput,
    registries: CompletableFuture<HolderLookup.Provider>,
    blockTags: CompletableFuture<TagLookup<Block>>,
    exFileHelper: ExistingFileHelper
) : ItemTagsProvider(output, registries, blockTags, Terrartifacts.ID, exFileHelper) {
    override fun addTags(provider: HolderLookup.Provider) {
        with(tag(ModTags.Items.CURIOS_ACCESSORIES)) {
            ModItems.ITEMS.entries
                .map { it.get() }
                .filter { it is AccessoryItem }
                .forEach { add(it) }
        }
    }
}