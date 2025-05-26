package com.str1llax.nexium.worldgen;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.register.NexiumBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class NexiumPlacedFeatures {
    public static final ResourceKey<PlacedFeature> NEXIUM_ORE_PLACED_KEY = registerKey("nexium_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_NEXIUM_ORE_PLACED_KEY = registerKey("nether_nexium_ore_placed");
    public static final ResourceKey<PlacedFeature> END_NEXIUM_ORE_PLACED_KEY = registerKey("end_nexium_ore_placed");

    public static final ResourceKey<PlacedFeature> HEVEA_PLACED_KEY = registerKey("hevea_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, NEXIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NexiumConfiguredFeatures.OVERWORLD_NEXIUM_ORE_KEY),
                NexiumOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, NETHER_NEXIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NexiumConfiguredFeatures.NETHER_NEXIUM_ORE_KEY),
                NexiumOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, END_NEXIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NexiumConfiguredFeatures.END_NEXIUM_ORE_KEY),
                NexiumOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, HEVEA_PLACED_KEY, configuredFeatures.getOrThrow(NexiumConfiguredFeatures.HEVEA_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.1f, 2), NexiumBlocks.HEVEA_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
