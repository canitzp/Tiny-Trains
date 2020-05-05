package de.canitzp.tinytrains;

import de.canitzp.tinytrains.steam.AdvancedMinecraftRenderer;
import de.canitzp.tinytrains.steam.SteamLoco;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber
@Mod(TinyTrains.MODID)
public class TinyTrains {
    
    public static final String MODID = "tinytrains";
    public static final String MODNAME = "Tiny Trains";
    
    public static final Logger LOGGER = LogManager.getLogger(MODNAME);
    
    public static final EntityType<SteamLoco> STEAM_LOCO_ENTITY_TYPE = (EntityType<SteamLoco>) EntityType.Builder.create((EntityType.IFactory<SteamLoco>) SteamLoco::new, EntityClassification.MISC).size(0.98F, 0.7F).setUpdateInterval(1).build("steam_loco").setRegistryName(MODID, "steam_loco");
    
    public TinyTrains() {
        LOGGER.info(String.format("%s was found and is getting loaded. Have fun with your trains :3", MODNAME));
        
        ForgeRegistries.ENTITIES.register(STEAM_LOCO_ENTITY_TYPE);
        //ForgeRegistries.ITEMS.register(new SteamLocoItem());
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::initClient);
    }
    
    public void initClient(final FMLClientSetupEvent event){
        RenderingRegistry.registerEntityRenderingHandler(STEAM_LOCO_ENTITY_TYPE, AdvancedMinecraftRenderer::new);
    }
    
}
