package com.orecacti.resourcefulcactimod.common.block.entity;

import com.orecacti.resourcefulcactimod.common.block.ModBlocks;
import com.orecacti.resourcefulcactimod.common.item.ModItems;
import com.orecacti.resourcefulcactimod.screen.CactiMaterializerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class CactiMaterializerBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemHandler = new ItemStackHandler(2){
        @Override
        public int getSlotLimit(int slot) {
            if(slot == INPUT_SLOT){
                return 1;
            }
            return super.getSlotLimit(slot);
        }

        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            if(slot == OUTPUT_SLOT){
                return false;
            }
            return super.isItemValid(slot, stack);
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()){
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    public static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    protected final ContainerData data;

    private final int SPEED = 72;
    private int progress = 0;
    private int maxProgress = SPEED;

    public CactiMaterializerBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.CACTI_MATERIALIZER_BE.get(), pos, blockState);
        data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch(index){
                    case 0 -> CactiMaterializerBlockEntity.this.progress;
                    case 1 -> CactiMaterializerBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0: CactiMaterializerBlockEntity.this.progress = value;
                    case 1: CactiMaterializerBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.grodomirsresourcefulcactimod.cacti_materializer");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new CactiMaterializerMenu(containerId, playerInventory,this, this.data);
    }

    public void drops(){
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++){
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    private float rotation;

    public float getRenderingRotation() {
        rotation += 0.5f;
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("inventory", itemHandler.serializeNBT(registries));
        tag.putInt("cacti_materializer.progress", progress);
        tag.putInt("cacti_materializer.max_progress", maxProgress);

        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);

        itemHandler.deserializeNBT(registries, tag.getCompound("inventory"));
        progress = tag.getInt("cacti_materializer.progress");
        maxProgress = tag.getInt("cacti_materializer.max_progress");
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        if(hasRecipe()){
            increaseCraftingProgres();
            setChanged(level, blockPos, blockState);

            if(hasCraftingFinished()){
                craftItem();
                resetProgress();
            }
        }else{
            resetProgress();
        }
    }

    private void craftItem() {
        ItemStack output = new ItemStack(ModBlocks.COAL_CACTUS.asItem());

        //itemHandler.extractItem(INPUT_SLOT, 1, false);
        itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(output.getItem(),
                itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + output.getCount()));
    }


    private void resetProgress() {
        progress = 0;
        maxProgress = SPEED;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgres() {
        progress++;
    }

    private boolean hasRecipe() {
        ItemStack output = new ItemStack(ModBlocks.COAL_CACTUS.asItem());
        return itemHandler.getStackInSlot(INPUT_SLOT).is(ModBlocks.COAL_CACTUS.asItem()) &&
                canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ||
                itemHandler.getStackInSlot(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ? 64 : itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
        int currentCount = itemHandler.getStackInSlot(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return super.getUpdateTag(registries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return super.getUpdatePacket();
    }

    public IItemHandler getItemHandlerCapability(@Nullable Direction direction) {
        return itemHandler;
    }
}
