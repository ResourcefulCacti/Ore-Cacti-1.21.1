package com.orecacti.resourcefulcactimod.init;

import com.orecacti.resourcefulcactimod.gui.InWorldInteractionMenu;
import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, ResourcefulCactiMod.MOD_ID);
    public static final DeferredHolder<MenuType<?>, MenuType<InWorldInteractionMenu>> IN_WORLD_INTERACTION = REGISTRY.register("in_world_interaction",
            () -> IMenuTypeExtension.create(InWorldInteractionMenu::new));
}
