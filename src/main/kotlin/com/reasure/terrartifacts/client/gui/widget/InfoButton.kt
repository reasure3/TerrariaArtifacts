package com.reasure.terrartifacts.client.gui.widget

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.client.data.ClientShowInfoData
import com.reasure.terrartifacts.item.accessories.informational.InfoType
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.components.Button.OnPress
import net.minecraft.client.gui.components.ImageButton
import net.minecraft.client.gui.components.WidgetSprites

class InfoButton(
    x: Int, y: Int, val type: InfoType
) : ImageButton(
    x, y, 9, 9,
    makeWidgetSprites(type),
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
        fun makeWidgetSprites(infoType: InfoType): WidgetSprites {
            if (infoType == InfoType.MOON_PHASE) {
                val level = Minecraft.getInstance().level
                if (level != null && !level.dimensionType().natural) {
                    return WidgetSprites(
                        Terrartifacts.modLoc("icon/red_moon_phase"),
                        Terrartifacts.modLoc("icon/red_moon_phase_disabled"),
                        Terrartifacts.modLoc("icon/red_moon_phase_focused"),
                        Terrartifacts.modLoc("icon/red_moon_phase_disabled_focused")
                    )
                }
            }

            return WidgetSprites(
                Terrartifacts.modLoc("icon/${infoType.serializedName}"),
                Terrartifacts.modLoc("icon/${infoType.serializedName}_disabled"),
                Terrartifacts.modLoc("icon/${infoType.serializedName}_focused"),
                Terrartifacts.modLoc("icon/${infoType.serializedName}_disabled_focused")
            )
        }
    }
}