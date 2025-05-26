package com.str1llax.nexium.events;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.blocks.entity.NexiumBlockEntities;
import com.str1llax.nexium.blocks.entity.renderer.IncubatorBlockEntityRenderer;
import com.str1llax.nexium.entity.client.NexiumModelLayers;
import com.str1llax.nexium.entity.client.StonyModel;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderHighlightEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Nexium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NexiumModClientEvents {

    @SubscribeEvent
    public static void registryLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(NexiumModelLayers.STONY_LAYER, StonyModel::createBodyLayer);
        event.registerLayerDefinition(NexiumModelLayers.HEVEA_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(NexiumModelLayers.HEVEA_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(NexiumBlockEntities.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(NexiumBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
        event.registerBlockEntityRenderer(NexiumBlockEntities.INCUBATOR_BLOCK_ENTITY.get(), IncubatorBlockEntityRenderer::new);
    }
}
