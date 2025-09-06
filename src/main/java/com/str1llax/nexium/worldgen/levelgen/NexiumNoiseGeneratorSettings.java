package com.str1llax.nexium.worldgen.levelgen;

import com.str1llax.nexium.Nexium;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;



public class NexiumNoiseGeneratorSettings {
    public static final ResourceKey<NoiseGeneratorSettings> TEST_NOISE = ResourceKey.create(Registries.NOISE_SETTINGS, ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "test"));

    public static void bootstrap(BootstapContext<NoiseGeneratorSettings> pContext) {
        pContext.register(TEST_NOISE, testNoise(pContext));
    }

    public static NoiseGeneratorSettings testNoise(BootstapContext<?> pContext) {
        return new NoiseGeneratorSettings(
                NexiumNoiseSettings.TEST_NOISE_SETTINGS, // Noise settings
                Blocks.STONE.defaultBlockState(), // Default block
                Blocks.AIR.defaultBlockState(), // Default fluid
                NexiumNoiseRouters.overworld(pContext.lookup(Registries.DENSITY_FUNCTION), pContext.lookup(Registries.NOISE), false, false), // Noise router
                SurfaceRuleData.overworld(), // NexiumSurfaceRules.test(), // Surface rule
                (new OverworldBiomeBuilder()).spawnTarget(), // Spawn target
                0, // Sea level
                false, // Disable mob generation
                false, // Aquifers enabled
                false, // Ore veins enabled
                false); // Use legacy random source
    }
}
