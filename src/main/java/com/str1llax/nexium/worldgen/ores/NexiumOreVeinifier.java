package com.str1llax.nexium.worldgen.ores;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.NoiseChunk;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;

// Also copy of 1.20.1 vanilla OreVeinifier because of private

public class NexiumOreVeinifier {

    protected static NoiseChunk.BlockStateFiller create(DensityFunction pVeinToggle, DensityFunction pVeinRidged, DensityFunction pVeinGap, PositionalRandomFactory pRandom) {
        BlockState blockstate = null;
        return (p_209666_) -> {
            double d0 = pVeinToggle.compute(p_209666_);
            int i = p_209666_.blockY();
            NexiumOreVeinifier.VeinType oreveinifier$veintype = d0 > 0.0D ? NexiumOreVeinifier.VeinType.COPPER : NexiumOreVeinifier.VeinType.IRON;
            double d1 = Math.abs(d0);
            int j = oreveinifier$veintype.maxY - i;
            int k = i - oreveinifier$veintype.minY;
            if (k >= 0 && j >= 0) {
                int l = Math.min(j, k);
                double d2 = Mth.clampedMap((double)l, 0.0D, 20.0D, -0.2D, 0.0D);
                if (d1 + d2 < (double)0.4F) {
                    return blockstate;
                } else {
                    RandomSource randomsource = pRandom.at(p_209666_.blockX(), i, p_209666_.blockZ());
                    if (randomsource.nextFloat() > 0.7F) {
                        return blockstate;
                    } else if (pVeinRidged.compute(p_209666_) >= 0.0D) {
                        return blockstate;
                    } else {
                        double d3 = Mth.clampedMap(d1, (double)0.4F, (double)0.6F, (double)0.1F, (double)0.3F);
                        if ((double)randomsource.nextFloat() < d3 && pVeinGap.compute(p_209666_) > (double)-0.3F) {
                            return randomsource.nextFloat() < 0.02F ? oreveinifier$veintype.rawOreBlock : oreveinifier$veintype.ore;
                        } else {
                            return oreveinifier$veintype.filler;
                        }
                    }
                }
            } else {
                return blockstate;
            }
        };
    }

    public enum VeinType {
        COPPER(Blocks.COPPER_ORE.defaultBlockState(), Blocks.RAW_COPPER_BLOCK.defaultBlockState(), Blocks.GRANITE.defaultBlockState(), 0, 50),
        IRON(Blocks.DEEPSLATE_IRON_ORE.defaultBlockState(), Blocks.RAW_IRON_BLOCK.defaultBlockState(), Blocks.TUFF.defaultBlockState(), -60, -8);

        final BlockState ore;
        final BlockState rawOreBlock;
        final BlockState filler;
        public final int minY;
        public final int maxY;

        private VeinType(BlockState pOre, BlockState pRawOreBlock, BlockState pFiller, int pMinY, int pMaxY) {
            this.ore = pOre;
            this.rawOreBlock = pRawOreBlock;
            this.filler = pFiller;
            this.minY = pMinY;
            this.maxY = pMaxY;
        }
    }
}
