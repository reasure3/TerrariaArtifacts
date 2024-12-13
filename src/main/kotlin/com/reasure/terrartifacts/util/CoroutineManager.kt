package com.reasure.terrartifacts.util

import com.reasure.terrartifacts.Terrartifacts
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.io.Closeable

abstract class CoroutineManager<T>(name: String, loggerName: String = Terrartifacts.ID) : Closeable {
    private var scope: CoroutineScope? = null
    private val taskChannel = Channel<T>(Channel.CONFLATED)
    private val name = "CoroutineManager[$name]"
    private val logger: Logger = LogManager.getLogger(loggerName)

    fun start() {
        if (scope != null) {
            logger.warn("$name already started")
            return
        }

        logger.info("Starting $name")

        scope = CoroutineScope(
            SupervisorJob() +
                    Dispatchers.Default +
                    CoroutineName(name)
        ).also { coroutineScope ->
            coroutineScope.launch {
                logger.info("Coroutine for $name started")
                for (data in taskChannel) {
                    try {
                        if (!isActive) break
                        runner(data)
                    } catch (e: CancellationException) {
                        logger.info("Coroutine for $name cancelled")
                        break
                    } catch (e: Exception) {
                        logger.error("Coroutine for $name error: $e", e)
                    }
                }
            }
        }
    }

    private fun stop() {
        logger.info("Stopping $name")
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