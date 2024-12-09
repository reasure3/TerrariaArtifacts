package com.reasure.terrartifacts.client.handler

import com.reasure.terrartifacts.item.accessories.informational.InfoType
import kotlinx.coroutines.*
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn

@OnlyIn(Dist.CLIENT)
object CoroutineHandler {
    private val scope = CoroutineScope(Dispatchers.Default)

    private val jobPool: MutableMap<String, Job?> = mutableMapOf(
        InfoType.ENEMY_COUNT.serializedName to null,
        InfoType.TREASURE.serializedName to null,
        InfoType.RARE_CREATURE.serializedName to null
    )

    fun launchWithPool(key: String, block: suspend CoroutineScope.() -> Unit) {
        if (jobPool[key] == null || jobPool[key]?.isCompleted == true) {
            jobPool[key] = scope.launch(
                CoroutineName("Coroutine - $key"),
                block = block
            )
        }
    }
}