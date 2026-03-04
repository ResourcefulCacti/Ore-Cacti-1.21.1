/*package com.orecacti.resourcefulcactimod.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;

public class ModCustomPottedBlock extends FlowerPotBlock {

    public ModCustomPottedBlock(Block p_53528_, BlockBehaviour.Properties properties) {
        super(p_53528_, properties);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        super.onPlace(state, level, pos, oldState, movedByPiston);

        if(!level.isClientSide){
            level.scheduleTick(pos, this, 20);
        }
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.tick(state, level, pos, random);

        BlockPos blockBelow = pos.below();

        IItemHandler handler = level.getCapability(
                Capabilities.ItemHandler.BLOCK,
                blockBelow,
                Direction.UP
        );

        if(handler != null){
            ItemStack toInsert = new ItemStack(this.getPotted().asItem(), 1);

            //System.out.println("Kurwa 2: " + toInsert);

            for(int i = 0; i < handler.getSlots(); i++){
                toInsert = handler.insertItem(i, toInsert, false);
                if(toInsert.isEmpty()) break;
            }
        }

        level.scheduleTick(pos, this, 200);
    }
}*/
