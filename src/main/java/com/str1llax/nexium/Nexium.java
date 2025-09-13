package com.str1llax.nexium;

import com.str1llax.nexium.blocks.entity.NexiumBlockEntities;
import com.str1llax.nexium.config.NexiumClientConfig;
import com.str1llax.nexium.config.NexiumCommonConfig;
import com.str1llax.nexium.config.NexiumServerConfig;
import com.str1llax.nexium.entity.NexiumEntities;
import com.str1llax.nexium.entity.client.NexiumBoatRenderer;
import com.str1llax.nexium.entity.client.StonyRenderer;
import com.str1llax.nexium.loot.NexiumLootModifiers;
import com.str1llax.nexium.register.NexiumRecipes;
import com.str1llax.nexium.register.NexiumBlocks;
import com.str1llax.nexium.register.NexiumItems;
import com.str1llax.nexium.register.NexiumTabs;
import com.str1llax.nexium.register.NexiumMenus;
import com.str1llax.nexium.screen.screens.IncubatorScreen;
import com.str1llax.nexium.sound.NexiumSounds;
import com.str1llax.nexium.util.ModKeyBindings;
import com.str1llax.nexium.util.ModWoodTypes;
import com.str1llax.nexium.villager.ModVillagers;
import com.str1llax.nexium.worldgen.tree.NexiumFoliagePlacers;
import com.str1llax.nexium.worldgen.tree.NexiumTrunkPlacerTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Nexium.MOD_ID)
public class Nexium {
    public static final String MOD_ID = "nexium";
    public Nexium(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();

        context.registerConfig(ModConfig.Type.SERVER, NexiumServerConfig.SPEC);
        context.registerConfig(ModConfig.Type.COMMON, NexiumCommonConfig.SPEC);
        context.registerConfig(ModConfig.Type.CLIENT, NexiumClientConfig.SPEC);

        NexiumTabs.TABS.register(bus);
        NexiumItems.ITEMS.register(bus);
        NexiumBlocks.BLOCKS.register(bus);

        NexiumBlockEntities.register(bus);
        NexiumLootModifiers.register(bus);
        ModVillagers.register(bus);
        NexiumSounds.register(bus);
        NexiumEntities.register(bus);
        NexiumMenus.register(bus);
        NexiumRecipes.register(bus);

        NexiumTrunkPlacerTypes.register(bus);
        NexiumFoliagePlacers.register(bus);

        bus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(NexiumBlocks.FLOWIE.getId(), NexiumBlocks.POTTED_FLOWIE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(NexiumBlocks.HEVEA_SAPLING.getId(), NexiumBlocks.POTTED_HEVEA_SAPLING);
        });
    }
}
