package com.reasure.terrartifacts.data

import com.reasure.terrartifacts.Terrartifacts
import net.minecraft.core.registries.Registries
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.registries.datamaps.DataMapType

/**
 * @see com.reasure.terrartifacts.event.RegisterEvents.registerDataMapTypes
 */
object ModDataMaps {
    val RARE_BLOCK_DATA: DataMapType<Block, RareBlockData> = DataMapType.builder(
        Terrartifacts.modLoc("rare_block_data"),
        Registries.BLOCK,
        RareBlockData.CODEC
    ).synced(
        RareBlockData.CODEC,
        false
    ).build()
}