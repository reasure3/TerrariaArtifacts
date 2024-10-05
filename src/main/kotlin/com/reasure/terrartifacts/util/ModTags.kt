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

        val INFORMATION: TagKey<Item> = modTag("information")
        val INFORMATION_TIME: TagKey<Item> = modTag("information/time")
        val INFORMATION_TIME_HOUR: TagKey<Item> = modTag("information/time/hour")
        val INFORMATION_TIME_HALF_HOUR: TagKey<Item> = modTag("information/time/half_hour")
        val INFORMATION_TIME_MINUTE: TagKey<Item> = modTag("information/time/minute")
        val INFORMATION_WEATHER: TagKey<Item> = modTag("information/weather")
        val INFORMATION_FISHING_POWER: TagKey<Item> = modTag("information/fishing_power")
        val INFORMATION_POSITION: TagKey<Item> = modTag("information/position")
        val INFORMATION_DEPTH: TagKey<Item> = modTag("information/depth")
        val INFORMATION_ENEMY_COUNT: TagKey<Item> = modTag("information/enemy_count")
        val INFORMATION_KILL_COUNT: TagKey<Item> = modTag("information/kill_count")
        val INFORMATION_MOON_PHASE: TagKey<Item> = modTag("information/moon_phase")
        val INFORMATION_MOVEMENT_SPEED: TagKey<Item> = modTag("information/movement_speed")
        val INFORMATION_TREASURE: TagKey<Item> = modTag("information/treasure")

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