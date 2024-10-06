package com.reasure.terrartifacts.client.data

import com.reasure.terrartifacts.ServerModConfig

object ClientDamageTracker {
    private val damageEntryList: MutableList<DamageEntry> = mutableListOf()
    var dps = 0.0f
        private set
    private var lastDamage = 0.0f

    fun addDamageEntry(gameTime: Long, damage: Float) {
        updateDamageEntry(gameTime)
        damageEntryList.add(DamageEntry(gameTime, damage))
        if (damageEntryList.size > ServerModConfig.SERVER.maxDpsDamageEntryCount) {
            damageEntryList.removeFirst()
        }
        lastDamage = damage
        dps = calculateDps()
    }

    fun updateDamageEntry(curGameTime: Long) {
        damageEntryList.removeAll { entry ->
            curGameTime - entry.gameTime > ServerModConfig.SERVER.dpsTrackingTick
                    || entry.gameTime > curGameTime // Prevent bug
        }
    }

    fun reset() {
        damageEntryList.clear()
        dps = 0.0f
        lastDamage = 0.0f
    }

    private fun calculateDps(): Float {
        if (damageEntryList.isEmpty()) return dps
        if (damageEntryList.size == 1) return lastDamage
        val totalDamage = damageEntryList.sumOf { it.damage.toDouble() }
        val damageTick = damageEntryList.last().gameTime - damageEntryList.first().gameTime
        val damageSecond = damageTick / 20.0
        if (damageSecond < 1) return totalDamage.toFloat()
        return (totalDamage / damageSecond).toFloat()
    }

    data class DamageEntry(val gameTime: Long, val damage: Float)
}