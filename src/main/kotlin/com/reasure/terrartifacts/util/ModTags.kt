package com.reasure.terrartifacts.util

import com.reasure.terrartifacts.Terrartifacts
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item

class ModTags {
    object Items {
        val INGOTS_TIN: TagKey<Item> = forgeTag("ingots/tin")
        val INGOTS_SILVER: TagKey<Item> = forgeTag("ingots/silver")
        val INGOTS_TUNGSTEN: TagKey<Item> = forgeTag("ingots/tungsten")
        val INGOTS_PLATINUM: TagKey<Item> = forgeTag("ingots/platinum")

        val FULL_WATCH: TagKey<Item> = modTag("watch_full")

        val CURIOS_ACCESSORIES: TagKey<Item> = curiosTag("accessory")

        private fun forgeTag(name: String): TagKey<Item> {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name))
        }

        private fun modTag(name: String): TagKey<Item> {
            return ItemTags.create(Terrartifacts.modLoc(name))
        }

        private fun curiosTag(name: String): TagKey<Item> {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("curios", name))
        }
    }
}