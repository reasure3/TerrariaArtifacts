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
    val rareCreature: Boolean,
    val dps: Boolean
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
        InfoType.DPS -> dps
    }

    operator fun get(type: WatchType) = when (type) {
        WatchType.MINUTE -> timeMinute
        WatchType.HALF_HOUR -> timeHalfHour
        WatchType.HOUR -> timeHour
    }

    companion object {
        val CODEC: Codec<DisplayInfoData> = RecordCodecBuilder.create { instance ->
            instance.group(
                Codec.BOOL.optionalFieldOf("time_hour", false).forGetter(DisplayInfoData::timeHour),
                Codec.BOOL.optionalFieldOf("time_halfHour", false).forGetter(DisplayInfoData::timeHalfHour),
                Codec.BOOL.optionalFieldOf("time_minute", false).forGetter(DisplayInfoData::timeMinute),
                Codec.BOOL.optionalFieldOf("weather", false).forGetter(DisplayInfoData::weather),
                Codec.BOOL.optionalFieldOf("fishingPower", false).forGetter(DisplayInfoData::fishingPower),
                Codec.BOOL.optionalFieldOf("position", false).forGetter(DisplayInfoData::position),
                Codec.BOOL.optionalFieldOf("depth", false).forGetter(DisplayInfoData::depth),
                Codec.BOOL.optionalFieldOf("enemyCount", false).forGetter(DisplayInfoData::enemyCount),
                Codec.BOOL.optionalFieldOf("killCount", false).forGetter(DisplayInfoData::killCount),
                Codec.BOOL.optionalFieldOf("moonPhase", false).forGetter(DisplayInfoData::moonPhase),
                Codec.BOOL.optionalFieldOf("movementSpeed", false).forGetter(DisplayInfoData::movementSpeed),
                Codec.BOOL.optionalFieldOf("treasure", false).forGetter(DisplayInfoData::treasure),
                Codec.BOOL.optionalFieldOf("rareCreature", false).forGetter(DisplayInfoData::rareCreature),
                Codec.BOOL.optionalFieldOf("dps", false).forGetter(DisplayInfoData::dps)
            ).apply(instance, ::DisplayInfoData)
        }
    }
}
