package com.reasure.terrartifacts.client.data

import com.reasure.terrartifacts.data.ShowInfoData
import com.reasure.terrartifacts.item.accessories.informational.InformationType
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

    val data = EnumMap(InformationType.entries.associateWith { DEFAULT_VALUE })

    fun copyFrom(serverData: ShowInfoData) = InformationType.entries.forEach { data[it] = serverData[it] }

    private fun sendDataToServer() {
        PacketDistributor.sendToServer(
            SendShowInfoDataPacket(
                ShowInfoData(
                    showTime = ClientShowInfoData[InformationType.TIME],
                    showWeather = ClientShowInfoData[InformationType.WEATHER],
                    showFishingPower = ClientHasInfoAccessoryData[InformationType.FISHING_POWER],
                    showDirection = ClientHasInfoAccessoryData[InformationType.POSITION],
                    showDepth = ClientHasInfoAccessoryData[InformationType.DEPTH],
                    showEnemyCount = ClientHasInfoAccessoryData[InformationType.ENEMY_COUNT],
                    showKillCount = ClientHasInfoAccessoryData[InformationType.KILL_COUNT]
                )
            )
        )
    }

    fun toggleData(type: InformationType) {
        data[type] = !ClientShowInfoData[type]
        sendDataToServer()
    }

    operator fun get(type: InformationType) = data[type] ?: DEFAULT_VALUE
    operator fun set(type: InformationType, value: Boolean) {
        data[type] = value
        sendDataToServer()
    }
}