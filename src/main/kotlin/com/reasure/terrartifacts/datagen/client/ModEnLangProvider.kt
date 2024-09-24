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
        add(ModItems.GPS, "GPS")
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
        add(TranslationKeys.INFO_DEPTH, "⑸ Depth: %s")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_DEPTH, "Depth")
    }

    override fun addConfigs() {
        addConfigDesc("infoButtonLayoutPos", "Info Accessory Toggle Button Layout")
        addConfigDesc("infoButtonOffsetX", "Info Accessory Toggle Button X Offset")
        addConfigDesc("infoButtonOffsetY", "Info Accessory Toggle Button Y Offset")
    }
}