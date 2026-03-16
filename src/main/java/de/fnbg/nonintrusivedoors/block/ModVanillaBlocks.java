package de.fnbg.nonintrusivedoors.block;

import de.fnbg.nonintrusivedoors.NonIntrusiveDoors;
import de.fnbg.nonintrusivedoors.block.custom.CustomDoorBlock;
import de.fnbg.nonintrusivedoors.block.custom.CustomTrapDoorBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDoor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = NonIntrusiveDoors.MOD_ID)
public class ModVanillaBlocks {

    // Saved for use in registerItems — blocks are registered before items
    private static CustomDoorBlock WOODEN_DOOR, SPRUCE_DOOR, BIRCH_DOOR, JUNGLE_DOOR, ACACIA_DOOR, DARK_OAK_DOOR, IRON_DOOR;
    private static CustomTrapDoorBlock TRAPDOOR, IRON_TRAPDOOR;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        // Block translation keys must match vanilla tile.*.name lang keys
        WOODEN_DOOR   = door("wooden_door",   Material.WOOD, 3.0F, "doorWood",    SoundType.WOOD);
        SPRUCE_DOOR   = door("spruce_door",   Material.WOOD, 3.0F, "doorWood",    SoundType.WOOD);
        BIRCH_DOOR    = door("birch_door",    Material.WOOD, 3.0F, "doorWood",    SoundType.WOOD);
        JUNGLE_DOOR   = door("jungle_door",   Material.WOOD, 3.0F, "doorWood",    SoundType.WOOD);
        ACACIA_DOOR   = door("acacia_door",   Material.WOOD, 3.0F, "doorWood",    SoundType.WOOD);
        DARK_OAK_DOOR = door("dark_oak_door", Material.WOOD, 3.0F, "doorWood",    SoundType.WOOD);
        IRON_DOOR     = door("iron_door",     Material.IRON, 5.0F, "doorIron",    SoundType.METAL);
        TRAPDOOR      = trapdoor("trapdoor",       Material.WOOD, 3.0F, "trapdoor",    SoundType.WOOD);
        IRON_TRAPDOOR = trapdoor("iron_trapdoor",  Material.IRON, 5.0F, "ironTrapdoor",SoundType.METAL);

        event.getRegistry().register(WOODEN_DOOR);
        event.getRegistry().register(SPRUCE_DOOR);
        event.getRegistry().register(BIRCH_DOOR);
        event.getRegistry().register(JUNGLE_DOOR);
        event.getRegistry().register(ACACIA_DOOR);
        event.getRegistry().register(DARK_OAK_DOOR);
        event.getRegistry().register(IRON_DOOR);
        event.getRegistry().register(TRAPDOOR);
        event.getRegistry().register(IRON_TRAPDOOR);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        // Replace vanilla door items so they place our custom blocks (which have no collision when open)
        // Item translation keys match vanilla item.*.name lang keys
        event.getRegistry().register(new ItemDoor(WOODEN_DOOR)  .setTranslationKey("doorOak")    .setRegistryName("minecraft", "wooden_door"));
        event.getRegistry().register(new ItemDoor(SPRUCE_DOOR)  .setTranslationKey("doorSpruce") .setRegistryName("minecraft", "spruce_door"));
        event.getRegistry().register(new ItemDoor(BIRCH_DOOR)   .setTranslationKey("doorBirch")  .setRegistryName("minecraft", "birch_door"));
        event.getRegistry().register(new ItemDoor(JUNGLE_DOOR)  .setTranslationKey("doorJungle") .setRegistryName("minecraft", "jungle_door"));
        event.getRegistry().register(new ItemDoor(ACACIA_DOOR)  .setTranslationKey("doorAcacia") .setRegistryName("minecraft", "acacia_door"));
        event.getRegistry().register(new ItemDoor(DARK_OAK_DOOR).setTranslationKey("doorDarkOak").setRegistryName("minecraft", "dark_oak_door"));
        event.getRegistry().register(new ItemDoor(IRON_DOOR)    .setTranslationKey("doorIron")   .setRegistryName("minecraft", "iron_door"));

        // Replace trapdoor items — trapdoors use ItemBlock, not ItemDoor
        event.getRegistry().register(new ItemBlock(TRAPDOOR)      .setTranslationKey("trapdoor")    .setRegistryName("minecraft", "trapdoor"));
        event.getRegistry().register(new ItemBlock(IRON_TRAPDOOR) .setTranslationKey("ironTrapdoor").setRegistryName("minecraft", "iron_trapdoor"));
    }

    private static CustomDoorBlock door(String name, Material material, float hardness, String translationKey, SoundType sound) {
        CustomDoorBlock block = new CustomDoorBlock(material, sound,
                () -> Item.getByNameOrId("minecraft:" + name));
        block.setHardness(hardness);
        block.setTranslationKey(translationKey);
        block.setRegistryName("minecraft", name);
        return block;
    }

    private static CustomTrapDoorBlock trapdoor(String name, Material material, float hardness, String translationKey, SoundType sound) {
        CustomTrapDoorBlock block = new CustomTrapDoorBlock(material, sound);
        block.setHardness(hardness);
        block.setTranslationKey(translationKey);
        block.setRegistryName("minecraft", name);
        return block;
    }
}
