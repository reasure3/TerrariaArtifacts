package com.reasure.terrartifacts.client.data

import com.reasure.terrartifacts.data.ShowInfoData
import com.reasure.terrartifacts.item.accessories.informational.InformationType
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
            ShowInfoData(
                showTime = ClientShowInfoData[InformationType.TIME]
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