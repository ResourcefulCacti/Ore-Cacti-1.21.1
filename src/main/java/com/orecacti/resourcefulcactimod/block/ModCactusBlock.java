package com.orecacti.resourcefulcactimod.block;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ModCactusBlock extends CactusBlock {

    //public static final int MAX_AGE = 15;
    //public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 15);

    public ModCactusBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState blockstate = level.getBlockState(pos.relative(direction));
            if (blockstate.isSolid() || level.getFluidState(pos.relative(direction)).is(FluidTags.LAVA)) {
                return false;
            }
        }

        BlockState blockstate1 = level.getBlockState(pos.below());
        net.neoforged.neoforge.common.util.TriState soilDecision = blockstate1.canSustainPlant(level, pos.below(), Direction.UP, state);
        if (!soilDecision.isDefault()) return soilDecision.isTrue();
        //return (blockstate1.is(ModBlocks.IRON_CACTUS) || blockstate1.is(BlockTags.SAND)) && !level.getBlockState(pos.above()).liquid();
        return (blockstate1.getBlock() instanceof ModCactusBlock || blockstate1.is(BlockTags.SAND)) && !level.getBlockState(pos.above()).liquid();
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.tick(state, level, pos, random);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(!state.is(ModBlocks.SHEARED_CACTUS.get())){
            entity.hurt(level.damageSources().cactus(), 1.0F);
        }

    }

}
