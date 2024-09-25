package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.client.player.LocalPlayer
import net.minecraft.network.chat.Component
import net.minecraft.util.Mth

interface IMovementSpeedInfo {
    companion object {
        fun getInformation(player: LocalPlayer): Component {
            val speed = Mth.length(
                player.x - player.xOld,
                player.y - player.yOld,
                player.z - player.zOld
            ) * 20
            return Component.translatable(TranslationKeys.INFO_MOVEMENT_SPEED, speed.toInt())
                .withStyle(AbstractInformationalItem.ICON)
        }
    }
}