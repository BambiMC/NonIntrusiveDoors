package de.fnbg.nonintrusivedoors.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class CustomTrapDoorBlock extends TrapDoorBlock {

    public CustomTrapDoorBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        if (state.getValue(OPEN)) {
            return VoxelShapes.empty();
        }
        return super.getCollisionShape(state, world, pos, context);
    }
}
