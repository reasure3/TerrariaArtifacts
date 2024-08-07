package com.reasure.terrartifacts.block

// THIS LINE IS REQUIRED FOR USING PROPERTY DELEGATES
import com.reasure.terrartifacts.Terrartifacts
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModBlocks {
    val BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(Terrartifacts.ID)

    val EXAMPLE_BLOCK: Block by BLOCKS.register("example_block") { ->
        Block(BlockBehaviour.Properties.of().lightLevel { 15 }.strength(3.0f))
    }
}
