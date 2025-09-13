package com.str1llax.nexium.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;

public class ModKeyBindings {
    // Categories
    public static final String GENERAL_CATEGORY = "key.category.nexium.general";

    // Keys
    public static KeyMapping activateDebugItemKey = new KeyMapping("key.nexium.activate_debug_item", InputConstants.Type.KEYSYM, InputConstants.KEY_X, GENERAL_CATEGORY);

}
