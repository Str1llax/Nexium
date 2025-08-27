package com.str1llax.nexium.datagen;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.datagen.loot.NexiumGlobalLootModifiersProvider;
import com.str1llax.nexium.datagen.loot.NexiumLootTableProvider;
import com.str1llax.nexium.datagen.models.NexiumBlockStateProvider;
import com.str1llax.nexium.datagen.models.NexiumItemModelProvider;
import com.str1llax.nexium.datagen.pois.NexiumPoITypeTagsProvider;
import com.str1llax.nexium.datagen.recipes.NexiumRecipeProvider;
import com.str1llax.nexium.datagen.tags.NexiumBiomeTagGenerator;
import com.str1llax.nexium.datagen.tags.NexiumBlockTagGenerator;
import com.str1llax.nexium.datagen.tags.NexiumItemTagGenerator;
import com.str1llax.nexium.datagen.worldgen.NexiumWorldGenProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Nexium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new NexiumRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), NexiumLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new NexiumBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new NexiumItemModelProvider(packOutput, existingFileHelper));

        NexiumBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new NexiumBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new NexiumItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeServer(), new NexiumGlobalLootModifiersProvider(packOutput));
        generator.addProvider(event.includeServer(), new NexiumPoITypeTagsProvider(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new NexiumWorldGenProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new NexiumBiomeTagGenerator(packOutput, lookupProvider, existingFileHelper));
    }
}
