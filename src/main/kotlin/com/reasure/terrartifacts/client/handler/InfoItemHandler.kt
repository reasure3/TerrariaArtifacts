package com.reasure.terrartifacts.client.handler

import com.reasure.terrartifacts.client.data.ClientHasInfoItemData
import com.reasure.terrartifacts.client.data.ClientShowInfoData
import com.reasure.terrartifacts.item.accessories.informational.InfoType
import com.reasure.terrartifacts.item.accessories.informational.WatchType
import com.reasure.terrartifacts.util.CuriosUtil
import com.reasure.terrartifacts.util.ModTags
import net.minecraft.client.player.LocalPlayer
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn

@OnlyIn(Dist.CLIENT)
object InfoItemHandler {
    val infoTagMapping = mapOf(
        ModTags.Items.INFORMATION_TIME to InfoType.TIME,
        ModTags.Items.INFORMATION_WEATHER to InfoType.WEATHER,
        ModTags.Items.INFORMATION_FISHING_POWER to InfoType.FISHING_POWER,
        ModTags.Items.INFORMATION_POSITION to InfoType.POSITION,
        ModTags.Items.INFORMATION_DEPTH to InfoType.DEPTH,
        ModTags.Items.INFORMATION_ENEMY_COUNT to InfoType.ENEMY_COUNT,
        ModTags.Items.INFORMATION_KILL_COUNT to InfoType.KILL_COUNT,
        ModTags.Items.INFORMATION_MOON_PHASE to InfoType.MOON_PHASE,
        ModTags.Items.INFORMATION_MOVEMENT_SPEED to InfoType.MOVEMENT_SPEED,
        ModTags.Items.INFORMATION_TREASURE to InfoType.TREASURE
    )

    private val infoComponent: MutableList<Component> = mutableListOf()
    fun reset() {
        infoComponent.clear()
        InfoComponentHandler.reset()
        ClientHasInfoItemData.reset()
    }

    fun updateInfo(player: LocalPlayer) {
        if ((player.level().dayTime % 10).toInt() == 0)
            checkInventory(player)
        infoComponent.clear()
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
            if (item.`is`(ModTags.Items.INFORMATION)) {
                checkInfoItem(item)
                checkTimeItem(item)
            }
        }
    }

    private fun checkInfoItem(item: ItemStack) {
        infoTagMapping.forEach { (tag, type) ->
            if (item.`is`(tag)) ClientHasInfoItemData[type] = true
        }
    }

    private fun checkTimeItem(item: ItemStack) {
        when {
            item.`is`(ModTags.Items.INFORMATION_TIME_MINUTE) -> ClientHasInfoItemData[WatchType.MINUTE] = true
            item.`is`(ModTags.Items.INFORMATION_TIME_HALF_HOUR) -> ClientHasInfoItemData[WatchType.HALF_HOUR] = true
            item.`is`(ModTags.Items.INFORMATION_TIME_HOUR) -> ClientHasInfoItemData[WatchType.HOUR] = true
        }
    }

    fun infoComponent(): MutableList<Component> = infoComponent
}