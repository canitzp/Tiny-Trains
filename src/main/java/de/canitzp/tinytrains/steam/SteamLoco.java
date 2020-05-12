package de.canitzp.tinytrains.steam;

import de.canitzp.tinytrains.AdvancedMinecartEntity;
import de.canitzp.tinytrains.TinyTrains;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SteamLoco extends AdvancedMinecartEntity<SteamLoco> {
    
    public SteamLoco(World world){
        super(TinyTrains.STEAM_LOCO_ENTITY_TYPE, world);
    }
    
    public SteamLoco(EntityType<?> type, World world) {
        super(type, world);
    }
    
    public SteamLoco(World worldIn, double posX, double posY, double posZ) {
        super(TinyTrains.STEAM_LOCO_ENTITY_TYPE, worldIn, posX, posY, posZ);
    }
    
    @Override
    public ItemStack getCartItem() {
        return new ItemStack(Items.PUMPKIN);
    }
    
    @Override
    public boolean isPoweredCart() {
        return true;
    }
    
    @Override
    public boolean canBeRidden() {
        return false;
    }
    
    @Override
    public EntityModel<SteamLoco> createModel() {
        return new SteamLocoModel();
    }
    
    @Override
    public ResourceLocation createTexture() {
        return new ResourceLocation(TinyTrains.MODID, "textures/trains/steam_loco.png");
    }
}
