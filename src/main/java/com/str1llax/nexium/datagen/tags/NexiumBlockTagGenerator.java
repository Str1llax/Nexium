package com.str1llax.nexium.datagen.tags;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.register.NexiumBlocks;
import com.str1llax.nexium.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class NexiumBlockTagGenerator extends BlockTagsProvider {
    public NexiumBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Nexium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        /*this.tag(ModTags.Blocks.NAME)
                .add(NexiumBlocks.NAME.get())
                .addTag(Tags.Blocks.ORES);*/

        //MINECRAFT TAGS
        this.tag(BlockTags.MINEABLE_WITH_AXE);

        this.tag(BlockTags.MINEABLE_WITH_HOE);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(NexiumBlocks.CUT_AMETHYST_BLOCK.get())
                .add(NexiumBlocks.NEXIUM_ORE.get())
                .add(NexiumBlocks.DEEPSLATE_NEXIUM_ORE.get())
                .add(NexiumBlocks.NETHER_NEXIUM_ORE.get())
                .add(NexiumBlocks.END_NEXIUM_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(NexiumBlocks.CUT_AMETHYST_BLOCK.get());

        this.tag(BlockTags.CRYSTAL_SOUND_BLOCKS)
                .add(NexiumBlocks.CUT_AMETHYST_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(NexiumBlocks.NEXIUM_ORE.get())
                .add(NexiumBlocks.DEEPSLATE_NEXIUM_ORE.get())
                .add(NexiumBlocks.NETHER_NEXIUM_ORE.get())
                .add(NexiumBlocks.END_NEXIUM_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL);

        this.tag(BlockTags.NEEDS_STONE_TOOL);

        this.tag(BlockTags.WOODEN_FENCES)
                .add(NexiumBlocks.HEVEA_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(NexiumBlocks.HEVEA_FENCE_GATE.get());

        this.tag(BlockTags.WOODEN_STAIRS)
                .add(NexiumBlocks.HEVEA_STAIRS.get());

        this.tag(BlockTags.WOODEN_SLABS)
                .add(NexiumBlocks.HEVEA_SLAB.get());

        this.tag(BlockTags.WOODEN_DOORS)
                .add(NexiumBlocks.HEVEA_DOOR.get());

        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(NexiumBlocks.HEVEA_TRAPDOOR.get());

        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(NexiumBlocks.HEVEA_PRESSURE_PLATE.get());

        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(NexiumBlocks.HEVEA_BUTTON.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(NexiumBlocks.HEVEA_LOG.get(),
                        NexiumBlocks.STRIPPED_HEVEA_LOG.get(),
                        NexiumBlocks.HEVEA_WOOD.get(),
                        NexiumBlocks.STRIPPED_HEVEA_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(NexiumBlocks.HEVEA_PLANKS.get());

        this.tag(BlockTags.LEAVES)
                .add(NexiumBlocks.HEVEA_LEAVES.get());

        this.tag(BlockTags.STANDING_SIGNS)
                .add(NexiumBlocks.HEVEA_SIGN.get());

        this.tag(BlockTags.WALL_SIGNS)
                .add(NexiumBlocks.HEVEA_WALL_SIGN.get());

        this.tag(BlockTags.CEILING_HANGING_SIGNS)
                .add(NexiumBlocks.HEVEA_HANGING_SIGN.get());

        this.tag(BlockTags.WALL_HANGING_SIGNS)
                .add(NexiumBlocks.HEVEA_WALL_HANGING_SIGN.get());

        this.tag(BlockTags.MAINTAINS_FARMLAND)
                .add(NexiumBlocks.GARLIC_CROP.get());

        this.tag(BlockTags.BEE_GROWABLES)
                .add(NexiumBlocks.GARLIC_CROP.get());

        this.tag(BlockTags.CROPS)
                .add(NexiumBlocks.GARLIC_CROP.get());

        //FORGE TAGS
        this.tag(Tags.Blocks.STORAGE_BLOCKS_AMETHYST)
                .add(NexiumBlocks.CUT_AMETHYST_BLOCK.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        this.tag(Tags.Blocks.NEEDS_GOLD_TOOL);

        this.tag(Tags.Blocks.NEEDS_WOOD_TOOL);

        this.tag(Tags.Blocks.ORES_IN_GROUND_STONE)
                .add(NexiumBlocks.NEXIUM_ORE.get());

        this.tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE)
                .add(NexiumBlocks.DEEPSLATE_NEXIUM_ORE.get());

        this.tag(Tags.Blocks.ORES_IN_GROUND_NETHERRACK)
                .add(NexiumBlocks.NETHER_NEXIUM_ORE.get());

        this.tag(Tags.Blocks.ORES)
                .add(NexiumBlocks.NEXIUM_ORE.get())
                .add(NexiumBlocks.DEEPSLATE_NEXIUM_ORE.get())
                .add(NexiumBlocks.NETHER_NEXIUM_ORE.get())
                .add(NexiumBlocks.END_NEXIUM_ORE.get());

        this.tag(Tags.Blocks.ORE_RATES_SINGULAR)
                .add(NexiumBlocks.NEXIUM_ORE.get())
                .add(NexiumBlocks.DEEPSLATE_NEXIUM_ORE.get())
                .add(NexiumBlocks.NETHER_NEXIUM_ORE.get())
                .add(NexiumBlocks.END_NEXIUM_ORE.get());

        //NEXIUM TAGS
        this.tag(ModTags.Blocks.NEEDS_AMETHYST_TOOL)
                .add(NexiumBlocks.SOUND_BLOCK.get());

        this.tag(ModTags.Blocks.NEXIUM_ORES)
                .add(NexiumBlocks.NEXIUM_ORE.get())
                .add(NexiumBlocks.DEEPSLATE_NEXIUM_ORE.get())
                .add(NexiumBlocks.NETHER_NEXIUM_ORE.get())
                .add(NexiumBlocks.END_NEXIUM_ORE.get());
    }
}
