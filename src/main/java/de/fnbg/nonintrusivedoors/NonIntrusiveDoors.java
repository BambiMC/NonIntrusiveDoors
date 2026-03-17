package de.fnbg.nonintrusivedoors;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.fnbg.nonintrusivedoors.block.ModVanillaBlocks;

@Mod(modid = NonIntrusiveDoors.MOD_ID, name = "Non Intrusive Doors", version = "@VERSION@",
        acceptedMinecraftVersions = "[1.7.10]")
public class NonIntrusiveDoors {

    public static final String MOD_ID = "nonintrusivedoors";

    @Mod.Instance
    public static NonIntrusiveDoors instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModVanillaBlocks.replaceAll();
    }
}
