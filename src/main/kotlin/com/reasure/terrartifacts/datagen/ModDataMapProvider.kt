package com.reasure.terrartifacts.datagen

import com.reasure.terrartifacts.data.ModDataMaps
import com.reasure.terrartifacts.data.RareBlockData
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.tags.BlockTags
import net.minecraft.tags.TagKey
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
}