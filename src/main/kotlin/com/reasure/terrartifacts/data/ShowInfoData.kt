package com.reasure.terrartifacts.data

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import com.reasure.terrartifacts.item.accessories.informational.InfoType
import io.netty.buffer.ByteBuf
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec

/**
 * 플레이어가 정보 악세서리 소지 시, 해당 정보를 보여줄지 여부를 저장
 *
 * 인벤토리 화면에서 플레이어가 직접 수정 가능
 *
 * Target: Player
 * @see ModDataAttachments
 */
data class ShowInfoData(
    val showTime: Boolean,
    val showWeather: Boolean,
    val showFishingPower: Boolean,
    val showPosition: Boolean,
    val showDepth: Boolean,
    val showEnemyCount: Boolean,
    val showKillCount: Boolean,
    val showMoonPhase: Boolean,
    val showMovementSpeed: Boolean,
    val showTreasure: Boolean,
    val showRareCreature: Boolean,
    val showDps: Boolean
) {
    operator fun get(type: InfoType) = when (type) {
        InfoType.TIME -> showTime
        InfoType.WEATHER -> showWeather
        InfoType.FISHING_POWER -> showFishingPower
        InfoType.POSITION -> showPosition
        InfoType.DEPTH -> showDepth
        InfoType.ENEMY_COUNT -> showEnemyCount
        InfoType.KILL_COUNT -> showKillCount
        InfoType.MOON_PHASE -> showMoonPhase
        InfoType.MOVEMENT_SPEED -> showMovementSpeed
        InfoType.TREASURE -> showTreasure
        InfoType.RARE_CREATURE -> showRareCreature
        InfoType.DPS -> showDps
    }

    companion object {
        fun create(): ShowInfoData = ShowInfoData(
            showTime = true,
            showWeather = true,
            showFishingPower = true,
            showPosition = true,
            showDepth = true,
            showEnemyCount = true,
            showKillCount = true,
            showMoonPhase = true,
            showMovementSpeed = true,
            showTreasure = true,
            showRareCreature = true,
            showDps = true
        )

        val CODEC: Codec<ShowInfoData> = RecordCodecBuilder.create { instance ->
            instance.group(
                Codec.BOOL.fieldOf("showTime").forGetter(ShowInfoData::showTime),
                Codec.BOOL.fieldOf("showWeather").forGetter(ShowInfoData::showWeather),
                Codec.BOOL.fieldOf("showFishingPower").forGetter(ShowInfoData::showFishingPower),
                Codec.BOOL.fieldOf("showPosition").forGetter(ShowInfoData::showPosition),
                Codec.BOOL.fieldOf("showDepth").forGetter(ShowInfoData::showDepth),
                Codec.BOOL.fieldOf("showEnemyCount").forGetter(ShowInfoData::showEnemyCount),
                Codec.BOOL.fieldOf("showKillCount").forGetter(ShowInfoData::showKillCount),
                Codec.BOOL.fieldOf("showMoonPhase").forGetter(ShowInfoData::showMoonPhase),
                Codec.BOOL.fieldOf("showMovementSpeed").forGetter(ShowInfoData::showMovementSpeed),
                Codec.BOOL.fieldOf("showTreasure").forGetter(ShowInfoData::showTreasure),
                Codec.BOOL.fieldOf("showRareCreature").forGetter(ShowInfoData::showRareCreature),
                Codec.BOOL.fieldOf("showDps").forGetter(ShowInfoData::showDps)
            ).apply(instance, ::ShowInfoData)
        }

        val STREAM_CODEC: StreamCodec<ByteBuf, ShowInfoData> = object : StreamCodec<ByteBuf, ShowInfoData> {
            override fun decode(buf: ByteBuf) = ShowInfoData(
                ByteBufCodecs.BOOL.decode(buf), // showTime
                ByteBufCodecs.BOOL.decode(buf), // showWeather
                ByteBufCodecs.BOOL.decode(buf), // showFishingPower
                ByteBufCodecs.BOOL.decode(buf), // showPosition
                ByteBufCodecs.BOOL.decode(buf), // showDepth
                ByteBufCodecs.BOOL.decode(buf), // showEnemyCount
                ByteBufCodecs.BOOL.decode(buf), // showKillCount
                ByteBufCodecs.BOOL.decode(buf), // showMoonPhase
                ByteBufCodecs.BOOL.decode(buf), // showMovementSpeed
                ByteBufCodecs.BOOL.decode(buf), // showTreasure
                ByteBufCodecs.BOOL.decode(buf), // showRareCreature
                ByteBufCodecs.BOOL.decode(buf) // showDps
            )

            override fun encode(buf: ByteBuf, data: ShowInfoData) {
                ByteBufCodecs.BOOL.encode(buf, data.showTime)
                ByteBufCodecs.BOOL.encode(buf, data.showWeather)
                ByteBufCodecs.BOOL.encode(buf, data.showFishingPower)
                ByteBufCodecs.BOOL.encode(buf, data.showPosition)
                ByteBufCodecs.BOOL.encode(buf, data.showDepth)
                ByteBufCodecs.BOOL.encode(buf, data.showEnemyCount)
                ByteBufCodecs.BOOL.encode(buf, data.showKillCount)
                ByteBufCodecs.BOOL.encode(buf, data.showMoonPhase)
                ByteBufCodecs.BOOL.encode(buf, data.showMovementSpeed)
                ByteBufCodecs.BOOL.encode(buf, data.showTreasure)
                ByteBufCodecs.BOOL.encode(buf, data.showRareCreature)
                ByteBufCodecs.BOOL.encode(buf, data.showDps)
            }
        }
    }
}