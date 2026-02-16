package com.orecacti.resourcefulcactimod.compat;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import com.orecacti.resourcefulcactimod.recipe.InWorldInteractionRecipe;
import com.orecacti.resourcefulcactimod.recipe.ModRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JeiRCactiModPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(ResourcefulCactiMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new InWorldInteractionRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<InWorldInteractionRecipe> inWorldInteractionRecipes = recipeManager
                .getAllRecipesFor(ModRecipe.INWORLDINTERACTION_TYPE.get()).stream().map(RecipeHolder::value).toList();

        registration.addRecipes(InWorldInteractionRecipeCategory.INWORLDINTERACTION_RECIPE_TYPE, inWorldInteractionRecipes);
    }
}
