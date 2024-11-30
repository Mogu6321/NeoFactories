package com.mogu.neofactories.util;

import com.mogu.neofactories.NeoFactories;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class NeoFactories_Tag {
    public static class Items {
        public static final TagKey<Item> SOLICA_LOG = createTag("solica_log");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(NeoFactories.MODID, name));
        }
    }
    public static class Blocks {

        public static TagKey<Block> SOLICA_LOG = createTag("solica_log");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(NeoFactories.MODID, name));
        }
    }
}
