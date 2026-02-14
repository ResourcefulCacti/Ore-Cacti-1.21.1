package com.orecacti.resourcefulcactimod.datagen;

import com.orecacti.resourcefulcactimod.ResourcefulCactiMod;
import com.orecacti.resourcefulcactimod.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ResourcefulCactiMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        cactusBlock(ModBlocks.SHEARED_CACTUS);
        cactusBlock(ModBlocks.COAL_CACTUS);
        cactusBlock(ModBlocks.IRON_CACTUS);
        cactusBlock(ModBlocks.COPPER_CACTUS);
        cactusBlock(ModBlocks.AMETHYST_CACTUS);
        cactusBlock(ModBlocks.DIAMOND_CACTUS);
        cactusBlock(ModBlocks.EMERALD_CACTUS);
        cactusBlock(ModBlocks.GLOWSTONE_CACTUS);
        cactusBlock(ModBlocks.GOLD_CACTUS);
        cactusBlock(ModBlocks.LAPIS_CACTUS);
        cactusBlock(ModBlocks.NETHERITE_CACTUS);
        cactusBlock(ModBlocks.QUARTZ_CACTUS);
        cactusBlock(ModBlocks.REDSTONE_CACTUS);
        cactusBlock(ModBlocks.CREEPER_CACTUS);
    }

    /*private void cactusBlock(DeferredBlock<?> block) {
        String name = block.getId().getPath();

        ModelFile model = models()
                .withExistingParent(name, mcLoc("block/block"))
                .renderType("cutout")
                .texture("side", modLoc("block/" + name + "_side"))
                .texture("top", modLoc("block/" + name + "_top"))
                .texture("bottom", modLoc("block/cactus_bottom"))
                .texture("particle", modLoc("block/" + name + "_side"))
                .element()
                .from(1, 0, 1)
                .to(15, 16, 15)
                .allFaces((dir, face) -> {
                    switch (dir) {
                        case UP -> face.texture("#top");
                        case DOWN -> face.texture("#bottom");
                        default -> face.texture("#side");
                    }
                })
                .end();

        simpleBlockWithItem(block.get(), model);
    }*/

    private void cactusBlock(DeferredBlock<?> block) {
        String name = block.getId().getPath();

        ModelFile model = models()
                .withExistingParent(name, mcLoc("block/block"))
                .renderType("cutout")
                .texture("side", modLoc("block/" + name + "_side"))
                .texture("top", modLoc("block/" + name + "_top"))
                .texture("bottom", modLoc("block/cactus_bottom"))
                .texture("particle", modLoc("block/" + name + "_side"))

                // Top & Bottom element
                .element()
                .from(0, 0, 0)
                .to(16, 16, 16)
                .face(Direction.DOWN)
                .texture("#bottom")
                .uvs(0, 0, 16, 16)
                .cullface(Direction.DOWN)
                .end()
                .face(Direction.UP)
                .texture("#top")
                .uvs(0, 0, 16, 16)
                .cullface(Direction.UP)
                .end()
                .end()

                // North/South inset
                .element()
                .from(0, 0, 1)
                .to(16, 16, 15)
                .face(Direction.NORTH)
                .texture("#side")
                .uvs(0, 0, 16, 16)
                .end()
                .face(Direction.SOUTH)
                .texture("#side")
                .uvs(0, 0, 16, 16)
                .end()
                .end()

                // East/West inset
                .element()
                .from(1, 0, 0)
                .to(15, 16, 16)
                .face(Direction.WEST)
                .texture("#side")
                .uvs(0, 0, 16, 16)
                .end()
                .face(Direction.EAST)
                .texture("#side")
                .uvs(0, 0, 16, 16)
                .end()
                .end();

        simpleBlockWithItem(block.get(), model);
    }

}
