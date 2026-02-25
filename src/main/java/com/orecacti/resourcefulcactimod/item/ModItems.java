package com.orecacti.resourcefulcactimod.item;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import com.orecacti.resourcefulcactimod.util.item.GsonSpikeReader;
import com.orecacti.resourcefulcactimod.util.item.ModSpikeItemData;
import com.orecacti.resourcefulcactimod.util.item.ReadSpikeFromJson;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ResourcefulCactiMod.MOD_ID);
    public static final DeferredRegister.Items CUSTOM_ITEM = DeferredRegister.createItems(ResourcefulCactiMod.MOD_ID);

    public static final DeferredItem<CactusSpikeItem> CACTUS_SPIKE = ITEMS.register("cactus_spike",
            () -> new CactusSpikeItem(new Item.Properties()));

    //Tier 1
    public static final DeferredItem<Item>COAL_CACTUS_SPIKE = ITEMS.register("coal_cactus_spike",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>AMETHYST_CACTUS_SPIKE = ITEMS.register("amethyst_cactus_spike",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>QUARTZ_CACTUS_SPIKE = ITEMS.register("quartz_cactus_spike",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>GLOWSTONE_CACTUS_SPIKE = ITEMS.register("glowstone_cactus_spike",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>LAPIS_CACTUS_SPIKE = ITEMS.register("lapis_cactus_spike",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>REDSTONE_CACTUS_SPIKE = ITEMS.register("redstone_cactus_spike",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>WEAK_OVERWORLD_ESSENCE = ITEMS.register("weak_overworld_essence",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<EssenceItem>OVERWORLD_ESSENCE = ITEMS.register("overworld_essence",
            () -> new EssenceItem(new EssenceItem.Properties()));

    public static final DeferredItem<Item>OVERWORLD_STABILIZER = ITEMS.register("overworld_stabilizer",
            () -> new Item(new Item.Properties()));

    //Tier 2
    public static final DeferredItem<Item>IRON_CACTUS_SPIKE = ITEMS.register("iron_cactus_spike",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPER_CACTUS_SPIKE = ITEMS.register("copper_cactus_spike",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>GOLD_CACTUS_SPIKE = ITEMS.register("gold_cactus_spike",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>DIAMOND_CACTUS_SPIKE = ITEMS.register("diamond_cactus_spike",
                () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>EMERALD_CACTUS_SPIKE = ITEMS.register("emerald_cactus_spike",
                () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>WEAK_NETHER_ESSENCE = ITEMS.register("weak_nether_essence",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>NETHER_ESSENCE = ITEMS.register("nether_essence",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>NETHER_STABILIZER = ITEMS.register("nether_stabilizer",
            () -> new Item(new Item.Properties()));


    //Tier 3
    public static final DeferredItem<Item>NETHERITE_CACTUS_SPIKE = ITEMS.register("netherite_cactus_spike",
                () -> new Item(new Item.Properties()));

    private static final List<DeferredItem<? extends Item>> DYNAMIC_SPIKE_ITEMS = new ArrayList<>();
    public static final LinkedHashMap<String, DeferredItem<? extends Item>> REGISTERED_CUSTOM_SPIKES = new LinkedHashMap<>();

    public static void readThis(){
        /*List<ModSpikeItemData> readItems = GsonSpikeReader.readItemsFromFile();

        assert readItems != null;

        if(!readItems.isEmpty()){
            for(ModSpikeItemData addedSpike : readItems){
                String id = addedSpike.getId();

                customSpikes(id);
            }
        }*/
        if(!ReadSpikeFromJson.REGISTER_SPIKE_FROM_JSON.isEmpty()){
            for(String spike : ReadSpikeFromJson.REGISTER_SPIKE_FROM_JSON){
                customSpikes(spike);
            }
        }
    }

    public static void customSpikes(String id){
        DeferredItem<Item> deferred = CUSTOM_ITEM.register(id, () -> new Item(new Item.Properties()));

        DYNAMIC_SPIKE_ITEMS.add(deferred);
        REGISTERED_CUSTOM_SPIKES.put(id, deferred);
    }

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
        CUSTOM_ITEM.register(eventBus);
        readThis();
    }
}
