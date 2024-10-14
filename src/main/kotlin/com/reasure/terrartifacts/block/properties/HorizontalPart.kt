package com.reasure.terrartifacts.block.properties

import net.minecraft.util.StringRepresentable

enum class HorizontalPart(private val partName: String) : StringRepresentable {
    LEFT("left"),
    RIGHT("right");

    override fun toString(): String = partName

    override fun getSerializedName(): String = partName
}