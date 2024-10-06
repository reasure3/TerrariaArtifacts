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

    val treasureDetectDistance: Double by builder
        .defineInRange("treasureDetectDistance", 30.0, 0.1, 512.0)

    val checkTreasureTickRate: Int by builder
        .defineInRange("checkTreasureTickRate", 20, 1, 1000)

    val rareCreatureDetectDistance: Double by builder
        .defineInRange("rareCreatureDetectDistance", 30.0, 0.1, 512.0)

    val dpsTrackingTick: Int by builder
        .defineInRange("dpsTrackingTick", 60, 1, Int.MAX_VALUE)

    val checkInventoryTickRate: Int by builder
        .defineInRange("checkInventoryTickRate", 10, 1, 1000)

    val maxDpsDamageEntryCount: Int by builder
        .defineInRange("maxDpsDamageEntryCount", 100, 1, Int.MAX_VALUE)
}