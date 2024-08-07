package com.reasure.terrartifacts.data

import com.reasure.terrartifacts.Terrartifacts
import net.neoforged.neoforge.attachment.AttachmentType
import net.neoforged.neoforge.registries.DeferredRegister
import net.neoforged.neoforge.registries.NeoForgeRegistries
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModDataAttachments {
    val ATTACHMENT_TYPES: DeferredRegister<AttachmentType<*>> =
        DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Terrartifacts.ID)

    val SHOW_INFO: AttachmentType<ShowInfoData> by ATTACHMENT_TYPES.register("show_info") { ->
        AttachmentType.builder(::ShowInfoData).serialize(ShowInfoData.CODEC).build()
    }
}