package com.reasure.terrartifacts.client

import com.reasure.terrartifacts.item.accessories.informational.InfoType
import com.reasure.terrartifacts.network.packet.SendShowInfoDataOnlyOnePacket
import net.neoforged.neoforge.network.PacketDistributor

object DataSenderC2S {
    fun sendShowInfo(type: InfoType, value: Boolean) {
        PacketDistributor.sendToServer(
            SendShowInfoDataOnlyOnePacket(type, value)
        )
    }
}