package com.reasure.terrartifacts.client

import com.reasure.terrartifacts.client.gui.widget.InfoButtonListWidget
import com.reasure.terrartifacts.util.BaseConfig
import net.neoforged.neoforge.common.ModConfigSpec

object ClientModConfig {
    val CLIENT: Client
    val SPEC: ModConfigSpec

    init {
        with(ModConfigSpec.Builder().configure(::Client)) {
            CLIENT = left
            SPEC = right
        }
    }
}

class Client(builder: ModConfigSpec.Builder) : BaseConfig(builder) {
    val infoButtonLayoutPos: InfoButtonListWidget.LayoutPos by builder
        .defineEnum("infoButtonLayoutPos", InfoButtonListWidget.LayoutPos.LEFT)

    val infoButtonOffsetX: Int by builder
        .defineInRange("infoButtonOffsetX", 0, -1000, 1000)

    val infoButtonOffsetY: Int by builder
        .defineInRange("infoButtonOffsetY", 0, -1000, 1000)
}