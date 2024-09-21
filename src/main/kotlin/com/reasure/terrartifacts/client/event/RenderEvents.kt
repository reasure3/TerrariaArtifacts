package com.reasure.terrartifacts.client.event

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.client.ClientModConfig
import com.reasure.terrartifacts.client.color.AnimatedColors
import com.reasure.terrartifacts.client.gui.widget.InfoButtonListWidget
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen
import net.minecraft.client.gui.screens.inventory.InventoryScreen
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.client.event.ClientTickEvent
import net.neoforged.neoforge.client.event.RenderFrameEvent
import net.neoforged.neoforge.client.event.ScreenEvent

@EventBusSubscriber(modid = Terrartifacts.ID, bus = EventBusSubscriber.Bus.GAME, value = [Dist.CLIENT])
object RenderEvents {
    @SubscribeEvent
    fun openInventory(event: ScreenEvent.Init.Post) {
        val screen = event.screen

        if (screen !is InventoryScreen && screen !is CreativeModeInventoryScreen) return

        val gui = screen as AbstractContainerScreen<*>
        val isCreative = screen is CreativeModeInventoryScreen

        event.addListener(
            InfoButtonListWidget(
                gui.guiLeft,
                gui.guiTop,
                ClientModConfig.CLIENT.infoButtonLayoutPos,
                isCreative
            )
        )
    }

    @SubscribeEvent
    fun clientTick(event: ClientTickEvent.Pre) {
        AnimatedColors.updateTick()
    }

    @SubscribeEvent
    fun onFrame(event: RenderFrameEvent.Pre) {
        AnimatedColors.updateFrame(event.partialTick.realtimeDeltaTicks)
    }
}