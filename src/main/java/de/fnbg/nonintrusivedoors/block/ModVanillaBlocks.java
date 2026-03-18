package de.fnbg.nonintrusivedoors.block;

import de.fnbg.nonintrusivedoors.block.custom.CustomDoorBlock;
import de.fnbg.nonintrusivedoors.block.custom.CustomTrapDoorBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import com.google.common.collect.BiMap;
import net.minecraft.util.ObjectIntIdentityMap;
import net.minecraft.util.RegistryNamespaced;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

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
        custom.setBlockTextureName("door_wood");

        swapBlockInRegistry(Blocks.wooden_door, custom, "minecraft:wooden_door");
    }

    private static void replaceIronDoor() {
        CustomDoorBlock custom = new CustomDoorBlock(Material.iron,
                () -> (Item) Item.itemRegistry.getObject("iron_door"));
        custom.setHardness(5.0f);
        custom.setStepSound(Block.soundTypeMetal);
        custom.setBlockName("doorIron");
        custom.setBlockTextureName("door_iron");

        swapBlockInRegistry(Blocks.iron_door, custom, "minecraft:iron_door");
    }

    private static void replaceTrapDoor() {
        CustomTrapDoorBlock custom = new CustomTrapDoorBlock(Material.wood);
        custom.setHardness(3.0f);
        custom.setStepSound(Block.soundTypeWood);
        custom.setBlockName("trapdoor");
        custom.setBlockTextureName("trapdoor");

        // Grab the ItemBlock before swapping — trapdoor has an ItemBlock at the same
        // numeric id as the block (96). We update its internal block reference so that
        // placing a trapdoor item still creates our custom block.
        Item trapDoorItem = Item.getItemFromBlock(Blocks.trapdoor);

        swapBlockInRegistry(Blocks.trapdoor, custom, "minecraft:trapdoor");

        if (trapDoorItem instanceof ItemBlock) {
            setFinalField(ItemBlock.class, "field_150939_a", trapDoorItem, custom);
        }
    }

    /**
     * Replaces {@code old} with {@code custom} directly inside the block registry's
     * internal maps, without calling {@link net.minecraft.util.RegistryNamespaced#addObject}.
     *
     * Calling addObject triggers FML's item-registration side effects, which corrupt
     * the ItemBlock identity mapping for blocks (like trapdoor) that share their
     * numeric id with an ItemBlock in the item registry. Direct map surgery avoids that.
     *
     * Field discovery strategy (must work in both dev/MCP and production/SRG environments):
     *
     *   ObjectIntIdentityMap in RegistryNamespaced
     *     → found by TYPE: MCP calls it "underlyingIntegerMap"; SRG uses a different name.
     *       Type-based search is name-agnostic and works in both environments.
     *
     *   ObjectIntIdentityMap.field_148749_a  — IdentityHashMap object → id
     *   ObjectIntIdentityMap.field_148748_b  — ArrayList       id     → object
     *     → SRG names with no MCP mapping; identical in both environments.
     *
     *   RegistryNamespaced.field_148758_b  — inverse BiMap (block → name)
     *     → SRG name with no MCP mapping; identical in both environments.
     *       It is a live view of registryObjects, so forcePut here also updates
     *       the forward map (registryObjects / name → block).
     */
    @SuppressWarnings("unchecked")
    private static void swapBlockInRegistry(Block old, Block custom, String fullRegistryName) {
        try {
            int id = Block.getIdFromBlock(old);

            // Find the ObjectIntIdentityMap by TYPE — avoids the MCP-vs-SRG name mismatch.
            Field idMapField = findFieldByType(RegistryNamespaced.class, ObjectIntIdentityMap.class);
            ObjectIntIdentityMap idMap = (ObjectIntIdentityMap) idMapField.get(Block.blockRegistry);

            // SRG names (no MCP mapping) — same in dev and production.
            Field objToIdField = ObjectIntIdentityMap.class.getDeclaredField("field_148749_a");
            objToIdField.setAccessible(true);
            Map<Object, Integer> objToId = (Map<Object, Integer>) objToIdField.get(idMap);

            Field idToObjField = ObjectIntIdentityMap.class.getDeclaredField("field_148748_b");
            idToObjField.setAccessible(true);
            List<Object> idToObj = (List<Object>) idToObjField.get(idMap);

            objToId.remove(old);
            objToId.put(custom, id);
            idToObj.set(id, custom);

            // field_148758_b is the inverse BiMap (block→name) in RegistryNamespaced.
            // SRG name with no MCP mapping — same in both environments.
            // forcePut(custom, name) removes the old block's entry for that name and adds
            // the new one, automatically updating the forward map (registryObjects) as a view.
            Field invField = RegistryNamespaced.class.getDeclaredField("field_148758_b");
            invField.setAccessible(true);
            BiMap<Object, Object> inverse = (BiMap<Object, Object>) invField.get(Block.blockRegistry);
            inverse.forcePut(custom, fullRegistryName);

            // FML's FMLControlledNamespacedRegistry may keep its own inverseObjectRegistry.
            // FML classes are not obfuscated, so this name is stable across environments.
            try {
                Field fmlInvField = Block.blockRegistry.getClass().getDeclaredField("inverseObjectRegistry");
                fmlInvField.setAccessible(true);
                Map<Object, Object> fmlInverse = (Map<Object, Object>) fmlInvField.get(Block.blockRegistry);
                Object name = fmlInverse.remove(old);
                if (name != null) fmlInverse.put(custom, name);
            } catch (NoSuchFieldException ignored) {}

        } catch (Exception e) {
            throw new RuntimeException("Failed to swap block in registry: " + fullRegistryName, e);
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

    /** Finds the first declared field of the given type in {@code owner} (not its superclasses). */
    private static Field findFieldByType(Class<?> owner, Class<?> type) throws NoSuchFieldException {
        for (Field f : owner.getDeclaredFields()) {
            if (f.getType() == type) {
                f.setAccessible(true);
                return f;
            }
        }
        throw new NoSuchFieldException("No field of type " + type.getName() + " in " + owner.getName());
    }

    private static void makeWritable(Field field) throws Exception {
        field.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
    }
}
