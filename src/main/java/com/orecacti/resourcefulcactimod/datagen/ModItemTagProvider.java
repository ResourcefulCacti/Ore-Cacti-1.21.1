package com.orecacti.resourcefulcactimod.datagen;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import com.orecacti.resourcefulcactimod.common.block.ModBlocks;
import com.orecacti.resourcefulcactimod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ResourcefulCactiMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        var inputAnimalFoodsTag = tag(ModTags.Items.ANIMAL_FOODS);
        var inputCamelFoodTag = tag(ItemTags.CAMEL_FOOD);
        var inputCactusCropTag = tag(ModTags.Items.CACTUS_CROP);

        ModBlocks.BLOCKS.getEntries().forEach(blockMeow ->
                inputAnimalFoodsTag.add(blockMeow.get().asItem()));

        ModBlocks.BLOCKS.getEntries().forEach(blockMeow ->
                inputCamelFoodTag.add(blockMeow.get().asItem()));

        ModBlocks.BLOCKS.getEntries().forEach(blockMeow ->
                inputCactusCropTag.add(blockMeow.get().asItem()));

        tag(ItemTags.IRON_ORES)
                .add(ModBlocks.IRON_CACTUS.asItem());
        tag(ItemTags.COPPER_ORES)
                .add(ModBlocks.COPPER_CACTUS.asItem());
        tag(ItemTags.COAL_ORES)
                .add(ModBlocks.COAL_CACTUS.asItem());
        tag(ItemTags.GOLD_ORES)
                .add(ModBlocks.GOLD_CACTUS.asItem());
        tag(ItemTags.DIAMOND_ORES)
                .add(ModBlocks.DIAMOND_CACTUS.asItem());
        tag(ItemTags.EMERALD_ORES)
                .add(ModBlocks.EMERALD_CACTUS.asItem());
        tag(ItemTags.LAPIS_ORES)
                .add(ModBlocks.LAPIS_CACTUS.asItem());
        tag(ItemTags.REDSTONE_ORES)
                .add(ModBlocks.REDSTONE_CACTUS.asItem());
    }
}
