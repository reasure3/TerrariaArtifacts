package com.reasure.terrartifacts.data.attachment

import com.mojang.serialization.Codec
import com.reasure.terrartifacts.Terrartifacts
import net.minecraft.core.UUIDUtil
import net.neoforged.neoforge.attachment.AttachmentType
import net.neoforged.neoforge.registries.DeferredRegister
import net.neoforged.neoforge.registries.NeoForgeRegistries
import thedarkcolour.kotlinforforge.neoforge.forge.getValue
import java.util.UUID

object ModDataAttachments {
    val ATTACHMENT_TYPES: DeferredRegister<AttachmentType<*>> =
        DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Terrartifacts.ID)

    val SHOW_INFO: AttachmentType<ShowInfoData> by ATTACHMENT_TYPES.register("show_info") { ->
        AttachmentType.builder(ShowInfoData.Companion::create).serialize(ShowInfoData.CODEC).build()
    }

    val PLAYER_KILL_COUNT: AttachmentType<Map<UUID, Int>>
            by ATTACHMENT_TYPES.register("player_kill_count") { ->
                AttachmentType.builder { -> mapOf<UUID, Int>() }
                    .serialize(Codec.unboundedMap(UUIDUtil.CODEC, Codec.INT))
                    .build()
            }
}