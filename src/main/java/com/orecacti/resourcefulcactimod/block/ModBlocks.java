package com.orecacti.resourcefulcactimod.block;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import com.orecacti.resourcefulcactimod.item.ModItems;
import com.orecacti.resourcefulcactimod.util.block.ReadCactiFromJson;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ResourcefulCactiMod.MOD_ID);

    public static final DeferredRegister.Blocks CUSTOM_CACTI = DeferredRegister.createBlocks(ResourcefulCactiMod.MOD_ID);
    public static final DeferredRegister.Blocks POTTED_CACTI = DeferredRegister.createBlocks(ResourcefulCactiMod.MOD_ID);

    public static final DeferredBlock<ModCactusBlock> SHEARED_CACTUS = registerBlock("sheared_cactus",
            () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                    .strength(0.4F)
                    .sound(SoundType.WOOL)
                    .pushReaction(PushReaction.DESTROY)
                    .mapColor(MapColor.PLANT)
                    .randomTicks()));

    //Tier 1
    public static final DeferredBlock<ModCactusBlock> COAL_CACTUS = registerBlock("coal_cactus",
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

    public static final DeferredBlock<ModCactusBlock> QUARTZ_CACTUS = registerBlock("quartz_cactus",
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

    public static final DeferredBlock<ModCactusBlock> LAPIS_CACTUS = registerBlock("lapis_cactus",
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

    //Tier 2
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

    public static final DeferredBlock<ModCactusBlock> GOLD_CACTUS = registerBlock("gold_cactus",
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


    //Tier 3
    public static final DeferredBlock<ModCactusBlock> NETHERITE_CACTUS = registerBlock("netherite_cactus",
                () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                        .strength(0.4F)
                        .sound(SoundType.WOOL)
                        .pushReaction(PushReaction.DESTROY)
                        .mapColor(MapColor.PLANT)
                        .randomTicks()));


    //Secret Cactus
    public static final DeferredBlock<ModCactusBlock> CREEPER_CACTUS = registerBlock("creeper_cactus",
            () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                    .strength(0.4F)
                    .sound(SoundType.WOOL)
                    .pushReaction(PushReaction.DESTROY)
                    .mapColor(MapColor.PLANT)
                    .randomTicks()));

    public static final DeferredBlock<ModCustomPottedBlock> POTTED_COAL = registerPottedBlock("potted_coal",
            () -> new ModCustomPottedBlock(COAL_CACTUS.get(), BlockBehaviour.Properties.of()
                    .instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> registerPottedBlock(String name, Supplier<T> block){
        return POTTED_CACTI.register(name, block);
    }

    private static <T extends Block> DeferredBlock<T> registerCustomCacti(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = CUSTOM_CACTI.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static final List<DeferredBlock<? extends Block>> DYNAMIC_CACTI_BLOCKS = new ArrayList<>();
    public static final Map<String, DeferredBlock<ModCactusBlock>> CUSTOM_CACTI_MAP = new HashMap<>();

    private static void readThis(){
        /*List<ModCactusBlockData> readBlocks = GsonCactusReader.readBlocksFromFile();

        assert readBlocks != null;
        if(!readBlocks.isEmpty()){
            for(ModCactusBlockData addedCacti : readBlocks){
                String id = addedCacti.getId();
                int lightLevel = addedCacti.getLightLevel();

                customCacti(id, lightLevel);
            }
        }*/
        if(!ReadCactiFromJson.CACTI_FROM_JSON.isEmpty()){
            for(Map.Entry <String, Integer> cacti : ReadCactiFromJson.CACTI_FROM_JSON.entrySet()){
                String id = cacti.getKey();
                int lightLevel = cacti.getValue();

                customCacti(id, lightLevel);

            /*j++;
            System.out.println(j + ": new_ID: " + id);
            System.out.println(j + ": new_LightLevel: " + lightLevel);*/
            }
        }
    }

    private static void customCacti(String id, int lightLevel){
        DeferredBlock<ModCactusBlock> deferred = registerCustomCacti(id,
                () -> new ModCactusBlock(BlockBehaviour.Properties.of()
                        .strength(0.4F)
                        .sound(SoundType.WOOL)
                        .pushReaction(PushReaction.DESTROY)
                        .mapColor(MapColor.PLANT)
                        .randomTicks()
                        .lightLevel(idkWhatThisIs -> lightLevel)
                ));

        DYNAMIC_CACTI_BLOCKS.add(deferred);
        CUSTOM_CACTI_MAP.put(id, deferred);
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
        readThis();
        CUSTOM_CACTI.register(eventBus);
        POTTED_CACTI.register(eventBus);
    }
}
