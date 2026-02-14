package com.orecacti.resourcefulcactimod.init;

import com.orecacti.resourcefulcactimod.recipes.InWorldInteractionRecipe;
import com.orecacti.resourcefulcactimod.recipes.InWorldInteractionRecipeCategory;
import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;


import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.IModPlugin;

import java.util.stream.Collectors;
import java.util.Objects;
import java.util.List;

public class ModJeiPlugin implements IModPlugin {
    public static RecipeType<InWorldInteractionRecipe> InWorldInteraction_Type = new RecipeType<>(InWorldInteractionRecipeCategory.UID, InWorldInteractionRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(ResourcefulCactiMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new InWorldInteractionRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<InWorldInteractionRecipe> InWorldInteractionRecipes = recipeManager.getAllRecipesFor(InWorldInteractionRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
        registration.addRecipes(InWorldInteraction_Type, InWorldInteractionRecipes);
    }
}
