package com.reasure.terrartifacts.client

import com.reasure.terrartifacts.item.accessories.informational.IWatch
import com.reasure.terrartifacts.item.accessories.informational.WatchType
import com.reasure.terrartifacts.util.CuriosUtil
import net.minecraft.client.player.LocalPlayer
import net.minecraft.network.chat.Component
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn

@OnlyIn(Dist.CLIENT)
class InformationHandler {
    companion object {
        private var displayInfo: ClientOnlyDisplayInfoData = ClientOnlyDisplayInfoData(
            hasMinInfo = false,
            hasHalfHourInfo = false,
            hasHourInfo = false
        )

        private val infoComponent: MutableList<Component> = mutableListOf()

        fun updateInfo(player: LocalPlayer) {
            if ((player.level().dayTime % 10).toInt() == 0)
                checkInventory(player)
            infoComponent.clear()
            val level = player.level()
            if (displayInfo.hasTimeInfo()) {
                infoComponent.add(IWatch.getInformation(level, displayInfo.displayTimeType()))
            }
        }

        private fun checkInventory(player: LocalPlayer) {
            displayInfo.reset()
            val inventory = CuriosUtil.getAccessories(player)
            inventory.addAll(player.inventory.items)
            for (stack in inventory) {
                when (val item = stack.item) {
                    is IWatch -> when (item.watchType()) {
                        WatchType.MINUTE -> displayInfo.hasMinInfo = true
                        WatchType.HALF_HOUR -> displayInfo.hasHalfHourInfo = true
                        WatchType.HOUR -> displayInfo.hasHourInfo = true
                    }
                }
            }
        }

        fun infoComponent(): MutableList<Component> = this.infoComponent
    }


    data class ClientOnlyDisplayInfoData(
        var hasMinInfo: Boolean = false,
        var hasHalfHourInfo: Boolean = false,
        var hasHourInfo: Boolean = false
    ) {
        fun hasTimeInfo(): Boolean = this.hasMinInfo || this.hasHalfHourInfo || this.hasHourInfo
        fun displayTimeType(): WatchType =
            if (hasMinInfo) WatchType.MINUTE
            else if (hasHalfHourInfo) WatchType.HALF_HOUR
            else WatchType.HOUR

        fun reset() {
            hasMinInfo = false
            hasHalfHourInfo = false
            hasHourInfo = false
        }
    }
}