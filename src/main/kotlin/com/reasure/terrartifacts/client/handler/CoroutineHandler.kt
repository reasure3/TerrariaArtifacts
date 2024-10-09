package com.reasure.terrartifacts.client.handler

import kotlinx.coroutines.*
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn

@OnlyIn(Dist.CLIENT)
object CoroutineHandler {
    private val scope = CoroutineScope(Dispatchers.Default)

    private var infoJob: Job? = null

    fun launchFindInfo(block: suspend CoroutineScope.() -> Unit) {
        if (infoJob == null || infoJob?.isCompleted == true) {
            infoJob = scope.launch(
                context = CoroutineName("Find Huge Info"),
                block = block
            )
        }
    }
}