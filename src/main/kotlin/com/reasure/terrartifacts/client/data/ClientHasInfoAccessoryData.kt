package com.reasure.terrartifacts.client.data

import com.reasure.terrartifacts.item.accessories.informational.InformationType
import com.reasure.terrartifacts.item.accessories.informational.WatchType
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn

/**
 * 정보 악세서리를 가지고 있는지 여부 저장
 */
@OnlyIn(Dist.CLIENT)
object ClientHasInfoAccessoryData {
    var hasMinInfo = false
    var hasHalfHourInfo = false
    var hasHourInfo = false
    var hasWeatherInfo = false
    var hasFishingPowerInfo = false
    var hasDirectionInfo = false
    var hasDepthInfo = false
    var hasEnemyCountInfo = false
    var hasKillCountInfo = false
    var hasMoonPhaseInfo = false
    var hasMovementSpeedInfo = false

    fun hasTimeInfo(): Boolean = hasMinInfo || hasHalfHourInfo || hasHourInfo
    fun displayTimeType(): WatchType =
        if (hasMinInfo) WatchType.MINUTE
        else if (hasHalfHourInfo) WatchType.HALF_HOUR
        else WatchType.HOUR

    fun reset() {
        hasMinInfo = false
        hasHalfHourInfo = false
        hasHourInfo = false
        hasWeatherInfo = false
        hasFishingPowerInfo = false
        hasDirectionInfo = false
        hasDepthInfo = false
        hasEnemyCountInfo = false
        hasKillCountInfo = false
        hasMoonPhaseInfo = false
        hasMovementSpeedInfo = false
    }

    operator fun get(type: InformationType) = when (type) {
        InformationType.TIME -> hasTimeInfo()
        InformationType.WEATHER -> hasWeatherInfo
        InformationType.FISHING_POWER -> hasFishingPowerInfo
        InformationType.POSITION -> hasDirectionInfo
        InformationType.DEPTH -> hasDepthInfo
        InformationType.ENEMY_COUNT -> hasEnemyCountInfo
        InformationType.KILL_COUNT -> hasKillCountInfo
        InformationType.MOON_PHASE -> hasMoonPhaseInfo
        InformationType.MOVEMENT_SPEED -> hasMovementSpeedInfo
    }
}