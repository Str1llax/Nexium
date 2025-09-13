package com.str1llax.nexium.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class NexiumClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue TEST_BOOL_CLIENT;


    static {
        BUILDER.push("Client Settings");
        BUILDER.comment("These are Nexium mod's client setting");

        TEST_BOOL_CLIENT = BUILDER.comment("Test client boolean setting").define("testBoolClient", true);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
