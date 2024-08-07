package com.reasure.terrartifacts

import com.reasure.terrartifacts.block.ModBlocks
import com.reasure.terrartifacts.item.ModCreativeTabs
import com.reasure.terrartifacts.item.ModItems
import net.minecraft.client.Minecraft
import net.minecraft.resources.ResourceLocation
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.neoforge.forge.runForDist

// https://github.com/TheDeathlyCow/more-geodes-reforged/blob/main/src/main/kotlin/com/github/thedeathlycow/moregeodes/forge/
@Mod(Terrartifacts.ID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
object Terrartifacts {
    const val ID = "terrartifacts"

    private val LOGGER: Logger = LogManager.getLogger(ID)

    fun modLoc(name: String): ResourceLocation = ResourceLocation.fromNamespaceAndPath(ID, name)

    init {
        LOGGER.log(Level.INFO, "Hello world!")

        // Register the KDeferredRegister to the mod-specific event bus
        ModItems.ITEMS.register(MOD_BUS)
        ModBlocks.BLOCKS.register(MOD_BUS)
        ModCreativeTabs.CREATIVE_TABS.register(MOD_BUS)

        runForDist(
            clientTarget = {
                MOD_BUS.addListener(Terrartifacts::onClientSetup)
                Minecraft.getInstance()
            },
            serverTarget = {
                MOD_BUS.addListener(Terrartifacts::onServerSetup)
                "test"
            }
        )
    }

    /**
     * This is used for initializing client specific
     * things such as renderers and keymaps
     * Fired on the mod specific event bus.
     */
    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.log(Level.INFO, "Initializing client...")
    }

    /**
     * Fired on the global Forge bus.
     */
    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
        LOGGER.log(Level.INFO, "Server starting...")
    }

    @SubscribeEvent
    fun onCommonSetup(event: FMLCommonSetupEvent) {
        LOGGER.log(Level.INFO, "Hello! This is working!")
    }
}
