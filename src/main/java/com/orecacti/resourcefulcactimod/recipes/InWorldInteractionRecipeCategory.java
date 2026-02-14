package com.orecacti.resourcefulcactimod.recipes;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.GuiGraphics;

import com.orecacti.resourcefulcactimod.init.ModJeiPlugin;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;
import org.jetbrains.annotations.Nullable;

public class InWorldInteractionRecipeCategory implements IRecipeCategory<InWorldInteractionRecipe>{
    public final static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(ResourcefulCactiMod.MOD_ID, "inworldinteraction");
    public final static ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(ResourcefulCactiMod.MOD_ID, "textures/gui/recipe2.png");
    private final IDrawable background;
    private final IDrawable icon;

    public InWorldInteractionRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 86);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Blocks.CACTUS.asItem()));
    }

    @Override
    public RecipeType<InWorldInteractionRecipe> getRecipeType() {
        return ModJeiPlugin.InWorldInteraction_Type;
    }

    @Override
    public Component getTitle() {
        return Component.literal("In World Interaction");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public int getWidth() {
        return this.background.getWidth();
    }

    @Override
    public int getHeight() {
        return this.background.getHeight();
    }

    @Override
    public void draw(InWorldInteractionRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.background.draw(guiGraphics);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, InWorldInteractionRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 30, 17).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 67, 53).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 124, 35).addItemStack(recipe.getResultItem(null));
    }
}
