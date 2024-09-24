package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.client.player.LocalPlayer
import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.world.level.Level
import net.minecraft.world.level.biome.Biome

interface IWeatherInfo {
    companion object {
        fun getInformation(player: LocalPlayer): Component {
            val level = player.level()
            val weather = if (level.isThundering) {
                when (level.getPrecipitationAt(player.onPos)) {
                    Biome.Precipitation.NONE -> Component.translatable(TranslationKeys.WEATHER_CLEAR)
                    Biome.Precipitation.RAIN -> Component.translatable(TranslationKeys.WEATHER_THUNDER)
                    Biome.Precipitation.SNOW -> Component.translatable(TranslationKeys.WEATHER_THUNDER)
                }
            } else if (level.isRaining) {
                when (level.getPrecipitationAt(player.onPos)) {
                    Biome.Precipitation.NONE -> Component.translatable(TranslationKeys.WEATHER_CLEAR)
                    Biome.Precipitation.RAIN -> Component.translatable(TranslationKeys.WEATHER_RAIN)
                    Biome.Precipitation.SNOW -> Component.translatable(TranslationKeys.WEATHER_SNOW)
                }
            } else if (level.dimension() == Level.OVERWORLD) Component.translatable(TranslationKeys.WEATHER_CLEAR)
            else Component.translatable(TranslationKeys.WEATHER_CLOUDY)

            return Component.translatable(
                TranslationKeys.INFO_WEATHER,
                weather,
                (level.rainLevel * 100).toInt(),
                (level.thunderLevel * 100).toInt()
            ).withStyle(AbstractInformationalItem.ICON)
        }

        private fun Level.getPrecipitationAt(pos: BlockPos): Biome.Precipitation =
            getBiome(pos).value().getPrecipitationAt(pos)
    }
}