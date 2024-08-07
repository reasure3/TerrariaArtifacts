package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.client.TranslationKeys
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.Style
import net.minecraft.world.level.Level

interface IWatch {
    fun watchType(): WatchType

    companion object {
        private val ICON = Style.EMPTY.withFont(Terrartifacts.modLoc("terraria"))

        fun getInformation(level: Level, type: WatchType): Component {
            val formattedTime = formatTime(level.dayTime(), type)
            val amPmComponent =
                if (isMorning(level.dayTime()))
                    Component.translatable(TranslationKeys.TIME_MORNING_KEY)
                else
                    Component.translatable(TranslationKeys.TIME_AFTERNOON_KEY)
            return Component.translatable(TranslationKeys.INFO_TIME_KEY, amPmComponent, formattedTime)
                .withStyle(ICON)
        }

        private fun formatTime(daytime: Long, type: WatchType): String {
            val time = (daytime % 24000).toInt()
            // 0 tick = 06:00
            var hour = time / 1000 + 6
            // 12:00 ~ 12:59는 그대로 12:xx로 표기하도록
            if (hour > 12) hour %= 12
            val minute = ((daytime % 1000) * 0.06).toInt()

            return when (type) {
                WatchType.HOUR -> String.format("%2d:00", hour)
                WatchType.HALF_HOUR -> String.format("%2d:%02d", hour, (minute / 30) * 30)
                WatchType.MINUTE -> String.format("%2d:%02d", hour, minute)
            }
        }

        private fun isMorning(daytime: Long): Boolean {
            val hour = daytime % 24000
            // 6000 tick = 12:00:00
            // 18000 tick = 00:00:00
            return hour < 6000 || hour >= 18000
        }
    }
}