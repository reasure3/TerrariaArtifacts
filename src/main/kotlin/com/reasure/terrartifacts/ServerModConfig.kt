package com.reasure.terrartifacts

import com.reasure.terrartifacts.util.BaseConfig
import net.neoforged.neoforge.common.ModConfigSpec


object ServerModConfig {
    val SERVER: Server
    val SPEC: ModConfigSpec

    init {
        with(ModConfigSpec.Builder().configure(::Server)) {
            SERVER = left
            SPEC = right
        }
    }
}

class Server(builder: ModConfigSpec.Builder) : BaseConfig(builder) {
    val radarDetectDistance: Double by builder
        .defineInRange("radarDetectDistance", 30.0, 0.1, 512.0)
}