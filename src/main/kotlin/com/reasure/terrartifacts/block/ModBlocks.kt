package com.reasure.terrartifacts.block

// THIS LINE IS REQUIRED FOR USING PROPERTY DELEGATES
import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.item.ModItems
import com.reasure.terrartifacts.item.ModRarity
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModBlocks {
    val BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(Terrartifacts.ID)

    val EXAMPLE_BLOCK: Block by registerBlock("example_block") {
        Block(BlockBehaviour.Properties.of().lightLevel { 15 }.strength(3.0f))
    }

    val TINKERERS_WORKSHOP: Block by registerBlock("tinkerers_workshop") {
        TinkerersWorkshopBlock()
    }

    private fun <T : Block> registerBlock(name: String, block: () -> T): DeferredBlock<T> {
        val registry = BLOCKS.register(name, block)
        ModItems.ITEMS.register(name) { ->
            BlockItem(registry.get(), Item.Properties().rarity(ModRarity.WHITE))
        }
        return registry
    }
}
