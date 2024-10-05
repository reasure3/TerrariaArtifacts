package com.reasure.terrartifacts.data

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder

/**
 * Target: Block
 * @see ModDataMaps
 */
data class RareBlockData(val value: Int) {
    companion object {
        val CODEC: Codec<RareBlockData> = RecordCodecBuilder.create { instance ->
            instance.group(
                Codec.INT.fieldOf("value").forGetter(RareBlockData::value)
            ).apply(instance, ::RareBlockData)
        }
    }
}
