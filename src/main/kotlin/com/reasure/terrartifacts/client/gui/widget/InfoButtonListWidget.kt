package com.reasure.terrartifacts.client.gui.widget

import com.reasure.terrartifacts.client.ClientModConfig
import com.reasure.terrartifacts.client.data.ClientHasInfoItemData
import com.reasure.terrartifacts.item.accessories.informational.InfoType
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.components.AbstractContainerWidget
import net.minecraft.client.gui.components.events.GuiEventListener
import net.minecraft.client.gui.narration.NarratedElementType
import net.minecraft.client.gui.narration.NarrationElementOutput
import net.minecraft.network.chat.Component

class InfoButtonListWidget(guiX: Int, guiY: Int, private val layout: LayoutPos, isCreative: Boolean) :
    AbstractContainerWidget(
        guiX + layout.offsetX(isCreative), guiY + layout.offsetY(isCreative), layout.width, layout.height,
        Component.literal("info toggle buttons")
    ) {
    private val buttons = InfoType.entries.map { InfoButton(0, 0, it) }

    override fun renderWidget(
        gui: GuiGraphics, mouseX: Int, mouseY: Int, partialTick: Float
    ) {
        var offsetX = 0
        var offsetY = 0

        buttons.forEach {
            it.visible = ClientHasInfoItemData[it.type]
            if (it.visible) {
                it.x = this.x + offsetX
                it.y = this.y + offsetY
                it.render(gui, mouseX, mouseY, partialTick)

                offsetX += layout.increaseX()
                offsetY += layout.increaseY()
            }
        }
    }

    override fun updateWidgetNarration(narration: NarrationElementOutput) {
        narration.add(NarratedElementType.TITLE, message)
    }

    override fun children(): List<GuiEventListener?> {
        return buttons.filter { it.visible }
    }

    enum class LayoutPos(
        private val offsetX: Int,
        private val offsetY: Int,
        val width: Int,
        val height: Int,
        private val isHorizontal: Boolean = false
    ) {
        LEFT(-11, 1, 11, 131),
        RIGHT(177, 1, 11, 131),
        TOP(1, -11, 131, 11, true),
        BOTTOM(1, 167, 131, 11, true);

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