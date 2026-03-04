package com.orecacti.resourcefulcactimod.mixin;

import com.orecacti.resourcefulcactimod.common.block.ModBlocks;
import com.orecacti.resourcefulcactimod.common.block.ModCactusBlock;
import com.orecacti.resourcefulcactimod.common.item.ModItems;
import com.orecacti.resourcefulcactimod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ItemAbilities;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShearsItem.class)
public abstract class ShearsItemMixin {

    @Inject(method = "useOn", at = @At("HEAD"), cancellable = true)
    public void injectUsetItemOn(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir){
        ItemStack itemStack = context.getItemInHand();
        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);
        Player player = context.getPlayer();
        //InteractionHand interactionHand = context.getHand();

        if(!itemStack.canPerformAction(ItemAbilities.SHEARS_CARVE)){
            return;
        }

        if(!(blockState.is(ModTags.Blocks.SHEARABLE_BLOCKS))){
            return;
        }

        if(level.isClientSide){
            cir.setReturnValue(InteractionResult.sidedSuccess(level.isClientSide));
            return;
        }

        BlockState shearedCactus = ModBlocks.SHEARED_CACTUS.get().defaultBlockState();
        level.setBlock(blockPos, shearedCactus, Block.UPDATE_ALL);

        ItemEntity itemEntity = new ItemEntity(
                level,
                blockPos.getX() + 0.5,
                blockPos.getY() + 0.5,
                blockPos.getZ() + 0.5,
                new ItemStack(ModItems.CACTUS_SPIKE.get(), 4)
                );

        level.addFreshEntity(itemEntity);
        //Block.popResource(level, blockPos, new ItemStack(ModItems.CACTUS_SPIKE.get(), 4));
        level.playSound(null, blockPos, SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
        level.gameEvent(player, GameEvent.SHEAR, blockPos);

        if(player != null){
            itemStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
            player.awardStat(Stats.ITEM_USED.get(Items.SHEARS));
        }
        cir.setReturnValue(InteractionResult.SUCCESS);
    }
}
