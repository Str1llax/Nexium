package com.str1llax.nexium.compat;

import com.str1llax.nexium.blocks.IncubatorBlock;
import com.str1llax.nexium.blocks.entity.IncubatorBlockEntity;
import com.str1llax.nexium.compat.Jade.IncubatorComponent;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadeNexiumPlugin implements IWailaPlugin {

    @Override
    public void register(IWailaCommonRegistration registration) {
        // register data providers
        registration.registerBlockDataProvider(IncubatorComponent.INSTANCE, IncubatorBlockEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        // register component providers, icon providers, callbacks, and config options here
        registration.registerBlockComponent(IncubatorComponent.INSTANCE, IncubatorBlock.class);
    }
}
