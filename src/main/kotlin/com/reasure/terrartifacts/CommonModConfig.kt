package com.reasure.terrartifacts

import com.reasure.terrartifacts.util.BaseConfig
import net.neoforged.neoforge.common.ModConfigSpec


object CommonModConfig {
    val COMMON: Common
    val SPEC: ModConfigSpec

    init {
        with(ModConfigSpec.Builder().configure(::Common)) {
            COMMON = left
            SPEC = right
        }
    }
}

class Common(builder: ModConfigSpec.Builder) : BaseConfig(builder) {
    val radarDetectDistance: Double by builder
        .defineInRange("radarDetectDistance", 30.0, 0.1, 512.0)
}