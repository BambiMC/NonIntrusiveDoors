package de.fnbg.nonintrusivedoors.block;

import de.fnbg.nonintrusivedoors.NonIntrusiveDoors;
import de.fnbg.nonintrusivedoors.block.custom.CustomDoorBlock;
import de.fnbg.nonintrusivedoors.block.custom.CustomTrapDoorBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.TallBlockItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NonIntrusiveDoors.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModVanillaBlocks {

    // Saved for use in registerItems — blocks are registered before items
    private static CustomDoorBlock OAK_DOOR, SPRUCE_DOOR, BIRCH_DOOR, JUNGLE_DOOR,
            ACACIA_DOOR, DARK_OAK_DOOR, CRIMSON_DOOR, WARPED_DOOR, IRON_DOOR;
    private static CustomTrapDoorBlock OAK_TRAPDOOR, SPRUCE_TRAPDOOR, BIRCH_TRAPDOOR,
            JUNGLE_TRAPDOOR, ACACIA_TRAPDOOR, DARK_OAK_TRAPDOOR, CRIMSON_TRAPDOOR,
            WARPED_TRAPDOOR, IRON_TRAPDOOR;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        OAK_DOOR      = door(Blocks.OAK_DOOR,      "oak_door");
        SPRUCE_DOOR   = door(Blocks.SPRUCE_DOOR,    "spruce_door");
        BIRCH_DOOR    = door(Blocks.BIRCH_DOOR,     "birch_door");
        JUNGLE_DOOR   = door(Blocks.JUNGLE_DOOR,    "jungle_door");
        ACACIA_DOOR   = door(Blocks.ACACIA_DOOR,    "acacia_door");
        DARK_OAK_DOOR = door(Blocks.DARK_OAK_DOOR,  "dark_oak_door");
        CRIMSON_DOOR  = door(Blocks.CRIMSON_DOOR,   "crimson_door");
        WARPED_DOOR   = door(Blocks.WARPED_DOOR,    "warped_door");
        IRON_DOOR     = door(Blocks.IRON_DOOR,      "iron_door");

        OAK_TRAPDOOR      = trapdoor(Blocks.OAK_TRAPDOOR,      "oak_trapdoor");
        SPRUCE_TRAPDOOR   = trapdoor(Blocks.SPRUCE_TRAPDOOR,    "spruce_trapdoor");
        BIRCH_TRAPDOOR    = trapdoor(Blocks.BIRCH_TRAPDOOR,     "birch_trapdoor");
        JUNGLE_TRAPDOOR   = trapdoor(Blocks.JUNGLE_TRAPDOOR,    "jungle_trapdoor");
        ACACIA_TRAPDOOR   = trapdoor(Blocks.ACACIA_TRAPDOOR,    "acacia_trapdoor");
        DARK_OAK_TRAPDOOR = trapdoor(Blocks.DARK_OAK_TRAPDOOR,  "dark_oak_trapdoor");
        CRIMSON_TRAPDOOR  = trapdoor(Blocks.CRIMSON_TRAPDOOR,   "crimson_trapdoor");
        WARPED_TRAPDOOR   = trapdoor(Blocks.WARPED_TRAPDOOR,    "warped_trapdoor");
        IRON_TRAPDOOR     = trapdoor(Blocks.IRON_TRAPDOOR,      "iron_trapdoor");

        event.getRegistry().registerAll(
                OAK_DOOR, SPRUCE_DOOR, BIRCH_DOOR, JUNGLE_DOOR,
                ACACIA_DOOR, DARK_OAK_DOOR, CRIMSON_DOOR, WARPED_DOOR, IRON_DOOR,
                OAK_TRAPDOOR, SPRUCE_TRAPDOOR, BIRCH_TRAPDOOR, JUNGLE_TRAPDOOR,
                ACACIA_TRAPDOOR, DARK_OAK_TRAPDOOR, CRIMSON_TRAPDOOR, WARPED_TRAPDOOR, IRON_TRAPDOOR
        );
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        Item.Properties building = new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS);

        // Replace vanilla door items so they place our custom blocks
        event.getRegistry().registerAll(
                new TallBlockItem(OAK_DOOR,      building).setRegistryName("minecraft:oak_door"),
                new TallBlockItem(SPRUCE_DOOR,   building).setRegistryName("minecraft:spruce_door"),
                new TallBlockItem(BIRCH_DOOR,    building).setRegistryName("minecraft:birch_door"),
                new TallBlockItem(JUNGLE_DOOR,   building).setRegistryName("minecraft:jungle_door"),
                new TallBlockItem(ACACIA_DOOR,   building).setRegistryName("minecraft:acacia_door"),
                new TallBlockItem(DARK_OAK_DOOR, building).setRegistryName("minecraft:dark_oak_door"),
                new TallBlockItem(CRIMSON_DOOR,  building).setRegistryName("minecraft:crimson_door"),
                new TallBlockItem(WARPED_DOOR,   building).setRegistryName("minecraft:warped_door"),
                new TallBlockItem(IRON_DOOR,     building).setRegistryName("minecraft:iron_door"),

                // Replace trapdoor items — trapdoors use BlockItem, not TallBlockItem
                new BlockItem(OAK_TRAPDOOR,      building).setRegistryName("minecraft:oak_trapdoor"),
                new BlockItem(SPRUCE_TRAPDOOR,   building).setRegistryName("minecraft:spruce_trapdoor"),
                new BlockItem(BIRCH_TRAPDOOR,    building).setRegistryName("minecraft:birch_trapdoor"),
                new BlockItem(JUNGLE_TRAPDOOR,   building).setRegistryName("minecraft:jungle_trapdoor"),
                new BlockItem(ACACIA_TRAPDOOR,   building).setRegistryName("minecraft:acacia_trapdoor"),
                new BlockItem(DARK_OAK_TRAPDOOR, building).setRegistryName("minecraft:dark_oak_trapdoor"),
                new BlockItem(CRIMSON_TRAPDOOR,  building).setRegistryName("minecraft:crimson_trapdoor"),
                new BlockItem(WARPED_TRAPDOOR,   building).setRegistryName("minecraft:warped_trapdoor"),
                new BlockItem(IRON_TRAPDOOR,     building).setRegistryName("minecraft:iron_trapdoor")
        );
    }

    private static CustomDoorBlock door(Block vanilla, String name) {
        return (CustomDoorBlock) new CustomDoorBlock(AbstractBlock.Properties.copy(vanilla))
                .setRegistryName("minecraft", name);
    }

    private static CustomTrapDoorBlock trapdoor(Block vanilla, String name) {
        return (CustomTrapDoorBlock) new CustomTrapDoorBlock(AbstractBlock.Properties.copy(vanilla))
                .setRegistryName("minecraft", name);
    }
}
