package com.orecacti.resourcefulcactimod.item;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ResourcefulCactiMod.MOD_ID);

    public static final DeferredItem<CactusSpikeItem> CACTUS_SPIKE = ITEMS.register("cactus_spike",
            () -> new CactusSpikeItem(new Item.Properties()));

    public static final DeferredItem<Item> COPPER_CACTUS_SPIKE = ITEMS.register("copper_cactus_spike",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>IRON_CACTUS_SPIKE = ITEMS.register("iron_cactus_spike",
                () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>AMETHYST_CACTUS_SPIKE = ITEMS.register("amethyst_cactus_spike",
                () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>COAL_CACTUS_SPIKE = ITEMS.register("coal_cactus_spike",
                () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>DIAMOND_CACTUS_SPIKE = ITEMS.register("diamond_cactus_spike",
                () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>EMERALD_CACTUS_SPIKE = ITEMS.register("emerald_cactus_spike",
                () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>GLOWSTONE_CACTUS_SPIKE = ITEMS.register("glowstone_cactus_spike",
                () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>GOLD_CACTUS_SPIKE = ITEMS.register("gold_cactus_spike",
                () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>LAPIS_CACTUS_SPIKE = ITEMS.register("lapis_cactus_spike",
                () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>NETHERITE_CACTUS_SPIKE = ITEMS.register("netherite_cactus_spike",
                () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>QUARTZ_CACTUS_SPIKE = ITEMS.register("quartz_cactus_spike",
                () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>REDSTONE_CACTUS_SPIKE = ITEMS.register("redstone_cactus_spike",
                () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>WEAK_OVERWORLD_ESSENCE = ITEMS.register("weak_overworld_essence",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>OVERWORLD_ESSENCE = ITEMS.register("overworld_essence",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>OVERWORLD_STABILIZER = ITEMS.register("overworld_stabilizer",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>WEAK_NETHER_ESSENCE = ITEMS.register("weak_nether_essence",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>NETHER_ESSENCE = ITEMS.register("nether_essence",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>NETHER_STABILIZER = ITEMS.register("nether_stabilizer",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
