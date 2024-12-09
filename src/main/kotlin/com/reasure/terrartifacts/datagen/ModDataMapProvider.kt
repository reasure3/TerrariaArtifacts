package com.reasure.terrartifacts.datagen

import com.reasure.terrartifacts.data.datamap.ModDataMaps
import com.reasure.terrartifacts.data.datamap.RareBlockData
import com.reasure.terrartifacts.data.datamap.RareEntityData
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.tags.BlockTags
import net.minecraft.tags.TagKey
import net.minecraft.world.entity.EntityType
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.common.data.DataMapProvider
import java.util.concurrent.CompletableFuture

class ModDataMapProvider(output: PackOutput, registries: CompletableFuture<HolderLookup.Provider>) :
    DataMapProvider(output, registries) {
    override fun gather() {
        builder(ModDataMaps.RARE_BLOCK_DATA)
            .rareBlock(Blocks.DECORATED_POT, 50)
            .rareBlock(Tags.Blocks.ORES_QUARTZ, 100)
            .rareBlock(Blocks.QUARTZ_BLOCK, 150)
            .rareBlock(Tags.Blocks.ORES_COAL, 200)
            .rareBlock(Tags.Blocks.STORAGE_BLOCKS_COAL, 250)
            .rareBlock(Tags.Blocks.ORES_COPPER, 300)
            .rareBlock(Tags.Blocks.STORAGE_BLOCKS_RAW_COPPER, 350)
            .rareBlock(Tags.Blocks.STORAGE_BLOCKS_COPPER, 360)
            .rareBlock(Tags.Blocks.ORES_LAPIS, 400)
            .rareBlock(Tags.Blocks.ORES_REDSTONE, 401)
            .rareBlock(Tags.Blocks.STORAGE_BLOCKS_LAPIS, 450)
            .rareBlock(Tags.Blocks.STORAGE_BLOCKS_REDSTONE, 451)
            .rareBlock(Tags.Blocks.ORES_IRON, 500)
            .rareBlock(Tags.Blocks.STORAGE_BLOCKS_RAW_IRON, 550)
            .rareBlock(Tags.Blocks.STORAGE_BLOCKS_IRON, 560)
            .rareBlock(Tags.Blocks.ORES_GOLD, 600)
            .rareBlock(Tags.Blocks.STORAGE_BLOCKS_RAW_GOLD, 650)
            .rareBlock(Tags.Blocks.STORAGE_BLOCKS_GOLD, 660)
            .rareBlock(Blocks.SMALL_AMETHYST_BUD, 700)
            .rareBlock(Blocks.MEDIUM_AMETHYST_BUD, 701)
            .rareBlock(Blocks.LARGE_AMETHYST_BUD, 702)
            .rareBlock(Blocks.AMETHYST_BLOCK, 750)
            .rareBlock(Blocks.BUDDING_AMETHYST, 755)
            .rareBlock(Blocks.AMETHYST_CLUSTER, 760)
            .rareBlock(Tags.Blocks.ORES_EMERALD, 800)
            .rareBlock(Tags.Blocks.STORAGE_BLOCKS_EMERALD, 850)
            .rareBlock(Tags.Blocks.ORES_DIAMOND, 900)
            .rareBlock(Tags.Blocks.STORAGE_BLOCKS_DIAMOND, 950)
            .rareBlock(Blocks.ANCIENT_DEBRIS, 1000)
            .rareBlock(Tags.Blocks.STORAGE_BLOCKS_NETHERITE, 1050)
            .rareBlock(Tags.Blocks.BARRELS, 5000)
            .rareBlock(Tags.Blocks.CHESTS, 5010)
            .rareBlock(BlockTags.SHULKER_BOXES, 5020)
            .rareBlock(BlockTags.SHULKER_BOXES, 5020)
            .rareBlock(Blocks.DRAGON_EGG, 10000)

        builder(ModDataMaps.RARE_ENTITY_DATA)
            .rareEntity(EntityType.ENDER_DRAGON, 100)
            .rareEntity(EntityType.WITHER, 90)
            .rareEntity(EntityType.WARDEN, 80)
            .rareEntity(EntityType.ELDER_GUARDIAN, 50)
            .rareEntity(EntityType.SKELETON_HORSE, 40)
            .rareEntity(EntityType.PIGLIN_BRUTE, 19)
            .rareEntity(EntityType.MOOSHROOM, 18)
            .rareEntity(EntityType.SHULKER, 17)
            .rareEntity(EntityType.ENDERMITE, 16)
            .rareEntity(EntityType.BREEZE, 15)
            .rareEntity(EntityType.BLAZE, 14)
            .rareEntity(EntityType.WITHER_SKELETON, 13)
            .rareEntity(EntityType.SNIFFER, 12)
            .rareEntity(EntityType.ALLAY, 11)
            .rareEntity(EntityType.AXOLOTL, 10)
            .rareEntity(EntityType.GUARDIAN, 9)
            .rareEntity(EntityType.SILVERFISH, 8)
            .rareEntity(EntityType.ARMADILLO, 7)
            .rareEntity(EntityType.BEE, 6)
            .rareEntity(EntityType.PANDA, 5)
            .rareEntity(EntityType.WOLF, 4)
            .rareEntity(EntityType.GOAT, 3)
            .rareEntity(EntityType.EVOKER, 2)
            .rareEntity(EntityType.PHANTOM, 1)
    }

    @Suppress("DEPRECATION")
    private fun Builder<RareBlockData, Block>.rareBlock(
        block: Block,
        value: Int
    ): Builder<RareBlockData, Block> =
        add(block.builtInRegistryHolder(), RareBlockData(value), false)

    private fun Builder<RareBlockData, Block>.rareBlock(
        blockTag: TagKey<Block>,
        value: Int
    ): Builder<RareBlockData, Block> =
        add(blockTag, RareBlockData(value), false)

    @Suppress("DEPRECATION")
    private fun Builder<RareEntityData, EntityType<*>>.rareEntity(
        entity: EntityType<*>,
        rarity: Int
    ): Builder<RareEntityData, EntityType<*>> =
        add(entity.builtInRegistryHolder(), RareEntityData(rarity), false)
}