package com.reasure.terrartifacts.datagen.client

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.item.ModItems
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder
import net.neoforged.neoforge.client.model.generators.ItemModelProvider
import net.neoforged.neoforge.client.model.generators.ModelFile
import net.neoforged.neoforge.common.data.ExistingFileHelper
import java.util.*

class ModItemModelProvider(output: PackOutput, exFileHelper: ExistingFileHelper) :
    ItemModelProvider(output, Terrartifacts.ID, exFileHelper) {
    val generatedItem: ModelFile = ModelFile.UncheckedModelFile("item/generated")

    override fun registerModels() {
        clockItem(ModItems.COPPER_CLOCK)
        clockItem(ModItems.TIN_CLOCK)
        clockItem(ModItems.SILVER_CLOCK)
        clockItem(ModItems.TUNGSTEN_CLOCK)
        clockItem(ModItems.PLATINUM_CLOCK)

        basicItem(ModItems.COPPER_WATCH)
        basicItem(ModItems.TIN_WATCH)
        basicItem(ModItems.SILVER_WATCH)
        basicItem(ModItems.TUNGSTEN_WATCH)
        basicItem(ModItems.GOLD_WATCH)
        basicItem(ModItems.PLATINUM_WATCH)
        basicItem(ModItems.WEATHER_RADIO)
        basicItem(ModItems.FISHERMAN_POCKET_GUIDE)
        basicItem(ModItems.COMPASS)
        basicItem(ModItems.DEPTH_METER)
        basicItem(ModItems.RADAR)
        basicItem(ModItems.TALLY_COUNTER)
        basicItem(ModItems.SEXTANT)
        basicItem(ModItems.STOPWATCH)
        basicItem(ModItems.METAL_DETECTOR)
        basicItem(ModItems.LIFEFORM_ANALYZER)
        basicItem(ModItems.DPS_METER)
        basicItem(ModItems.GPS)
        basicItem(ModItems.FISH_FINDER)
        basicItem(ModItems.REK3000)
        basicItem(ModItems.GOBLIN_TECH)
        basicItem(ModItems.PDA)
    }

    private fun clockItem(item: Item): ItemModelBuilder {
        val subClocks = mutableListOf<ItemModelBuilder>()
        val loc = BuiltInRegistries.ITEM.getKey(item).withPrefix("item/clock/")
        for (i in 1..63) {
            val clock = loc.withSuffix(String.format(Locale.ROOT, "_%02d", i))
            subClocks.add(
                getBuilder(clock.toString())
                    .parent(generatedItem)
                    .texture("layer0", clock)
            )
        }

        var model = getBuilder(BuiltInRegistries.ITEM.getKey(item).path)
            .parent(generatedItem)
            .texture("layer0", loc.withSuffix("_00"))

        model = model.override()
            .predicate(ResourceLocation.withDefaultNamespace("time"), 0.0f)
            .model(model)
            .end()

        for (i in 0..62) {
            model = model.override()
                .predicate(ResourceLocation.withDefaultNamespace("time"), 0.0078125f + 0.015625f * i)
                .model(subClocks[i])
                .end()
        }

        return model.override()
            .predicate(ResourceLocation.withDefaultNamespace("time"), 0.9921875f)
            .model(model)
            .end()
    }
}