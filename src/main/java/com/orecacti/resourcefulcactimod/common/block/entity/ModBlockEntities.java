package com.orecacti.resourcefulcactimod.common.block.entity;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import com.orecacti.resourcefulcactimod.common.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ResourcefulCactiMod.MOD_ID);

    public static final Supplier<BlockEntityType<CactiMaterializerBlockEntity>> CACTI_MATERIALIZER_BE =
            BLOCK_ENTITIES.register("cacti_materializer_be", () -> BlockEntityType.Builder.of(
                    CactiMaterializerBlockEntity::new, ModBlocks.CACTI_MATERIALIZER.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }

    public static void registerCapabilities(RegisterCapabilitiesEvent event){
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK,
                CACTI_MATERIALIZER_BE.get(), CactiMaterializerBlockEntity::getItemHandlerCapability);
    }
}
