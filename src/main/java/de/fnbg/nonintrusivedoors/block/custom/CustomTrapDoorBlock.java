package de.fnbg.nonintrusivedoors.block.custom;

import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class CustomTrapDoorBlock extends BlockTrapDoor {

    public CustomTrapDoorBlock(Material material) {
        super(material);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        if (isTrapDoorOpen(world, x, y, z)) {
            return null;
        }
        return super.getCollisionBoundingBoxFromPool(world, x, y, z);
    }

    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z,
                                        AxisAlignedBB mask, List list, Entity entity) {
        if (!isTrapDoorOpen(world, x, y, z)) {
            super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
        }
    }

    /** Metadata bit 0x4 = open. */
    private boolean isTrapDoorOpen(IBlockAccess world, int x, int y, int z) {
        return (world.getBlockMetadata(x, y, z) & 4) != 0;
    }
}
