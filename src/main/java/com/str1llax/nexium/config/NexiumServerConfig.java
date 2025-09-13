package com.str1llax.nexium.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class NexiumServerConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue TEST_BOOL_SERVER;
    public static final ForgeConfigSpec.IntValue TEST_RANGE_SERVER;

    static {
        BUILDER.push("Server Settings");
        BUILDER.comment("These are Nexium mod's server settings");

        TEST_BOOL_SERVER = BUILDER
                .comment("Test server boolean setting")
                .define("testBoolServer", false);
        TEST_RANGE_SERVER = BUILDER
                .comment("Test server range setting")
                .defineInRange("testRangeServer", 1, 0, 100);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
