package com.reasure.terrartifacts.item

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.item.accessories.informational.CompassItem
import com.reasure.terrartifacts.item.accessories.informational.DepthMeterItem
import com.reasure.terrartifacts.item.accessories.informational.FishFinderItem
import com.reasure.terrartifacts.item.accessories.informational.FishermanPocketGuideItem
import com.reasure.terrartifacts.item.accessories.informational.GPSItem
import com.reasure.terrartifacts.item.accessories.informational.RadarItem
import com.reasure.terrartifacts.item.accessories.informational.SextantItem
import com.reasure.terrartifacts.item.accessories.informational.TallyCounterItem
import com.reasure.terrartifacts.item.accessories.informational.WatchItem
import com.reasure.terrartifacts.item.accessories.informational.WatchType
import com.reasure.terrartifacts.item.accessories.informational.WeatherRadioItem
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

    val WEATHER_RADIO: Item by ITEMS.register("weather_radio") { ->
        WeatherRadioItem(Item.Properties().rarity(ModRarity.BLUE))
    }

    val FISHERMAN_POCKET_GUIDE: Item by ITEMS.register("fisherman_pocket_guide") { ->
        FishermanPocketGuideItem(Item.Properties().rarity(ModRarity.BLUE))
    }

    val COMPASS: Item by ITEMS.register("compass") { ->
        CompassItem(Item.Properties().rarity(ModRarity.BLUE))
    }

    val DEPTH_METER: Item by ITEMS.register("depth_meter") { ->
        DepthMeterItem(Item.Properties().rarity(ModRarity.BLUE))
    }

    val RADAR: Item by ITEMS.register("radar") { ->
        RadarItem(Item.Properties().rarity(ModRarity.BLUE))
    }

    val TALLY_COUNTER: Item by ITEMS.register("tally_counter") { ->
        TallyCounterItem(Item.Properties().rarity(ModRarity.BLUE))
    }

    val SEXTANT: Item by ITEMS.register("sextant") { ->
        SextantItem(Item.Properties().rarity(ModRarity.BLUE))
    }

    val GPS: Item by ITEMS.register("gps") { ->
        GPSItem(Item.Properties().rarity(ModRarity.ORANGE))
    }

    val FISH_FINDER: Item by ITEMS.register("fish_finder") { ->
        FishFinderItem(Item.Properties().rarity(ModRarity.ORANGE))
    }

    // Below line is for test

    @Suppress("unused")
    val TEST_RAINBOW: Item by ITEMS.register("test_rainbow") { ->
        Item(Item.Properties().rarity(ModRarity.EXPERT))
    }

    @Suppress("unused")
    val TEST_MASTER: Item by ITEMS.register("test_master") { ->
        Item(Item.Properties().rarity(ModRarity.MASTER))
    }
}