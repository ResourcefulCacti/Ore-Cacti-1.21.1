package com.orecacti.resourcefulcactimod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.core.registries.BuiltInRegistries;

import com.orecacti.resourcefulcactimod.recipes.InWorldInteractionRecipe;
import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;

@EventBusSubscriber(modid = ResourcefulCactiMod.MOD_ID)
public class ModRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, "grodomirsresourcefulcactimod");
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "grodomirsresourcefulcactimod");

    @SubscribeEvent
    public static void register(FMLConstructModEvent event) {
        IEventBus bus = ModList.get().getModContainerById("grodomirsresourcefulcactimod").get().getEventBus();
        event.enqueueWork(() -> {
            RECIPE_TYPES.register(bus);
            SERIALIZERS.register(bus);
            RECIPE_TYPES.register("inworldinteraction", () -> InWorldInteractionRecipe.Type.INSTANCE);
            SERIALIZERS.register("inworldinteraction", () -> InWorldInteractionRecipe.Serializer.INSTANCE);
        });
    }
}
