package com.str1llax.nexium.datagen.tags;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.register.NexiumBlocks;
import com.str1llax.nexium.register.NexiumItems;
import com.str1llax.nexium.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class NexiumItemTagGenerator extends ItemTagsProvider {
    public NexiumItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                                  CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Nexium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //NEXIUM TAGS
        this.tag(ModTags.Items.COOKED_MEAT)
                .add(Items.COOKED_BEEF,
                        Items.COOKED_CHICKEN,
                        Items.COOKED_MUTTON,
                        Items.COOKED_PORKCHOP,
                        Items.COOKED_RABBIT);

        //MINECRAFT TAGS
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(NexiumBlocks.HEVEA_LOG.get().asItem(),
                        NexiumBlocks.STRIPPED_HEVEA_LOG.get().asItem(),
                        NexiumBlocks.HEVEA_WOOD.get().asItem(),
                        NexiumBlocks.STRIPPED_HEVEA_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(NexiumBlocks.HEVEA_PLANKS.get().asItem());

        this.tag(ItemTags.LEAVES)
                .add(NexiumBlocks.HEVEA_LEAVES.get().asItem());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(NexiumItems.AMETHYST_HELMET.get(),
                        NexiumItems.AMETHYST_CHESTPLATE.get(),
                        NexiumItems.AMETHYST_LEGGINGS.get(),
                        NexiumItems.AMETHYST_BOOTS.get());

        this.tag(ItemTags.MUSIC_DISCS)
                .add(NexiumItems.RICK_ASTLEY_MUSIC_DISK.get());

        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(NexiumItems.RICK_ASTLEY_MUSIC_DISK.get());

        this.tag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(NexiumItems.GARLIC_SEEDS.get())
                .add(NexiumItems.CORN_SEEDS.get());

        this.tag(ItemTags.SWORDS)
                .add(NexiumItems.MURASAMA.get())
                .add(NexiumItems.AMETHYST_SWORD.get());

        this.tag(ItemTags.PICKAXES)
                .add(NexiumItems.AMETHYST_PICKAXE.get());

        this.tag(ItemTags.AXES)
                .add(NexiumItems.AMETHYST_AXE.get());

        this.tag(ItemTags.SHOVELS)
                .add(NexiumItems.AMETHYST_SHOVEL.get());

        this.tag(ItemTags.HOES)
                .add(NexiumItems.AMETHYST_HOE.get());

        //FORGE TAGS
        this.tag(Tags.Items.GEMS_AMETHYST)
                .add(NexiumItems.AMETHYST.get());

        this.tag(Tags.Items.CROPS)
                .add(NexiumItems.GARLIC.get());

        this.tag(Tags.Items.SEEDS)
                .add(NexiumItems.GARLIC_SEEDS.get());

        this.tag(Tags.Items.ARMORS_HELMETS)
                .add(NexiumItems.AMETHYST_HELMET.get());

        this.tag(Tags.Items.ARMORS_CHESTPLATES)
                .add(NexiumItems.AMETHYST_CHESTPLATE.get());

        this.tag(Tags.Items.ARMORS_LEGGINGS)
                .add(NexiumItems.AMETHYST_LEGGINGS.get());

        this.tag(Tags.Items.ARMORS_BOOTS)
                .add(NexiumItems.AMETHYST_BOOTS.get());

        this.tag(Tags.Items.ORES_IN_GROUND_STONE)
                .add(NexiumBlocks.NEXIUM_ORE.get().asItem());

        this.tag(Tags.Items.ORES_IN_GROUND_DEEPSLATE)
                .add(NexiumBlocks.DEEPSLATE_NEXIUM_ORE.get().asItem());

        this.tag(Tags.Items.ORES_IN_GROUND_NETHERRACK)
                .add(NexiumBlocks.NETHER_NEXIUM_ORE.get().asItem());

        this.tag(Tags.Items.ORES)
                .add(NexiumBlocks.NEXIUM_ORE.get().asItem())
                .add(NexiumBlocks.DEEPSLATE_NEXIUM_ORE.get().asItem())
                .add(NexiumBlocks.NETHER_NEXIUM_ORE.get().asItem())
                .add(NexiumBlocks.END_NEXIUM_ORE.get().asItem());

        this.tag(Tags.Items.ORE_RATES_SINGULAR)
                .add(NexiumBlocks.NEXIUM_ORE.get().asItem())
                .add(NexiumBlocks.DEEPSLATE_NEXIUM_ORE.get().asItem())
                .add(NexiumBlocks.NETHER_NEXIUM_ORE.get().asItem())
                .add(NexiumBlocks.END_NEXIUM_ORE.get().asItem());
    }
}
