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
        add(ModItems.WEAHER_RADIO, "Weather Radio")
    }

    override fun addBlocks() {
        add(ModBlocks.EXAMPLE_BLOCK, "Example Block")
    }

    override fun addTooltips() {
        add(TranslationKeys.HOUR_TOOLTIP_KEY, "Displays the time down to the hour")
        add(TranslationKeys.HALF_HOUR_TOOLTIP_KEY, "Displays the time down to the half-hour")
        add(TranslationKeys.MINUTE_TOOLTIP_KEY, "Displays the time down to the minute")
        add(TranslationKeys.WEATHER_RADIO_TOOLTIP_KEY, "Displays the weather")
    }

    override fun addGui() {
        add(TranslationKeys.GROUP_TERRARTIFACTS_KEY, "Terraria Artifacts")
        add(TranslationKeys.GROUP_TERRARTIFACTS_DEVELOP_KEY, "Terraria Artifacts Develop Tab")
        addCuriosSlot("accessory", "Accessory")
        add(TranslationKeys.INFO_TIME_KEY, "⑴ %2\$s %1\$s")
        add(TranslationKeys.TIME_MORNING_KEY, "AM")
        add(TranslationKeys.TIME_AFTERNOON_KEY, "PM")
        add(TranslationKeys.TIME_BUTTON_MESSAGE, "Time")
        add(TranslationKeys.INFO_WEATHER_KEY, "⑵ %1\$s (\uD83D\uDCA7 %2\$s%%, ⚡ %3\$s%%)")
        add(TranslationKeys.WEATHER_CLEAR_KEY, "Clear")
        add(TranslationKeys.WEATHER_CLOUDY_KEY, "Cloudy")
        add(TranslationKeys.WEATHER_RAIN_KEY, "Rain")
        add(TranslationKeys.WEATHER_SNOW_KEY, "Snow")
        add(TranslationKeys.WEATHER_THUNDER_KEY, "Thunder")
        add(TranslationKeys.WEATHER_BUTTON_MESSAGE, "Weather")
    }

    override fun addConfigs() {
        addConfigDesc("infoButtonLayoutPos", "Info Accessory Toggle Button Layout")
        addConfigDesc("infoButtonOffsetX", "Info Accessory Toggle Button X Offset")
        addConfigDesc("infoButtonOffsetY", "Info Accessory Toggle Button Y Offset")
    }
}