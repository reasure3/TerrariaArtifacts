package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.item.accessories.AccessoryItem

abstract class AbstractInformationalItem(properties: Properties, val infoType: InformationType) :
    AccessoryItem(properties) {

    /**
     * @return 'true': when information must be received through the server
     *
     * 'false': when information received through only the client
     */
    abstract fun shouldUseInfoPacket(): Boolean
}