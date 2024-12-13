package com.reasure.terrartifacts.client.handler

import com.reasure.terrartifacts.ServerModConfig
import com.reasure.terrartifacts.client.TerrartifactsClient
import com.reasure.terrartifacts.client.data.ClientDamageTracker
import com.reasure.terrartifacts.client.data.ClientHasInfoItemData
import com.reasure.terrartifacts.client.data.ClientShowInfoData
import com.reasure.terrartifacts.item.accessories.informational.InfoType
import com.reasure.terrartifacts.item.accessories.informational.WatchType
import com.reasure.terrartifacts.item.component.ModDataComponents
import com.reasure.terrartifacts.util.CuriosUtil
import net.minecraft.client.player.LocalPlayer
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn

@OnlyIn(Dist.CLIENT)
object InfoDataHandler {
    private val infoComponent: MutableList<Component> = mutableListOf()

    fun reset() {
        TerrartifactsClient.LOGGER.info("Reset Info Data")
        infoComponent.clear()
        InfoComponentHandler.reset()
        ClientHasInfoItemData.reset()
        ClientDamageTracker.reset()
    }

    fun updateInfo(player: LocalPlayer) {
        val gameTime = player.level().gameTime
        if ((gameTime % ServerModConfig.SERVER.checkInventoryTickRate) == 0L)
            checkInventory(player)
        infoComponent.clear()
        InfoComponentHandler.updateHugeInfoComponent(player)
        InfoType.entries.forEach {
            if (ClientShowInfoData[it] && ClientHasInfoItemData[it]) {
                infoComponent.add(InfoComponentHandler[it, player])
            }
        }
    }

    fun receiveKillCount(targetPlayerName: String, killCount: Int) {
        InfoComponentHandler.updateKillCountComponent(
            Component.literal(targetPlayerName),
            killCount
        )
    }

    fun receiveKillCount(targetEntity: ResourceLocation, killCount: Int) {
        InfoComponentHandler.updateKillCountComponent(
            BuiltInRegistries.ENTITY_TYPE[targetEntity].description,
            killCount
        )
    }

    private fun checkInventory(player: LocalPlayer) {
        ClientHasInfoItemData.reset()
        val inventory = CuriosUtil.getAccessories(player)
        inventory.addAll(player.inventory.items)

        for (item in inventory) {
            val hasInfo = item.get(ModDataComponents.HAS_INFO) ?: continue
            InfoType.entries.forEach {
                if (hasInfo[it]) ClientHasInfoItemData[it] = true
            }
            WatchType.entries.forEach {
                if (hasInfo[it]) ClientHasInfoItemData[it] = true
            }
        }
    }

    fun infoComponent(): List<Component> = infoComponent
}