package com.reasure.terrartifacts.client.gui.overlay

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.client.handler.InformationHandler
import net.minecraft.client.DeltaTracker
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.LayeredDraw
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn

@OnlyIn(Dist.CLIENT)
class InfoHudOverlay : LayeredDraw.Layer {
    override fun render(gui: GuiGraphics, tracker: DeltaTracker) {
        val minecraft = Minecraft.getInstance()
        if (minecraft.options.hideGui) return
        val infoList = InformationHandler.infoComponent()
        if (infoList.isEmpty()) return

        val font = minecraft.font
        val screenWidth = gui.guiWidth()
        val screenHeight = gui.guiHeight()
        val width = (infoList.maxOfOrNull { font.width(it) } ?: 0) + 1
        val height = font.lineHeight + 1
        val top = (screenHeight - height * infoList.size + 1) / 2
        for (i in 0..<infoList.size) {
            gui.drawString(font, infoList[i], screenWidth - width, top + i * height, 0xffffff, true)
        }
    }

    companion object {
        val OVERLAY_ID = Terrartifacts.modLoc("${Terrartifacts.ID}.info_hud_overlay")
    }
}