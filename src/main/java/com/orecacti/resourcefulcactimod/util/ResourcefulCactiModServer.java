package com.orecacti.resourcefulcactimod.util;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import com.orecacti.resourcefulcactimod.block.ModBlocks;
import com.orecacti.resourcefulcactimod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@Mod(value = ResourcefulCactiMod.MOD_ID, dist = Dist.DEDICATED_SERVER)

@EventBusSubscriber(modid = ResourcefulCactiMod.MOD_ID, value = Dist.DEDICATED_SERVER)
public class ResourcefulCactiModServer {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        if (level.isClientSide()) return;

        ItemStack stack = event.getItemStack();
        if (!(stack.getItem() instanceof ShearsItem)) return;

        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);

        if (!state.is(ModTags.Blocks.SHEARABLE_BLOCKS)) return;

        Player player = event.getEntity();

        BlockState shearedState = ModBlocks.SHEARED_CACTUS.get()
                .defaultBlockState();

        EquipmentSlot slot = event.getHand() == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;

        if (player != null) {
            stack.hurtAndBreak(1, player, slot);
        }

        Containers.dropItemStack(
                level,
                pos.getX() + 0.5,
                pos.getY() + 0.5,
                pos.getZ() + 0.5,
                new ItemStack(ModItems.CACTUS_SPIKE.get(), 4)
        );

        level.setBlock(pos, shearedState, Block.UPDATE_ALL);

        level.playSound(
                null,
                pos,
                SoundEvents.SHEEP_SHEAR,
                SoundSource.BLOCKS,
                1.0F,
                1.0F
        );

        event.setCanceled(true);
        event.setCancellationResult(InteractionResult.SUCCESS);
    }
}
