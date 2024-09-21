package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.client.player.LocalPlayer
import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.world.level.Level
import net.minecraft.world.level.biome.Biome

interface IWeatherRadio {
    companion object {
        fun getInformation(player: LocalPlayer): Component {
            val level = player.level()
            val weather = if (level.isThundering) {
                when (level.getPrecipitationAt(player.onPos)) {
                    Biome.Precipitation.NONE -> Component.translatable(TranslationKeys.WEATHER_CLEAR_KEY)
                    Biome.Precipitation.RAIN -> Component.translatable(TranslationKeys.WEATHER_THUNDER_KEY)
                    Biome.Precipitation.SNOW -> Component.translatable(TranslationKeys.WEATHER_THUNDER_KEY)
                }
            } else if (level.isRaining) {
                when (level.getPrecipitationAt(player.onPos)) {
                    Biome.Precipitation.NONE -> Component.translatable(TranslationKeys.WEATHER_CLEAR_KEY)
                    Biome.Precipitation.RAIN -> Component.translatable(TranslationKeys.WEATHER_RAIN_KEY)
                    Biome.Precipitation.SNOW -> Component.translatable(TranslationKeys.WEATHER_SNOW_KEY)
                }
            } else if (level.dimension() == Level.OVERWORLD) Component.translatable(TranslationKeys.WEATHER_CLEAR_KEY)
            else Component.translatable(TranslationKeys.WEATHER_CLOUDY_KEY)

            return Component.translatable(
                TranslationKeys.INFO_WEATHER_KEY,
                weather,
                (level.rainLevel * 100).toInt(),
                (level.thunderLevel * 100).toInt()
            ).withStyle(AbstractInformationalItem.ICON)
        }

        private fun Level.getPrecipitationAt(pos: BlockPos): Biome.Precipitation =
            getBiome(pos).value().getPrecipitationAt(pos)
    }
}