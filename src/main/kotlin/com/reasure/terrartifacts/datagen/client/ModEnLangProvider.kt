package com.reasure.terrartifacts.datagen.client

import com.reasure.terrartifacts.block.ModBlocks
import com.reasure.terrartifacts.item.ModItems
import com.reasure.terrartifacts.util.ModTags
import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.data.PackOutput

class ModEnLangProvider(output: PackOutput) :
    ModBaseLangProvider(output, "en_us") {
    override fun addItems() {
        add(ModItems.COPPER_CLOCK, "Copper Clock")
        add(ModItems.TIN_CLOCK, "Tin Clock")
        add(ModItems.SILVER_CLOCK, "Silver Clock")
        add(ModItems.TUNGSTEN_CLOCK, "Tungsten Clock")
        add(ModItems.PLATINUM_CLOCK, "Platinum Clock")
        add(ModItems.COPPER_WATCH, "Copper Watch")
        add(ModItems.TIN_WATCH, "Tin Watch")
        add(ModItems.SILVER_WATCH, "Silver Watch")
        add(ModItems.TUNGSTEN_WATCH, "Tungsten Watch")
        add(ModItems.GOLD_WATCH, "Gold Watch")
        add(ModItems.PLATINUM_WATCH, "Platinum Watch")
        add(ModItems.WEATHER_RADIO, "Weather Radio")
        add(ModItems.FISHERMAN_POCKET_GUIDE, "Fisherman's Pocket Guide")
        add(ModItems.COMPASS, "Compass")
        add(ModItems.DEPTH_METER, "Depth Meter")
        add(ModItems.RADAR, "Radar")
        add(ModItems.TALLY_COUNTER, "Tally Counter")
        add(ModItems.SEXTANT, "Sextant")
        add(ModItems.STOPWATCH, "Stopwatch")
        add(ModItems.METAL_DETECTOR, "Metal Detector")
        add(ModItems.LIFEFORM_ANALYZER, "Lifeform Analyzer")
        add(ModItems.DPS_METER, "DPS Meter")
        add(ModItems.GPS, "GPS")
        add(ModItems.FISH_FINDER, "Fish Finder")
        add(ModItems.REK3000, "R.E.K. 3000")
        add(ModItems.GOBLIN_TECH, "Goblin Tech")
        add(ModItems.PDA, "PDA")
    }

    override fun addBlocks() {
        add(ModBlocks.EXAMPLE_BLOCK, "Example Block")
    }

    override fun addTooltips() {
        add(TranslationKeys.TOOLTIP_TIME_HOUR_ITEM, "⑴ Displays the time down to the hour")
        add(TranslationKeys.TOOLTIP_TIME_HALF_HOUR_ITEM, "⑴ Displays the time down to the half-hour")
        add(TranslationKeys.TOOLTIP_TIME_MINUTE_ITEM, "⑴ Displays the time down to the minute")
        add(TranslationKeys.TOOLTIP_WEATHER_ITEM, "⑵ Displays the weather")
        add(TranslationKeys.TOOLTIP_FISHING_POWER_ITEM, "⑶ Displays fishing power")
        add(TranslationKeys.TOOLTIP_POSITION_ITEM, "⑷ Displays the player's horizontal position")
        add(TranslationKeys.TOOLTIP_DEPTH_ITEM, "⑸ Displays the player's vertical position")
        add(TranslationKeys.TOOLTIP_ENEMY_COUNT_ITEM, "⑹ Displays number of nearby enemies")
        add(TranslationKeys.TOOLTIP_KILL_COUNT_ITEM, "⑺ Displays number of kills per enemy type")
        add(TranslationKeys.TOOLTIP_MOON_PHASE_ITEM, "⑻ Displays the current moon phase")
        add(TranslationKeys.TOOLTIP_MOVEMENT_SPEED_ITEM, "⑽ Displays movement speed")
        add(TranslationKeys.TOOLTIP_TREASURE_ITEM, "⑾ Displays nearby valuable objects")
        add(TranslationKeys.TOOLTIP_RARE_CREATURES_ITEM, "⑿ Displays the name of nearby rare enemies and critters")
        add(TranslationKeys.TOOLTIP_DPS_ITEM, "⒀ Displays damage per second")
    }

    override fun addGui() {
        add(TranslationKeys.GROUP_TERRARTIFACTS_KEY, "Terraria Artifacts")
        add(TranslationKeys.GROUP_TERRARTIFACTS_DEVELOP_KEY, "Terraria Artifacts Develop Tab")
        addCuriosSlot("accessory", "Accessory")
        addInfoOverlays()
        addInfoToggleButtons()
    }

    private fun addInfoOverlays() {
        // TIME
        add(TranslationKeys.INFO_TIME, "⑴ %2\$s %1\$s")
        add(TranslationKeys.TIME_MORNING, "AM")
        add(TranslationKeys.TIME_AFTERNOON, "PM")
        // WEATHER
        add(TranslationKeys.INFO_WEATHER, "⑵ %1\$s (💧 %2\$s%%, ⚡ %3\$s%%)")
        add(TranslationKeys.WEATHER_CLEAR, "Clear")
        add(TranslationKeys.WEATHER_CLOUDY, "Cloudy")
        add(TranslationKeys.WEATHER_RAIN, "Rain")
        add(TranslationKeys.WEATHER_SNOW, "Snow")
        add(TranslationKeys.WEATHER_THUNDER, "Thunder")
        // FISHING POWER
        add(TranslationKeys.INFO_FISHING_POWER, "⑶ Luck: %s")
        // POSITION
        add(TranslationKeys.INFO_POSITION, "⑷ X: %1\$s, Z: %1\$s")
        // DEPTH
        add(TranslationKeys.INFO_DEPTH, "⑸ Y: %s")
        // ENEMY COUNT
        add(TranslationKeys.INFO_ENEMY_COUNT, "⑹ %s enemies nearby!")
        add(TranslationKeys.INFO_NO_ENEMY_COUNT, "⑹ No enemies nearby")
        // KILL COUNT
        add(TranslationKeys.INFO_KILL_COUNT, "⑺ %1\$s: %2\$s")
        add(TranslationKeys.INFO_NO_KILL_COUNT, "⑺ Kill count unavailable")
        // MOON PHASE
        add(TranslationKeys.INFO_MOON_PHASE_FULL_MOON, "⑻ Full moon")
        add(TranslationKeys.INFO_MOON_PHASE_WANING_GIBBOUS, "⑻ Waning gibbous")
        add(TranslationKeys.INFO_MOON_PHASE_LAST_QUARTER, "⑻ Last quarter")
        add(TranslationKeys.INFO_MOON_PHASE_WANING_CRESCENT, "⑻ Waning crescent")
        add(TranslationKeys.INFO_MOON_PHASE_NEW_MOON, "⑻ New moon")
        add(TranslationKeys.INFO_MOON_PHASE_WAXING_CRESCENT, "⑻ Waxing crescent")
        add(TranslationKeys.INFO_MOON_PHASE_FIRST_QUARTER, "⑻ First quarter")
        add(TranslationKeys.INFO_MOON_PHASE_WAXING_GIBBOUS, "⑻ Waxing gibbous")
        add(TranslationKeys.INFO_NO_MOON_PHASE, "⑼ No moon")
        add(TranslationKeys.INFO_NETHER_MOON_PHASE, "⑼ Nether moon")
        add(TranslationKeys.INFO_END_MOON_PHASE, "⑼ End moon")
        // MOVEMENT SPEED
        add(TranslationKeys.INFO_MOVEMENT_SPEED, "⑽ %s m/s")
        // TREASURE
        add(TranslationKeys.INFO_TREASURE, "⑾ %s detected nearby!")
        add(TranslationKeys.INFO_NO_TREASURE, "⑾ No treasure nearby")
        // RARE CREATURE
        add(TranslationKeys.INFO_RARE_CREATURE, "⑿ %s")
        add(TranslationKeys.INFO_NO_RARE_CREATURE, "⑿ No rare creatures nearby")
        // DPS
        add(TranslationKeys.INFO_DPS, "⒀ %s damage per second")
        add(TranslationKeys.INFO_NO_DPS, "⒀ N/A")
    }

    private fun addInfoToggleButtons() {
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_TIME, "Time")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_WEATHER, "Weather")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_FISHING_POWER, "Fishing Power")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_POSITION, "Position")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_DEPTH, "Depth")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_ENEMY_COUNT, "Enemy Count")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_KILL_COUNT, "Kill Count")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_MOON_PHASE, "Moon Phase")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_MOVEMENT_SPEED, "Movement Speed")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_TREASURE, "Treasure")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_RARE_CREATURES, "Rare Creatures")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_DPS, "DPS")
    }

    override fun addConfigs() {
        addConfigDesc("title", "Terrartifacts Configs")

        addConfigDesc("section.terrartifacts.client.toml", "Terrartifacts Client Config File")
        addConfigDesc("section.terrartifacts.client.toml.title", "Terrartifacts Client Configs")

        addConfigDesc("infoButtonLayoutPos", "Info Toggle Button Layout")
        addConfigDesc("infoButtonLayoutPos.tooltip", "Info Accessory Toggle Button Layout")

        addConfigDesc("infoButtonOffsetX", "Info Toggle Button X Offset")
        addConfigDesc("infoButtonOffsetX.tooltip", "Info Accessory Toggle Button X Offset")

        addConfigDesc("infoButtonOffsetY", "Info Toggle Button Y Offset")
        addConfigDesc("infoButtonOffsetY.tooltip", "Info Accessory Toggle Button Y Offset")

        addConfigDesc("section.terrartifacts.server.toml", "Terrartifacts Server Config File")
        addConfigDesc("section.terrartifacts.server.toml.title", "Terrartifacts Server Configs")

        addConfigDesc("radarDetectDistance", "Radar Detection Range")
        addConfigDesc("radarDetectDistance.tooltip", "Define Radar Detection Range")

        addConfigDesc("treasureDetectDistance", "Treasure Detection Range")
        addConfigDesc("treasureDetectDistance.tooltip", "Define Treasure Detection Range")

        addConfigDesc("rareCreatureDetectDistance", "Rare Creature Detection Range")
        addConfigDesc("rareCreatureDetectDistance.tooltip", "Define Rare Creature Detection Range")

        addConfigDesc("dpsTrackingTick", "Dps Tracking Tick")
        addConfigDesc(
            "dpsTrackingTick.tooltip",
            "Define Dps Tracking Tick\n\nDPS is calculated only from the damage accumulated during this tick."
        )

        addConfigDesc("maxDpsDamageEntryCount", "Max Dps Track Count")
        addConfigDesc(
            "maxDpsDamageEntryCount.tooltip",
            "Define Max Dps Track Count\n\nWhen damage accumulates and exceeds this number, older damage is removed first."
        )

        addConfigDesc("checkInventoryTickRate", "Inventory Check Tick Rate")
        addConfigDesc(
            "checkInventoryTickRate.tooltip",
            "Define Inventory Check Tick Rate\n\nEvery this tick, check if there is an information item in your inventory."
        )
    }

    override fun addTags() {
        addTag(ModTags.Items.INGOTS_TIN, "Tin Ingots")
        addTag(ModTags.Items.INGOTS_SILVER, "Silver Ingots")
        addTag(ModTags.Items.INGOTS_TUNGSTEN, "Tungsten Ingots")
        addTag(ModTags.Items.INGOTS_PLATINUM, "Platinum Ingots")
        addTag(ModTags.Items.CURIOS_ACCESSORIES, "Accessories")
    }
}