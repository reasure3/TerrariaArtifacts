package com.reasure.terrartifacts.data

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import com.reasure.terrartifacts.item.accessories.informational.InfoType
import com.reasure.terrartifacts.item.accessories.informational.WatchType

/**
 * Target: Item
 * @see ModDataMaps
 */
data class DisplayInfoData(
    val timeHour: Boolean,
    val timeHalfHour: Boolean,
    val timeMinute: Boolean,
    val weather: Boolean,
    val fishingPower: Boolean,
    val position: Boolean,
    val depth: Boolean,
    val enemyCount: Boolean,
    val killCount: Boolean,
    val moonPhase: Boolean,
    val movementSpeed: Boolean,
    val treasure: Boolean,
    val rareCreature: Boolean
) {
    operator fun get(type: InfoType) = when (type) {
        InfoType.TIME -> timeHour or timeHalfHour or timeMinute
        InfoType.WEATHER -> weather
        InfoType.FISHING_POWER -> fishingPower
        InfoType.POSITION -> position
        InfoType.DEPTH -> depth
        InfoType.ENEMY_COUNT -> enemyCount
        InfoType.KILL_COUNT -> killCount
        InfoType.MOON_PHASE -> moonPhase
        InfoType.MOVEMENT_SPEED -> movementSpeed
        InfoType.TREASURE -> treasure
        InfoType.RARE_CREATURE -> rareCreature
    }

    operator fun get(type: WatchType) = when (type) {
        WatchType.MINUTE -> timeMinute
        WatchType.HALF_HOUR -> timeHalfHour
        WatchType.HOUR -> timeHour
    }

    companion object {
        val CODEC: Codec<DisplayInfoData> = RecordCodecBuilder.create { instance ->
            instance.group(
                Codec.BOOL.fieldOf("time_hour").forGetter(DisplayInfoData::timeHour),
                Codec.BOOL.fieldOf("time_half_hour").forGetter(DisplayInfoData::timeHalfHour),
                Codec.BOOL.fieldOf("time_hour").forGetter(DisplayInfoData::timeMinute),
                Codec.BOOL.fieldOf("weather").forGetter(DisplayInfoData::weather),
                Codec.BOOL.fieldOf("fishingPower").forGetter(DisplayInfoData::fishingPower),
                Codec.BOOL.fieldOf("position").forGetter(DisplayInfoData::position),
                Codec.BOOL.fieldOf("depth").forGetter(DisplayInfoData::depth),
                Codec.BOOL.fieldOf("enemyCount").forGetter(DisplayInfoData::enemyCount),
                Codec.BOOL.fieldOf("killCount").forGetter(DisplayInfoData::killCount),
                Codec.BOOL.fieldOf("moonPhase").forGetter(DisplayInfoData::moonPhase),
                Codec.BOOL.fieldOf("movementSpeed").forGetter(DisplayInfoData::movementSpeed),
                Codec.BOOL.fieldOf("treasure").forGetter(DisplayInfoData::treasure),
                Codec.BOOL.fieldOf("rareCreature").forGetter(DisplayInfoData::rareCreature)
            ).apply(instance, ::DisplayInfoData)
        }
    }
}
