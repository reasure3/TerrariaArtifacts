package com.reasure.terrartifacts.datagen

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.item.ModItems
import com.reasure.terrartifacts.util.ModTags
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.data.recipes.ShapelessRecipeBuilder
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.neoforged.neoforge.common.Tags
import java.util.concurrent.CompletableFuture

class ModRecipeProvider(output: PackOutput, registries: CompletableFuture<HolderLookup.Provider>) :
    RecipeProvider(output, registries) {
    override fun buildRecipes(recipeOutput: RecipeOutput) {
        clockRecipe(ModItems.COPPER_CLOCK, Tags.Items.INGOTS_COPPER, recipeOutput)
        clockRecipe(ModItems.TIN_CLOCK, ModTags.Items.INGOTS_TIN, recipeOutput)
        clockRecipe(ModItems.SILVER_CLOCK, ModTags.Items.INGOTS_SILVER, recipeOutput)
        clockRecipe(ModItems.TUNGSTEN_CLOCK, ModTags.Items.INGOTS_TUNGSTEN, recipeOutput)
        clockRecipe(ModItems.PLATINUM_CLOCK, ModTags.Items.INGOTS_PLATINUM, recipeOutput)

        watchRecipe(ModItems.COPPER_WATCH, ModItems.COPPER_CLOCK, recipeOutput)
        watchRecipe(ModItems.TIN_WATCH, ModItems.TIN_CLOCK, recipeOutput)
        watchRecipe(ModItems.SILVER_WATCH, ModItems.SILVER_CLOCK, recipeOutput)
        watchRecipe(ModItems.TUNGSTEN_WATCH, ModItems.TUNGSTEN_CLOCK, recipeOutput)
        watchRecipe(ModItems.GOLD_WATCH, Items.CLOCK, recipeOutput)
        watchRecipe(ModItems.PLATINUM_WATCH, ModItems.PLATINUM_CLOCK, recipeOutput)

        addTinkersRecipe(recipeOutput)
    }

    private fun clockRecipe(clock: Item, mainIngredient: TagKey<Item>, recipeOutput: RecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, clock)
            .define('#', mainIngredient)
            .defineBy('X', Items.REDSTONE)
            .pattern(" # ")
            .pattern("#X#")
            .pattern(" # ")
            .save(recipeOutput)
    }

    private fun watchRecipe(watch: Item, clock: Item, recipeOutput: RecipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, watch)
            .requiresBy(clock)
            .requires(Tags.Items.CHAINS)
            .save(recipeOutput)
    }


    private fun addTinkersRecipe(output: RecipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.GPS)
            .requiresBy(ModItems.GOLD_WATCH)
            .requiresBy(ModItems.COMPASS)
            .requiresBy(ModItems.DEPTH_METER)
            .save(output, Terrartifacts.modLoc("gps_from_gold_watch"))

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.GPS)
            .requiresBy(ModItems.PLATINUM_WATCH)
            .requiresBy(ModItems.COMPASS)
            .requiresBy(ModItems.DEPTH_METER)
            .save(output, Terrartifacts.modLoc("gps_from_platinum_watch"))

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.FISH_FINDER)
            .requiresBy(ModItems.WEATHER_RADIO)
            .requiresBy(ModItems.FISHERMAN_POCKET_GUIDE)
            .requiresBy(ModItems.SEXTANT)
            .save(output)

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.REK3000)
            .requiresBy(ModItems.RADAR)
            .requiresBy(ModItems.TALLY_COUNTER)
            .requiresBy(ModItems.LIFEFORM_ANALYZER)
            .save(output)

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.GOBLIN_TECH)
            .requiresBy(ModItems.STOPWATCH)
            .requiresBy(ModItems.METAL_DETECTOR)
            .requiresBy(ModItems.DPS_METER)
            .save(output)

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PDA)
            .requiresBy(ModItems.GPS)
            .requiresBy(ModItems.FISH_FINDER)
            .requiresBy(ModItems.REK3000)
            .requiresBy(ModItems.GOBLIN_TECH)
            .save(output)
    }

    private fun ShapedRecipeBuilder.defineBy(symbol: Char, item: Item) =
        define(symbol, item).unlockedBy("has_${BuiltInRegistries.ITEM.getKey(item).path.replace('/', '_')}", has(item))

    private fun ShapelessRecipeBuilder.requiresBy(item: Item) =
        requires(item).unlockedBy("has_${BuiltInRegistries.ITEM.getKey(item).path.replace('/', '_')}", has(item))
}