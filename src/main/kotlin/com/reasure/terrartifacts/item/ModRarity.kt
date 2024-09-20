package com.reasure.terrartifacts.item

import com.reasure.terrartifacts.Terrartifacts
import net.minecraft.network.chat.Style
import net.minecraft.world.item.Rarity
import net.neoforged.fml.common.asm.enumextension.EnumProxy
import java.util.function.UnaryOperator

object ModRarity {
    @JvmField
    val GRAY_PROXY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, -1, "${Terrartifacts.ID}:gray",
        UnaryOperator { style: Style -> style.withColor(0x828282) }
    )
    val GRAY: Rarity
        get() = GRAY_PROXY.value

    @JvmField
    val WHITE_PROXY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 0, "${Terrartifacts.ID}:white",
        UnaryOperator { style: Style -> style.withColor(0xffffff) }
    )
    val WHITE: Rarity
        get() = WHITE_PROXY.value

    @JvmField
    val BLUE_PROXY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 1, "${Terrartifacts.ID}:blue",
        UnaryOperator { style: Style -> style.withColor(0x9696ff) }
    )
    val BLUE: Rarity
        get() = BLUE_PROXY.value

    @JvmField
    val GREEN_PROXY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 2, "${Terrartifacts.ID}:green",
        UnaryOperator { style: Style -> style.withColor(0x96ff96) }
    )
    val GREEN: Rarity
        get() = GREEN_PROXY.value

    @JvmField
    val ORANGE_PROXY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 3, "${Terrartifacts.ID}:orange",
        UnaryOperator { style: Style -> style.withColor(0xffc896) }
    )
    val ORANGE: Rarity
        get() = ORANGE_PROXY.value

    @JvmField
    val LIGHT_RED_PROXY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 4, "${Terrartifacts.ID}:light_red",
        UnaryOperator { style: Style -> style.withColor(0xff9696) }
    )
    val LIGHT_RED: Rarity
        get() = LIGHT_RED_PROXY.value

    @JvmField
    val PINK_PROXY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 5, "${Terrartifacts.ID}:pink",
        UnaryOperator { style: Style -> style.withColor(0x96ff96) }
    )
    val PINK: Rarity
        get() = PINK_PROXY.value

    @JvmField
    val LIGHT_PURPLE_PROXY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 6, "${Terrartifacts.ID}:light_purple",
        UnaryOperator { style: Style -> style.withColor(0xd2a0ff) }
    )
    val LIGHT_PURPLE: Rarity
        get() = LIGHT_PURPLE_PROXY.value

    @JvmField
    val LIME_PROXY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 7, "${Terrartifacts.ID}:lime",
        UnaryOperator { style: Style -> style.withColor(0x96ff0a) }
    )
    val LIME: Rarity
        get() = LIME_PROXY.value

    @JvmField
    val YELLOW_PROXY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 8, "${Terrartifacts.ID}:yellow",
        UnaryOperator { style: Style -> style.withColor(0xffff0a) }
    )
    val YELLOW: Rarity
        get() = YELLOW_PROXY.value

    @JvmField
    val CYAN_PROXY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 9, "${Terrartifacts.ID}:cyan",
        UnaryOperator { style: Style -> style.withColor(0x05c8ff) }
    )
    val CYAN: Rarity
        get() = CYAN_PROXY.value

    @JvmField
    val RED_PROXY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 10, "${Terrartifacts.ID}:red",
        UnaryOperator { style: Style -> style.withColor(0xff2864) }
    )
    val RED: Rarity
        get() = RED_PROXY.value

    @JvmField
    val PURPLE_PROXY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 11, "${Terrartifacts.ID}:purple",
        UnaryOperator { style: Style -> style.withColor(0x8428ff) }
    )
    val PURPLE: Rarity
        get() = PURPLE_PROXY.value

    @JvmField
    val QUEST_PROXY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, -11, "${Terrartifacts.ID}:quest",
        UnaryOperator { style: Style -> style.withColor(0xffaf00) }
    )
    val QUEST: Rarity
        get() = QUEST_PROXY.value

    @JvmField
    val EXPERT_PROXY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, -12, "${Terrartifacts.ID}:expert",
        UnaryOperator { style: Style ->
            style.withColor(0xb227fd).withItalic(true).withBold(true)
        }
    )
    val EXPERT: Rarity
        get() = EXPERT_PROXY.value

    @JvmField
    val MASTER_PROXY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, -13, "${Terrartifacts.ID}:master",
        UnaryOperator { style: Style ->
            style.withColor(0xb227fd).withItalic(true).withBold(true).withUnderlined(true)
        }
    )
    val MASTER: Rarity
        get() = MASTER_PROXY.value
}