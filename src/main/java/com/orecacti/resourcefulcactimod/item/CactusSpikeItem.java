package com.orecacti.resourcefulcactimod.item;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import com.orecacti.resourcefulcactimod.block.ModBlocks;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Map;

public class CactusSpikeItem extends Item {

    private static final Map<Block, DeferredItem<? extends Item>> SPIKE_MAP =
            Map.ofEntries(
              Map.entry(Blocks.COPPER_BLOCK, ModItems.COPPER_CACTUS_SPIKE),
              Map.entry(Blocks.IRON_BLOCK, ModItems.IRON_CACTUS_SPIKE),
              Map.entry(Blocks.AMETHYST_BLOCK, ModItems.AMETHYST_CACTUS_SPIKE),
              Map.entry(Blocks.COAL_BLOCK, ModItems.COAL_CACTUS_SPIKE),
              Map.entry(Blocks.DIAMOND_BLOCK, ModItems.DIAMOND_CACTUS_SPIKE),
              Map.entry(Blocks.EMERALD_BLOCK, ModItems.EMERALD_CACTUS_SPIKE),
              Map.entry(Blocks.GLOWSTONE, ModItems.GLOWSTONE_CACTUS_SPIKE),
              Map.entry(Blocks.GOLD_BLOCK, ModItems.GOLD_CACTUS_SPIKE),
              Map.entry(Blocks.LAPIS_BLOCK, ModItems.LAPIS_CACTUS_SPIKE),
              Map.entry(Blocks.NETHERITE_BLOCK, ModItems.NETHERITE_CACTUS_SPIKE),
              Map.entry(Blocks.QUARTZ_BLOCK, ModItems.QUARTZ_CACTUS_SPIKE),
              Map.entry(Blocks.REDSTONE_BLOCK, ModItems.REDSTONE_CACTUS_SPIKE)
            );

    public CactusSpikeItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level  = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(SPIKE_MAP.containsKey(clickedBlock)){
            if(!level.isClientSide){
                level.destroyBlock(context.getClickedPos(), false);

                context.getItemInHand().shrink(1);

                DeferredItem<? extends Item> asd = SPIKE_MAP.get(clickedBlock);
                ItemStack spikeItem = new ItemStack(asd.get());
                context.getPlayer().getInventory().placeItemBackInInventory(spikeItem);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {
        Level level = player.level();

        if(!player.level().isClientSide){
            if(interactionTarget.getType() == EntityType.CREEPER) {
                ItemStack reward = new ItemStack(ModBlocks.CREEPER_CACTUS.asItem());

                ItemEntity droppedItem = new ItemEntity(
                        level,
                        interactionTarget.getX(),
                        interactionTarget.getY(),
                        interactionTarget.getZ(),
                        reward
                );
                level.addFreshEntity(droppedItem);

                player.getItemInHand(usedHand).shrink(1);
                interactionTarget.discard();
                //player.getInventory().placeItemBackInInventory(reward);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
}
