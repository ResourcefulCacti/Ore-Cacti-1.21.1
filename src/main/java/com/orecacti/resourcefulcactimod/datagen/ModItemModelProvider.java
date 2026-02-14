package com.orecacti.resourcefulcactimod.datagen;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import com.orecacti.resourcefulcactimod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ResourcefulCactiMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CACTUS_SPIKE.get());
        basicItem(ModItems.IRON_CACTUS_SPIKE.get());
        basicItem(ModItems.COPPER_CACTUS_SPIKE.get());
        basicItem(ModItems.AMETHYST_CACTUS_SPIKE.get());
        basicItem(ModItems.COAL_CACTUS_SPIKE.get());
        basicItem(ModItems.DIAMOND_CACTUS_SPIKE.get());
        basicItem(ModItems.EMERALD_CACTUS_SPIKE.get());
        basicItem(ModItems.GLOWSTONE_CACTUS_SPIKE.get());
        basicItem(ModItems.GOLD_CACTUS_SPIKE.get());
        basicItem(ModItems.LAPIS_CACTUS_SPIKE.get());
        basicItem(ModItems.NETHERITE_CACTUS_SPIKE.get());
        basicItem(ModItems.QUARTZ_CACTUS_SPIKE.get());
        basicItem(ModItems.REDSTONE_CACTUS_SPIKE.get());
        basicItem(ModItems.WEAK_OVERWORLD_ESSENCE.get());
        basicItem(ModItems.OVERWORLD_ESSENCE.get());
        basicItem(ModItems.OVERWORLD_STABILIZER.get());
        basicItem(ModItems.WEAK_NETHER_ESSENCE.get());
        basicItem(ModItems.NETHER_ESSENCE.get());
        basicItem(ModItems.NETHER_STABILIZER.get());
        basicItem(ModItems.COPPER_NUGGET.get());
    }
}
