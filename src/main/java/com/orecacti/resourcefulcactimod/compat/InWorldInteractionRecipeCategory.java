package com.orecacti.resourcefulcactimod.compat;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import com.orecacti.resourcefulcactimod.recipe.InWorldInteractionRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

public class InWorldInteractionRecipeCategory implements IRecipeCategory<InWorldInteractionRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(ResourcefulCactiMod.MOD_ID, "inworldinteraction");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(ResourcefulCactiMod.MOD_ID, "textures/gui/recipe2.png");

    public static final RecipeType<InWorldInteractionRecipe> INWORLDINTERACTION_RECIPE_TYPE =
            new RecipeType<>(UID, InWorldInteractionRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public InWorldInteractionRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 86);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Blocks.CACTUS));
    }

    @Override
    public RecipeType<InWorldInteractionRecipe> getRecipeType() {
        return INWORLDINTERACTION_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("In World Interaction");
        //return Component.translatable("");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public int getHeight() {
        return this.background.getHeight();
    }

    @Override
    public int getWidth() {
        return this.background.getWidth();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, InWorldInteractionRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 30, 17).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 67, 53).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 124, 35).addItemStack(recipe.getResultItem(null));
    }

    @Override
    public void draw(InWorldInteractionRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
        background.draw(guiGraphics);
    }
}
