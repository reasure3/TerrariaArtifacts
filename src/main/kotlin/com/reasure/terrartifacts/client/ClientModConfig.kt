package com.reasure.terrartifacts.client

import com.reasure.terrartifacts.client.gui.button.InfoButton
import net.neoforged.neoforge.common.ModConfigSpec
import kotlin.reflect.KProperty

operator fun <T> ModConfigSpec.ConfigValue<T>.getValue(any: Any?, property: KProperty<*>): T {
    return get()
}

operator fun ModConfigSpec.IntValue.getValue(any: Any?, property: KProperty<*>): Int {
    return get()
}

operator fun <T : Enum<T>> ModConfigSpec.EnumValue<T>.getValue(any: Any?, property: KProperty<*>): T {
    return get()
}

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

class Client(builder: ModConfigSpec.Builder) {
    val infoButtonLayoutPos: InfoButton.LayoutPos by builder
        .defineEnum("infoButtonLayoutPos", InfoButton.LayoutPos.LEFT)

    val infoButtonOffsetX: Int by builder
        .defineInRange("infoButtonOffsetX", 0, -1000, 1000)

    val infoButtonOffsetY: Int by builder
        .defineInRange("infoButtonOffsetY", 0, -1000, 1000)
}