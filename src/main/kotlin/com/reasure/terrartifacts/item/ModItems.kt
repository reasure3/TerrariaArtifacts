package com.reasure.terrartifacts.item

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.block.ModBlocks
import com.reasure.terrartifacts.item.accessories.informational.WatchItem
import com.reasure.terrartifacts.item.accessories.informational.WatchType
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModItems {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(Terrartifacts.ID)

    val EXAMPLE_BLOCK: Item by ITEMS.register("example_block") { ->
        BlockItem(ModBlocks.EXAMPLE_BLOCK, Item.Properties())
    }

    val COPPER_WATCH: Item by ITEMS.register("copper_watch") { ->
        WatchItem(Item.Properties().rarity(ModRarity.WHITE.value), WatchType.HOUR)
    }

    val TIN_WATCH: Item by ITEMS.register("tin_watch") { ->
        WatchItem(Item.Properties().rarity(ModRarity.WHITE.value), WatchType.HOUR)
    }

    val SILVER_WATCH: Item by ITEMS.register("silver_watch") { ->
        WatchItem(Item.Properties().rarity(ModRarity.WHITE.value), WatchType.HALF_HOUR)
    }

    val TUNGSTEN_WATCH: Item by ITEMS.register("tungsten_watch") { ->
        WatchItem(Item.Properties().rarity(ModRarity.WHITE.value), WatchType.HALF_HOUR)
    }

    val GOLD_WATCH: Item by ITEMS.register("gold_watch") { ->
        WatchItem(Item.Properties().rarity(ModRarity.BLUE.value), WatchType.MINUTE)
    }

    val PLATINUM_WATCH: Item by ITEMS.register("platinum_watch") { ->
        WatchItem(Item.Properties().rarity(ModRarity.BLUE.value), WatchType.MINUTE)
    }
}