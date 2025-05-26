package com.str1llax.nexium.worldgen;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.register.NexiumBlocks;
import com.str1llax.nexium.worldgen.tree.custom.HeveaFoliagePlacer;
import com.str1llax.nexium.worldgen.tree.custom.HeveaTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class NexiumConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_NEXIUM_ORE_KEY = registerKey("nexium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_NEXIUM_ORE_KEY = registerKey("nether_nexium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_NEXIUM_ORE_KEY = registerKey("end_nexium_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> HEVEA_KEY = registerKey("hevea");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceable = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceable = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldNexiumOres = List.of(
                OreConfiguration.target(stoneReplaceable, NexiumBlocks.NEXIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, NexiumBlocks.DEEPSLATE_NEXIUM_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_NEXIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldNexiumOres, 9));
        register(context, NETHER_NEXIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceable, NexiumBlocks.NETHER_NEXIUM_ORE.get().defaultBlockState(), 9));
        register(context, END_NEXIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceable, NexiumBlocks.END_NEXIUM_ORE.get().defaultBlockState(), 9));

        register(context, HEVEA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(NexiumBlocks.HEVEA_LOG.get()),
                new HeveaTrunkPlacer(5, 4, 3),
                BlockStateProvider.simple(NexiumBlocks.HEVEA_LEAVES.get()),
                new HeveaFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                new TwoLayersFeatureSize(1, 0,2)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
