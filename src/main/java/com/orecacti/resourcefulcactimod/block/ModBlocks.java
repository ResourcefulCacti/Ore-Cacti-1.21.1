package com.orecacti.resourcefulcactimod.block;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import com.orecacti.resourcefulcactimod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ResourcefulCactiMod.MOD_ID);

    public static final DeferredBlock<ModCactusBlock> SHEARED_CACTUS = registerBlock("sheared_cactus",
            () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                    .strength(0.4F)
                    .sound(SoundType.WOOL)
                    .pushReaction(PushReaction.DESTROY)
                    .mapColor(MapColor.PLANT)
                    .randomTicks()));

    public static final DeferredBlock<ModCactusBlock> IRON_CACTUS = registerBlock("iron_cactus",
            () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                    .strength(0.4F)
                    .sound(SoundType.WOOL)
                    .pushReaction(PushReaction.DESTROY)
                    .mapColor(MapColor.PLANT)
                    .randomTicks()));

    public static final DeferredBlock<ModCactusBlock> COPPER_CACTUS = registerBlock("copper_cactus",
                () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                        .strength(0.4F)
                        .sound(SoundType.WOOL)
                        .pushReaction(PushReaction.DESTROY)
                        .mapColor(MapColor.PLANT)
                        .randomTicks()));

    public static final DeferredBlock<ModCactusBlock> AMETHYST_CACTUS = registerBlock("amethyst_cactus",
                () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                        .strength(0.4F)
                        .sound(SoundType.WOOL)
                        .pushReaction(PushReaction.DESTROY)
                        .mapColor(MapColor.PLANT)
                        .randomTicks()));

    public static final DeferredBlock<ModCactusBlock> COAL_CACTUS = registerBlock("coal_cactus",
                () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                        .strength(0.4F)
                        .sound(SoundType.WOOL)
                        .pushReaction(PushReaction.DESTROY)
                        .mapColor(MapColor.PLANT)
                        .randomTicks()));

    public static final DeferredBlock<ModCactusBlock> DIAMOND_CACTUS = registerBlock("diamond_cactus",
                () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                        .strength(0.4F)
                        .sound(SoundType.WOOL)
                        .pushReaction(PushReaction.DESTROY)
                        .mapColor(MapColor.PLANT)
                        .randomTicks()));

    public static final DeferredBlock<ModCactusBlock> EMERALD_CACTUS = registerBlock("emerald_cactus",
                () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                        .strength(0.4F)
                        .sound(SoundType.WOOL)
                        .pushReaction(PushReaction.DESTROY)
                        .mapColor(MapColor.PLANT)
                        .randomTicks()));

    public static final DeferredBlock<ModCactusBlock> GLOWSTONE_CACTUS = registerBlock("glowstone_cactus",
                () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                        .strength(0.4F)
                        .sound(SoundType.WOOL)
                        .lightLevel(whyCantThisBeJustANumber -> 9)
                        .pushReaction(PushReaction.DESTROY)
                        .mapColor(MapColor.PLANT)
                        .randomTicks()));

    public static final DeferredBlock<ModCactusBlock> GOLD_CACTUS = registerBlock("gold_cactus",
                () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                        .strength(0.4F)
                        .sound(SoundType.WOOL)
                        .pushReaction(PushReaction.DESTROY)
                        .mapColor(MapColor.PLANT)
                        .randomTicks()));

    public static final DeferredBlock<ModCactusBlock> LAPIS_CACTUS = registerBlock("lapis_cactus",
                () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                        .strength(0.4F)
                        .sound(SoundType.WOOL)
                        .pushReaction(PushReaction.DESTROY)
                        .mapColor(MapColor.PLANT)
                        .randomTicks()));

    public static final DeferredBlock<ModCactusBlock> NETHERITE_CACTUS = registerBlock("netherite_cactus",
                () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                        .strength(0.4F)
                        .sound(SoundType.WOOL)
                        .pushReaction(PushReaction.DESTROY)
                        .mapColor(MapColor.PLANT)
                        .randomTicks()));

    public static final DeferredBlock<ModCactusBlock> QUARTZ_CACTUS = registerBlock("quartz_cactus",
                () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                        .strength(0.4F)
                        .sound(SoundType.WOOL)
                        .pushReaction(PushReaction.DESTROY)
                        .mapColor(MapColor.PLANT)
                        .randomTicks()));

    public static final DeferredBlock<ModCactusBlock> REDSTONE_CACTUS = registerBlock("redstone_cactus",
                () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                        .strength(0.4F)
                        .sound(SoundType.WOOL)
                        .pushReaction(PushReaction.DESTROY)
                        .mapColor(MapColor.PLANT)
                        .randomTicks()));

    public static final DeferredBlock<ModCactusBlock> CREEPER_CACTUS = registerBlock("creeper_cactus",
            () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                    .strength(0.4F)
                    .sound(SoundType.WOOL)
                    .pushReaction(PushReaction.DESTROY)
                    .mapColor(MapColor.PLANT)
                    .randomTicks()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
