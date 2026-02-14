package com.orecacti.resourcefulcactimod.datagen;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import com.orecacti.resourcefulcactimod.block.ModBlocks;
import com.orecacti.resourcefulcactimod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ResourcefulCactiMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
       tag(BlockTags.ENDERMAN_HOLDABLE)
               .add(ModBlocks.SHEARED_CACTUS.get());

       tag(ModTags.Blocks.SHEARABLE_BLOCKS)
               .add(Blocks.CACTUS);

       tag(ModTags.Blocks.TIER0_CACTUS)
               .add(Blocks.CACTUS)
               .add(ModBlocks.SHEARED_CACTUS.get());

       tag(ModTags.Blocks.TIER1_CACTUS)
               .add(ModBlocks.COAL_CACTUS.get())
               .add(ModBlocks.LAPIS_CACTUS.get())
               .add(ModBlocks.REDSTONE_CACTUS.get())
               .add(ModBlocks.AMETHYST_CACTUS.get())
               .add(ModBlocks.QUARTZ_CACTUS.get())
               .add(ModBlocks.GLOWSTONE_CACTUS.get());

       tag(ModTags.Blocks.TIER2_CACTUS)
               .add(ModBlocks.IRON_CACTUS.get())
               .add(ModBlocks.COPPER_CACTUS.get())
               .add(ModBlocks.GOLD_CACTUS.get())
               .add(ModBlocks.EMERALD_CACTUS.get())
               .add(ModBlocks.DIAMOND_CACTUS.get());

       tag(ModTags.Blocks.TIER3_CACTUS)
               .add(ModBlocks.NETHERITE_CACTUS.get());

       tag(ModTags.Blocks.SAND_GROWABLES)
               .add(ModBlocks.SHEARED_CACTUS.get())
               .add(ModBlocks.IRON_CACTUS.get())//
               .add(ModBlocks.COPPER_CACTUS.get())//
               .add(ModBlocks.AMETHYST_CACTUS.get())//
               .add(ModBlocks.COAL_CACTUS.get())//
               .add(ModBlocks.DIAMOND_CACTUS.get())//
               .add(ModBlocks.EMERALD_CACTUS.get())//
               .add(ModBlocks.GLOWSTONE_CACTUS.get())//
               .add(ModBlocks.GOLD_CACTUS.get())//
               .add(ModBlocks.LAPIS_CACTUS.get())//
               .add(ModBlocks.NETHERITE_CACTUS.get())//
               .add(ModBlocks.QUARTZ_CACTUS.get())//
               .add(ModBlocks.REDSTONE_CACTUS.get())
               .add(ModBlocks.CREEPER_CACTUS.get());

    }
}
