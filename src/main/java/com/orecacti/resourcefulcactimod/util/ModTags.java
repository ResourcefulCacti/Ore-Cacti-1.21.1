package com.orecacti.resourcefulcactimod.util;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> SHEARABLE_BLOCKS = createTag("shearable_blocks");
        public static final TagKey<Block> TIER0_CACTUS = createTag("tier0_cactus");
        public static final TagKey<Block> TIER1_CACTUS = createTag("tier1_cactus");
        public static final TagKey<Block> TIER2_CACTUS = createTag("tier2_cactus");
        public static final TagKey<Block> TIER3_CACTUS = createTag("tier3_cactus");

        public static final TagKey<Block> SAND_GROWABLES = createCompatibleTag("sand_growables");
        public static final TagKey<Block> SOUL_SAND_GROWABLES = createCompatibleTag("soul_sand_growables");

        public static TagKey<Block> createCompatibleTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c",name));
        }

        public static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ResourcefulCactiMod.MOD_ID, name));
        }
    }


    public static class Items {
        //public static final TagKey<Item> TRANS_ITEMS = createTag("trans_items");
        public static final TagKey<Item> FERTILIZERS = createCompatibleTag("fertilizers");
        public static final TagKey<Item> CACTUS_CROP = createCompatibleTag("crops/cactus");
        public static final TagKey<Item> ANIMAL_FOODS = createCompatibleTag("animal_foods");

        public static TagKey<Item> createCompatibleTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }

        public static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ResourcefulCactiMod.MOD_ID, name));
        }
    }
}
