package com.reasure.terrartifacts.client.data

import com.reasure.terrartifacts.data.ShowInfoData
import com.reasure.terrartifacts.item.accessories.informational.InfoType
import com.reasure.terrartifacts.network.SendShowInfoDataPacket
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn
import net.neoforged.neoforge.network.PacketDistributor
import java.util.*

/**
 * 해당 정보를 보여줄지 말지 여부 저장
 */
@OnlyIn(Dist.CLIENT)
object ClientShowInfoData {
    private const val DEFAULT_VALUE = false

    val data: EnumMap<InfoType, Boolean> = EnumMap(InfoType.entries.associateWith { DEFAULT_VALUE })

    fun copyFrom(serverData: ShowInfoData) = InfoType.entries.forEach { data[it] = serverData[it] }

    private fun sendDataToServer() {
        PacketDistributor.sendToServer(
            SendShowInfoDataPacket(
                ShowInfoData(
                    showTime = ClientShowInfoData[InfoType.TIME],
                    showWeather = ClientShowInfoData[InfoType.WEATHER],
                    showFishingPower = ClientShowInfoData[InfoType.FISHING_POWER],
                    showDirection = ClientShowInfoData[InfoType.POSITION],
                    showDepth = ClientShowInfoData[InfoType.DEPTH],
                    showEnemyCount = ClientShowInfoData[InfoType.ENEMY_COUNT],
                    showKillCount = ClientShowInfoData[InfoType.KILL_COUNT],
                    showMoonPhase = ClientShowInfoData[InfoType.MOON_PHASE],
                    showMovementSpeed = ClientShowInfoData[InfoType.MOVEMENT_SPEED]
                )
            )
        )
    }

    fun toggleData(type: InfoType) {
        data[type] = !ClientShowInfoData[type]
        sendDataToServer()
    }

    operator fun get(type: InfoType) = data[type] ?: DEFAULT_VALUE
    operator fun set(type: InfoType, value: Boolean) {
        data[type] = value
        sendDataToServer()
    }
}