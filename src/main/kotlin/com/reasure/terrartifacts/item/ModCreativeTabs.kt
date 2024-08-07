package com.reasure.terrartifacts.item

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.block.ModBlocks
import com.reasure.terrartifacts.client.TranslationKeys
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModCreativeTabs {
    val CREATIVE_TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Terrartifacts.ID)

    val TERRA_ARTIFACTS: CreativeModeTab by CREATIVE_TABS.register("terra_artifacts") { ->
        CreativeModeTab.builder()
            .icon { ItemStack(ModItems.COPPER_WATCH) }
            .title(Component.translatable(TranslationKeys.GROUP_TERRARTIFACTS_KEY))
            .displayItems { _, entries ->
                entries.accept(ItemStack(ModBlocks.EXAMPLE_BLOCK))
                entries.accept(ItemStack(ModItems.COPPER_WATCH))
                entries.accept(ItemStack(ModItems.TIN_WATCH))
                entries.accept(ItemStack(ModItems.SILVER_WATCH))
                entries.accept(ItemStack(ModItems.TUNGSTEN_WATCH))
                entries.accept(ItemStack(ModItems.GOLD_WATCH))
                entries.accept(ItemStack(ModItems.PLATINUM_WATCH))
            }
            .build()
    }
}