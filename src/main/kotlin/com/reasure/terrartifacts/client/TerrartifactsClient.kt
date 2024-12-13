package com.reasure.terrartifacts.client

import com.reasure.terrartifacts.Terrartifacts
import net.neoforged.api.distmarker.Dist
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.Mod
import net.neoforged.fml.config.ModConfig
import net.neoforged.neoforge.client.gui.ConfigurationScreen
import net.neoforged.neoforge.client.gui.IConfigScreenFactory
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(Terrartifacts.ID, dist = [Dist.CLIENT])
class TerrartifactsClient(modContainer: ModContainer) {
    companion object {
        val LOGGER: Logger = LogManager.getLogger(Terrartifacts.ID + "_client")
    }

    init {
        modContainer.registerConfig(ModConfig.Type.CLIENT, ClientModConfig.SPEC)
        val screenFactory = IConfigScreenFactory { container, screen -> ConfigurationScreen(container, screen) }
        modContainer.registerExtensionPoint(IConfigScreenFactory::class.java, screenFactory)
    }
}