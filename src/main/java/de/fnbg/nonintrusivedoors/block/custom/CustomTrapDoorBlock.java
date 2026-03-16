package de.fnbg.nonintrusivedoors.block.custom;

import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nullable;

public class CustomTrapDoorBlock extends BlockTrapDoor {

    public CustomTrapDoorBlock(Material material, SoundType soundType) {
        super(material);
        this.setSoundType(soundType);
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        if (blockState.getValue(OPEN)) {
            return NULL_AABB;
        }
        return super.getCollisionBoundingBox(blockState, worldIn, pos);
    }
}
