package com.reasure.terrartifacts.datagen

import com.reasure.terrartifacts.item.ModItems
import com.reasure.terrartifacts.util.ModTags
import net.minecraft.core.HolderLookup
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
            .define('X', Items.REDSTONE)
            .pattern(" # ")
            .pattern("#X#")
            .pattern(" # ")
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .save(recipeOutput)
    }

    private fun watchRecipe(watch: Item, clock: Item, recipeOutput: RecipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, watch)
            .requires(clock)
            .requires(Tags.Items.CHAINS)
            .unlockedBy("has_clock", has(clock))
            .save(recipeOutput)
    }


    private fun addTinkersRecipe(output: RecipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.GPS)
            .requires(ModTags.Items.FULL_WATCH)
            .requires(ModItems.COMPASS)
            .requires(ModItems.DEPTH_METER)
            .unlockedBy("has_watch", has(ModTags.Items.FULL_WATCH))
            .unlockedBy("has_compass", has(ModItems.COMPASS))
            .unlockedBy("has_depth_meter", has(ModItems.DEPTH_METER))
            .save(output)
    }
}