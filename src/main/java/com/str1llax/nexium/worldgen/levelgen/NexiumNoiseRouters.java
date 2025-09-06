package com.str1llax.nexium.worldgen.levelgen;

import com.str1llax.nexium.worldgen.ores.NexiumOreVeinifier;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.stream.Stream;

// Copy of 1.20.1 Vanilla Overworld NoiseRouterData with dependencies

public class NexiumNoiseRouters {

    private static final ResourceKey<DensityFunction> Y = getKey("y");
    private static final ResourceKey<DensityFunction> SHIFT_X = getKey("shift_x");
    private static final ResourceKey<DensityFunction> SHIFT_Z = getKey("shift_z");
    public static final ResourceKey<DensityFunction> CONTINENTS = getKey("overworld/continents");
    public static final ResourceKey<DensityFunction> EROSION = getKey("overworld/erosion");
    public static final ResourceKey<DensityFunction> RIDGES = getKey("overworld/ridges");
    public static final ResourceKey<DensityFunction> FACTOR = getKey("overworld/factor");
    public static final ResourceKey<DensityFunction> DEPTH = getKey("overworld/depth");
    private static final ResourceKey<DensityFunction> SLOPED_CHEESE = getKey("overworld/sloped_cheese");
    public static final ResourceKey<DensityFunction> CONTINENTS_LARGE = getKey("overworld_large_biomes/continents");
    public static final ResourceKey<DensityFunction> EROSION_LARGE = getKey("overworld_large_biomes/erosion");
    private static final ResourceKey<DensityFunction> FACTOR_LARGE = getKey("overworld_large_biomes/factor");
    private static final ResourceKey<DensityFunction> DEPTH_LARGE = getKey("overworld_large_biomes/depth");
    private static final ResourceKey<DensityFunction> SLOPED_CHEESE_LARGE = getKey("overworld_large_biomes/sloped_cheese");
    private static final ResourceKey<DensityFunction> FACTOR_AMPLIFIED = getKey("overworld_amplified/factor");
    private static final ResourceKey<DensityFunction> DEPTH_AMPLIFIED = getKey("overworld_amplified/depth");
    private static final ResourceKey<DensityFunction> SLOPED_CHEESE_AMPLIFIED = getKey("overworld_amplified/sloped_cheese");
    private static final ResourceKey<DensityFunction> SPAGHETTI_ROUGHNESS_FUNCTION = getKey("overworld/caves/spaghetti_roughness_function");
    private static final ResourceKey<DensityFunction> ENTRANCES = getKey("overworld/caves/entrances");
    private static final ResourceKey<DensityFunction> NOODLE = getKey("overworld/caves/noodle");
    private static final ResourceKey<DensityFunction> PILLARS = getKey("overworld/caves/pillars");
    private static final ResourceKey<DensityFunction> SPAGHETTI_2D = getKey("overworld/caves/spaghetti_2d");

    private static ResourceKey<DensityFunction> getKey(String pLocation) {
        return ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.parse(pLocation));
    }
    
    private static DensityFunction getFunction(HolderGetter<DensityFunction> pDensityFunctions, ResourceKey<DensityFunction> pKey) {
        return new DensityFunctions.HolderHolder(pDensityFunctions.getOrThrow(pKey));
    }

    public static void bootstrap(BootstapContext<DensityFunction> pContext) {

    }

    private static DensityFunction postProcess(DensityFunction pDensityFunction) {
        DensityFunction densityfunction = DensityFunctions.blendDensity(pDensityFunction);
        return DensityFunctions.mul(DensityFunctions.interpolated(densityfunction), DensityFunctions.constant(0.64D)).squeeze();
    }

    protected static NoiseRouter overworld(HolderGetter<DensityFunction> pDensityFunctions, HolderGetter<NormalNoise.NoiseParameters> pNoiseParameters, boolean pLarge, boolean pAmplified) {
        DensityFunction densityfunction = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_BARRIER), 0.5D);
        DensityFunction densityfunction1 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_FLUID_LEVEL_FLOODEDNESS), 0.67D);
        DensityFunction densityfunction2 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_FLUID_LEVEL_SPREAD), 0.7142857142857143D);
        DensityFunction densityfunction3 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_LAVA));
        DensityFunction densityfunction4 = getFunction(pDensityFunctions, SHIFT_X);
        DensityFunction densityfunction5 = getFunction(pDensityFunctions, SHIFT_Z);
        DensityFunction densityfunction6 = DensityFunctions.shiftedNoise2d(densityfunction4, densityfunction5, 0.25D, pNoiseParameters.getOrThrow(pLarge ? Noises.TEMPERATURE_LARGE : Noises.TEMPERATURE));
        DensityFunction densityfunction7 = DensityFunctions.shiftedNoise2d(densityfunction4, densityfunction5, 0.25D, pNoiseParameters.getOrThrow(pLarge ? Noises.VEGETATION_LARGE : Noises.VEGETATION));
        DensityFunction densityfunction8 = getFunction(pDensityFunctions, pLarge ? FACTOR_LARGE : (pAmplified ? FACTOR_AMPLIFIED : FACTOR));
        DensityFunction densityfunction9 = getFunction(pDensityFunctions, pLarge ? DEPTH_LARGE : (pAmplified ? DEPTH_AMPLIFIED : DEPTH));
        DensityFunction densityfunction10 = noiseGradientDensity(DensityFunctions.cache2d(densityfunction8), densityfunction9);
        DensityFunction densityfunction11 = getFunction(pDensityFunctions, pLarge ? SLOPED_CHEESE_LARGE : (pAmplified ? SLOPED_CHEESE_AMPLIFIED : SLOPED_CHEESE));
        DensityFunction densityfunction12 = DensityFunctions.min(densityfunction11, DensityFunctions.mul(DensityFunctions.constant(5.0D), getFunction(pDensityFunctions, ENTRANCES)));
        DensityFunction densityfunction13 = DensityFunctions.rangeChoice(densityfunction11, -1000000.0D, 1.5625D, densityfunction12, underground(pDensityFunctions, pNoiseParameters, densityfunction11));
        DensityFunction densityfunction14 = DensityFunctions.min(postProcess(slideOverworld(pAmplified, densityfunction13)), getFunction(pDensityFunctions, NOODLE));
        DensityFunction densityfunction15 = getFunction(pDensityFunctions, Y);
        int i = Stream.of(NexiumOreVeinifier.VeinType.values()).mapToInt((p_224495_) -> p_224495_.minY).min().orElse(-DimensionType.MIN_Y * 2);
        int j = Stream.of(NexiumOreVeinifier.VeinType.values()).mapToInt((p_224457_) -> p_224457_.maxY).max().orElse(-DimensionType.MIN_Y * 2);
        DensityFunction densityfunction16 = yLimitedInterpolatable(densityfunction15, DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.ORE_VEININESS), 1.5D, 1.5D), i, j, 0);
        float f = 4.0F;
        DensityFunction densityfunction17 = yLimitedInterpolatable(densityfunction15, DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.ORE_VEIN_A), 4.0D, 4.0D), i, j, 0).abs();
        DensityFunction densityfunction18 = yLimitedInterpolatable(densityfunction15, DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.ORE_VEIN_B), 4.0D, 4.0D), i, j, 0).abs();
        DensityFunction densityfunction19 = DensityFunctions.add(DensityFunctions.constant((double)-0.08F), DensityFunctions.max(densityfunction17, densityfunction18));
        DensityFunction densityfunction20 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.ORE_GAP));
        return new NoiseRouter(densityfunction, densityfunction1, densityfunction2, densityfunction3, densityfunction6, densityfunction7, getFunction(pDensityFunctions, pLarge ? CONTINENTS_LARGE : CONTINENTS), getFunction(pDensityFunctions, pLarge ? EROSION_LARGE : EROSION), densityfunction9, getFunction(pDensityFunctions, RIDGES), slideOverworld(pAmplified, DensityFunctions.add(densityfunction10, DensityFunctions.constant(-0.703125D)).clamp(-64.0D, 64.0D)), densityfunction14, densityfunction16, densityfunction19, densityfunction20);
    }

    private static DensityFunction underground(HolderGetter<DensityFunction> pDensityFunctions, HolderGetter<NormalNoise.NoiseParameters> pNoiseParameters, DensityFunction p_256658_) {
        DensityFunction densityfunction = getFunction(pDensityFunctions, SPAGHETTI_2D);
        DensityFunction densityfunction1 = getFunction(pDensityFunctions, SPAGHETTI_ROUGHNESS_FUNCTION);
        DensityFunction densityfunction2 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.CAVE_LAYER), 8.0D);
        DensityFunction densityfunction3 = DensityFunctions.mul(DensityFunctions.constant(4.0D), densityfunction2.square());
        DensityFunction densityfunction4 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.CAVE_CHEESE), 0.6666666666666666D);
        DensityFunction densityfunction5 = DensityFunctions.add(DensityFunctions.add(DensityFunctions.constant(0.27D), densityfunction4).clamp(-1.0D, 1.0D), DensityFunctions.add(DensityFunctions.constant(1.5D), DensityFunctions.mul(DensityFunctions.constant(-0.64D), p_256658_)).clamp(0.0D, 0.5D));
        DensityFunction densityfunction6 = DensityFunctions.add(densityfunction3, densityfunction5);
        DensityFunction densityfunction7 = DensityFunctions.min(DensityFunctions.min(densityfunction6, getFunction(pDensityFunctions, ENTRANCES)), DensityFunctions.add(densityfunction, densityfunction1));
        DensityFunction densityfunction8 = getFunction(pDensityFunctions, PILLARS);
        DensityFunction densityfunction9 = DensityFunctions.rangeChoice(densityfunction8, -1000000.0D, 0.03D, DensityFunctions.constant(-1000000.0D), densityfunction8);
        return DensityFunctions.max(densityfunction7, densityfunction9);
    }

    private static DensityFunction noiseGradientDensity(DensityFunction pMinFunction, DensityFunction pMaxFunction) {
        DensityFunction densityfunction = DensityFunctions.mul(pMaxFunction, pMinFunction);
        return DensityFunctions.mul(DensityFunctions.constant(4.0D), densityfunction.quarterNegative());
    }

    private static DensityFunction slideOverworld(boolean pAmplified, DensityFunction pDensityFunction) {
        return slide(pDensityFunction, -64, 384, pAmplified ? 16 : 80, pAmplified ? 0 : 64, -0.078125D, 0, 24, pAmplified ? 0.4D : 0.1171875D);
    }

    private static DensityFunction slide(DensityFunction pDensityFunction, int pMinY, int pMaxY, int p_224447_, int p_224448_, double p_224449_, int p_224450_, int p_224451_, double p_224452_) {
        DensityFunction densityfunction1 = DensityFunctions.yClampedGradient(pMinY + pMaxY - p_224447_, pMinY + pMaxY - p_224448_, 1.0D, 0.0D);
        DensityFunction $$9 = DensityFunctions.lerp(densityfunction1, p_224449_, pDensityFunction);
        DensityFunction densityfunction2 = DensityFunctions.yClampedGradient(pMinY + p_224450_, pMinY + p_224451_, 0.0D, 1.0D);
        return DensityFunctions.lerp(densityfunction2, p_224452_, $$9);
    }

    private static DensityFunction yLimitedInterpolatable(DensityFunction p_209472_, DensityFunction p_209473_, int p_209474_, int p_209475_, int p_209476_) {
        return DensityFunctions.interpolated(DensityFunctions.rangeChoice(p_209472_, (double)p_209474_, (double)(p_209475_ + 1), p_209473_, DensityFunctions.constant((double)p_209476_)));
    }

    /*
    public static NoiseRouter test(HolderGetter<DensityFunction> pDensityFunctions, HolderGetter<NormalNoise.NoiseParameters> pNoiseParameters) {
        DensityFunction barrierNoise = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_BARRIER), 0D);
        DensityFunction fluidLevelFloodednessNoise = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_FLUID_LEVEL_FLOODEDNESS), 0D);
        DensityFunction fluidLevelSpreadNoise = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_FLUID_LEVEL_SPREAD), 0D);
        DensityFunction lavaNoise = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_LAVA));
        DensityFunction temperatureNoise = DensityFunctions.shiftedNoise2d(getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.parse("shift_x"))),
                getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.parse("shift_z"))), 0.5D, pNoiseParameters.getOrThrow(Noises.TEMPERATURE));
        DensityFunction vegetationNoise = DensityFunctions.shiftedNoise2d(getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.parse("shift_x"))),
                getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.parse("shift_z"))), 0.5D, pNoiseParameters.getOrThrow(Noises.VEGETATION));
        DensityFunction continents = getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, NoiseRouterData.CONTINENTS.location()));
        DensityFunction erosion = getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, NoiseRouterData.EROSION.location()));
        DensityFunction depth = getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, DEPTH.location()));
        DensityFunction ridges = getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, NoiseRouterData.RIDGES.location()));
        DensityFunction initialDensityWithoutJaggedness = slideOverworld(DensityFunctions.add(noiseGradientDensity(DensityFunctions.cache2d(getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, FACTOR.location()))),
                getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, DEPTH.location()))), DensityFunctions.constant(-1D)).clamp(0D, 64.0D));

        DensityFunction slopedCheese = getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.parse("overworld/sloped_cheese")));
        DensityFunction caveEntrances = DensityFunctions.min(slopedCheese, DensityFunctions.mul(DensityFunctions.constant(5.0D),
                getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.parse("overworld/caves/entrances")))));
        DensityFunction cheeseEntrances = DensityFunctions.rangeChoice(slopedCheese, -1000000.0D, 1.5D, caveEntrances, underground(pDensityFunctions, pNoiseParameters, slopedCheese));
        DensityFunction finalDensity = DensityFunctions.min(postProcess(slideOverworld(cheeseEntrances)),
                getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.parse("overworld/caves/noodle"))));

        DensityFunction veinToggle = yLimitedInterpolatable(getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.parse("y"))),
                DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.ORE_VEININESS), 1.5D, 1.5D), 1, 300, 0);
        DensityFunction veinA = yLimitedInterpolatable(getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.parse("y"))),
                DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.ORE_VEIN_A), 1.5D, 1.5D), 1, 300, 0).abs();
        DensityFunction veinB = yLimitedInterpolatable(getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.parse("y"))),
                DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.ORE_VEIN_B), 1.5D, 1.5D), 1, 300, 0).abs();
        DensityFunction veinRidged = DensityFunctions.add(DensityFunctions.constant((double)-0.08F), DensityFunctions.max(veinA, veinB));
        DensityFunction veinGap = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.ORE_GAP));

        return new NoiseRouter(
                barrierNoise,
                fluidLevelFloodednessNoise,
                fluidLevelSpreadNoise,
                lavaNoise,
                temperatureNoise,
                vegetationNoise,
                continents,
                erosion,
                depth,
                ridges,
                initialDensityWithoutJaggedness,
                finalDensity,
                veinToggle,
                veinRidged,
                veinGap);
    }

    private static DensityFunction underground(HolderGetter<DensityFunction> pDensityFunctions, HolderGetter<NormalNoise.NoiseParameters> pNoiseParameters, DensityFunction p_256658_) {
        DensityFunction spaghetti2d = getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.parse("overworld/caves/spaghetti_2d")));
        DensityFunction spaghettiRoughnessFunction = getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.parse("overworld/caves/spaghetti_roughness_function")));
        DensityFunction caveLayer = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.CAVE_LAYER), 20.0D);
        DensityFunction caveLayerSquare = DensityFunctions.mul(DensityFunctions.constant(4.0D), caveLayer.square());
        DensityFunction caveCheese = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.CAVE_CHEESE), 0.2D);
        DensityFunction multiCaveCheese = DensityFunctions.add(DensityFunctions.add(DensityFunctions.constant(0.5D), caveCheese).clamp(-1.0D, 1.0D),
                DensityFunctions.add(DensityFunctions.constant(1.5D), DensityFunctions.mul(DensityFunctions.constant(-0.64D), p_256658_)).clamp(0.0D, 0.5D));
        DensityFunction multiCaveSquare = DensityFunctions.add(caveLayerSquare, multiCaveCheese);
        DensityFunction caveEntrances = DensityFunctions.min(DensityFunctions.min(multiCaveSquare, getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.parse("overworld/caves/entrances")))),
                DensityFunctions.add(spaghetti2d, spaghettiRoughnessFunction));
        DensityFunction pillars = getFunction(pDensityFunctions, ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.parse("overworld/caves/pillars")));
        DensityFunction cavePillars = DensityFunctions.rangeChoice(pillars, -1000000.0D, 0.03D, DensityFunctions.constant(-1000000.0D), caveEntrances);
        return DensityFunctions.max(caveEntrances, cavePillars);
    }

    private static DensityFunction yLimitedInterpolatable(DensityFunction p_209472_, DensityFunction p_209473_, int p_209474_, int p_209475_, int p_209476_) {
        return DensityFunctions.interpolated(DensityFunctions.rangeChoice(p_209472_, (double)p_209474_, (double)(p_209475_ + 1), p_209473_, DensityFunctions.constant((double)p_209476_)));
    }

    private static DensityFunction postProcess(DensityFunction pDensityFunction) {
        DensityFunction densityfunction = DensityFunctions.blendDensity(pDensityFunction);
        return DensityFunctions.mul(DensityFunctions.interpolated(densityfunction), DensityFunctions.constant(0.64D)).squeeze();
    }

    private static DensityFunction noiseGradientDensity(DensityFunction pMinFunction, DensityFunction pMaxFunction) {
        DensityFunction densityfunction = DensityFunctions.mul(pMaxFunction, pMinFunction);
        return DensityFunctions.mul(DensityFunctions.constant(4.0D), densityfunction.quarterNegative());
    }

    private static DensityFunction slideOverworld(DensityFunction pDensityFunction) {
        return slide(pDensityFunction, 0, 384,80,64, -1D, 0, 30,0.1D);
    }

    private static DensityFunction slide(DensityFunction pDensityFunction, int pMinY, int pMaxY, int p_224447_, int p_224448_, double p_224449_, int p_224450_, int p_224451_, double p_224452_) {
        DensityFunction densityfunction1 = DensityFunctions.yClampedGradient(pMinY + pMaxY - p_224447_, pMinY + pMaxY - p_224448_, 1.0D, 0.0D);
        DensityFunction $$9 = DensityFunctions.lerp(densityfunction1, p_224449_, pDensityFunction);
        DensityFunction densityfunction2 = DensityFunctions.yClampedGradient(pMinY + p_224450_, pMinY + p_224451_, 0.0D, 1.0D);
        return DensityFunctions.lerp(densityfunction2, p_224452_, $$9);
    }*/
}
