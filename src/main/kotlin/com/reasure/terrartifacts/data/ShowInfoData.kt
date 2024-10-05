package com.reasure.terrartifacts.data

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import com.reasure.terrartifacts.item.accessories.informational.InfoType

/**
 * 플레이어가 정보 악세서리 소지 시, 해당 정보를 보여줄지 여부를 저장
 *
 * 인벤토리 화면에서 플레이어가 직접 수정 가능
 *
 * Target: Player
 * @see ModDataAttachmentss
 */
data class ShowInfoData(
    val showTime: Boolean,
    val showWeather: Boolean,
    val showFishingPower: Boolean,
    val showPosition: Boolean,
    val showDepth: Boolean,
    val showEnemyCount: Boolean,
    val showKillCount: Boolean,
    val showMoonPhase: Boolean,
    val showMovementSpeed: Boolean,
    val showTreasure: Boolean,
    val showRareCreature: Boolean
) {
    operator fun get(type: InfoType) = when (type) {
        InfoType.TIME -> showTime
        InfoType.WEATHER -> showWeather
        InfoType.FISHING_POWER -> showFishingPower
        InfoType.POSITION -> showPosition
        InfoType.DEPTH -> showDepth
        InfoType.ENEMY_COUNT -> showEnemyCount
        InfoType.KILL_COUNT -> showKillCount
        InfoType.MOON_PHASE -> showMoonPhase
        InfoType.MOVEMENT_SPEED -> showMovementSpeed
        InfoType.TREASURE -> showTreasure
        InfoType.RARE_CREATURE -> showRareCreature
    }

    companion object {
        fun create(): ShowInfoData = ShowInfoData(
            showTime = true,
            showWeather = true,
            showFishingPower = true,
            showPosition = true,
            showDepth = true,
            showEnemyCount = true,
            showKillCount = true,
            showMoonPhase = true,
            showMovementSpeed = true,
            showTreasure = true,
            showRareCreature = true
        )

        val CODEC: Codec<ShowInfoData> = RecordCodecBuilder.create { instance ->
            instance.group(
                Codec.BOOL.fieldOf("showTime").forGetter(ShowInfoData::showTime),
                Codec.BOOL.fieldOf("showWeather").forGetter(ShowInfoData::showWeather),
                Codec.BOOL.fieldOf("showFishingPower").forGetter(ShowInfoData::showFishingPower),
                Codec.BOOL.fieldOf("showPosition").forGetter(ShowInfoData::showPosition),
                Codec.BOOL.fieldOf("showDepth").forGetter(ShowInfoData::showDepth),
                Codec.BOOL.fieldOf("showEnemyCount").forGetter(ShowInfoData::showEnemyCount),
                Codec.BOOL.fieldOf("showKillCount").forGetter(ShowInfoData::showKillCount),
                Codec.BOOL.fieldOf("showMoonPhase").forGetter(ShowInfoData::showMoonPhase),
                Codec.BOOL.fieldOf("showMovementSpeed").forGetter(ShowInfoData::showMovementSpeed),
                Codec.BOOL.fieldOf("showTreasure").forGetter(ShowInfoData::showTreasure),
                Codec.BOOL.fieldOf("showRareCreature").forGetter(ShowInfoData::showRareCreature)
            ).apply(instance, ::ShowInfoData)
        }
    }
}