package com.reasure.terrartifacts.util

import net.minecraft.core.BlockPos
import net.minecraft.world.entity.Entity
import net.minecraft.world.level.Level
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.phys.AABB

object LevelUtil {
    fun Level.getPrecipitationAt(pos: BlockPos): Biome.Precipitation =
        getBiome(pos).value().getPrecipitationAt(pos)

    fun Entity.getNearbyEntityCount(distance: Double, predicate: (entity: Entity) -> Boolean): Int {
        val pos = position()
        return level().getEntities(
            this, AABB(
                pos.x - distance, pos.y - distance, pos.z - distance,
                pos.x + distance, pos.y + distance, pos.z + distance
            ), predicate
        ).size
    }
}