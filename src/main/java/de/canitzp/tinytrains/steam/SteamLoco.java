package de.canitzp.tinytrains.steam;

import de.canitzp.tinytrains.AdvancedMinecartEntity;
import de.canitzp.tinytrains.TinyTrains;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class SteamLoco extends AdvancedMinecartEntity {
    
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
    
}
