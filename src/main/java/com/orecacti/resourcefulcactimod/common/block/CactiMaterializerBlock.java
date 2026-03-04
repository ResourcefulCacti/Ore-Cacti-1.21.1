package com.orecacti.resourcefulcactimod.common.block;

import com.mojang.serialization.MapCodec;
import com.orecacti.resourcefulcactimod.common.block.entity.CactiMaterializerBlockEntity;
import com.orecacti.resourcefulcactimod.common.block.entity.ModBlockEntities;
import com.orecacti.resourcefulcactimod.util.VoxelShapeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CactiMaterializerBlock extends BaseEntityBlock {
    public static final MapCodec<CactiMaterializerBlock> CODEC = simpleCodec(CactiMaterializerBlock::new);

    private static final VoxelShape FRAME_DATA = VoxelShapeUtils.combine(
            box(0,0, 0, 2, 2, 16),
            box(2,0, 0, 16, 2, 2),
            box(2,0, 14, 16, 2, 16),
            box(14, 0, 2, 16, 2, 14),

            box(0,14, 0, 2, 16, 16),
            box(2,14, 0, 16, 16, 2),
            box(2,14, 14, 16, 16, 16),
            box(14, 14, 2, 16, 16, 14),

            box(0, 2, 0, 2, 14, 2),
            box(14, 2, 0, 16, 14, 2),
            box(0, 2, 14, 2, 14, 16),
            box(14, 2, 14, 16, 14, 16)
    );

    private static final VoxelShape FRAME = FRAME_DATA;

    protected CactiMaterializerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CactiMaterializerBlockEntity(pos, state);
    }

    @NotNull
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        //System.out.println("getShape called at " + pos);
        return FRAME;
    }

    /*@Override
    protected VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return FRAME;
    }*/

    @Override
    protected boolean isCollisionShapeFullBlock(BlockState state, BlockGetter level, BlockPos pos) {
        return false;
    }

    @Override
    protected boolean isOcclusionShapeFullBlock(BlockState state, BlockGetter level, BlockPos pos) {
        return false;
    }

    @Override
    protected boolean useShapeForLightOcclusion(BlockState state) {
        return false;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()){
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if(blockEntity instanceof CactiMaterializerBlockEntity cactiMaterializerBlockEntity){
                cactiMaterializerBlockEntity.drops();
            }
        }

        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(!level.isClientSide()){
            BlockEntity entity = level.getBlockEntity(pos);
            if(entity instanceof CactiMaterializerBlockEntity cactiMaterializerBlockEntity){
                ((ServerPlayer) player).openMenu(new SimpleMenuProvider(cactiMaterializerBlockEntity, Component.literal("Cacti Materializer")), pos);
            }else{
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return ItemInteractionResult.sidedSuccess(level.isClientSide());
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if(level.isClientSide){
            return null;
        }

        return createTickerHelper(blockEntityType, ModBlockEntities.CACTI_MATERIALIZER_BE.get(),
                (level1, blockPos, blockState, blockEntity) -> blockEntity.tick(level1, blockPos, blockState));
    }
}
