package com.reasure.terrartifacts.client.gui.widget

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.client.data.ClientShowInfoData
import com.reasure.terrartifacts.item.accessories.informational.InformationType
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.components.Button.OnPress
import net.minecraft.client.gui.components.ImageButton
import net.minecraft.client.gui.components.WidgetSprites

class InfoButton(
    x: Int,
    y: Int,
    sprites: WidgetSprites,
    val type: InformationType
) : ImageButton(
    x, y, 9, 9, sprites,
    OnPress { ClientShowInfoData.toggleData(type) },
    type.message
) {

    override fun renderWidget(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int, partialTick: Float) {
        guiGraphics.blitSprite(sprites[isToggled(), isHoveredOrFocused], x, y, width, height)

        if (isHovered) {
            val font = Minecraft.getInstance().font
            guiGraphics.renderTooltip(font, message, mouseX, mouseY)
        }
    }

    private fun isToggled(): Boolean = ClientShowInfoData[type]

    companion object {
        val TIME_WIDGET = WidgetSprites(
            Terrartifacts.modLoc("icon/time"),
            Terrartifacts.modLoc("icon/time_disabled"),
            Terrartifacts.modLoc("icon/time_focused"),
            Terrartifacts.modLoc("icon/time_disabled_focused")
        )

        fun getWidget(type: InformationType): WidgetSprites = when (type) {
            InformationType.TIME -> TIME_WIDGET
        }
    }
}