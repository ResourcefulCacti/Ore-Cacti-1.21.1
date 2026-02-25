package com.orecacti.resourcefulcactimod.item;

import com.orecacti.resourcefulcactimod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.Tags;

public class EssenceItem extends Item {
    public EssenceItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        if(!entity.level().isClientSide && entity.onGround()){
            BlockPos posBelow = entity.blockPosition().below();
            BlockState stateBelow = entity.level().getBlockState(posBelow);

            if(stateBelow.is(Blocks.SCULK)){
                ItemStack reward = new ItemStack(Items.WHEAT_SEEDS, stack.getCount());

                ItemEntity droppedItem = new ItemEntity(
                        entity.level(),
                        entity.getX(),
                        entity.getY(),
                        entity.getZ(),
                        reward
                );
                entity.discard();

                entity.level().addFreshEntity(droppedItem);
            }
        }
        return false;
    }
}
