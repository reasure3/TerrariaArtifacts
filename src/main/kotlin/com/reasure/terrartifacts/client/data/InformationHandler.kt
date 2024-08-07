package com.reasure.terrartifacts.client.data

import com.reasure.terrartifacts.item.accessories.informational.IWatch
import com.reasure.terrartifacts.item.accessories.informational.InformationType
import com.reasure.terrartifacts.item.accessories.informational.WatchType
import com.reasure.terrartifacts.util.CuriosUtil
import net.minecraft.client.player.LocalPlayer
import net.minecraft.network.chat.Component
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn

@OnlyIn(Dist.CLIENT)
object InformationHandler {
    private val infoComponent: MutableList<Component> = mutableListOf()

    fun updateInfo(player: LocalPlayer) {
        if ((player.level().dayTime % 10).toInt() == 0)
            checkInventory(player)
        infoComponent.clear()
        val level = player.level()
        if (ClientShowInfoData[InformationType.TIME] && ClientHasInfoAccessoryData.hasTimeInfo()) {
            infoComponent.add(IWatch.getInformation(level, ClientHasInfoAccessoryData.displayTimeType()))
        }
    }

    private fun checkInventory(player: LocalPlayer) {
        ClientHasInfoAccessoryData.reset()
        val inventory = CuriosUtil.getAccessories(player)
        inventory.addAll(player.inventory.items)
        for (stack in inventory) {
            when (val item = stack.item) {
                is IWatch -> when (item.watchType()) {
                    WatchType.MINUTE -> ClientHasInfoAccessoryData.hasMinInfo = true
                    WatchType.HALF_HOUR -> ClientHasInfoAccessoryData.hasHalfHourInfo = true
                    WatchType.HOUR -> ClientHasInfoAccessoryData.hasHourInfo = true
                }
            }
        }
    }

    fun infoComponent(): MutableList<Component> = infoComponent
}