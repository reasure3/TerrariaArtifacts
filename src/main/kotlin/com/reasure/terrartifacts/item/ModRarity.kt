package com.reasure.terrartifacts.item

import com.reasure.terrartifacts.Terrartifacts
import net.minecraft.network.chat.Style
import net.minecraft.world.item.Rarity
import net.neoforged.fml.common.asm.enumextension.EnumProxy
import java.util.function.UnaryOperator

object ModRarity {
    /**
     * The lowest tier.
     * Only "junk" fish items have this as a base rarity: Tin Can, Old Shoe, and Seaweed.
     * This tier mainly accommodates White or Blue-tier equipment with poor modifiers, such as a Shameful Iron Broadsword.
     */
    @JvmField
    val GRAY: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, -1, "${Terrartifacts.ID}:gray",
        UnaryOperator { style: Style -> style.withColor(0x828282) }
    )

    /**
     * Items without a rarity value specified in Terraria's game code default to this tier.
     * It is by far the rarity containing the most items, many of which could be considered the most common items in the game.
     * Coins, Hearts and Mana Stars are in this tier.
     * It includes most furniture; building materials (blocks and walls); early tools, weapons, and armor (made from wood or low-tier ores);
     * common crafting materials like Gel and herbs; and most of the items that are sold by early NPCs.
     * Items from this tier will be destroyed in lava, with a few exceptions.
     */
    @JvmField
    val WHITE: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 0, "${Terrartifacts.ID}:white",
        UnaryOperator { style: Style -> style.withColor(0xffffff) }
    )

    /**
     * Some Weapons and armor crafted from early ores, along with early dropped/looted items like the Shackle and Lucky Horseshoe.
     * Also includes banners, trophies, masks, fish, and pre-Hardmode dyes.
     * Items in this tier and above will not be destroyed in lava.
     */
    @JvmField
    val BLUE: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 1, "${Terrartifacts.ID}:blue",
        UnaryOperator { style: Style -> style.withColor(0x9696ff) }
    )

    /**
     * Midway pre-Hardmode items.
     * These are mostly looted, dropped, or purchased (non-craftable) items,
     * with the exception of Necro armor, Sandgun, Spinal Tap, Sunglasses, Obsidian Skull,
     * Star Cannon, Diamond Staff, and Tinkerer's Workshop combinations.
     */
    @JvmField
    val GREEN: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 2, "${Terrartifacts.ID}:green",
        UnaryOperator { style: Style -> style.withColor(0x96ff96) }
    )

    /**
     * Late-stage pre-Hardmode items: Weapons and armor made of Hellstone, Jungle and Underground Jungle items, Underworld items.
     * Several Hardmode ores, crafting materials, and consumables (Greater Healing Potion and some ammunition items) also fall into this category.
     */
    @JvmField
    val ORANGE: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 3, "${Terrartifacts.ID}:orange",
        UnaryOperator { style: Style -> style.withColor(0xffc896) }
    )

    /**
     * Early Hardmode items, including those crafted from the six Hardmode ores spawned from destroying Altars,and item drops from early and/or common Hardmode enemies.
     * Also includes flasks, and some items that are rare, but still obtainable very early on, such as the Golden Bug Net and Slime Staff.
     * Also includes some late pre-Hardmode items such as Mana Flower, and most of the items crafted with the Shiny Red Balloon.
     */
    @JvmField
    val LIGHT_RED: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 4, "${Terrartifacts.ID}:light_red",
        UnaryOperator { style: Style -> style.withColor(0xff9696) }
    )

    /**
     * Mid-Hardmode (pre-Plantera) items, including those acquired after defeating mechanical bosses, e.g. Flamethrower, Optic Staff, and Hallowed armor.
     * Also includes the more expensive Hardmode NPC purchases like the Clentaminator, and the rarer Hardmode drops,
     * including the special mid-tier wing ingredients (Tattered Bee Wing, Fire Feather, etc).
     * Also includes certain pre-Hardmode vanity items such as the Winter Cape.
     */
    @JvmField
    val PINK: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 5, "${Terrartifacts.ID}:pink",
        UnaryOperator { style: Style -> style.withColor(0x96ff96) }
    )

    /**
     * A smaller tier consisting of the rarest pre-Plantera items, mostly purchased or dropped, like the Death Sickle and Coin Gun.
     * Also some higher-tier Tinkerer's Workshop combinations, like the Ankh Charm, and the Ammo Box (obtainable pre-Hardmode).
     */
    @JvmField
    val LIGHT_PURPLE: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 6, "${Terrartifacts.ID}:light_purple",
        UnaryOperator { style: Style -> style.withColor(0xd2a0ff) }
    )

    /**
     * Items acquired around Plantera and Golem, and the Hardmode Underground Jungle.
     * Chlorophyte tools and weapons, Ankh Shield, Temple Key, some Frost Moon drops, and the Candy Cane Hook.
     * Also some powerful yet pre-Hardmode Tinkerer's Workshop combinations, like the Cell Phone, Frostspark Boots, Lava Waders, and Terraspark Boots.
     */
    @JvmField
    val LIME: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 7, "${Terrartifacts.ID}:lime",
        UnaryOperator { style: Style -> style.withColor(0x96ff0a) }
    )

    /**
     * Items acquired or crafted from loot obtained in the post-Plantera Dungeon: Spectre/Ectoplasm items, Biome Chest items like Vampire Knives;
     * Certain Mimic drops with high modifiers such as the Unreal Daedalus Stormbow; Shroomite items;
     * Drops from the late-game events: Martian Madness, Pumpkin Moon, Frost Moon, Betsy; and Duke Fishron drops.
     * Also Beetle armor, Terra Blade, Portal Gun, and all mounts (except for the Minecart).
     */
    @JvmField
    val YELLOW: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 8, "${Terrartifacts.ID}:yellow",
        UnaryOperator { style: Style -> style.withColor(0xffff0a) }
    )

    /**
     * This smaller tier contains early items acquired from the Lunar Events (primarily Lunar Fragments, Monoliths and some Moon Lord drops);
     * developer items, which can be obtained rarely from Treasure Bags in Expert Mode; and streamer items.
     * For Old-gen console, Windows Phone, and Nintendo 3DS, only reforged weapons and accessories with a base rarity of Lime or Yellow can have this modifier,
     * as Cyan is the highest rarity in those versions.
     */
    @JvmField
    val CYAN: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 9, "${Terrartifacts.ID}:cyan",
        UnaryOperator { style: Style -> style.withColor(0x05c8ff) }
    )

    /**
     * Items crafted at the Ancient Manipulator from Lunar Fragments and/or Luminite.
     * Also some direct Moon Lord drops, Yellow items with high-level modifiers, and the Ancient Manipulator crafting station itself.
     */
    @JvmField
    val RED: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 10, "${Terrartifacts.ID}:red",
        UnaryOperator { style: Style -> style.withColor(0xff2864) }
    )

    /**
     * This tier consists of Cyan and Red items that have high-level modifiers.
     * No items currently have this as a base rarity.
     * On Old Chinese and tModLoader Legacy, the Arkhalis is the only item with a base rarity of Purple,
     * even though it is obtainable before Hardmode.
     */
    @JvmField
    val PURPLE: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, 11, "${Terrartifacts.ID}:purple",
        UnaryOperator { style: Style -> style.withColor(0x8428ff) }
    )

    /**
     * This special tier contains only "quest items" to be turned over to quest-giving NPCs (currently the Dye Trader and Angler) for rewards.
     * Quest items have no other use, though the Strange Plants can be sold for 20 Silver Coin each, and can be used as decoration.
     */
    @JvmField
    val QUEST: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, -11, "${Terrartifacts.ID}:quest",
        UnaryOperator { style: Style -> style.withColor(0xffaf00) }
    )

    /**
     * This special tier contains Expert mode-exclusive items obtained by opening Treasure Bags
     * dropped by Expert Mode and Master Mode bosses, as well as the Treasure Bags themselves.
     * All Expert-exclusive items from Treasure Bags have this rarity, with the exception of 0x33's Aviators and developer items.
     *
     * In the game code, these items contain other tier numbers, despite displaying the animated Rainbow rarity color in-game.
     */
    @JvmField
    val EXPERT: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, -12, "${Terrartifacts.ID}:expert",
        UnaryOperator { style: Style ->
            style.withColor(0xb227fd).withItalic(true).withBold(true)
        }
    )

    /**
     * This special tier contains Master Mode-exclusive items dropped by bosses in Master Mode.
     */
    @JvmField
    val MASTER: EnumProxy<Rarity> = EnumProxy(
        Rarity::class.java, -13, "${Terrartifacts.ID}:master",
        UnaryOperator { style: Style ->
            style.withColor(0xb227fd).withItalic(true).withBold(true).withUnderlined(true)
        }
    )
}