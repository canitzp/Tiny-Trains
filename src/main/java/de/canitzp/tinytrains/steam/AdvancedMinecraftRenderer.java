package de.canitzp.tinytrains.steam;

import com.mojang.blaze3d.matrix.MatrixStack;
import de.canitzp.tinytrains.AdvancedMinecartEntity;
import de.canitzp.tinytrains.TinyTrains;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MinecartRenderer;
import net.minecraft.util.ResourceLocation;

public class AdvancedMinecraftRenderer<T extends AdvancedMinecartEntity<T>> extends EntityRenderer<T> {
    
    public AdvancedMinecraftRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }
    
    @Override
    public void render(T entity, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entity, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        entity.render(this.renderManager, entity, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
    
    @Override
    public ResourceLocation getEntityTexture(T entity) {
        return entity.getTexture();
    }
}
