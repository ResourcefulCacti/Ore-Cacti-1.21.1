package com.orecacti.resourcefulcactimod.recipe;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipe {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, ResourcefulCactiMod.MOD_ID);

    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, ResourcefulCactiMod.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<InWorldInteractionRecipe>> INWORLDINTERACTION_SERIALIZER =
            SERIALIZERS.register("inworldinteraction", InWorldInteractionRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<InWorldInteractionRecipe>> INWORLDINTERACTION_TYPE =
            TYPES.register("inworldinteraction", () -> new RecipeType<InWorldInteractionRecipe>() {
                @Override
                public String toString() {
                    return "inworldinteraction";
                }
            });

    public static void register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
