package com.str1llax.nexium.events;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.entity.NexiumEntities;
import com.str1llax.nexium.entity.custom.StonyEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Nexium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NexiumModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(NexiumEntities.STONY.get(), StonyEntity.createAttributes().build());
    }
}
