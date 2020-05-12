package de.canitzp.tinytrains.item;

import de.canitzp.tinytrains.AdvancedMinecartEntity;
import de.canitzp.tinytrains.TinyTrains;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.UUID;

public class ItemSpanner extends Item {
    
    private static final String NBT_CART_KEY = "first_cart";
    
    public ItemSpanner() {
        super(new Properties().maxStackSize(1).group(ItemGroup.TOOLS));
        this.setRegistryName(TinyTrains.MODID, "item_spanner");
    }
    
    public static void putCart(ItemStack stack, AdvancedMinecartEntity<?> cart){
        if(!stack.isEmpty() && stack.getItem() instanceof ItemSpanner){
            stack.getOrCreateTag().putInt(NBT_CART_KEY, cart.getEntityId());
        }
    }
    
    public static boolean hasCart(ItemStack stack){
        return !stack.isEmpty() && stack.getItem() instanceof ItemSpanner && stack.getOrCreateTag().contains(NBT_CART_KEY);
    }
    
    public static AdvancedMinecartEntity<?> getCart(ItemStack stack, World world){
        if(!stack.isEmpty() && stack.getItem() instanceof ItemSpanner && stack.getOrCreateTag().contains(NBT_CART_KEY)){
            int entityId = stack.getOrCreateTag().getInt(NBT_CART_KEY);
            Entity entity = world.getEntityByID(entityId);
            if(entity instanceof AdvancedMinecartEntity<?>){
                return (AdvancedMinecartEntity<?>) entity;
            }
        }
        return null;
    }
    
}
