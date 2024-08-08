package com.reasure.terrartifacts.client

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.client.data.ClientHasInfoAccessoryData
import com.reasure.terrartifacts.client.gui.button.InfoButton
import com.reasure.terrartifacts.client.handler.InformationHandler
import com.reasure.terrartifacts.item.accessories.informational.InformationType
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen
import net.minecraft.client.gui.screens.inventory.InventoryScreen
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.client.event.ClientTickEvent
import net.neoforged.neoforge.client.event.ScreenEvent

@EventBusSubscriber(modid = Terrartifacts.ID, bus = EventBusSubscriber.Bus.GAME, value = [Dist.CLIENT])
object GameClient {
    @SubscribeEvent
    fun clientTick(event: ClientTickEvent.Post) {
        val mc = Minecraft.getInstance()
        val player = mc.player ?: return
        InformationHandler.updateInfo(player)
    }

    @SubscribeEvent
    fun openInventory(event: ScreenEvent.Init.Post) {
        val screen = event.screen

        if (screen !is InventoryScreen && screen !is CreativeModeInventoryScreen) return

        val gui = screen as AbstractContainerScreen<*>
        val isCreative = screen is CreativeModeInventoryScreen
        val layoutPos = ClientModConfig.CLIENT.infoButtonLayoutPos
        var offsetX = layoutPos.offsetX(isCreative)
        var offsetY = layoutPos.offsetY(isCreative)

        InformationType.entries.forEach {
            if (ClientHasInfoAccessoryData[it]) {
                event.addListener(
                    InfoButton(
                        gui.guiLeft + offsetX,
                        gui.guiTop + offsetY,
                        InfoButton.TIME_WIDGET,
                        InformationType.TIME
                    )
                )
                offsetX += layoutPos.increaseX()
                offsetY += layoutPos.increaseY()
            }
        }
    }
}