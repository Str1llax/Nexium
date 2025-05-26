package com.str1llax.nexium.worldgen.tree;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.worldgen.tree.custom.HeveaFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NexiumFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, Nexium.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<HeveaFoliagePlacer>> HEVEA_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("hevea_foliage_placer",
            () -> new FoliagePlacerType<>(HeveaFoliagePlacer.CODEC));

    public static void register(IEventBus bus) {
        FOLIAGE_PLACERS.register(bus);
    }
}
