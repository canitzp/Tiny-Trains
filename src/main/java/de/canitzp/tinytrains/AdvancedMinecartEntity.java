package de.canitzp.tinytrains;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import de.canitzp.tinytrains.item.ItemSpanner;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Quaternion;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.texture.MissingTextureSprite;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;

public abstract class AdvancedMinecartEntity<T extends AdvancedMinecartEntity<T>> extends AbstractMinecartEntity {
    
    private EntityModel<T> cachedModel;
    private ResourceLocation cachedTexture;
    
    private AdvancedMinecartEntity<?> pullingEntity;
    
    public AdvancedMinecartEntity(EntityType<?> type, World world) {
        super(type, world);
    }
    
    public AdvancedMinecartEntity(EntityType<?> type, World worldIn, double posX, double posY, double posZ) {
        super(type, worldIn, posX, posY, posZ);
    }
    
    @Nonnull
    @Override
    public Type getMinecartType() {
        return Type.RIDEABLE;
    }
    
    @Nonnull
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    
    @Override
    public void tick() {
        super.tick();
        // todo add pulling code
    }
    
    @Override
    public boolean processInitialInteract(@Nonnull PlayerEntity player, @Nonnull Hand hand) {
        ItemStack held = player.getHeldItem(hand);
        if(!held.isEmpty() && held.getItem() instanceof ItemSpanner){
            
            return true;
        }
        return super.processInitialInteract(player, hand);
    }
    
    public void setPullingEntity(AdvancedMinecartEntity<?> pullingEntity){
        this.pullingEntity = pullingEntity;
    }
    
    public boolean hasEntityToPull(){
        return this.pullingEntity != null;
    }
    
    public AdvancedMinecartEntity<?> getPullingEntity(){
        return this.pullingEntity;
    }
    
    public EntityModel<T> createModel(){
        return null;
    }
    
    public final EntityModel<T> getModel(){
        return this.cachedModel != null ? this.cachedModel : (this.cachedModel = this.createModel());
    }
    
    public ResourceLocation createTexture(){
        return MissingTextureSprite.getLocation();
    }
    
    public final ResourceLocation getTexture(){
        return this.cachedTexture != null ? this.cachedTexture : (this.cachedTexture = this.createTexture());
    }
    
    public void render(EntityRendererManager rendererManager, T entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight){
        if(this.getModel() != null){
            matrixStack.push();
            
            matrixStack.rotate(Vector3f.XN.rotationDegrees(180F));
            matrixStack.translate(0, -0.5F, 0);
    
            //matrixStack.translate(0.0D, 0.375D, 0.0D);
            matrixStack.rotate(Vector3f.YP.rotationDegrees(entityYaw + 45F));
    
            matrixStack.scale(-1.0F, -1.0F, 1.0F);
            this.getModel().setRotationAngles(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
            IVertexBuilder ivertexbuilder = buffer.getBuffer(this.getModel().getRenderType(this.getTexture()));
            this.getModel().render(matrixStack, ivertexbuilder, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStack.pop();
        }
    }
}