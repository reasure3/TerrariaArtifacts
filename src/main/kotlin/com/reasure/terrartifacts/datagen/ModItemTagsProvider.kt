package com.reasure.terrartifacts.datagen

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.item.ModItems
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
        tag(ModTags.Items.FULL_WATCH)
            .add(ModItems.GOLD_WATCH)
            .add(ModItems.PLATINUM_WATCH)

        tag(ModTags.Items.CURIOS_ACCESSORIES)
            .add(ModItems.COPPER_WATCH)
            .add(ModItems.TIN_WATCH)
            .add(ModItems.SILVER_WATCH)
            .add(ModItems.TUNGSTEN_WATCH)
            .add(ModItems.GOLD_WATCH)
            .add(ModItems.PLATINUM_WATCH)
            .add(ModItems.WEATHER_RADIO)
            .add(ModItems.FISHERMAN_POCKET_GUIDE)
            .add(ModItems.COMPASS)
            .add(ModItems.DEPTH_METER)
            .add(ModItems.RADAR)
            .add(ModItems.GPS)
    }
}