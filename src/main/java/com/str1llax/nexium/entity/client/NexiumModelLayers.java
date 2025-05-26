package com.str1llax.nexium.entity.client;

import com.str1llax.nexium.Nexium;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class NexiumModelLayers {
    public static final ModelLayerLocation STONY_LAYER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "stony_layer"), "main");
    public static final ModelLayerLocation HEVEA_BOAT_LAYER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "boat/hevea"), "main");
    public static final ModelLayerLocation HEVEA_CHEST_BOAT_LAYER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "chest_boat/hevea"), "main");
}
