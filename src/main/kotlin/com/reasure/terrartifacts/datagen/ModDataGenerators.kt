package com.reasure.terrartifacts.datagen

import com.reasure.terrartifacts.Terrartifacts.ID
import com.reasure.terrartifacts.datagen.client.*
import net.minecraft.data.loot.LootTableProvider
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.data.event.GatherDataEvent

@EventBusSubscriber(modid = ID, bus = EventBusSubscriber.Bus.MOD)
object ModDataGenerators {

    @SubscribeEvent
    fun gatherData(event: GatherDataEvent) {
        with(event.generator) {
            val exFileHelper = event.existingFileHelper
            val output = this.packOutput
            val lookupProvider = event.lookupProvider

            val blockTagsProvider = ModBlockTagsProvider(output, lookupProvider, exFileHelper)
            addProvider(event.includeServer(), blockTagsProvider)
            addProvider(
                event.includeServer(),
                ModItemTagsProvider(output, lookupProvider, blockTagsProvider.contentsGetter(), exFileHelper)
            )
            addProvider(
                event.includeServer(),
                LootTableProvider(
                    output,
                    setOf(),
                    listOf(LootTableProvider.SubProviderEntry(::ModBlockLootTableProvider, LootContextParamSets.BLOCK)),
                    lookupProvider
                )
            )
            addProvider(event.includeServer(), ModCuriosDataProvider(output, exFileHelper, lookupProvider))

            addProvider(
                event.includeClient(),
                ModBlockStateProvider(output, exFileHelper)
            )
            addProvider(event.includeClient(), ModItemModelProvider(output, exFileHelper))
            addProvider(event.includeClient(), ModEnLangProvider(output))
            addProvider(event.includeClient(), ModKoLangProvider(output))
        }
    }
}