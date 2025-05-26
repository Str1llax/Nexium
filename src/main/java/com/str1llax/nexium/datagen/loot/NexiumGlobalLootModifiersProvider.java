package com.str1llax.nexium.datagen.loot;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.loot.AddItemModifier;
import com.str1llax.nexium.loot.AddSusSandModifier;
import com.str1llax.nexium.register.NexiumItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class NexiumGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public NexiumGlobalLootModifiersProvider(PackOutput output) {
        super(output, Nexium.MOD_ID);
    }

    @Override
    protected void start() {
        add("pine_cone_from_spruce_leaves", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SPRUCE_LEAVES).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, NexiumItems.PINE_CONE.get()));

        add("amethyst_from_jungle_temple", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/jungle_temple")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, NexiumItems.AMETHYST.get()));

        add("amethyst_smithing_template_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, NexiumItems.AMETHYST_SMITHING_TEMPLATE.get()));

        add("amethyst_from_suspicious_sand", new AddSusSandModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.parse("archaeology/desert_pyramid")).build()}, NexiumItems.AMETHYST.get()));
    }
}
