package com.orecacti.resourcefulcactimod.datagen;

import com.orecacti.resourcefulcactimod.block.ModBlocks;
import com.orecacti.resourcefulcactimod.item.ModItems;
import com.orecacti.resourcefulcactimod.util.ModTags;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.SHEARED_CACTUS.get());
        /*dropSelf(ModBlocks.IRON_CACTUS.get());
        dropSelf(ModBlocks.COPPER_CACTUS.get());
        dropSelf(ModBlocks.AMETHYST_CACTUS.get());
        dropSelf(ModBlocks.COAL_CACTUS.get());
        dropSelf(ModBlocks.DIAMOND_CACTUS.get());
        dropSelf(ModBlocks.EMERALD_CACTUS.get());
        dropSelf(ModBlocks.GLOWSTONE_CACTUS.get());
        dropSelf(ModBlocks.GOLD_CACTUS.get());
        dropSelf(ModBlocks.LAPIS_CACTUS.get());
        dropSelf(ModBlocks.NETHERITE_CACTUS.get());
        dropSelf(ModBlocks.QUARTZ_CACTUS.get());
        dropSelf(ModBlocks.REDSTONE_CACTUS.get());*/
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

        /* Non-existent ingredient for non-existent Tier 4 cacti
        dropSelfPlusExtra(
                ModBlocks.DIAMOND_CACTUS.get(),
                ModItems.WEAK_END_ESSENCE.asItem(),
                0.1F,
                1);
         */
    }

    //protected LootTable.Builder testLoot(Block block, Item item, float chances, int count){
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
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
