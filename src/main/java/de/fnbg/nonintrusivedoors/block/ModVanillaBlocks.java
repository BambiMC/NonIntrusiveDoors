package de.fnbg.nonintrusivedoors.block;

import de.fnbg.nonintrusivedoors.block.custom.CustomDoorBlock;
import de.fnbg.nonintrusivedoors.block.custom.CustomTrapDoorBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ModVanillaBlocks {

    /**
     * Called in preInit. Replaces the three vanilla door/trapdoor blocks (and their
     * item references) with custom versions that have no collision when open.
     *
     * In 1.7.10 only two door types and one trapdoor type exist:
     *   wooden_door (oak), iron_door, trapdoor (oak).
     */
    public static void replaceAll() {
        replaceWoodenDoor();
        replaceIronDoor();
        replaceTrapDoor();
    }

    private static void replaceWoodenDoor() {
        CustomDoorBlock custom = new CustomDoorBlock(Material.wood,
                () -> (Item) Item.itemRegistry.getObject("wooden_door"));
        custom.setHardness(3.0f);
        custom.setStepSound(Block.soundTypeWood);
        custom.setBlockName("doorWood");

        int id = Block.getIdFromBlock(Blocks.wooden_door);
        Block.blockRegistry.addObject(id, "wooden_door", custom);
        setStaticFinalField(Blocks.class, "wooden_door", custom);
    }

    private static void replaceIronDoor() {
        CustomDoorBlock custom = new CustomDoorBlock(Material.iron,
                () -> (Item) Item.itemRegistry.getObject("iron_door"));
        custom.setHardness(5.0f);
        custom.setStepSound(Block.soundTypeMetal);
        custom.setBlockName("doorIron");

        int id = Block.getIdFromBlock(Blocks.iron_door);
        Block.blockRegistry.addObject(id, "iron_door", custom);
        setStaticFinalField(Blocks.class, "iron_door", custom);
    }

    private static void replaceTrapDoor() {
        CustomTrapDoorBlock custom = new CustomTrapDoorBlock(Material.wood);
        custom.setHardness(3.0f);
        custom.setStepSound(Block.soundTypeWood);
        custom.setBlockName("trapdoor");

        int id = Block.getIdFromBlock(Blocks.trapdoor);
        Block.blockRegistry.addObject(id, "trapdoor", custom);

        // ItemBlock holds the block reference in a final field — update it
        // so that placing a trapdoor item creates our custom block.
        Item trapDoorItem = Item.getItemFromBlock(Blocks.trapdoor);
        if (trapDoorItem instanceof ItemBlock) {
            setFinalField(ItemBlock.class, "field_150939_a", trapDoorItem, custom);
        }

        setStaticFinalField(Blocks.class, "trapdoor", custom);
    }

    /**
     * Updates a static final field via reflection (Java 8).
     */
    private static void setStaticFinalField(Class<?> clazz, String fieldName, Object value) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            makeWritable(field);
            field.set(null, value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update static field " + clazz.getSimpleName() + "." + fieldName, e);
        }
    }

    /**
     * Updates an instance final field via reflection (Java 8).
     */
    private static void setFinalField(Class<?> clazz, String fieldName, Object instance, Object value) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            makeWritable(field);
            field.set(instance, value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update field " + clazz.getSimpleName() + "." + fieldName, e);
        }
    }

    private static void makeWritable(Field field) throws Exception {
        field.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
    }
}
