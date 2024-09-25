package com.reasure.terrartifacts.datagen.client

import com.reasure.terrartifacts.block.ModBlocks
import com.reasure.terrartifacts.item.ModItems
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
        add(ModItems.GPS, "GPS")
        add(ModItems.FISH_FINDER, "어류 탐지기")
    }

    override fun addBlocks() {
        add(ModBlocks.EXAMPLE_BLOCK, "Example Block")
    }

    override fun addTooltips() {
        add(TranslationKeys.TOOLTIP_WATCH_HOUR, "Displays the time down to the hour")
        add(TranslationKeys.TOOLTIP_WATCH_HALF_HOUR, "Displays the time down to the half-hour")
        add(TranslationKeys.TOOLTIP_WATCH_MINUTE, "Displays the time down to the minute")
        add(TranslationKeys.TOOLTIP_WEATHER_RADIO, "Displays the weather")
        add(TranslationKeys.TOOLTIP_FISHERMAN_POCKET_GUIDE, "Displays fishing power")
        add(TranslationKeys.TOOLTIP_COMPASS, "Displays the player's horizontal position")
        add(TranslationKeys.TOOLTIP_DEPTH_METER, "Displays the player's vertical position")
        add(TranslationKeys.TOOLTIP_RADAR, "Displays number of nearby enemies")
        add(TranslationKeys.TOOLTIP_TALLY_COUNTER, "Displays number of kills per enemy type")
        add(TranslationKeys.TOOLTIP_SEXTANT, "Displays the current moon phase")
    }

    override fun addGui() {
        add(TranslationKeys.GROUP_TERRARTIFACTS_KEY, "Terraria Artifacts")
        add(TranslationKeys.GROUP_TERRARTIFACTS_DEVELOP_KEY, "Terraria Artifacts Develop Tab")
        addCuriosSlot("accessory", "Accessory")
        add(TranslationKeys.INFO_TIME, "⑴ %2\$s %1\$s")
        add(TranslationKeys.TIME_MORNING, "AM")
        add(TranslationKeys.TIME_AFTERNOON, "PM")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_TIME, "Time")
        add(TranslationKeys.INFO_WEATHER, "⑵ %1\$s (💧 %2\$s%%, ⚡ %3\$s%%)")
        add(TranslationKeys.WEATHER_CLEAR, "Clear")
        add(TranslationKeys.WEATHER_CLOUDY, "Cloudy")
        add(TranslationKeys.WEATHER_RAIN, "Rain")
        add(TranslationKeys.WEATHER_SNOW, "Snow")
        add(TranslationKeys.WEATHER_THUNDER, "Thunder")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_WEATHER, "Weather")
        add(TranslationKeys.INFO_FISHING_POWER, "⑶ Luck: %s")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_FISHING_POWER, "Fishing Power")
        add(TranslationKeys.INFO_POSITION, "⑷ X: %1\$s, Z: %1\$s")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_POSITION, "Position")
        add(TranslationKeys.INFO_DEPTH, "⑸ Y: %s")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_DEPTH, "Depth")
        add(TranslationKeys.INFO_ENEMY_COUNT, "⑹ %s enemies nearby!")
        add(TranslationKeys.INFO_NO_ENEMY_COUNT, "⑹ No enemies nearby")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_ENEMY_COUNT, "Enemy Count")
        add(TranslationKeys.INFO_KILL_COUNT, "⑺ %1\$s: %2\$s")
        add(TranslationKeys.INFO_NO_KILL_COUNT, "⑺ Kill count unavailable")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_KILL_COUNT, "Kill Count")
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
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_MOON_PHASE, "Moon Phase")
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

        addConfigDesc("section.terrartifacts.common.toml", "Terrartifacts Common Config File")
        addConfigDesc("section.terrartifacts.client.common.title", "Terrartifacts Common Configs")

        addConfigDesc("radarDetectDistance", "Radar Detection Range")
        addConfigDesc("radarDetectDistance.tooltip", "Define Radar Detection Range")
    }
}