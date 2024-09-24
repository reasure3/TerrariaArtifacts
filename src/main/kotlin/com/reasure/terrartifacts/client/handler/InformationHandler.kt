package com.reasure.terrartifacts.client.handler

import com.reasure.terrartifacts.client.data.ClientHasInfoAccessoryData
import com.reasure.terrartifacts.client.data.ClientShowInfoData
import com.reasure.terrartifacts.item.accessories.informational.IDepthInfo
import com.reasure.terrartifacts.item.accessories.informational.IDirectionInfo
import com.reasure.terrartifacts.item.accessories.informational.IEnemyCountInfo
import com.reasure.terrartifacts.item.accessories.informational.IFishingPowerInfo
import com.reasure.terrartifacts.item.accessories.informational.ITimeInfo
import com.reasure.terrartifacts.item.accessories.informational.IWeatherInfo
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
            infoComponent.add(ITimeInfo.getInformation(level, ClientHasInfoAccessoryData.displayTimeType()))
        }
        if (ClientShowInfoData[InformationType.WEATHER] && ClientHasInfoAccessoryData.hasWeatherInfo) {
            infoComponent.add(IWeatherInfo.getInformation(player))
        }
        if (ClientShowInfoData[InformationType.FISHING_POWER] && ClientHasInfoAccessoryData.hasFishingPowerInfo) {
            infoComponent.add(IFishingPowerInfo.getInformation(player))
        }
        if (ClientShowInfoData[InformationType.POSITION] && ClientHasInfoAccessoryData.hasDirectionInfo) {
            infoComponent.add(IDirectionInfo.getInformation(player))
        }
        if (ClientShowInfoData[InformationType.DEPTH] && ClientHasInfoAccessoryData.hasDepthInfo) {
            infoComponent.add(IDepthInfo.getInformation(player))
        }
        if (ClientShowInfoData[InformationType.ENEMY_COUNT] && ClientHasInfoAccessoryData.hasEnemyCountInfo) {
            infoComponent.add(IEnemyCountInfo.getInformation(player))
        }
    }

    private fun checkInventory(player: LocalPlayer) {
        ClientHasInfoAccessoryData.reset()
        val inventory = CuriosUtil.getAccessories(player)
        inventory.addAll(player.inventory.items)
        for (stack in inventory) {
            val item = stack.item
            if (item is ITimeInfo) {
                when (item.watchType()) {
                    WatchType.MINUTE -> ClientHasInfoAccessoryData.hasMinInfo = true
                    WatchType.HALF_HOUR -> ClientHasInfoAccessoryData.hasHalfHourInfo = true
                    WatchType.HOUR -> ClientHasInfoAccessoryData.hasHourInfo = true
                }
            }
            if (item is IWeatherInfo) ClientHasInfoAccessoryData.hasWeatherInfo = true
            if (item is IFishingPowerInfo) ClientHasInfoAccessoryData.hasFishingPowerInfo = true
            if (item is IDirectionInfo) ClientHasInfoAccessoryData.hasDirectionInfo = true
            if (item is IDepthInfo) ClientHasInfoAccessoryData.hasDepthInfo = true
            if (item is IEnemyCountInfo) ClientHasInfoAccessoryData.hasEnemyCountInfo = true
        }
    }

    fun infoComponent(): MutableList<Component> = infoComponent
}