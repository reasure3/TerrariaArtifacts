package com.reasure.terrartifacts.datagen

import com.reasure.terrartifacts.Terrartifacts
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.ExistingFileHelper
import top.theillusivec4.curios.api.CuriosDataProvider
import java.util.concurrent.CompletableFuture

class ModCuriosDataProvider(
    output: PackOutput,
    exFileHelper: ExistingFileHelper,
    registries: CompletableFuture<HolderLookup.Provider>
) : CuriosDataProvider(Terrartifacts.ID, output, exFileHelper, registries) {

    override fun generate(registries: HolderLookup.Provider?, fileHelper: ExistingFileHelper?) {
        createSlot("accessory")
            .size(6)
            .addCosmetic(true)
            .icon(Terrartifacts.modLoc("slot/empty_accessory_slot"))

        createEntities("terrartifacts_entities")
            .addPlayer()
            .addSlots("accessory")
    }
}