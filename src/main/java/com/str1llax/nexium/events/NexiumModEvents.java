package com.str1llax.nexium.events;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.entity.NexiumEntities;
import com.str1llax.nexium.entity.custom.StonyEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Nexium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NexiumModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(NexiumEntities.STONY.get(), StonyEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void onConfigLoading(ModConfigEvent.Loading event) {
        if (event.getConfig().getModId().equals(Nexium.MOD_ID)) System.out.println("Loading config: " + event.getConfig().getFileName());
    }

    @SubscribeEvent
    public static void onConfigReloading(ModConfigEvent.Reloading event) {
        if (event.getConfig().getModId().equals(Nexium.MOD_ID)) System.out.println("Reloading config: " + event.getConfig().getFileName());
    }
}
