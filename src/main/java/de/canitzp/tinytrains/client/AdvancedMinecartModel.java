package de.canitzp.tinytrains.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import de.canitzp.tinytrains.AdvancedMinecartEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class AdvancedMinecartModel<T extends AdvancedMinecartEntity<T>> extends EntityModel<T> {
    
    private ModelRenderer rootRenderer;
    
    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    
    }
    
    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        if(this.rootRenderer != null){
            this.rootRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
    }
    
    protected void setRootRenderer(ModelRenderer root){
        this.rootRenderer = root;
    }
    
}
