package com.reasure.terrartifacts.item

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.item.accessories.AccessoryItem
import com.reasure.terrartifacts.item.accessories.informational.InfoType
import com.reasure.terrartifacts.item.accessories.informational.WatchType
import com.reasure.terrartifacts.item.component.HasInfo
import com.reasure.terrartifacts.item.component.ModDataComponents
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
        AccessoryItem(
            Item.Properties().rarity(ModRarity.WHITE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.TIME, watchType = WatchType.HOUR)),
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_TIME_HOUR_ITEM)
        )
    }

    val TIN_WATCH: Item by ITEMS.register("tin_watch") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.WHITE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.TIME, watchType = WatchType.HOUR)),
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_TIME_HOUR_ITEM)
        )
    }

    val SILVER_WATCH: Item by ITEMS.register("silver_watch") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.WHITE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.TIME, watchType = WatchType.HALF_HOUR)),
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_TIME_HALF_HOUR_ITEM)
        )
    }

    val TUNGSTEN_WATCH: Item by ITEMS.register("tungsten_watch") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.WHITE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.TIME, watchType = WatchType.HALF_HOUR)),
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_TIME_HALF_HOUR_ITEM)
        )
    }

    val GOLD_WATCH: Item by ITEMS.register("gold_watch") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.TIME, watchType = WatchType.MINUTE)),
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_TIME_MINUTE_ITEM)
        )
    }

    val PLATINUM_WATCH: Item by ITEMS.register("platinum_watch") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.TIME, watchType = WatchType.MINUTE)),
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_TIME_MINUTE_ITEM)
        )
    }

    val WEATHER_RADIO: Item by ITEMS.register("weather_radio") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.WEATHER)),
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_WEATHER_ITEM)
        )
    }

    val FISHERMAN_POCKET_GUIDE: Item by ITEMS.register("fisherman_pocket_guide") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.FISHING_POWER)),
            tooltipKeys = listOf(TranslationKeys.INFO_FISHING_POWER)
        )
    }

    val COMPASS: Item by ITEMS.register("compass") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.POSITION)),
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_POSITION_ITEM)
        )
    }

    val DEPTH_METER: Item by ITEMS.register("depth_meter") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.DEPTH)),
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_DEPTH_ITEM)
        )
    }

    val RADAR: Item by ITEMS.register("radar") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.ENEMY_COUNT)),
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_ENEMY_COUNT_ITEM)
        )
    }

    val TALLY_COUNTER: Item by ITEMS.register("tally_counter") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.KILL_COUNT)),
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_KILL_COUNT_ITEM)
        )
    }

    val SEXTANT: Item by ITEMS.register("sextant") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.MOON_PHASE)),
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_MOON_PHASE_ITEM)
        )
    }

    val STOPWATCH: Item by ITEMS.register("stopwatch") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.MOVEMENT_SPEED)),
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_MOVEMENT_SPEED_ITEM)
        )
    }

    val METAL_DETECTOR: Item by ITEMS.register("metal_detector") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.TREASURE)),
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_TREASURE_ITEM)
        )
    }

    val LIFEFORM_ANALYZER: Item by ITEMS.register("lifeform_analyzer") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.RARE_CREATURE)),
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_RARE_CREATURES_ITEM)
        )
    }

    val DPS_METER: Item by ITEMS.register("dps_meter") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.DPS)),
            tooltipKeys = listOf(TranslationKeys.TOOLTIP_DPS_ITEM)
        )
    }

    val GPS: Item by ITEMS.register("gps") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.ORANGE).stacksTo(1)
                .component(
                    ModDataComponents.HAS_INFO,
                    HasInfo.create(InfoType.TIME, InfoType.POSITION, InfoType.DEPTH, watchType = WatchType.MINUTE)
                ),
            tooltipKeys = listOf(
                TranslationKeys.TOOLTIP_TIME_MINUTE_ITEM,
                TranslationKeys.TOOLTIP_POSITION_ITEM,
                TranslationKeys.TOOLTIP_DEPTH_ITEM
            )
        )
    }

    val FISH_FINDER: Item by ITEMS.register("fish_finder") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.ORANGE).stacksTo(1)
                .component(
                    ModDataComponents.HAS_INFO,
                    HasInfo.create(InfoType.WEATHER, InfoType.FISHING_POWER, InfoType.MOON_PHASE)
                ),
            tooltipKeys = listOf(
                TranslationKeys.TOOLTIP_WEATHER_ITEM,
                TranslationKeys.TOOLTIP_FISHING_POWER_ITEM,
                TranslationKeys.TOOLTIP_MOON_PHASE_ITEM
            )
        )
    }

    val REK3000: Item by ITEMS.register("rek3000") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.ORANGE).stacksTo(1)
                .component(
                    ModDataComponents.HAS_INFO,
                    HasInfo.create(InfoType.ENEMY_COUNT, InfoType.KILL_COUNT, InfoType.RARE_CREATURE)
                ),
            tooltipKeys = listOf(
                TranslationKeys.TOOLTIP_ENEMY_COUNT_ITEM,
                TranslationKeys.TOOLTIP_KILL_COUNT_ITEM,
                TranslationKeys.TOOLTIP_RARE_CREATURES_ITEM
            )
        )
    }

    val GOBLIN_TECH: Item by ITEMS.register("goblin_tech") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.ORANGE).stacksTo(1)
                .component(
                    ModDataComponents.HAS_INFO,
                    HasInfo.create(InfoType.MOVEMENT_SPEED, InfoType.TREASURE, InfoType.DPS)
                ),
            tooltipKeys = listOf(
                TranslationKeys.TOOLTIP_MOVEMENT_SPEED_ITEM,
                TranslationKeys.TOOLTIP_TREASURE_ITEM,
                TranslationKeys.TOOLTIP_DPS_ITEM
            )
        )
    }

    val PDA: Item by ITEMS.register("pda") { ->
        AccessoryItem(
            Item.Properties().rarity(ModRarity.PINK).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.all()),
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