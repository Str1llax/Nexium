package com.str1llax.nexium.util;

import java.awt.*;

public class ModTweaks {
    public static int ColorToInt(Color color) {
        return color.getRed() * 65536 + color.getGreen() * 256 + color.getBlue();
    }
}
