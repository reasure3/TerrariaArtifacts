package com.reasure.terrartifacts.util

import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item

class ModTags {
    object Items {
        val CURIOS_ACCESSORIES: TagKey<Item> = curiosTag("accessory")

        private fun curiosTag(name: String): TagKey<Item> {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("curios", name))
        }
    }
}