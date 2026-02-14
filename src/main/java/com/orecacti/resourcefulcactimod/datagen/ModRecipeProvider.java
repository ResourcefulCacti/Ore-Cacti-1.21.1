package com.orecacti.resourcefulcactimod.datagen;

import com.orecacti.resourcefulcactimod.block.ModBlocks;
import com.orecacti.resourcefulcactimod.item.ModItems;
import com.orecacti.resourcefulcactimod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        //Tier 1, no stabilizer
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COAL_CACTUS.get())
                .pattern("FSF")
                .pattern("SCS")
                .pattern("FSF")
                .define('S', ModItems.COAL_CACTUS_SPIKE.get())
                .define('C', ModBlocks.SHEARED_CACTUS.get())
                .define('F', ModTags.Items.FERTILIZERS)
                .unlockedBy("has_coal_spike", has(ModItems.COAL_CACTUS_SPIKE))
                .save(recipeOutput, "grodomirsresourcefulcactimod:coal_cactus_from_coal_spike");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LAPIS_CACTUS.get())
                .pattern("FSF")
                .pattern("SCS")
                .pattern("FSF")
                .define('S', ModItems.LAPIS_CACTUS_SPIKE.get())
                .define('C', ModBlocks.SHEARED_CACTUS.get())
                .define('F', ModTags.Items.FERTILIZERS)
                .unlockedBy("has_lapis_spike", has(ModItems.DIAMOND_CACTUS_SPIKE))
                .save(recipeOutput, "grodomirsresourcefulcactimod:lapis_cactus_from_lapis_spike");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.REDSTONE_CACTUS.get())
                .pattern("FSF")
                .pattern("SCS")
                .pattern("FSF")
                .define('S', ModItems.REDSTONE_CACTUS_SPIKE.get())
                .define('C', ModBlocks.SHEARED_CACTUS.get())
                .define('F', ModTags.Items.FERTILIZERS)
                .unlockedBy("has_redstone_spike", has(ModItems.REDSTONE_CACTUS_SPIKE))
                .save(recipeOutput, "grodomirsresourcefulcactimod:redstone_cactus_from_redstone_spike");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AMETHYST_CACTUS.get())
                .pattern("FSF")
                .pattern("SCS")
                .pattern("FSF")
                .define('S', ModItems.AMETHYST_CACTUS_SPIKE.get())
                .define('C', ModBlocks.SHEARED_CACTUS.get())
                .define('F', ModTags.Items.FERTILIZERS)
                .unlockedBy("has_amethyst_spike", has(ModItems.AMETHYST_CACTUS_SPIKE))
                .save(recipeOutput, "grodomirsresourcefulcactimod:amethyst_cactus_from_amethyst_spike");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.QUARTZ_CACTUS.get())
                .pattern("FSF")
                .pattern("SCS")
                .pattern("FSF")
                .define('S', ModItems.QUARTZ_CACTUS_SPIKE.get())
                .define('C', ModBlocks.SHEARED_CACTUS.get())
                .define('F', Items.NETHER_WART)
                .unlockedBy("has_quartz_spike", has(ModItems.QUARTZ_CACTUS_SPIKE))
                .save(recipeOutput, "grodomirsresourcefulcactimod:quartz_cactus_from_quartz_spike");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GLOWSTONE_CACTUS.get())
                .pattern("FSF")
                .pattern("SCS")
                .pattern("FSF")
                .define('S', ModItems.GLOWSTONE_CACTUS_SPIKE.get())
                .define('C', ModBlocks.SHEARED_CACTUS.get())
                .define('F', Items.NETHER_WART)
                .unlockedBy("has_glowstone_spike", has(ModItems.GLOWSTONE_CACTUS_SPIKE))
                .save(recipeOutput, "grodomirsresourcefulcactimod:glowstone_cactus_from_glowstone_spike");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OVERWORLD_ESSENCE.get())
                        .pattern("GGG")
                        .pattern("GGG")
                        .pattern("GGG")
                        .define('G', ModItems.WEAK_OVERWORLD_ESSENCE.get())
                        .unlockedBy("has_weak_overworld_essence", has(ModItems.WEAK_OVERWORLD_ESSENCE))
                        .save(recipeOutput, "grodomirsresourcefulcactimod:overworld_essence_from_weak_overworld_essence");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OVERWORLD_STABILIZER.get())
                .pattern("FEF")
                .pattern("ACA")
                .pattern("FSF")
                .define('E', Items.ECHO_SHARD)
                .define('A', Items.AMETHYST_SHARD)
                .define('S', Blocks.SCULK)
                .define('C', ModBlocks.SHEARED_CACTUS.get())
                .define('F', ModItems.OVERWORLD_ESSENCE)
                .unlockedBy("has_echo_shard", has(Items.ECHO_SHARD))
                .save(recipeOutput, "grodomirsresourcefulcactimod:overworld_stabilizer_from_echo_shard");

        //Tier 2, Overworld stabilizer
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IRON_CACTUS.get())
                .pattern("FSF")
                .pattern("SCS")
                .pattern("FSF")
                .define('S', ModItems.IRON_CACTUS_SPIKE.get())
                .define('C', ModItems.OVERWORLD_STABILIZER.get())
                .define('F', ModTags.Items.FERTILIZERS)
                .unlockedBy("has_iron_spike", has(ModItems.IRON_CACTUS_SPIKE))
                .save(recipeOutput, "grodomirsresourcefulcactimod:iron_cactus_from_iron_spike");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COPPER_CACTUS.get())
                .pattern("FSF")
                .pattern("SCS")
                .pattern("FSF")
                .define('S', ModItems.COPPER_CACTUS_SPIKE.get())
                .define('C', ModItems.OVERWORLD_STABILIZER.get())
                .define('F', ModTags.Items.FERTILIZERS)
                .unlockedBy("has_copper_spike", has(ModItems.COPPER_CACTUS_SPIKE))
                .save(recipeOutput, "grodomirsresourcefulcactimod:copper_cactus_from_copper_spike");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GOLD_CACTUS.get())
                .pattern("FSF")
                .pattern("SCS")
                .pattern("FSF")
                .define('S', ModItems.GOLD_CACTUS_SPIKE.get())
                .define('C', ModItems.OVERWORLD_STABILIZER.get())
                .define('F', ModTags.Items.FERTILIZERS)
                .unlockedBy("has_gold_spike", has(ModItems.GOLD_CACTUS_SPIKE))
                .save(recipeOutput, "grodomirsresourcefulcactimod:gold_cactus_from_gold_spike");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EMERALD_CACTUS.get())
                .pattern("FSF")
                .pattern("SCS")
                .pattern("FSF")
                .define('S', ModItems.EMERALD_CACTUS_SPIKE.get())
                .define('C', ModItems.OVERWORLD_STABILIZER.get())
                .define('F', ModTags.Items.FERTILIZERS)
                .unlockedBy("has_emerald_spike", has(ModItems.EMERALD_CACTUS_SPIKE))
                .save(recipeOutput, "grodomirsresourcefulcactimod:emerald_cactus_from_emerald_spike");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DIAMOND_CACTUS.get())
                .pattern("FSF")
                .pattern("SCS")
                .pattern("FSF")
                .define('S', ModItems.DIAMOND_CACTUS_SPIKE.get())
                .define('C', ModItems.OVERWORLD_STABILIZER.get())
                .define('F', ModItems.OVERWORLD_ESSENCE.get())
                .unlockedBy("has_diamond_spike", has(ModItems.DIAMOND_CACTUS_SPIKE))
                .save(recipeOutput, "grodomirsresourcefulcactimod:diamond_cactus_from_diamond_spike");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NETHER_ESSENCE.get())
                .pattern("GGG")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.WEAK_NETHER_ESSENCE.get())
                .unlockedBy("has_weak_nether_essence", has(ModItems.WEAK_NETHER_ESSENCE))
                .save(recipeOutput, "grodomirsresourcefulcactimod:nether_essence_from_weak_nether_essence");


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NETHER_STABILIZER.get())
                .pattern("WSW")
                .pattern("SCS")
                .pattern("WSW")
                .define('S', Items.NETHER_STAR)
                .define('C', ModBlocks.SHEARED_CACTUS.get())
                .define('W', ModItems.NETHER_ESSENCE.get())
                .unlockedBy("has_nether_star", has(Items.NETHER_STAR))
                .save(recipeOutput, "grodomirsresourcefulcactimod:nether_stabilizer_from_nether_shard");

        //Tier 3, Nether stabilizer
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NETHERITE_CACTUS.get())
                .pattern("FSF")
                .pattern("SCS")
                .pattern("FSF")
                .define('S', ModItems.NETHERITE_CACTUS_SPIKE.get())
                .define('C', ModItems.NETHER_STABILIZER.get())
                .define('F', Items.NETHER_WART)
                .unlockedBy("has_netherite_spike", has(ModItems.NETHERITE_CACTUS_SPIKE))
                .save(recipeOutput, "grodomirsresourcefulcactimod:netherite_cactus_from_netherite_spike");


        SimpleCookingRecipeBuilder.smelting(
                Ingredient.of(ModBlocks.SHEARED_CACTUS.get()),
                RecipeCategory.MISC,
                Items.GREEN_DYE,
                1f,
                200
        )
                .unlockedBy("has_sharead_cactus", has(ModBlocks.SHEARED_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:green_dye_from_smelting_sheared_cactus");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.IRON_CACTUS.get()),
                        RecipeCategory.MISC,
                        Items.IRON_INGOT,
                        0.7f,
                        200
                )
                .unlockedBy("has_iron_cactus", has(ModBlocks.IRON_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:iron_ingot_from_smelting_iron_cactus");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.COPPER_CACTUS.get()),
                        RecipeCategory.MISC,
                        Items.COPPER_INGOT,
                        0.7f,
                        200
                )
                .unlockedBy("has_copper_cactus", has(ModBlocks.COPPER_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:copper_ingot_from_smelting_copper_cactus");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.GOLD_CACTUS.get()),
                        RecipeCategory.MISC,
                        Items.GOLD_INGOT,
                        0.7f,
                        200
                )
                .unlockedBy("has_gold_cactus", has(ModBlocks.GOLD_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:gold_ingot_from_smelting_gold_cactus");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.DIAMOND_CACTUS.get()),
                        RecipeCategory.MISC,
                        Items.DIAMOND,
                        0.7f,
                        200
                )
                .unlockedBy("has_diamond_cactus", has(ModBlocks.COPPER_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:diamond_from_smelting_diamond_cactus");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.COAL_CACTUS.get()),
                        RecipeCategory.MISC,
                        Items.COAL,
                        0.1f,
                        200
                )
                .unlockedBy("has_coal_cactus", has(ModBlocks.COAL_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:coal_from_smelting_coal_cactus");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.LAPIS_CACTUS.get()),
                        RecipeCategory.MISC,
                        new ItemStack(Items.LAPIS_LAZULI, 4),
                        0.1f,
                        200
                )
                .unlockedBy("has_lapis_cactus", has(ModBlocks.LAPIS_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:lapis_from_smelting_lapis_cactus");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.REDSTONE_CACTUS.get()),
                        RecipeCategory.MISC,
                        new ItemStack(Items.REDSTONE, 4),
                        0.1f,
                        200
                )
                .unlockedBy("has_redstone_cactus", has(ModBlocks.REDSTONE_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:redstone_from_smelting_redstone_cactus");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.EMERALD_CACTUS.get()),
                        RecipeCategory.MISC,
                        Items.EMERALD,
                        0.1f,
                        200
                )
                .unlockedBy("has_emerald_cactus", has(ModBlocks.EMERALD_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:emerald_from_smelting_emerald_cactus");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.AMETHYST_CACTUS.get()),
                        RecipeCategory.MISC,
                        Items.AMETHYST_SHARD,
                        0.1f,
                        200
                )
                .unlockedBy("has_amethyst_cactus", has(ModBlocks.AMETHYST_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:amethyst_shard_from_smelting_amethyst_cactus");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.QUARTZ_CACTUS.get()),
                        RecipeCategory.MISC,
                        new ItemStack(Items.QUARTZ, 4),
                        0.2f,
                        200
                )
                .unlockedBy("has_quartz_cactus", has(ModBlocks.QUARTZ_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:quartz_from_smelting_quartz_cactus");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.GLOWSTONE_CACTUS.get()),
                        RecipeCategory.MISC,
                        new ItemStack(Items.GLOWSTONE_DUST, 4),
                        0.2f,
                        200
                )
                .unlockedBy("has_glowstone_cactus", has(ModBlocks.GLOWSTONE_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:glowstone_dust_from_smelting_glowstone_cactus");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.NETHERITE_CACTUS.get()),
                        RecipeCategory.MISC,
                        Items.NETHERITE_SCRAP,
                        0.2f,
                        200
                )
                .unlockedBy("has_netherite_cactus", has(ModBlocks.NETHERITE_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:netherite_scrap_from_smelting_netherite_cactus");

        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(ModBlocks.IRON_CACTUS.get()),
                        RecipeCategory.MISC,
                        Items.IRON_INGOT,
                        0.7f,
                        100
                )
                .unlockedBy("has_iron_cactus", has(ModBlocks.IRON_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:iron_ingot_from_blasting_iron_cactus");

        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(ModBlocks.COPPER_CACTUS.get()),
                        RecipeCategory.MISC,
                        Items.COPPER_INGOT,
                        0.7f,
                        100
                )
                .unlockedBy("has_copper_cactus", has(ModBlocks.COPPER_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:copper_ingot_from_blasting_copper_cactus");

        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(ModBlocks.GOLD_CACTUS.get()),
                        RecipeCategory.MISC,
                        Items.GOLD_INGOT,
                        0.7f,
                        100
                )
                .unlockedBy("has_gold_cactus", has(ModBlocks.GOLD_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:gold_ingot_from_blasting_gold_cactus");

        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(ModBlocks.NETHERITE_CACTUS.get()),
                        RecipeCategory.MISC,
                        Items.NETHERITE_SCRAP,
                        0.2f,
                        100
                )
                .unlockedBy("has_netherite_cactus", has(ModBlocks.NETHERITE_CACTUS.get()))
                .save(recipeOutput, "grodomirsresourcefulcactimod:netherite_scrap_from_blasting_netherite_cactus");

    }

}
