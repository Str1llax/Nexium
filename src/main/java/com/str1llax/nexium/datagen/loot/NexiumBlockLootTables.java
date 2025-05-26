package com.str1llax.nexium.datagen.loot;

import com.str1llax.nexium.blocks.CornCropBlock;
import com.str1llax.nexium.blocks.GarlicCropBlock;
import com.str1llax.nexium.register.NexiumBlocks;
import com.str1llax.nexium.register.NexiumItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class NexiumBlockLootTables extends BlockLootSubProvider {
    public NexiumBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(NexiumBlocks.CUT_AMETHYST_BLOCK.get());
        this.dropSelf(NexiumBlocks.SOUND_BLOCK.get());

        this.dropSelf(NexiumBlocks.HEVEA_SAPLING.get());
        this.dropSelf(NexiumBlocks.HEVEA_LOG.get());
        this.dropSelf(NexiumBlocks.STRIPPED_HEVEA_LOG.get());
        this.dropSelf(NexiumBlocks.HEVEA_WOOD.get());
        this.dropSelf(NexiumBlocks.STRIPPED_HEVEA_WOOD.get());
        this.dropSelf(NexiumBlocks.HEVEA_PLANKS.get());
        this.dropSelf(NexiumBlocks.HEVEA_STAIRS.get());
        this.dropSelf(NexiumBlocks.HEVEA_BUTTON.get());
        this.dropSelf(NexiumBlocks.HEVEA_PRESSURE_PLATE.get());
        this.dropSelf(NexiumBlocks.HEVEA_TRAPDOOR.get());
        this.dropSelf(NexiumBlocks.HEVEA_FENCE.get());
        this.dropSelf(NexiumBlocks.HEVEA_FENCE_GATE.get());

        this.add(NexiumBlocks.POTTED_HEVEA_SAPLING.get(), block -> createPotFlowerItemTable(NexiumBlocks.POTTED_HEVEA_SAPLING.get()));
        this.add(NexiumBlocks.HEVEA_LEAVES.get(), block -> createLeavesDrops(block, NexiumBlocks.HEVEA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(NexiumBlocks.HEVEA_SLAB.get(), block ->  createSlabItemTable(NexiumBlocks.HEVEA_SLAB.get()));
        this.add(NexiumBlocks.HEVEA_DOOR.get(), block ->  createDoorTable(NexiumBlocks.HEVEA_DOOR.get()));

        this.add(NexiumBlocks.HEVEA_SIGN.get(), block -> createSingleItemTable(NexiumBlocks.HEVEA_SIGN.get()));
        this.add(NexiumBlocks.HEVEA_WALL_SIGN.get(), block -> createSingleItemTable(NexiumBlocks.HEVEA_SIGN.get()));
        this.add(NexiumBlocks.HEVEA_HANGING_SIGN.get(), block -> createSingleItemTable(NexiumBlocks.HEVEA_HANGING_SIGN.get()));
        this.add(NexiumBlocks.HEVEA_WALL_HANGING_SIGN.get(), block -> createSingleItemTable(NexiumBlocks.HEVEA_HANGING_SIGN.get()));

        LootItemCondition.Builder lootItemCondition$Builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(NexiumBlocks.GARLIC_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GarlicCropBlock.AGE, 5));

        this.add(NexiumBlocks.GARLIC_CROP.get(), createCropDrops(NexiumBlocks.GARLIC_CROP.get(), NexiumItems.GARLIC.get(), NexiumItems.GARLIC_SEEDS.get(), lootItemCondition$Builder));

        LootItemCondition.Builder lootItemCondition$Builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(NexiumBlocks.CORN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 8));

        this.add(NexiumBlocks.CORN_CROP.get(), createCropDrops(NexiumBlocks.CORN_CROP.get(), NexiumItems.CORN.get(), NexiumItems.CORN_SEEDS.get(), lootItemCondition$Builder2));

        this.dropSelf(NexiumBlocks.FLOWIE.get());
        this.add(NexiumBlocks.POTTED_FLOWIE.get(), createPotFlowerItemTable(NexiumBlocks.POTTED_FLOWIE.get()));

        this.dropSelf(NexiumBlocks.INCUBATOR.get());

        this.dropWhenSilkTouch(NexiumBlocks.NEXIUM_ORE.get());
        this.dropWhenSilkTouch(NexiumBlocks.DEEPSLATE_NEXIUM_ORE.get());
        this.dropWhenSilkTouch(NexiumBlocks.NETHER_NEXIUM_ORE.get());
        this.dropWhenSilkTouch(NexiumBlocks.END_NEXIUM_ORE.get());

        this.add(NexiumBlocks.NEXIUM_ORE.get(),
                block -> createSmallOreDrops(NexiumBlocks.NEXIUM_ORE.get(), NexiumItems.NEXIUM_DUST.get()));
        this.add(NexiumBlocks.DEEPSLATE_NEXIUM_ORE.get(),
                block -> createSmallOreDrops(NexiumBlocks.DEEPSLATE_NEXIUM_ORE.get(), NexiumItems.NEXIUM_DUST.get()));
        this.add(NexiumBlocks.NETHER_NEXIUM_ORE.get(),
                block -> createSmallOreDrops(NexiumBlocks.NETHER_NEXIUM_ORE.get(), NexiumItems.NEXIUM_DUST.get()));
        this.add(NexiumBlocks.END_NEXIUM_ORE.get(),
                block -> createSmallOreDrops(NexiumBlocks.END_NEXIUM_ORE.get(), NexiumItems.NEXIUM_DUST.get()));

    }

    protected LootTable.Builder createSmallOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return NexiumBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
