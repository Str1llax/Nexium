package com.str1llax.nexium.sound;

import com.str1llax.nexium.Nexium;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NexiumSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Nexium.MOD_ID);

    public static final RegistryObject<SoundEvent> GOOFY_EATING = registerSoundEvents("goofy_eating");

    public static final RegistryObject<SoundEvent> RICK_ASTLEY = registerSoundEvents("rick_astley");

    //public static final ForgeSoundType SOUND_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f, *BREAK*, *STEP*, *PLACE*, *HIT*, *FALL*);

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUNDS_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, name)));
    }

    public static void register(IEventBus bus) {
        SOUNDS_EVENTS.register(bus);
    }
}
