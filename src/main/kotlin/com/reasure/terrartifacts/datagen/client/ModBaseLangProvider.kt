package com.reasure.terrartifacts.datagen.client

import com.reasure.terrartifacts.Terrartifacts
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.LanguageProvider

abstract class ModBaseLangProvider(output: PackOutput, locale: String) :
    LanguageProvider(output, Terrartifacts.ID, locale) {

    abstract fun addItems()
    abstract fun addBlocks()
    abstract fun addTooltip()
    abstract fun addGui()

    override fun addTranslations() {
        addItems()
        addBlocks()
        addTooltip()
        addGui()
    }

    protected fun addCuriosSlot(slot: String, name: String) = add("curios.identifier.$slot", name)
}