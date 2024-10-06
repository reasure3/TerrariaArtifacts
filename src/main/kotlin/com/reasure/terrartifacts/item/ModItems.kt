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
        AccessoryItem(tooltipKeys = listOf(TranslationKeys.TOOLTIP_TIME_HOUR_ITEM))
    }

    val TIN_WATCH: Item by ITEMS.register("tin_watch") { ->
        AccessoryItem(tooltipKeys = listOf(TranslationKeys.TOOLTIP_TIME_HOUR_ITEM))
    }

    val SILVER_WATCH: Item by ITEMS.register("silver_watch") { ->
        AccessoryItem(tooltipKeys = listOf(TranslationKeys.TOOLTIP_TIME_HALF_HOUR_ITEM))
    }

    val TUNGSTEN_WATCH: Item by ITEMS.register("tungsten_watch") { ->
        AccessoryItem(tooltipKeys = listOf(TranslationKeys.TOOLTIP_TIME_HALF_HOUR_ITEM))
    }

    val GOLD_WATCH: Item by ITEMS.register("gold_watch") { ->
        AccessoryItem(rarity = ModRarity.BLUE, tooltipKeys = listOf(TranslationKeys.TOOLTIP_TIME_MINUTE_ITEM))
    }

    val PLATINUM_WATCH: Item by ITEMS.register("platinum_watch") { ->
        AccessoryItem(rarity = ModRarity.BLUE, tooltipKeys = listOf(TranslationKeys.TOOLTIP_TIME_MINUTE_ITEM))
    }

    val WEATHER_RADIO: Item by ITEMS.register("weather_radio") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_WEATHER_ITEM)
        )
    }

    val FISHERMAN_POCKET_GUIDE: Item by ITEMS.register("fisherman_pocket_guide") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_FISHING_POWER_ITEM)
        )
    }

    val COMPASS: Item by ITEMS.register("compass") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_POSITION_ITEM)
        )
    }

    val DEPTH_METER: Item by ITEMS.register("depth_meter") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_DEPTH_ITEM)
        )
    }

    val RADAR: Item by ITEMS.register("radar") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_ENEMY_COUNT_ITEM)
        )
    }

    val TALLY_COUNTER: Item by ITEMS.register("tally_counter") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_KILL_COUNT_ITEM)
        )
    }

    val SEXTANT: Item by ITEMS.register("sextant") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_MOON_PHASE_ITEM)
        )
    }

    val STOPWATCH: Item by ITEMS.register("stopwatch") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_MOVEMENT_SPEED_ITEM)
        )
    }

    val METAL_DETECTOR: Item by ITEMS.register("metal_detector") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_TREASURE_ITEM)
        )
    }

    val LIFEFORM_ANALYZER: Item by ITEMS.register("lifeform_analyzer") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_RARE_CREATURES_ITEM)
        )
    }

    val DPS_METER: Item by ITEMS.register("dps_meter") { ->
        AccessoryItem(
            rarity = ModRarity.BLUE,
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_DPS_ITEM)
        )
    }

    val GPS: Item by ITEMS.register("gps") { ->
        AccessoryItem(
            rarity = ModRarity.ORANGE,
            tooltipKeys = listOf(
                TranslationKeys.TOOLTIP_TIME_MINUTE_ITEM,
                TranslationKeys.TOOLTIP_POSITION_ITEM,
                TranslationKeys.TOOLTIP_DEPTH_ITEM
            )
        )
    }

    val FISH_FINDER: Item by ITEMS.register("fish_finder") { ->
        AccessoryItem(
            rarity = ModRarity.ORANGE,
            tooltipKeys = listOf(
                TranslationKeys.TOOLTIP_WEATHER_ITEM,
                TranslationKeys.TOOLTIP_FISHING_POWER_ITEM,
                TranslationKeys.TOOLTIP_MOON_PHASE_ITEM
            )
        )
    }

    val REK3000: Item by ITEMS.register("rek3000") { ->
        AccessoryItem(
            rarity = ModRarity.ORANGE,
            tooltipKeys = listOf(
                TranslationKeys.TOOLTIP_ENEMY_COUNT_ITEM,
                TranslationKeys.TOOLTIP_KILL_COUNT_ITEM,
                TranslationKeys.TOOLTIP_RARE_CREATURES_ITEM
            )
        )
    }

    val GOBLIN_TECH: Item by ITEMS.register("goblin_tech") { ->
        AccessoryItem(
            rarity = ModRarity.ORANGE,
            tooltipKeys = listOf(
                TranslationKeys.TOOLTIP_MOVEMENT_SPEED_ITEM,
                TranslationKeys.TOOLTIP_TREASURE_ITEM,
                TranslationKeys.TOOLTIP_DPS_ITEM
            )
        )
    }

    val PDA: Item by ITEMS.register("pda") { ->
        AccessoryItem(
            rarity = ModRarity.PINK,
            tooltipKeys = listOf(
                TranslationKeys.TOOLTIP_TIME_MINUTE_ITEM,
                TranslationKeys.TOOLTIP_WEATHER_ITEM,
                TranslationKeys.TOOLTIP_FISHING_POWER_ITEM,
                TranslationKeys.TOOLTIP_POSITION_ITEM,
                TranslationKeys.TOOLTIP_DEPTH_ITEM,
                TranslationKeys.TOOLTIP_ENEMY_COUNT_ITEM,
                TranslationKeys.TOOLTIP_KILL_COUNT_ITEM,
                TranslationKeys.TOOLTIP_MOON_PHASE_ITEM,
                TranslationKeys.TOOLTIP_MOVEMENT_SPEED_ITEM,
                TranslationKeys.TOOLTIP_TREASURE_ITEM,
                TranslationKeys.TOOLTIP_RARE_CREATURES_ITEM,
                TranslationKeys.TOOLTIP_DPS_ITEM
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