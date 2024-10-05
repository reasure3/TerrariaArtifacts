package com.reasure.terrartifacts.item

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.item.accessories.AccessoryItem
import com.reasure.terrartifacts.util.TranslationKeys
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
        AccessoryItem(tooltipKeys = listOf(TranslationKeys.TOOLTIP_WATCH_HOUR))
    }

    val TIN_WATCH: Item by ITEMS.register("tin_watch") { ->
        AccessoryItem(tooltipKeys = listOf(TranslationKeys.TOOLTIP_WATCH_HOUR))
    }

    val SILVER_WATCH: Item by ITEMS.register("silver_watch") { ->
        AccessoryItem(tooltipKeys = listOf(TranslationKeys.TOOLTIP_WATCH_HALF_HOUR))
    }

    val TUNGSTEN_WATCH: Item by ITEMS.register("tungsten_watch") { ->
        AccessoryItem(tooltipKeys = listOf(TranslationKeys.TOOLTIP_WATCH_HALF_HOUR))
    }

    val GOLD_WATCH: Item by ITEMS.register("gold_watch") { ->
        AccessoryItem(rarity = ModRarity.BLUE, tooltipKeys = listOf(TranslationKeys.TOOLTIP_WATCH_MINUTE))
    }

    val PLATINUM_WATCH: Item by ITEMS.register("platinum_watch") { ->
        AccessoryItem(rarity = ModRarity.BLUE, tooltipKeys = listOf(TranslationKeys.TOOLTIP_WATCH_MINUTE))
    }

    val WEATHER_RADIO: Item by ITEMS.register("weather_radio") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_WEATHER_RADIO)
        )
    }

    val FISHERMAN_POCKET_GUIDE: Item by ITEMS.register("fisherman_pocket_guide") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_FISHERMAN_POCKET_GUIDE)
        )
    }

    val COMPASS: Item by ITEMS.register("compass") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_COMPASS)
        )
    }

    val DEPTH_METER: Item by ITEMS.register("depth_meter") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_DEPTH_METER)
        )
    }

    val RADAR: Item by ITEMS.register("radar") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_RADAR)
        )
    }

    val TALLY_COUNTER: Item by ITEMS.register("tally_counter") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_TALLY_COUNTER)
        )
    }

    val SEXTANT: Item by ITEMS.register("sextant") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_SEXTANT)
        )
    }

    val STOPWATCH: Item by ITEMS.register("stopwatch") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_STOPWATCH)
        )
    }

    val METAL_DETECTOR: Item by ITEMS.register("metal_detector") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_METAL_DETECTOR)
        )
    }

    val LIFEFORM_ANALYZER: Item by ITEMS.register("lifeform_analyzer") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_LIFEFORM_ANALYZER)
        )
    }

    val GPS: Item by ITEMS.register("gps") { ->
        AccessoryItem(
            rarity = ModRarity.ORANGE,
            tooltipKeys = listOf(
                TranslationKeys.TOOLTIP_WATCH_MINUTE,
                TranslationKeys.TOOLTIP_COMPASS,
                TranslationKeys.TOOLTIP_DEPTH_METER
            )
        )
    }

    val FISH_FINDER: Item by ITEMS.register("fish_finder") { ->
        AccessoryItem(
            rarity = ModRarity.ORANGE,
            tooltipKeys = listOf(
                TranslationKeys.TOOLTIP_WEATHER_RADIO,
                TranslationKeys.TOOLTIP_FISHERMAN_POCKET_GUIDE,
                TranslationKeys.TOOLTIP_SEXTANT
            )
        )
    }

    val REK3000: Item by ITEMS.register("rek3000") { ->
        AccessoryItem(
            rarity = ModRarity.ORANGE,
            tooltipKeys = listOf(
                TranslationKeys.TOOLTIP_RADAR,
                TranslationKeys.TOOLTIP_TALLY_COUNTER,
                TranslationKeys.TOOLTIP_LIFEFORM_ANALYZER
            )
        )
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