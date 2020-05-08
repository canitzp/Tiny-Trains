package de.canitzp.tinytrains;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
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
import net.minecraft.network.IPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;

public abstract class AdvancedMinecartEntity<T extends AdvancedMinecartEntity<T>> extends AbstractMinecartEntity {
    
    private EntityModel<T> cachedModel;
    
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
    
    public EntityModel<T> createModel(){
        return null;
    }
    
    public final EntityModel<T> getModel(){
        return this.cachedModel != null ? this.cachedModel : (this.cachedModel = this.createModel());
    }
    
    public ResourceLocation getTexture(){
        return MissingTextureSprite.getLocation();
    }
    
    public void render(EntityRendererManager rendererManager, T entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight){
        if(this.getModel() != null){
            matrixStack.push();
    
            matrixStack.translate(0.0D, 0.375D, 0.0D);
            matrixStack.rotate(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
    
            matrixStack.scale(-1.0F, -1.0F, 1.0F);
            this.getModel().setRotationAngles(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
            IVertexBuilder ivertexbuilder = buffer.getBuffer(this.getModel().getRenderType(this.getTexture()));
            this.getModel().render(matrixStack, ivertexbuilder, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStack.pop();
        }
    }
}