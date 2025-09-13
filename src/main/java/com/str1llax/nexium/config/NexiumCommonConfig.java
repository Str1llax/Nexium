package com.str1llax.nexium.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class NexiumCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue TEST_BOOL_COMMON;

    static {
        BUILDER.push("Common Settings");
        BUILDER.comment("These are Nexium mod's common settings");

        TEST_BOOL_COMMON = BUILDER
                .comment("Test common boolean setting")
                .define("testBoolCommon", false);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
