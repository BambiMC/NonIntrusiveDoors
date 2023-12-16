package de.fnbg.nonintrusivedoors;

import com.mojang.logging.LogUtils;
import de.fnbg.nonintrusivedoors.block.ModBlocks;
import de.fnbg.nonintrusivedoors.block.ModVanillaBlocks;
import de.fnbg.nonintrusivedoors.item.ModCreativeModTabs;
import de.fnbg.nonintrusivedoors.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NonIntrusiveDoors.MOD_ID)
public class NonIntrusiveDoors {
    public static final String MOD_ID = "nonintrusivedoors";
    public static final Logger LOGGER = LogUtils.getLogger();

    public NonIntrusiveDoors() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModVanillaBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
        // event.accept(ModItems.SAPPHIRE);
        // event.accept(ModItems.RAW_SAPPHIRE);
        // event.accept(ModBlocks.SAPPHIRE_BLOCK);
        // event.accept(ModBlocks.RAW_SAPPHIRE_BLOCK);
        // }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods
    // in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}