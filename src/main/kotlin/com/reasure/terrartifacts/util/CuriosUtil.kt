package com.reasure.terrartifacts.util

import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack
import top.theillusivec4.curios.api.CuriosApi

object CuriosUtil {
    fun getAccessories(entity: LivingEntity): ArrayList<ItemStack> {
        val items: ArrayList<ItemStack> = arrayListOf()
        CuriosApi.getCuriosInventory(entity).ifPresent { curiosHandler ->
            val itemHandler = curiosHandler.equippedCurios
            for (i in 0..itemHandler.slots) {
                val item = itemHandler.getStackInSlot(i)
                if (!item.isEmpty) items.add(item)
            }
        }
        return items
    }
}