package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.EntityType

interface IKillCountInfo {
    companion object {
        fun getInformation(entityType: EntityType<*>, kill: Int): Component {
            return getInformation(entityType.description, kill)
        }

        fun getInformation(targetName: Component, kill: Int): Component {
            return Component.translatable(TranslationKeys.INFO_KILL_COUNT, targetName, kill)
                .withStyle(AbstractInformationalItem.ICON)
        }
    }
}