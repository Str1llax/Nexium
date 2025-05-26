package com.str1llax.nexium.worldgen.tree;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.worldgen.tree.custom.HeveaTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NexiumTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, Nexium.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<HeveaTrunkPlacer>> HEVEA_TRUNK_PLACER = TRUNK_PLACER.register("hevea_trunk_placer",
            () -> new TrunkPlacerType<>(HeveaTrunkPlacer.CODEC));

    public static void register(IEventBus bus) {
        TRUNK_PLACER.register(bus);
    }
}
