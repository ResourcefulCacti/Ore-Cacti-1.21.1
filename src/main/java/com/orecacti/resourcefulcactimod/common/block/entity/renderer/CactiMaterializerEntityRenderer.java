package com.orecacti.resourcefulcactimod.common.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.orecacti.resourcefulcactimod.common.block.ModBlocks;
import com.orecacti.resourcefulcactimod.common.block.entity.CactiMaterializerBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import static com.orecacti.resourcefulcactimod.common.block.entity.CactiMaterializerBlockEntity.INPUT_SLOT;

public class CactiMaterializerEntityRenderer implements BlockEntityRenderer<CactiMaterializerBlockEntity> {
    public CactiMaterializerEntityRenderer(BlockEntityRendererProvider.Context context){

    }

    @Override
    public void render(CactiMaterializerBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        //ItemStack stack = blockEntity.itemHandler.getStackInSlot(0);
        ItemStack stack = blockEntity.itemHandler.getStackInSlot(INPUT_SLOT);

        BlockRenderDispatcher blockRenderer = Minecraft.getInstance().getBlockRenderer();
        BlockState state = Blocks.POTTED_CACTUS.defaultBlockState();
        BlockState state2 = ModBlocks.POTTED_COAL.get().defaultBlockState();

        poseStack.pushPose();
        //poseStack.translate(0.5f, 0.5f, 0.5f); //For Items
        poseStack.translate(0.25f, 0.25f, 0.25f); // For Blocks
        poseStack.scale(0.5f, 0.5f, 0.5f);
        //poseStack.mulPose(Axis.YP.rotationDegrees(blockEntity.getRenderingRotation()));

        /*itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, getLightLevel(blockEntity.getLevel(),
                blockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, poseStack, bufferSource, blockEntity.getLevel(), 1);*/

        blockRenderer.renderSingleBlock(state2, poseStack, bufferSource, packedLight, OverlayTexture.NO_OVERLAY);


        poseStack.popPose();
    }

    public int getLightLevel(Level level, BlockPos pos){
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);

        return LightTexture.pack(bLight, sLight);
    }
}
