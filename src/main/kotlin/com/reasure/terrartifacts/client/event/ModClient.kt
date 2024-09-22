package com.reasure.terrartifacts.client.event

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.Terrartifacts.Companion.LOGGER
import com.reasure.terrartifacts.client.gui.overlay.InfoHudOverlay
import com.reasure.terrartifacts.item.ModItems
import net.minecraft.client.renderer.item.ItemProperties
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent
import net.neoforged.neoforge.client.gui.VanillaGuiLayers

@Suppress("unused")
@EventBusSubscriber(modid = Terrartifacts.ID, bus = EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
object ModClient {
    @SubscribeEvent
    fun registerOverlay(event: RegisterGuiLayersEvent) {
        event.registerAbove(VanillaGuiLayers.SCOREBOARD_SIDEBAR, InfoHudOverlay.OVERLAY_ID, InfoHudOverlay())
    }

    /**
     * This is used for initializing client specific
     * things such as renderers and keymaps
     *
     * Fired on the mod specific event bus.
     */
    @SubscribeEvent
    fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.info("Setting up Terraria Artifacts Client")
        val timeLoc = ResourceLocation.withDefaultNamespace("time")
        val clockProperty = ItemProperties.getProperty(ItemStack(Items.CLOCK), timeLoc)
        if (clockProperty != null) {
            ItemProperties.register(ModItems.COPPER_CLOCK, timeLoc, clockProperty)
            ItemProperties.register(ModItems.TIN_CLOCK, timeLoc, clockProperty)
            ItemProperties.register(ModItems.SILVER_CLOCK, timeLoc, clockProperty)
            ItemProperties.register(ModItems.TUNGSTEN_CLOCK, timeLoc, clockProperty)
            ItemProperties.register(ModItems.PLATINUM_CLOCK, timeLoc, clockProperty)
        }
    }
}