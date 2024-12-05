package com.reasure.terrartifacts.data

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.util.ExtraCodecs

/**
 * Target: Entity
 * @see ModDataMaps
 */
data class RareEntityData(val rarity: Int) {
    companion object {
        val RARITY_CODEC: Codec<RareEntityData> =
            ExtraCodecs.NON_NEGATIVE_INT.xmap(::RareEntityData, RareEntityData::rarity)

        val CODEC: Codec<RareEntityData> = Codec.withAlternative(
            RecordCodecBuilder.create { instance ->
                instance.group(
                    ExtraCodecs.NON_NEGATIVE_INT.fieldOf("rarity").forGetter(RareEntityData::rarity)
                ).apply(instance, ::RareEntityData)
            },
            RARITY_CODEC
        )
    }
}
