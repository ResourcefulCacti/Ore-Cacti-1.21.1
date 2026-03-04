package com.orecacti.resourcefulcactimod.util;

import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Collection;

public class VoxelShapeUtils {

    public static VoxelShape combine(VoxelShape... shapes) {
        return batchCombine(Shapes.empty(), BooleanOp.OR, true, shapes);
    }

    public static VoxelShape combine(Collection<VoxelShape> shapes){
        return batchCombine(Shapes.empty(), BooleanOp.OR, true, shapes);
    }

    public static VoxelShape exclude(VoxelShape... shapes){
        return batchCombine(Shapes.block(), BooleanOp.ONLY_FIRST, true, shapes);
    }

    public static VoxelShape batchCombine(VoxelShape initial, BooleanOp function, boolean simplify, Collection<VoxelShape> shapes){
        VoxelShape combinedShape = initial;
        for(VoxelShape shape : shapes){
            combinedShape = Shapes.joinUnoptimized(combinedShape, shape, function);
        }

        return simplify ? combinedShape.optimize() : combinedShape;
    }

    public static VoxelShape batchCombine(VoxelShape initial, BooleanOp function, boolean simplify, VoxelShape... shapes){
        VoxelShape combinedShape = initial;
        for(VoxelShape shape : shapes){
            combinedShape = Shapes.joinUnoptimized(combinedShape, shape, function);
        }
        return simplify ? combinedShape.optimize() : combinedShape;
    }
}
