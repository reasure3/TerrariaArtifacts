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
    var hasMinInfo: Boolean = false
    var hasHalfHourInfo: Boolean = false
    var hasHourInfo: Boolean = false
    var hasWeatherInfo: Boolean = false
    var hasFishingPowerInfo: Boolean = false

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
    }

    operator fun get(type: InformationType) = when (type) {
        InformationType.TIME -> hasTimeInfo()
        InformationType.WEATHER -> hasWeatherInfo
        InformationType.FISHING_POWER -> hasFishingPowerInfo
    }
}