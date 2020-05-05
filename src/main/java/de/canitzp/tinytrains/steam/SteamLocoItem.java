package de.canitzp.tinytrains.steam;

import de.canitzp.tinytrains.TinyTrains;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;

public class SteamLocoItem extends Item {
    
    public SteamLocoItem() {
        super(new Properties().maxStackSize(1).group(ItemGroup.MISC));
        this.setRegistryName(TinyTrains.MODID, "steam_loco_item");
    }
    
    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        if(!context.getWorld().isRemote){
            TinyTrains.STEAM_LOCO_ENTITY_TYPE.spawn(context.getWorld(), context.getItem(), context.getPlayer(), context.getPos(), SpawnReason.SPAWN_EGG, true, true);
            //context.getWorld().addEntity(new SteamLoco(context.getWorld(), context.getPos().getX(), context.getPos().getY(), context.getPos().getZ()));
            return ActionResultType.SUCCESS;
        }
        return super.onItemUse(context);
    }
}
