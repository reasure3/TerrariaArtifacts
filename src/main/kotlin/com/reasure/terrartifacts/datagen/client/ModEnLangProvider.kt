package com.reasure.terrartifacts.datagen.client

import com.reasure.terrartifacts.block.ModBlocks
import com.reasure.terrartifacts.item.ModItems
import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.data.PackOutput

class ModEnLangProvider(output: PackOutput) :
    ModBaseLangProvider(output, "en_us") {
    override fun addItems() {
        add(ModItems.COPPER_WATCH, "Copper Watch")
        add(ModItems.TIN_WATCH, "Tin Watch")
        add(ModItems.SILVER_WATCH, "Silver Watch")
        add(ModItems.TUNGSTEN_WATCH, "Tungsten Watch")
        add(ModItems.GOLD_WATCH, "Gold Watch")
        add(ModItems.PLATINUM_WATCH, "Platinum Watch")
    }

    override fun addBlocks() {
        add(ModBlocks.EXAMPLE_BLOCK, "Example Block")
    }

    override fun addTooltips() {
        add(TranslationKeys.HOUR_TOOLTIP_KEY, "Displays the time down to the hour")
        add(TranslationKeys.HALF_HOUR_TOOLTIP_KEY, "Displays the time down to the half-hour")
        add(TranslationKeys.MINUTE_TOOLTIP_KEY, "Displays the time down to the minute")
    }

    override fun addGui() {
        add(TranslationKeys.GROUP_TERRARTIFACTS_KEY, "Terraria Artifacts")
        add(TranslationKeys.GROUP_TERRARTIFACTS_DEVELOP_KEY, "Terraria Artifacts Develop Tab")
        addCuriosSlot("accessory", "Accessory")
        add(TranslationKeys.INFO_TIME_KEY, "⑴ %2\$s %1\$s")
        add(TranslationKeys.TIME_MORNING_KEY, "AM")
        add(TranslationKeys.TIME_AFTERNOON_KEY, "PM")
        add(TranslationKeys.TIME_BUTTON_MESSAGE, "Time")
    }

    override fun addConfigs() {
        addConfigDesc("infoButtonLayoutPos", "Info Accessory Toggle Button Layout")
        addConfigDesc("infoButtonOffsetX", "Info Accessory Toggle Button X Offset")
        addConfigDesc("infoButtonOffsetY", "Info Accessory Toggle Button Y Offset")
    }
}