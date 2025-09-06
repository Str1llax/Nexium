package com.str1llax.nexium.worldgen.biomes;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.util.ModTweaks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import javax.annotation.Nullable;
import java.awt.*;

public class NexiumBiomes {
    public static final ResourceKey<Biome> TEST_BIOME = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "test_biome"));

    public static void bootstrap(BootstapContext<Biome> pContext) {
        HolderGetter<PlacedFeature> placedFeatures = pContext.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> worldCarvers = pContext.lookup(Registries.CONFIGURED_CARVER);
        pContext.register(TEST_BIOME, testBiome(placedFeatures, worldCarvers));
    }

    protected static int calculateSkyColor(float pTemperature) {
        float $$1 = pTemperature / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    private static Biome biome(boolean pHasPrecipitation, float pTemperature, float pDownfall, int pWaterColor, int pWaterFogColor, @Nullable Integer pGrassColorOverride, @Nullable Integer pFoliageColorOverride, MobSpawnSettings.Builder pMobSpawnSettings, BiomeGenerationSettings.Builder pGenerationSettings, @Nullable Music pBackgroundMusic) {
        BiomeSpecialEffects.Builder biomespecialeffects$builder = (new BiomeSpecialEffects.Builder()).waterColor(pWaterColor).waterFogColor(pWaterFogColor).fogColor(12638463).skyColor(calculateSkyColor(pTemperature)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(pBackgroundMusic);
        if (pGrassColorOverride != null) {
            biomespecialeffects$builder.grassColorOverride(pGrassColorOverride);
        }

        if (pFoliageColorOverride != null) {
            biomespecialeffects$builder.foliageColorOverride(pFoliageColorOverride);
        }

        return (new Biome.BiomeBuilder()).hasPrecipitation(pHasPrecipitation).temperature(pTemperature).downfall(pDownfall).specialEffects(biomespecialeffects$builder.build()).mobSpawnSettings(pMobSpawnSettings.build()).generationSettings(pGenerationSettings.build()).build();
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder pGenerationSettings) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(pGenerationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(pGenerationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(pGenerationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(pGenerationSettings);
        BiomeDefaultFeatures.addDefaultSprings(pGenerationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(pGenerationSettings);
    }

    public static Biome testBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pWorldCarvers) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder(pPlacedFeatures, pWorldCarvers);
        //globalOverworldGeneration(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        float temperature = 0.8f;
        int waterColor = ModTweaks.ColorToInt(new Color(34, 231, 170));
        int waterFogColor = ModTweaks.ColorToInt(new Color(32, 113, 138));
        int grassColorOverride = ModTweaks.ColorToInt(new Color(147, 17, 213));
        int foliageColorOverride = ModTweaks.ColorToInt(new Color(32, 61, 197, 255));
        Music biomeMusic = null;

        return biome(true, temperature, 0.4F, waterColor, waterFogColor, grassColorOverride, foliageColorOverride, mobspawnsettings$builder, biomegenerationsettings$builder, biomeMusic);
    }
}
