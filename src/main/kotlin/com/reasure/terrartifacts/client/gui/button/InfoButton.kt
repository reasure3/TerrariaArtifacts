package com.reasure.terrartifacts.client.gui.button

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.client.ClientModConfig
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
    private val type: InformationType
) : ImageButton(
    x, y, 9, 9, sprites,
    OnPress { ClientShowInfoData.toggleData(type) },
    type.message
) {

    override fun renderWidget(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int, partialTick: Float) {
        guiGraphics.blitSprite(sprites[isToggled(), isHoveredOrFocused], x, y, width, height)

        if (isHovered()) {
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
    }

    enum class LayoutPos(
        private val offsetX: Int,
        private val offsetY: Int,
        private val isHorizontal: Boolean = false
    ) {
        LEFT(-11, 1),
        RIGHT(177, 1),
        TOP(1, -11, true),
        BOTTOM(1, 167, true);

        fun offsetX(isCreative: Boolean): Int {
            var offset: Int = offsetX
            if (isCreative) {
                if (this == TOP) offset += 27
                else if (this == RIGHT) offset += 19
            }
            return offset + ClientModConfig.CLIENT.infoButtonOffsetX
        }

        fun offsetY(isCreative: Boolean): Int {
            var offset: Int = offsetY
            if (isCreative) {
                if (this == TOP) offset -= 27
                else if (this == BOTTOM) offset -= 1
            }
            return offset + ClientModConfig.CLIENT.infoButtonOffsetY
        }

        fun increaseX(): Int = if (isHorizontal) 10 else 0
        fun increaseY(): Int = if (isHorizontal) 0 else 10
    }
}