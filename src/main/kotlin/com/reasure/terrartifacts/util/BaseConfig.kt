package com.reasure.terrartifacts.util

import net.neoforged.neoforge.common.ModConfigSpec
import kotlin.reflect.KProperty

open class BaseConfig(builder: ModConfigSpec.Builder) {
    operator fun <T> ModConfigSpec.ConfigValue<T>.getValue(any: Any?, property: KProperty<*>): T {
        return get()
    }

    operator fun ModConfigSpec.IntValue.getValue(any: Any?, property: KProperty<*>): Int {
        return get()
    }

    operator fun <T : Enum<T>> ModConfigSpec.EnumValue<T>.getValue(any: Any?, property: KProperty<*>): T {
        return get()
    }

}