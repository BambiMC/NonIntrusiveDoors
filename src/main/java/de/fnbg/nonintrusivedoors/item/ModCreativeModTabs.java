package de.fnbg.nonintrusivedoors.item;

import de.fnbg.nonintrusivedoors.NonIntrusiveDoors;
import de.fnbg.nonintrusivedoors.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import de.fnbg.nonintrusivedoors.block.custom.CustomDoorBlock;
import de.fnbg.nonintrusivedoors.block.custom.CustomTrapDoorBlock;
import de.fnbg.nonintrusivedoors.block.ModVanillaBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, NonIntrusiveDoors.MOD_ID);

    // public static final RegistryObject<CreativeModeTab> NO_INTRUSIVE_DOORS_TAB =
    // CREATIVE_MODE_TABS.register(
    // "nonintrusivedoors_tab",
    // () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ID.get()))
    // .title(Component.translatable("creativetab.nonintrusivedoors_tab"))
    // .displayItems((pParameters, pOutput) -> {

    // //pOutput.accept(Items.COAL);

    // })
    // .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}