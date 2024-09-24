package com.reasure.terrartifacts.item.accessories.informational

import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.ChatFormatting
import net.minecraft.client.player.LocalPlayer
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.monster.Enemy
import net.minecraft.world.phys.AABB

interface IEnemyCountInfo {
    companion object {
        fun getInformation(player: LocalPlayer): Component {
            val pos = player.position()
            val count = player.level().getEntities(
                player,
                AABB(
                    pos.x - 30.0, pos.y - 30.0, pos.z - 30.0,
                    pos.x + 30.0, pos.y + 31.0, pos.z + 30.0
                )
            ) { entity ->
                entity is Enemy
            }.size
            if (count == 0) return Component.translatable(TranslationKeys.INFO_NO_ENEMY_COUNT)
                .withStyle(AbstractInformationalItem.ICON.withColor(ChatFormatting.GRAY))
            return Component.translatable(TranslationKeys.INFO_ENEMY_COUNT, count)
                .withStyle(AbstractInformationalItem.ICON)
        }
    }
}