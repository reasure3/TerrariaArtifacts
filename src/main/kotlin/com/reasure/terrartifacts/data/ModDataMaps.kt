package com.reasure.terrartifacts.data

import com.reasure.terrartifacts.Terrartifacts
import net.minecraft.core.registries.Registries
import net.minecraft.world.entity.EntityType
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.registries.datamaps.DataMapType

/**
 * @see com.reasure.terrartifacts.event.RegisterEvents.registerDataMapTypes
 */
object ModDataMaps {
    val DISPLAY_INFO_DATA: DataMapType<Item, DisplayInfoData> = DataMapType.builder(
        Terrartifacts.modLoc("display_info_data"),
        Registries.ITEM,
        DisplayInfoData.CODEC
    ).synced(
        DisplayInfoData.CODEC,
        false
    ).build()

    val RARE_BLOCK_DATA: DataMapType<Block, RareBlockData> = DataMapType.builder(
        Terrartifacts.modLoc("rare_block_data"),
        Registries.BLOCK,
        RareBlockData.CODEC
    ).synced(
        RareBlockData.CODEC,
        false
    ).build()

    val RARE_ENTITY_DATA: DataMapType<EntityType<*>, RareEntityData> = DataMapType.builder(
        Terrartifacts.modLoc("rare_entity_data"),
        Registries.ENTITY_TYPE,
        RareEntityData.CODEC
    ).synced(
        RareEntityData.CODEC,
        false
    ).build()
}