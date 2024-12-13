package com.reasure.terrartifacts.client.coroutine

import com.reasure.terrartifacts.client.TerrartifactsClient
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn
import java.io.Closeable

@OnlyIn(Dist.CLIENT)
abstract class CoroutineManager<T>(private val name: String) : Closeable {
    private var scope: CoroutineScope? = null
    private val taskChannel = Channel<T>(Channel.CONFLATED)

    fun start() {
        if (scope != null) return

        scope = CoroutineScope(
            SupervisorJob() +
                    Dispatchers.Default +
                    CoroutineName("CoroutineManager[$name]")
        ).also { coroutineScope ->
            coroutineScope.launch {
                for (data in taskChannel) {
                    try {
                        if (!isActive) break
                        runner(data)
                    } catch (e: CancellationException) {
                        TerrartifactsClient.LOGGER.info("CoroutineManager[$name] cancelled")
                        break
                    } catch (e: Exception) {
                        TerrartifactsClient.LOGGER.error("CoroutineManager[$name] error: $e", e)
                    }
                }
            }
        }
    }

    private fun stop() {
        scope?.cancel()
        scope = null
    }

    fun onTick(data: T) {
        taskChannel.trySend(data)
    }

    abstract suspend fun runner(data: T)

    override fun close() {
        stop()
        taskChannel.close()
    }
}