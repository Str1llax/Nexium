package com.str1llax.nexium.datagen.tags;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.util.ModTags;
import com.str1llax.nexium.worldgen.biomes.NexiumBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;

import java.util.concurrent.CompletableFuture;

public class NexiumBiomeTagGenerator extends BiomeTagsProvider {
    public NexiumBiomeTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @org.jetbrains.annotations.Nullable net.minecraftforge.common.data.ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, Nexium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Biomes.IS_TEST).addOptional(NexiumBiomes.TEST_BIOME.location());
    }
}
