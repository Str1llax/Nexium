package com.str1llax.nexium.worldgen.levelgen;

import com.mojang.serialization.DataResult;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.*;

public class NexiumNoiseSettings {

    protected static final NoiseSettings TEST_NOISE_SETTINGS = create(0, 512, 4, 1);

    // copy of vanilla methods
    // This thing connects chunks between each other
    private static DataResult<NoiseSettings> guardY(NoiseSettings noiseSettings) {
        if (noiseSettings.minY() + noiseSettings.height() > DimensionType.MAX_Y + 1) {
            return DataResult.error(() -> "min_y + height cannot be higher than: " + (DimensionType.MAX_Y + 1));
        } else if (noiseSettings.height() % 16 != 0) {
            return DataResult.error(() -> "height has to be a multiple of 16");
        } else {
            return noiseSettings.minY() % 16 != 0 ? DataResult.error(() -> "min_y has to be a multiple of 16") : DataResult.success(noiseSettings);
        }
    }

    public static NoiseSettings create(int pMinY, int pHeight, int pNoiseSizeHorizontal, int pNoiseSizeVertical) {
        NoiseSettings noisesettings = new NoiseSettings(pMinY, pHeight, pNoiseSizeHorizontal, pNoiseSizeVertical);
        guardY(noisesettings).error().ifPresent((error) -> {
            throw new IllegalStateException(error.message());
        });
        return noisesettings;
    }

}
