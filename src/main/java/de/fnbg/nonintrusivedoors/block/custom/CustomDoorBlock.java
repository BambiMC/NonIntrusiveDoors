package de.fnbg.nonintrusivedoors.block.custom;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class CustomDoorBlock extends BlockDoor {

    private final Supplier<Item> droppedItem;

    public CustomDoorBlock(Material material, Supplier<Item> droppedItem) {
        super(material);
        this.droppedItem = droppedItem;
    }

    /**
     * Upper half drops nothing; lower half drops the door item.
     * Overrides BlockDoor which checks (this.blockMaterial == Material.iron), which can
     * give wrong results since we pass the material explicitly.
     */
    @Override
    public Item getItemDropped(int meta, Random rand, int fortune) {
        return (meta & 8) != 0 ? null : droppedItem.get();
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        if (isDoorOpen(world, x, y, z)) {
            return null;
        }
        return super.getCollisionBoundingBoxFromPool(world, x, y, z);
    }

    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z,
                                        AxisAlignedBB mask, List list, Entity entity) {
        if (!isDoorOpen(world, x, y, z)) {
            super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
        }
    }

    /**
     * Door open state is in the lower half (metadata bit 0x4).
     * If we're in the upper half (bit 0x8 set), look one block down.
     */
    private boolean isDoorOpen(IBlockAccess world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        if ((meta & 8) != 0) {
            meta = world.getBlockMetadata(x, y - 1, z);
        }
        return (meta & 4) != 0;
    }
}
