package com.reasure.terrartifacts.item.component

import com.reasure.terrartifacts.Terrartifacts
import net.minecraft.core.component.DataComponentType
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModDataComponents {
    val DATA_COMPONENTS: DeferredRegister.DataComponents = DeferredRegister.createDataComponents(Terrartifacts.ID)

    val HAS_INFO: DataComponentType<HasInfo> by DATA_COMPONENTS.registerComponentType("has_info") { builder ->
        builder.persistent(HasInfo.CODEC).networkSynchronized(HasInfo.STREAM_CODEC)
    }
}