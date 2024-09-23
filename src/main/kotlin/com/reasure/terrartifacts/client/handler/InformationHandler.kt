package com.reasure.terrartifacts.client.handler

import com.reasure.terrartifacts.client.data.ClientHasInfoAccessoryData
import com.reasure.terrartifacts.client.data.ClientShowInfoData
import com.reasure.terrartifacts.item.accessories.informational.ICompass
import com.reasure.terrartifacts.item.accessories.informational.IDepthMeter
import com.reasure.terrartifacts.item.accessories.informational.IFishermanPocketGuide
import com.reasure.terrartifacts.item.accessories.informational.IWatch
import com.reasure.terrartifacts.item.accessories.informational.IWeatherRadio
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

    fun reset() {
        infoComponent.clear()
        ClientHasInfoAccessoryData.reset()
    }

    fun updateInfo(player: LocalPlayer) {
        if ((player.level().dayTime % 10).toInt() == 0)
            checkInventory(player)
        infoComponent.clear()
        val level = player.level()
        if (ClientShowInfoData[InformationType.TIME] && ClientHasInfoAccessoryData.hasTimeInfo()) {
            infoComponent.add(IWatch.getInformation(level, ClientHasInfoAccessoryData.displayTimeType()))
        }
        if (ClientShowInfoData[InformationType.WEATHER] && ClientHasInfoAccessoryData.hasWeatherInfo) {
            infoComponent.add(IWeatherRadio.getInformation(player))
        }
        if (ClientShowInfoData[InformationType.FISHING_POWER] && ClientHasInfoAccessoryData.hasFishingPowerInfo) {
            infoComponent.add(IFishermanPocketGuide.getInformation(player))
        }
        if (ClientShowInfoData[InformationType.POSITION] && ClientHasInfoAccessoryData.hasDirectionInfo) {
            infoComponent.add(ICompass.getInformation(player))
        }
        if (ClientShowInfoData[InformationType.DEPTH] && ClientHasInfoAccessoryData.hasDepthInfo) {
            infoComponent.add(IDepthMeter.getInformation(player))
        }
    }

    private fun checkInventory(player: LocalPlayer) {
        ClientHasInfoAccessoryData.reset()
        val inventory = CuriosUtil.getAccessories(player)
        inventory.addAll(player.inventory.items)
        for (stack in inventory) {
            val item = stack.item
            if (item is IWatch) {
                when (item.watchType()) {
                    WatchType.MINUTE -> ClientHasInfoAccessoryData.hasMinInfo = true
                    WatchType.HALF_HOUR -> ClientHasInfoAccessoryData.hasHalfHourInfo = true
                    WatchType.HOUR -> ClientHasInfoAccessoryData.hasHourInfo = true
                }
            }
            if (item is IWeatherRadio) ClientHasInfoAccessoryData.hasWeatherInfo = true
            if (item is IFishermanPocketGuide) ClientHasInfoAccessoryData.hasFishingPowerInfo = true
            if (item is ICompass) ClientHasInfoAccessoryData.hasDirectionInfo = true
            if (item is IDepthMeter) ClientHasInfoAccessoryData.hasDepthInfo = true
        }
    }

    fun infoComponent(): MutableList<Component> = infoComponent
}