package com.reasure.terrartifacts.item

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.item.accessories.informational.InfoType
import com.reasure.terrartifacts.item.accessories.informational.WatchType
import com.reasure.terrartifacts.item.component.HasInfo
import com.reasure.terrartifacts.item.component.ModDataComponents
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModItems {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(Terrartifacts.ID)

    val COPPER_CLOCK: Item by ITEMS.registerSimpleItem("copper_clock")
    val TIN_CLOCK: Item by ITEMS.registerSimpleItem("tin_clock")
    val SILVER_CLOCK: Item by ITEMS.registerSimpleItem("silver_clock")
    val TUNGSTEN_CLOCK: Item by ITEMS.registerSimpleItem("tungsten_clock")
    val PLATINUM_CLOCK: Item by ITEMS.registerSimpleItem("platinum_clock")

    val COPPER_WATCH: Item by ITEMS.registerItem("copper_watch") { properties ->
        Item(
            properties.rarity(ModRarity.WHITE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.TIME, watchType = WatchType.HOUR))
        )
    }

    val TIN_WATCH: Item by ITEMS.registerItem("tin_watch") { properties ->
        Item(
            properties.rarity(ModRarity.WHITE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.TIME, watchType = WatchType.HOUR))
        )
    }

    val SILVER_WATCH: Item by ITEMS.registerItem("silver_watch") { properties ->
        Item(
            properties.rarity(ModRarity.WHITE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.TIME, watchType = WatchType.HALF_HOUR))
        )
    }

    val TUNGSTEN_WATCH: Item by ITEMS.registerItem("tungsten_watch") { properties ->
        Item(
            properties.rarity(ModRarity.WHITE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.TIME, watchType = WatchType.HALF_HOUR))
        )
    }

    val GOLD_WATCH: Item by ITEMS.registerItem("gold_watch") { properties ->
        Item(
            properties.rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.TIME, watchType = WatchType.MINUTE))
        )
    }

    val PLATINUM_WATCH: Item by ITEMS.registerItem("platinum_watch") { properties ->
        Item(
            properties.rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.TIME, watchType = WatchType.MINUTE))
        )
    }

    val WEATHER_RADIO: Item by ITEMS.registerItem("weather_radio") { properties ->
        Item(
            properties.rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.WEATHER))
        )
    }

    val FISHERMAN_POCKET_GUIDE: Item by ITEMS.registerItem("fisherman_pocket_guide") { properties ->
        Item(
            properties.rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.FISHING_POWER))
        )
    }

    val COMPASS: Item by ITEMS.registerItem("compass") { properties ->
        Item(
            properties.rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.POSITION))
        )
    }

    val DEPTH_METER: Item by ITEMS.registerItem("depth_meter") { properties ->
        Item(
            properties.rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.DEPTH))
        )
    }

    val RADAR: Item by ITEMS.registerItem("radar") { properties ->
        Item(
            properties.rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.ENEMY_COUNT))
        )
    }

    val TALLY_COUNTER: Item by ITEMS.registerItem("tally_counter") { properties ->
        Item(
            properties.rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.KILL_COUNT))
        )
    }

    val SEXTANT: Item by ITEMS.registerItem("sextant") { properties ->
        Item(
            properties.rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.MOON_PHASE))
        )
    }

    val STOPWATCH: Item by ITEMS.registerItem("stopwatch") { properties ->
        Item(
            properties.rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.MOVEMENT_SPEED))
        )
    }

    val METAL_DETECTOR: Item by ITEMS.registerItem("metal_detector") { properties ->
        Item(
            properties.rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.TREASURE))
        )
    }

    val LIFEFORM_ANALYZER: Item by ITEMS.registerItem("lifeform_analyzer") { properties ->
        Item(
            properties.rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.RARE_CREATURE))
        )
    }

    val DPS_METER: Item by ITEMS.registerItem("dps_meter") { properties ->
        Item(
            properties.rarity(ModRarity.BLUE).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.create(InfoType.DPS))
        )
    }

    val GPS: Item by ITEMS.registerItem("gps") { properties ->
        Item(
            properties.rarity(ModRarity.ORANGE).stacksTo(1)
                .component(
                    ModDataComponents.HAS_INFO,
                    HasInfo.create(InfoType.TIME, InfoType.POSITION, InfoType.DEPTH, watchType = WatchType.MINUTE)
                )
        )
    }

    val FISH_FINDER: Item by ITEMS.registerItem("fish_finder") { properties ->
        Item(
            properties.rarity(ModRarity.ORANGE).stacksTo(1)
                .component(
                    ModDataComponents.HAS_INFO,
                    HasInfo.create(InfoType.WEATHER, InfoType.FISHING_POWER, InfoType.MOON_PHASE)
                )
        )
    }

    val REK3000: Item by ITEMS.registerItem("rek3000") { properties ->
        Item(
            properties.rarity(ModRarity.ORANGE).stacksTo(1)
                .component(
                    ModDataComponents.HAS_INFO,
                    HasInfo.create(InfoType.ENEMY_COUNT, InfoType.KILL_COUNT, InfoType.RARE_CREATURE)
                )
        )
    }

    val GOBLIN_TECH: Item by ITEMS.registerItem("goblin_tech") { properties ->
        Item(
            properties.rarity(ModRarity.ORANGE).stacksTo(1)
                .component(
                    ModDataComponents.HAS_INFO,
                    HasInfo.create(InfoType.MOVEMENT_SPEED, InfoType.TREASURE, InfoType.DPS)
                )
        )
    }

    val PDA: Item by ITEMS.registerItem("pda") { properties ->
        Item(
            properties.rarity(ModRarity.PINK).stacksTo(1)
                .component(ModDataComponents.HAS_INFO, HasInfo.all())
        )
    }

    // Below line is for test

    @Suppress("unused")
    val TEST_RAINBOW: Item by ITEMS.registerItem("test_rainbow") { properties ->
        Item(properties.rarity(ModRarity.EXPERT))
    }

    @Suppress("unused")
    val TEST_MASTER: Item by ITEMS.registerItem("test_master") { properties ->
        Item(properties.rarity(ModRarity.MASTER))
    }
}