package com.reasure.terrartifacts

import com.reasure.terrartifacts.block.ModBlocks
import com.reasure.terrartifacts.client.ClientModConfig
import com.reasure.terrartifacts.data.ModDataAttachments
import com.reasure.terrartifacts.item.ModCreativeTabs
import com.reasure.terrartifacts.item.ModItems
import net.minecraft.resources.ResourceLocation
import net.neoforged.api.distmarker.Dist
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.Mod
import net.neoforged.fml.config.ModConfig
import net.neoforged.neoforge.client.gui.ConfigurationScreen
import net.neoforged.neoforge.client.gui.IConfigScreenFactory
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.neoforge.forge.runWhenOn


// https://github.com/TheDeathlyCow/more-geodes-reforged/blob/main/src/main/kotlin/com/github/thedeathlycow/moregeodes/forge/
@Mod(Terrartifacts.ID)
class Terrartifacts(container: ModContainer) {
    companion object {
        const val ID = "terrartifacts"

        val LOGGER: Logger = LogManager.getLogger(ID)

        fun modLoc(name: String): ResourceLocation = ResourceLocation.fromNamespaceAndPath(ID, name)
    }

    init {
        LOGGER.log(Level.INFO, "Hello world!")

        // Register the KDeferredRegister to the mod-specific event bus
        ModItems.ITEMS.register(MOD_BUS)
        ModBlocks.BLOCKS.register(MOD_BUS)
        ModCreativeTabs.CREATIVE_TABS.register(MOD_BUS)
        ModDataAttachments.ATTACHMENT_TYPES.register(MOD_BUS)

        runWhenOn(Dist.CLIENT) {
            container.registerConfig(ModConfig.Type.CLIENT, ClientModConfig.SPEC)
            val screenFactory = IConfigScreenFactory { container, screen -> ConfigurationScreen(container, screen) }
            container.registerExtensionPoint(IConfigScreenFactory::class.java, screenFactory)
        }
    }
}
