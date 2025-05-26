package com.str1llax.nexium.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.entity.custom.StonyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class StonyRenderer extends MobRenderer<StonyEntity, StonyModel<StonyEntity>> {
    public StonyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new StonyModel<>(pContext.bakeLayer(NexiumModelLayers.STONY_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(StonyEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "textures/entity/stony/stony.png");
    }

    @Override
    public void render(StonyEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
        super.shadowRadius = 0.65f;
    }
}
