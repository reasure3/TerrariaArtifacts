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
        tag(ModTags.Items.INFORMATION)
            .addTag(ModTags.Items.INFORMATION_TIME)
            .addTag(ModTags.Items.INFORMATION_WEATHER)
            .addTag(ModTags.Items.INFORMATION_FISHING_POWER)
            .addTag(ModTags.Items.INFORMATION_POSITION)
            .addTag(ModTags.Items.INFORMATION_DEPTH)
            .addTag(ModTags.Items.INFORMATION_ENEMY_COUNT)
            .addTag(ModTags.Items.INFORMATION_KILL_COUNT)
            .addTag(ModTags.Items.INFORMATION_MOON_PHASE)
            .addTag(ModTags.Items.INFORMATION_MOVEMENT_SPEED)
            .addTag(ModTags.Items.INFORMATION_TREASURE)

        tag(ModTags.Items.INFORMATION_TIME)
            .addTag(ModTags.Items.INFORMATION_TIME_HOUR)
            .addTag(ModTags.Items.INFORMATION_TIME_HALF_HOUR)
            .addTag(ModTags.Items.INFORMATION_TIME_MINUTE)

        tag(ModTags.Items.INFORMATION_TIME_HOUR)
            .add(ModItems.COPPER_WATCH)
            .add(ModItems.TIN_WATCH)

        tag(ModTags.Items.INFORMATION_TIME_HALF_HOUR)
            .add(ModItems.SILVER_WATCH)
            .add(ModItems.TUNGSTEN_WATCH)

        tag(ModTags.Items.INFORMATION_TIME_MINUTE)
            .add(ModItems.GOLD_WATCH)
            .add(ModItems.PLATINUM_WATCH)
            .add(ModItems.GPS)

        tag(ModTags.Items.INFORMATION_WEATHER)
            .add(ModItems.WEATHER_RADIO)
            .add(ModItems.FISH_FINDER)

        tag(ModTags.Items.INFORMATION_FISHING_POWER)
            .add(ModItems.FISHERMAN_POCKET_GUIDE)
            .add(ModItems.FISH_FINDER)

        tag(ModTags.Items.INFORMATION_POSITION)
            .add(ModItems.COMPASS)
            .add(ModItems.GPS)

        tag(ModTags.Items.INFORMATION_DEPTH)
            .add(ModItems.DEPTH_METER)
            .add(ModItems.GPS)

        tag(ModTags.Items.INFORMATION_ENEMY_COUNT)
            .add(ModItems.RADAR)

        tag(ModTags.Items.INFORMATION_KILL_COUNT)
            .add(ModItems.TALLY_COUNTER)

        tag(ModTags.Items.INFORMATION_MOON_PHASE)
            .add(ModItems.SEXTANT)
            .add(ModItems.FISH_FINDER)

        tag(ModTags.Items.INFORMATION_MOVEMENT_SPEED)
            .add(ModItems.STOPWATCH)

        tag(ModTags.Items.INFORMATION_TREASURE)
            .add(ModItems.METAL_DETECTOR)

        with(tag(ModTags.Items.CURIOS_ACCESSORIES)) {
            ModItems.ITEMS.entries
                .map { it.get() }
                .filter { it is AccessoryItem }
                .forEach { add(it) }
        }
    }
}