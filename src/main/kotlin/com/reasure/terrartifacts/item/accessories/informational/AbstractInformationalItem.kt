package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.item.accessories.AccessoryItem
import net.minecraft.network.chat.Style

abstract class AbstractInformationalItem(properties: Properties) :
    AccessoryItem(properties) {

    /**
     * @return 'true': when information must be received through the server
     *
     * 'false': when information received through only the client
     */
    abstract fun shouldUseInfoPacket(): Boolean

    companion object {
        val ICON = Style.EMPTY.withFont(Terrartifacts.modLoc("terraria"))
    }
}