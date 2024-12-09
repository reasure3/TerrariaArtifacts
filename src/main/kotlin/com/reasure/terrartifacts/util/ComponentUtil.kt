package com.reasure.terrartifacts.util

import com.reasure.terrartifacts.Terrartifacts
import net.minecraft.ChatFormatting
import net.minecraft.network.chat.MutableComponent
import net.minecraft.network.chat.Style

object ComponentUtil {
    private val ICON = Style.EMPTY.withFont(Terrartifacts.modLoc("terraria"))

    fun MutableComponent.withIcon(): MutableComponent = withStyle(ICON)
    fun MutableComponent.withGray(): MutableComponent = withStyle(ChatFormatting.GRAY)
    fun MutableComponent.disabled(): MutableComponent = withIcon().withGray()
}