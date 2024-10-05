package com.reasure.terrartifacts.datagen.client

import com.reasure.terrartifacts.Terrartifacts
import net.minecraft.data.PackOutput
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.neoforged.neoforge.common.data.LanguageProvider

abstract class ModBaseLangProvider(output: PackOutput, locale: String) :
    LanguageProvider(output, Terrartifacts.ID, locale) {

    abstract fun addItems()
    abstract fun addBlocks()
    abstract fun addTooltips()
    abstract fun addGui()
    abstract fun addConfigs()
    abstract fun addTags()

    override fun addTranslations() {
        addItems()
        addBlocks()
        addTooltips()
        addGui()
        addConfigs()
        addTags()
    }

    protected fun addCuriosSlot(slot: String, name: String) = add("curios.identifier.$slot", name)

    protected fun addConfigDesc(config: String, name: String) = add("${Terrartifacts.ID}.configuration.$config", name)

    protected fun addTag(tag: TagKey<Item>, name: String) {
        val loc = tag.location
        add("tag.item.${loc.namespace}.${loc.path.replace('/', '.')}", name)
    }
}