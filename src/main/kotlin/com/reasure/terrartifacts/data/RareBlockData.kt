package com.reasure.terrartifacts.data

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.util.ExtraCodecs

/**
 * Target: Block
 * @see ModDataMaps
 */
data class RareBlockData(val value: Int) {
    companion object {
        val VALUE_CODEC: Codec<RareBlockData> = ExtraCodecs.NON_NEGATIVE_INT.xmap(::RareBlockData, RareBlockData::value)

        val CODEC: Codec<RareBlockData> = Codec.withAlternative(
            RecordCodecBuilder.create { instance ->
                instance.group(
                    ExtraCodecs.NON_NEGATIVE_INT.fieldOf("value").forGetter(RareBlockData::value)
                ).apply(instance, ::RareBlockData)
            },
            VALUE_CODEC
        )
    }
}
