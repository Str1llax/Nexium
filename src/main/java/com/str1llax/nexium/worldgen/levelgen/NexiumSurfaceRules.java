package com.str1llax.nexium.worldgen.levelgen;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class NexiumSurfaceRules {
    //TODO Try to understand and create custom surface rules

    private static SurfaceRules.RuleSource makeStateRule(Block pBlock) {
        return SurfaceRules.state(pBlock.defaultBlockState());
    }

    public static SurfaceRules.RuleSource test() {
        // SurfaceRules.ifTrue(SurfaceRules.ConditionSource pIfTrue, SurfaceRules.RuleSource pThenRun)
        // SurfaceRules.sequence(SurfaceRules.RuleSource... pRules)

        // SurfaceRules.RuleSource - what to do
        // SurfaceRules.ConditionSource - when to do

        SurfaceRules.RuleSource finalSequence = SurfaceRules.sequence();

        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();
        builder.add(finalSequence);
        return SurfaceRules.sequence(builder.build().toArray((i) -> {
            return new SurfaceRules.RuleSource[i];
        }));
    }
}
