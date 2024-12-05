package com.reasure.terrartifacts.client.data

import com.reasure.terrartifacts.client.DataSenderC2S
import com.reasure.terrartifacts.data.ShowInfoData
import com.reasure.terrartifacts.item.accessories.informational.InfoType
import com.reasure.terrartifacts.network.packet.SendShowInfoDataOnlyOnePacket
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

    fun toggleData(type: InfoType) {
        data[type] = !ClientShowInfoData[type]
        DataSenderC2S.sendShowInfo(type, ClientShowInfoData[type])
    }

    operator fun get(type: InfoType) = data[type] ?: DEFAULT_VALUE
    operator fun set(type: InfoType, value: Boolean) {
        data[type] = value
        DataSenderC2S.sendShowInfo(type, value)
    }
}