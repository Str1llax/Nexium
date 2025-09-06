package com.str1llax.nexium.datagen.worldgen;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.worldgen.NexiumBiomeModifiers;
import com.str1llax.nexium.worldgen.NexiumConfiguredFeatures;
import com.str1llax.nexium.worldgen.NexiumPlacedFeatures;
import com.str1llax.nexium.worldgen.biomes.NexiumBiomes;
import com.str1llax.nexium.worldgen.dimension.NexiumDimensions;
import com.str1llax.nexium.worldgen.levelgen.NexiumNoiseGeneratorSettings;
import com.str1llax.nexium.worldgen.levelgen.NexiumNoiseRouters;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class NexiumWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, NexiumDimensions::bootstrapType)
            .add(Registries.CONFIGURED_FEATURE, NexiumConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, NexiumPlacedFeatures::bootstrap)
            .add(Registries.BIOME, NexiumBiomes::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, NexiumBiomeModifiers::bootstrap)
            .add(Registries.DENSITY_FUNCTION, NexiumNoiseRouters::bootstrap)
            .add(Registries.NOISE_SETTINGS, NexiumNoiseGeneratorSettings::bootstrap)
            .add(Registries.LEVEL_STEM, NexiumDimensions::bootstrapStem);

    public NexiumWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Nexium.MOD_ID));
    }
}
