package com.orecacti.resourcefulcactimod.item;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import com.orecacti.resourcefulcactimod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ResourcefulCactiMod.MOD_ID);

    public static final Supplier<CreativeModeTab> RESOURCEFUL_CACTI_TAB = CREATIVE_MODE_TAB.register("resourcefulcacti_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.SHEARED_CACTUS.asItem()))
                    .title(Component.translatable("creativetab.grodomirsresourcefulcactimod.resourcefulcacti_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //output.accept(ModItems.CACTUS_SPIKE);
                        //output.accept(ModItems.COPPER_CACTUS_SPIKE);
                        //output.accept(ModItems.COPPER_NUGGET);
                        //output.accept(ModBlocks.SHEARED_CACTUS);
                        //output.accept(ModBlocks.IRON_CACTUS);
                        ModItems.ITEMS.getEntries().forEach(item ->
                                output.accept(item.get())
                        );
                        ModBlocks.BLOCKS.getEntries().forEach(block ->
                                output.accept(block.get())
                        );
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
