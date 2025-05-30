package com.reasure.terrartifacts.item

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.block.ModBlocks
import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModCreativeTabs {
    val CREATIVE_TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Terrartifacts.ID)

    @Suppress("unused")
    val TERRA_ARTIFACTS: CreativeModeTab by CREATIVE_TABS.register("terra_artifacts") { ->
        CreativeModeTab.builder()
            .icon { ItemStack(ModItems.COPPER_WATCH) }
            .title(Component.translatable(TranslationKeys.GROUP_TERRARTIFACTS_KEY))
            .displayItems { _, entries ->
                with(entries) {
                    accept(ModItems.COPPER_CLOCK)
                    accept(ModItems.TIN_CLOCK)
                    accept(ModItems.SILVER_CLOCK)
                    accept(ModItems.TUNGSTEN_CLOCK)
                    accept(Items.CLOCK)
                    accept(ModItems.PLATINUM_CLOCK)
                    accept(ModItems.COPPER_WATCH)
                    accept(ModItems.TIN_WATCH)
                    accept(ModItems.SILVER_WATCH)
                    accept(ModItems.TUNGSTEN_WATCH)
                    accept(ModItems.GOLD_WATCH)
                    accept(ModItems.PLATINUM_WATCH)
                    accept(ModItems.WEATHER_RADIO)
                    accept(ModItems.FISHERMAN_POCKET_GUIDE)
                    accept(ModItems.COMPASS)
                    accept(ModItems.DEPTH_METER)
                    accept(ModItems.RADAR)
                    accept(ModItems.TALLY_COUNTER)
                    accept(ModItems.SEXTANT)
                    accept(ModItems.STOPWATCH)
                    accept(ModItems.METAL_DETECTOR)
                    accept(ModItems.LIFEFORM_ANALYZER)
                    accept(ModItems.DPS_METER)
                    accept(ModItems.GPS)
                    accept(ModItems.FISH_FINDER)
                    accept(ModItems.REK3000)
                    accept(ModItems.GOBLIN_TECH)
                    accept(ModItems.PDA)
                }
            }
            .build()
    }

    @Suppress("unused")
    val DEVELOP_TAB: CreativeModeTab by CREATIVE_TABS.register("terra_artifacts_develop") { ->
        CreativeModeTab.builder()
            .icon { ItemStack(ModBlocks.EXAMPLE_BLOCK) }
            .title(Component.translatable(TranslationKeys.GROUP_TERRARTIFACTS_DEVELOP_KEY))
            .alignedRight()
            .withSearchBar()
            .displayItems { parameters, entries ->
                if (parameters.hasPermissions) {
                    ModItems.ITEMS.entries.forEach {
                        entries.accept(ItemStack(it))
                    }
                }
            }
            .build()
    }
}