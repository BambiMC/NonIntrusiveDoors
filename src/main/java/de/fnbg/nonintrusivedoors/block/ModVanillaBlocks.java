package de.fnbg.nonintrusivedoors.block;

import de.fnbg.nonintrusivedoors.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import de.fnbg.nonintrusivedoors.block.custom.CustomDoorBlock;
import de.fnbg.nonintrusivedoors.block.custom.CustomTrapDoorBlock;

import java.util.function.Supplier;

public class ModVanillaBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            "minecraft");

    // overwrite vanilla blocks
    public static final RegistryObject<Block> ACACIA_TRAPDOOR = registerBlock("acacia_trapdoor",
            () -> new CustomTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_TRAPDOOR), BlockSetType.ACACIA));

    public static final RegistryObject<Block> ACACIA_DOOR = registerBlock("acacia_door",
            () -> new CustomDoorBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_DOOR),
                    BlockSetType.ACACIA));

    public static final RegistryObject<Block> BAMBOO_TRAPDOOR = registerBlock("bamboo_trapdoor",
            () -> new CustomTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.BAMBOO));

    public static final RegistryObject<Block> BAMBOO_DOOR = registerBlock("bamboo_door",
            () -> new CustomDoorBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_DOOR).sound(SoundType.BAMBOO),
                    BlockSetType.BAMBOO));

    public static final RegistryObject<Block> BIRCH_TRAPDOOR = registerBlock("birch_trapdoor",
            () -> new CustomTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_TRAPDOOR), BlockSetType.BIRCH));

    public static final RegistryObject<Block> BIRCH_DOOR = registerBlock("birch_door",
            () -> new CustomDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR),
                    BlockSetType.BIRCH));

    public static final RegistryObject<Block> CHERRY_TRAPDOOR = registerBlock("cherry_trapdoor",
            () -> new CustomTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_TRAPDOOR), BlockSetType.CHERRY));

    public static final RegistryObject<Block> CHERRY_DOOR = registerBlock("cherry_door",
            () -> new CustomDoorBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_DOOR),
                    BlockSetType.CHERRY));

    public static final RegistryObject<Block> CRIMSON_TRAPDOOR = registerBlock("crimson_trapdoor",
            () -> new CustomTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_TRAPDOOR),
                    BlockSetType.CRIMSON));

    public static final RegistryObject<Block> CRIMSON_DOOR = registerBlock("crimson_door",
            () -> new CustomDoorBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_DOOR),
                    BlockSetType.CRIMSON));

    public static final RegistryObject<Block> DARK_OAK_TRAPDOOR = registerBlock("dark_oak_trapdoor",
            () -> new CustomTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_TRAPDOOR),
                    BlockSetType.DARK_OAK));

    public static final RegistryObject<Block> DARK_OAK_DOOR = registerBlock("dark_oak_door",
            () -> new CustomDoorBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR).sound(SoundType.WOOD),
                    BlockSetType.DARK_OAK));

    public static final RegistryObject<Block> IRON_TRAPDOOR = registerBlock("iron_trapdoor",
            () -> new CustomTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_TRAPDOOR), BlockSetType.IRON));

    public static final RegistryObject<Block> IRON_DOOR = registerBlock("iron_door",
            () -> new CustomDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_DOOR),
                    BlockSetType.IRON));

    public static final RegistryObject<Block> JUNGLE_TRAPDOOR = registerBlock("jungle_trapdoor",
            () -> new CustomTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_TRAPDOOR), BlockSetType.JUNGLE));

    public static final RegistryObject<Block> JUNGLE_DOOR = registerBlock("jungle_door",
            () -> new CustomDoorBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_DOOR).sound(SoundType.WOOD),
                    BlockSetType.JUNGLE));

    public static final RegistryObject<Block> MANGROVE_TRAPDOOR = registerBlock("mangrove_trapdoor",
            () -> new CustomTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_TRAPDOOR),
                    BlockSetType.MANGROVE));

    public static final RegistryObject<Block> MANGROVE_DOOR = registerBlock("mangrove_door",
            () -> new CustomDoorBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_DOOR).sound(SoundType.WOOD),
                    BlockSetType.MANGROVE));

    public static final RegistryObject<Block> OAK_TRAPDOOR = registerBlock("oak_trapdoor",
            () -> new CustomTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));

    public static final RegistryObject<Block> OAK_DOOR = registerBlock("oak_door",
            () -> new CustomDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.WOOD),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> SPRUCE_TRAPDOOR = registerBlock("spruce_trapdoor",
            () -> new CustomTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR), BlockSetType.SPRUCE));

    public static final RegistryObject<Block> SPRUCE_DOOR = registerBlock("spruce_door",
            () -> new CustomDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_DOOR),
                    BlockSetType.SPRUCE));

    public static final RegistryObject<Block> WARPED_TRAPDOOR = registerBlock("warped_trapdoor",
            () -> new CustomTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_TRAPDOOR), BlockSetType.WARPED));

    public static final RegistryObject<Block> WARPED_DOOR = registerBlock("warped_door",
            () -> new CustomDoorBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_DOOR),
                    BlockSetType.WARPED));

    // register methods

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}