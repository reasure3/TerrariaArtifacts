package com.reasure.terrartifacts.client.handler

import com.reasure.terrartifacts.Terrartifacts
import com.reasure.terrartifacts.item.accessories.informational.InfoType
import com.reasure.terrartifacts.util.CoroutineManager
import net.minecraft.client.player.LocalPlayer

object CoroutineHandler {
    private var infoManager: CoroutineManager<LocalPlayer>? = null
    private var hasHugeInfoItem: Boolean = false

    fun updateHugeInfo(player: LocalPlayer) {
        val currentHasHugeInfo = InfoComponentHandler.canDisplay(InfoType.TREASURE) ||
                InfoComponentHandler.canDisplay(InfoType.RARE_CREATURE) ||
                InfoComponentHandler.canDisplay(InfoType.ENEMY_COUNT)
        // When an item just arrived in your inventory
        if (currentHasHugeInfo && !hasHugeInfoItem) {
            startHugeInfo()
        }

        // When an item just disappeared from your inventory
        if (!currentHasHugeInfo && hasHugeInfoItem) {
            stopHugeInfo()
        }

        if (hasHugeInfoItem) {
            infoManager?.onTick(player)
        }
    }

    private fun startHugeInfo() {
        hasHugeInfoItem = true
        infoManager = object : CoroutineManager<LocalPlayer>("HugeInfo", loggerName = Terrartifacts.ID + "_client") {
            override suspend fun runner(data: LocalPlayer) {
                if (InfoComponentHandler.canDisplay(InfoType.TREASURE)) {
                    InfoComponentHandler.updateTreasureComponent(data.level(), data.onPos)
                }
                if (InfoComponentHandler.canDisplay(InfoType.RARE_CREATURE)) {
                    InfoComponentHandler.updateRareCreatureComponent(data, data.onPos)
                }
                if (InfoComponentHandler.canDisplay(InfoType.ENEMY_COUNT)) {
                    InfoComponentHandler.updateEnemyCountComponent(data)
                }
            }
        }.also { it.start() }
    }

    fun stopHugeInfo() {
        hasHugeInfoItem = false
        infoManager?.close()
        infoManager = null
    }
}