package com.reasure.terrartifacts.block.properties

import net.minecraft.world.level.block.state.properties.EnumProperty
import net.minecraft.world.level.block.state.properties.EnumProperty.create

object ModBlockStateProperties {
    val HORIZONTAL_PART: EnumProperty<HorizontalPart> = create("horizontal_part", HorizontalPart::class.java)
}