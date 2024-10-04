package com.reasure.terrartifacts.client.data

import com.reasure.terrartifacts.item.accessories.informational.InfoType
import com.reasure.terrartifacts.item.accessories.informational.WatchType
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn
import java.util.EnumMap
import kotlin.collections.set

/**
 * 정보 악세서리를 가지고 있는지 여부 저장
 */
@OnlyIn(Dist.CLIENT)
object ClientHasInfoItemData {
    private const val DEFAULT_VALUE = false

    val hasInfo: EnumMap<InfoType, Boolean> = EnumMap(InfoType.entries.associateWith { DEFAULT_VALUE })
    val hasTime: EnumMap<WatchType, Boolean> = EnumMap(WatchType.entries.associateWith { DEFAULT_VALUE })

    fun displayTimeType(): WatchType =
        if (get(WatchType.MINUTE)) WatchType.MINUTE
        else if (get(WatchType.HALF_HOUR)) WatchType.HALF_HOUR
        else WatchType.HOUR

    fun reset() {
        InfoType.entries.forEach { hasInfo[it] = DEFAULT_VALUE }
        WatchType.entries.forEach { hasTime[it] = DEFAULT_VALUE }
    }

    operator fun get(type: InfoType) = hasInfo[type] ?: DEFAULT_VALUE
    operator fun set(type: InfoType, value: Boolean) {
        hasInfo[type] = value
    }

    operator fun get(type: WatchType) = hasTime[type] ?: DEFAULT_VALUE
    operator fun set(type: WatchType, value: Boolean) {
        hasTime[type] = value
    }
}