package de.fnbg.nonintrusivedoors;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = NonIntrusiveDoors.MOD_ID, name = "Non Intrusive Doors", version = "@VERSION@",
        acceptedMinecraftVersions = "[1.12,1.13)")
public class NonIntrusiveDoors {

    public static final String MOD_ID = "nonintrusivedoors";

    @Mod.Instance
    public static NonIntrusiveDoors instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }
}
