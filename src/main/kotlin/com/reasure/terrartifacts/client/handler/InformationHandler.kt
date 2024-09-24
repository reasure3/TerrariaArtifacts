package com.reasure.terrartifacts.client.handler

import com.reasure.terrartifacts.client.data.ClientHasInfoAccessoryData
import com.reasure.terrartifacts.client.data.ClientShowInfoData
import com.reasure.terrartifacts.item.accessories.informational.AbstractInformationalItem
import com.reasure.terrartifacts.item.accessories.informational.IDepthInfo
import com.reasure.terrartifacts.item.accessories.informational.IDirectionInfo
import com.reasure.terrartifacts.item.accessories.informational.IEnemyCountInfo
import com.reasure.terrartifacts.item.accessories.informational.IFishingPowerInfo
import com.reasure.terrartifacts.item.accessories.informational.IKillCountInfo
import com.reasure.terrartifacts.item.accessories.informational.IMoonPhaseInfo
import com.reasure.terrartifacts.item.accessories.informational.ITimeInfo
import com.reasure.terrartifacts.item.accessories.informational.IWeatherInfo
import com.reasure.terrartifacts.item.accessories.informational.InformationType
import com.reasure.terrartifacts.item.accessories.informational.WatchType
import com.reasure.terrartifacts.network.SendEntityKillCountS2CPacket
import com.reasure.terrartifacts.network.SendPlayerKillCountS2CPacket
import com.reasure.terrartifacts.util.CuriosUtil
import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.ChatFormatting
import net.minecraft.client.player.LocalPlayer
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.network.chat.Component
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn

@OnlyIn(Dist.CLIENT)
object InformationHandler {
    private val infoComponent: MutableList<Component> = mutableListOf()

    private var killCountComponent: Component = Component.translatable(TranslationKeys.INFO_NO_KILL_COUNT)
        .withStyle(AbstractInformationalItem.ICON.withColor(ChatFormatting.GRAY))

    fun reset() {
        infoComponent.clear()
        killCountComponent = Component.translatable(TranslationKeys.INFO_NO_KILL_COUNT)
            .withStyle(AbstractInformationalItem.ICON.withColor(ChatFormatting.GRAY))
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
        if (ClientShowInfoData[InformationType.KILL_COUNT] && ClientHasInfoAccessoryData.hasKillCountInfo) {
            infoComponent.add(killCountComponent)
        }
        if (ClientShowInfoData[InformationType.MOON_PHASE] && ClientHasInfoAccessoryData.hasMoonPhaseInfo) {
            infoComponent.add(IMoonPhaseInfo.getInformation(level))
        }
    }

    fun getKillCount(playerKillData: SendPlayerKillCountS2CPacket) {
        killCountComponent = IKillCountInfo.getInformation(
            Component.literal(playerKillData.targetPlayerName),
            playerKillData.killCount
        )
    }

    fun getKillCount(entityKillData: SendEntityKillCountS2CPacket) {
        killCountComponent = IKillCountInfo.getInformation(
            BuiltInRegistries.ENTITY_TYPE[entityKillData.targetEntity],
            entityKillData.killCount
        )
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
            if (item is IKillCountInfo) ClientHasInfoAccessoryData.hasKillCountInfo = true
            if (item is IMoonPhaseInfo) ClientHasInfoAccessoryData.hasMoonPhaseInfo = true
        }
    }

    fun infoComponent(): MutableList<Component> = infoComponent
}