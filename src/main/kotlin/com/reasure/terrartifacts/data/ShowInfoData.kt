package com.reasure.terrartifacts.data

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import com.reasure.terrartifacts.item.accessories.informational.InformationType

/**
 * 플레이어가 정보 악세서리 소지 시, 해당 정보를 보여줄지 여부를 저장
 *
 * 인벤토리 화면에서 플레이어가 직접 수정 가능
 */
data class ShowInfoData(
    val showTime: Boolean,
    val showWeather: Boolean,
    val showFishingPower: Boolean,
    val showDirection: Boolean,
    val showDepth: Boolean,
    val showEnemyCount: Boolean,
    val showKillCount: Boolean
) {
    operator fun get(type: InformationType) = when (type) {
        InformationType.TIME -> showTime
        InformationType.WEATHER -> showWeather
        InformationType.FISHING_POWER -> showFishingPower
        InformationType.POSITION -> showDirection
        InformationType.DEPTH -> showDepth
        InformationType.ENEMY_COUNT -> showEnemyCount
        InformationType.KILL_COUNT -> showKillCount
    }

    companion object {
        fun create(): ShowInfoData = ShowInfoData(
            showTime = true,
            showWeather = true,
            showFishingPower = true,
            showDirection = true,
            showDepth = true,
            showEnemyCount = true,
            showKillCount = true
        )

        val CODEC: Codec<ShowInfoData> = RecordCodecBuilder.create { instance ->
            instance.group(
                Codec.BOOL.fieldOf("showTime").forGetter(ShowInfoData::showTime),
                Codec.BOOL.fieldOf("showWeather").forGetter(ShowInfoData::showWeather),
                Codec.BOOL.fieldOf("showFishingPower").forGetter(ShowInfoData::showFishingPower),
                Codec.BOOL.fieldOf("showDirection").forGetter(ShowInfoData::showDirection),
                Codec.BOOL.fieldOf("showDepth").forGetter(ShowInfoData::showDepth),
                Codec.BOOL.fieldOf("showEnemyCount").forGetter(ShowInfoData::showEnemyCount),
                Codec.BOOL.fieldOf("showKillCount").forGetter(ShowInfoData::showKillCount)
            ).apply(instance, ::ShowInfoData)
        }
    }
}