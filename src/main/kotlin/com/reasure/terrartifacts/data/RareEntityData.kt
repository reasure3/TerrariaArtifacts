package com.reasure.terrartifacts.data

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder

/**
 * Target: Entity
 * @see ModDataMaps
 */
data class RareEntityData(val rarity: Int) {
    fun test() {
    }

    companion object {
        val CODEC: Codec<RareEntityData> = RecordCodecBuilder.create { instance ->
            instance.group(
                Codec.INT.fieldOf("rarity").forGetter(RareEntityData::rarity)
            ).apply(instance, ::RareEntityData)
        }
    }
}
