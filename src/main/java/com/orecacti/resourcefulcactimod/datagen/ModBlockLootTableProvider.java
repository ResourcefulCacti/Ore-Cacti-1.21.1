package com.orecacti.resourcefulcactimod.datagen;

import com.orecacti.resourcefulcactimod.block.ModBlocks;
import com.orecacti.resourcefulcactimod.block.ModCactusBlock;
import com.orecacti.resourcefulcactimod.item.ModItems;
import com.orecacti.resourcefulcactimod.util.block.ReadCactiFromJson;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        dropSelf(ModBlocks.SHEARED_CACTUS.get());
        dropOther(ModBlocks.CREEPER_CACTUS.get(), Items.GUNPOWDER);

        //Tier1
        dropSelfPlusExtra(
                ModBlocks.COAL_CACTUS.get(),
                ModItems.WEAK_OVERWORLD_ESSENCE.asItem(),
                0.1F,
                1);

        dropSelfPlusExtra(
                ModBlocks.LAPIS_CACTUS.get(),
                ModItems.WEAK_OVERWORLD_ESSENCE.asItem(),
                0.1F,
                1);

        dropSelfPlusExtra(
                ModBlocks.REDSTONE_CACTUS.get(),
                ModItems.WEAK_OVERWORLD_ESSENCE.asItem(),
                0.1F,
                1);

        dropSelfPlusExtra(
                ModBlocks.AMETHYST_CACTUS.get(),
                ModItems.WEAK_OVERWORLD_ESSENCE.asItem(),
                0.1F,
                1);

        dropSelfPlusExtra(
                ModBlocks.QUARTZ_CACTUS.get(),
                ModItems.WEAK_OVERWORLD_ESSENCE.asItem(),
                0.1F,
                1);

        dropSelfPlusExtra(
                ModBlocks.GLOWSTONE_CACTUS.get(),
                ModItems.WEAK_OVERWORLD_ESSENCE.asItem(),
                0.1F,
                1);

        //Tier2

        dropSelfPlusExtra(
                ModBlocks.IRON_CACTUS.get(),
                ModItems.WEAK_NETHER_ESSENCE.asItem(),
                0.05F,
                1);

        dropSelfPlusExtra(
                ModBlocks.COPPER_CACTUS.get(),
                ModItems.WEAK_NETHER_ESSENCE.asItem(),
                0.05F,
                1);

        dropSelfPlusExtra(
                ModBlocks.GOLD_CACTUS.get(),
                ModItems.WEAK_NETHER_ESSENCE.asItem(),
                0.05F,
                1);

        dropSelfPlusExtra(
                ModBlocks.EMERALD_CACTUS.get(),
                ModItems.WEAK_NETHER_ESSENCE.asItem(),
                0.05F,
                1);

        dropSelfPlusExtra(
                ModBlocks.DIAMOND_CACTUS.get(),
                ModItems.WEAK_NETHER_ESSENCE.asItem(),
                0.1F,
                1);

        //Tier3
        dropSelf(ModBlocks.NETHERITE_CACTUS.get());

        dropOther(ModBlocks.POTTED_COAL.get(), ModBlocks.COAL_CACTUS.asItem());

        readThis();

        /* Non-existent ingredient for non-existent Tier 4 cacti
        dropSelfPlusExtra(
                ModBlocks.DIAMOND_CACTUS.get(),
                ModItems.WEAK_END_ESSENCE.asItem(),
                0.1F,
                1);
         */
    }

    private void readThis(){
        /*List<ModCactusBlockData> readBlocks = GsonCactusReader.readBlocksFromFile();


        assert readBlocks != null;

        if(!readBlocks.isEmpty()){
            for(ModCactusBlockData addedCacti : readBlocks){
                String id = addedCacti.getId();
                int lightLevel = addedCacti.getLightLevel();
                DeferredBlock<ModCactusBlock> cacti = ModBlocks.CUSTOM_CACTI_MAP.get(id);

                if(addedCacti.dropWithChance){
                    if(cacti != null){
                        dropSelfPlusExtra(cacti.get(), ModItems.WEAK_OVERWORLD_ESSENCE.asItem(), addedCacti.getEssenceDropChance(), 1);
                    }
                }else{
                    if(cacti != null){
                        dropSelf(cacti.get());
                    }
                }
            }
        }*/

        if(!ReadCactiFromJson.DROP_WITH_CHANCE.isEmpty()){
            Map<String, Float> chanceDrop = ReadCactiFromJson.CHANCE_DROP;
            Map<String, Integer> TIER = ReadCactiFromJson.TIER;

            for(Map.Entry <String, Boolean> cacti : ReadCactiFromJson.DROP_WITH_CHANCE.entrySet()){
                String id = cacti.getKey();
                Boolean dropWithChance = cacti.getValue();
                Float essenceDropChance = chanceDrop.get(id);
                Integer tier = TIER.get(id);
                DeferredBlock<ModCactusBlock> registeredCacti = ModBlocks.CUSTOM_CACTI_MAP.get(id);

                System.out.println("ID of map1: " + id);
                System.out.println("Dro extra?: " + dropWithChance);
                System.out.println("Chance to drop: " + essenceDropChance);
                System.out.println("Tier: " + tier);
                System.out.println("Deferred block: " + registeredCacti);

                if(dropWithChance && registeredCacti != null){
                    switch(tier) {
                        case 2 ->
                                dropSelfPlusExtra(registeredCacti.get(), ModItems.WEAK_NETHER_ESSENCE.asItem(), essenceDropChance, 1);
                        default ->
                                dropSelfPlusExtra(registeredCacti.get(), ModItems.WEAK_OVERWORLD_ESSENCE.asItem(), essenceDropChance, 1);
                    }
                }else{
                    if(registeredCacti !=null){
                        dropSelf(registeredCacti.get());
                    }
                }
            }
        }
    }

    protected void dropSelfPlusExtra(Block self, Item extra, float chance, int count){
        this.add(self, b -> {
           LootTable.Builder table = LootTable.lootTable();

           table.withPool(
                   LootPool.lootPool()
                           .setRolls(ConstantValue.exactly(1))
                           .add(LootItem.lootTableItem(b))
           );

           table.withPool(
                   LootPool.lootPool()
                           .setRolls(ConstantValue.exactly(1))
                           .when(LootItemRandomChanceCondition.randomChance(chance))
                           .add(LootItem.lootTableItem(extra))
                           .apply(SetItemCountFunction.setCount(ConstantValue.exactly(count)))
           );
           return this.applyExplosionDecay(b, table);
        });
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> blocks = new ArrayList<>();

        // Normal registered blocks
        ModBlocks.BLOCKS.getEntries()
                .forEach(holder -> blocks.add(holder.value()));

        // Custom JSON blocks
        ModBlocks.CUSTOM_CACTI_MAP.values()
                .forEach(deferred -> blocks.add(deferred.get()));

        return blocks;
    }
}
