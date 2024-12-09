package com.reasure.terrartifacts

import com.reasure.terrartifacts.block.ModBlocks
import com.reasure.terrartifacts.data.attachment.ModDataAttachments
import com.reasure.terrartifacts.item.ModCreativeTabs
import com.reasure.terrartifacts.item.ModItems
import net.minecraft.resources.ResourceLocation
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.Mod
import net.neoforged.fml.config.ModConfig
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS


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

        container.registerConfig(ModConfig.Type.SERVER, ServerModConfig.SPEC)
    }
}
