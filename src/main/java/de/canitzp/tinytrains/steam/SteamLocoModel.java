package de.canitzp.tinytrains.steam;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class SteamLocoModel extends EntityModel<SteamLoco> {
    
    private final ModelRenderer root;
    private final ModelRenderer base;
    private final ModelRenderer wheelno, wheelne;
    
    public SteamLocoModel() {
        textureWidth = 32;
        textureHeight = 35;
        
        root = new ModelRenderer(this);
        root.setRotationPoint(0, -8, 0);
        
        base = new ModelRenderer(this);
        base.addBox("BaseBottom", -3, 1, -8, 6, 1, 15, 0, 0, 16);
        base.addBox("BaseMiddle", -4, 2, -8, 8, 3, 15, 0, 0, 16);
        base.addBox("BaseMiddleplate", -7, 5, -8, 14, 1, 15, 0, 0, 16);
        base.addBox("BaseFront", -4, 6, -8, 8, 3, 8, 0, 0, 16);
        base.addBox("PuffPuff" ,-1, 9, -8, 2, 4, 2, 0, 10, 0);
        base.addBox("BaseBack", -7, 6, 0, 14, 8, 7, 0, 0, 16);
        base.addBox("CoverWest", -7, 2, -8, 2, 3, 15, 0, 0, 16);
        base.addBox("CoverEast", 5, 2, -8, 2, 3, 15, 0, 0, 16);
        
        wheelno = new ModelRenderer(this);
        wheelno.addBox(4, 1, -6, 1, 2, 2, 0, false);
        wheelno.addBox(4, 3, -6, 1, 1, 2, 0, false);
        wheelno.addBox(4, 3, -7, 1, 1, 2, 0, false);
        wheelno.addBox(4, 0, -6, 1, 1, 2, 0, false);
        wheelno.addBox(4, 1, -4, 1, 1, 2, 0, false);
    
        wheelne = new ModelRenderer(this);
        wheelne.addBox(-5, 1, -6, 1, 2, 2, 0, false);
        wheelne.addBox(-5, 3, -6, 1, 1, 2, 0, false);
        wheelne.addBox(-5, 3, -7, 1, 1, 2, 0, false);
        wheelne.addBox(-5, 0, -6, 1, 1, 2, 0, false);
        wheelne.addBox(-5, 1, -4, 1, 1, 2, 0, false);
        
        root.addChild(base);
        root.addChild(wheelno);
        root.addChild(wheelne);
    }
    
    @Override
    public void setRotationAngles(SteamLoco entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    
    }
    
    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
