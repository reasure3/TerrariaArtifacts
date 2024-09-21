package com.reasure.terrartifacts.item

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.item.accessories.informational.WatchItem
import com.reasure.terrartifacts.item.accessories.informational.WatchType
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModItems {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(Terrartifacts.ID)

    val COPPER_CLOCK: Item by ITEMS.register("copper_clock") { -> Item(Item.Properties()) }
    val TIN_CLOCK: Item by ITEMS.register("tin_clock") { -> Item(Item.Properties()) }
    val SILVER_CLOCK: Item by ITEMS.register("silver_clock") { -> Item(Item.Properties()) }
    val TUNGSTEN_CLOCK: Item by ITEMS.register("tungsten_clock") { -> Item(Item.Properties()) }
    val PLATINUM_CLOCK: Item by ITEMS.register("platinum_clock") { -> Item(Item.Properties()) }

    val COPPER_WATCH: Item by ITEMS.register("copper_watch") { ->
        WatchItem(Item.Properties().rarity(ModRarity.WHITE), WatchType.HOUR)
    }

    val TIN_WATCH: Item by ITEMS.register("tin_watch") { ->
        WatchItem(Item.Properties().rarity(ModRarity.WHITE), WatchType.HOUR)
    }

    val SILVER_WATCH: Item by ITEMS.register("silver_watch") { ->
        WatchItem(Item.Properties().rarity(ModRarity.WHITE), WatchType.HALF_HOUR)
    }

    val TUNGSTEN_WATCH: Item by ITEMS.register("tungsten_watch") { ->
        WatchItem(Item.Properties().rarity(ModRarity.WHITE), WatchType.HALF_HOUR)
    }

    val GOLD_WATCH: Item by ITEMS.register("gold_watch") { ->
        WatchItem(Item.Properties().rarity(ModRarity.BLUE), WatchType.MINUTE)
    }

    val PLATINUM_WATCH: Item by ITEMS.register("platinum_watch") { ->
        WatchItem(Item.Properties().rarity(ModRarity.BLUE), WatchType.MINUTE)
    }

    // Below line is for test

    val TEST_RAINBOW: Item by ITEMS.register("test_rainbow") { ->
        Item(Item.Properties().rarity(ModRarity.EXPERT))
    }

    val TEST_MASTER: Item by ITEMS.register("test_master") { ->
        Item(Item.Properties().rarity(ModRarity.MASTER))
    }
}