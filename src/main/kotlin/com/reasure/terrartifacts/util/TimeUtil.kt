package com.reasure.terrartifacts.util

import com.reasure.terrartifacts.item.accessories.informational.WatchType

object TimeUtil {
    fun formatTime(daytime: Long, type: WatchType): String {
        val time = (daytime % 24000).toInt()
        // 0 tick = 06:00
        var hour = time / 1000 + 6
        // 12:00 ~ 12:59는 그대로 12:xx로 표기하도록
        if (hour > 12) hour %= 12
        val minute = ((daytime % 1000) * 0.06).toInt()

        return when (type) {
            WatchType.HOUR -> "$hour:00"
            WatchType.HALF_HOUR -> String.format("%d:%02d", hour, (minute / 30) * 30)
            WatchType.MINUTE -> String.format("%d:%02d", hour, minute)
        }
    }

    fun isMorning(dayTime: Long): Boolean {
        val hour = dayTime % 24000
        // 6000 tick = 12:00:00
        // 18000 tick = 00:00:00
        return hour < 6000 || hour >= 18000
    }
}