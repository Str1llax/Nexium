package com.str1llax.nexium.util;

import com.str1llax.nexium.Nexium;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        //public static final TagKey<Block> NAME = tag("name");
        public static final TagKey<Block> NEEDS_AMETHYST_TOOL = tag("needs_amethyst_tool");
        public static final TagKey<Block> NEXIUM_ORES = tag("nexium_ores");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> COOKED_MEAT = tag("cooked_meat");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, name));
        }
    }
}
