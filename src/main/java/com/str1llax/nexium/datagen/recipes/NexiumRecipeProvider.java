package com.str1llax.nexium.datagen.recipes;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.recipes.builders.IncubatorRecipeBuilder;
import com.str1llax.nexium.register.NexiumBlocks;
import com.str1llax.nexium.register.NexiumItems;
import com.str1llax.nexium.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class NexiumRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public NexiumRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        stoneCutting(consumer, RecipeCategory.MISC, NexiumBlocks.CUT_AMETHYST_BLOCK.get(), Blocks.AMETHYST_BLOCK, 1);
        stoneCutting(consumer, RecipeCategory.MISC, NexiumItems.AMETHYST.get(), NexiumBlocks.CUT_AMETHYST_BLOCK.get(), 4);

        smithingTransform(consumer, RecipeCategory.MISC, NexiumItems.AMETHYST_SMITHING_TEMPLATE.get(), Items.IRON_SWORD, NexiumItems.AMETHYST.get(), NexiumItems.AMETHYST_SWORD.get());
        smithingTransform(consumer, RecipeCategory.MISC, NexiumItems.AMETHYST_SMITHING_TEMPLATE.get(), Items.IRON_PICKAXE, NexiumItems.AMETHYST.get(), NexiumItems.AMETHYST_PICKAXE.get());
        smithingTransform(consumer, RecipeCategory.MISC, NexiumItems.AMETHYST_SMITHING_TEMPLATE.get(), Items.IRON_AXE, NexiumItems.AMETHYST.get(), NexiumItems.AMETHYST_AXE.get());
        smithingTransform(consumer, RecipeCategory.MISC, NexiumItems.AMETHYST_SMITHING_TEMPLATE.get(), Items.IRON_SHOVEL, NexiumItems.AMETHYST.get(), NexiumItems.AMETHYST_SHOVEL.get());
        smithingTransform(consumer, RecipeCategory.MISC, NexiumItems.AMETHYST_SMITHING_TEMPLATE.get(), Items.IRON_HOE, NexiumItems.AMETHYST.get(), NexiumItems.AMETHYST_HOE.get());
        smithingTransform(consumer, RecipeCategory.MISC, NexiumItems.AMETHYST_SMITHING_TEMPLATE.get(), Items.IRON_HELMET, NexiumItems.AMETHYST.get(), NexiumItems.AMETHYST_HELMET.get());
        smithingTransform(consumer, RecipeCategory.MISC, NexiumItems.AMETHYST_SMITHING_TEMPLATE.get(), Items.IRON_CHESTPLATE, NexiumItems.AMETHYST.get(), NexiumItems.AMETHYST_CHESTPLATE.get());
        smithingTransform(consumer, RecipeCategory.MISC, NexiumItems.AMETHYST_SMITHING_TEMPLATE.get(), Items.IRON_LEGGINGS, NexiumItems.AMETHYST.get(), NexiumItems.AMETHYST_LEGGINGS.get());
        smithingTransform(consumer, RecipeCategory.MISC, NexiumItems.AMETHYST_SMITHING_TEMPLATE.get(), Items.IRON_BOOTS, NexiumItems.AMETHYST.get(), NexiumItems.AMETHYST_BOOTS.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, NexiumItems.SHAWARMA.get(), 1)
                .requires(Items.BREAD)
                .requires(Items.CARROT)
                .requires(Items.BAKED_POTATO)
                .requires(ModTags.Items.COOKED_MEAT)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .save(consumer);

        IncubatorRecipeBuilder.incubate(NexiumItems.STONY_SPAWN_EGG.get())
                .requires(Items.EGG)
                .requires(Items.STONE)
                .requires(Items.DIAMOND)
                .requires(Items.AMETHYST_SHARD)
                .save(consumer, Nexium.MOD_ID + ":" + getSimpleRecipeName(NexiumItems.STONY_SPAWN_EGG.get()) + "_incubating");
/*
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, NexiumItems.AMETHYST_SWORD.get(), 1)
                .pattern("x")
                .pattern("x")
                .pattern("i")
                .define('x', Ingredient.of(NexiumItems.AMETHYST.get()))
                .define('i', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(NexiumItems.AMETHYST.get()), has(NexiumItems.AMETHYST.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, NexiumItems.AMETHYST_PICKAXE.get(), 1)
                .pattern("xxx")
                .pattern(" i ")
                .pattern(" i ")
                .define('x', Ingredient.of(NexiumItems.AMETHYST.get()))
                .define('i', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(NexiumItems.AMETHYST.get()), has(NexiumItems.AMETHYST.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, NexiumItems.AMETHYST_AXE.get(), 1)
                .pattern("xx")
                .pattern("xi")
                .pattern(" i")
                .define('x', Ingredient.of(NexiumItems.AMETHYST.get()))
                .define('i', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(NexiumItems.AMETHYST.get()), has(NexiumItems.AMETHYST.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, NexiumItems.AMETHYST_SHOVEL.get(), 1)
                .pattern("x")
                .pattern("i")
                .pattern("i")
                .define('x', Ingredient.of(NexiumItems.AMETHYST.get()))
                .define('i', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(NexiumItems.AMETHYST.get()), has(NexiumItems.AMETHYST.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, NexiumItems.AMETHYST_HOE.get(), 1)
                .pattern("xx")
                .pattern(" i")
                .pattern(" i")
                .define('x', Ingredient.of(NexiumItems.AMETHYST.get()))
                .define('i', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(NexiumItems.AMETHYST.get()), has(NexiumItems.AMETHYST.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, NexiumItems.AMETHYST_HELMET.get(), 1)
                .pattern("xxx")
                .pattern("x x")
                .define('x', Ingredient.of(NexiumItems.AMETHYST.get()))
                .unlockedBy(getHasName(NexiumItems.AMETHYST.get()), has(NexiumItems.AMETHYST.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, NexiumItems.AMETHYST_CHESTPLATE.get(), 1)
                .pattern("x x")
                .pattern("xxx")
                .pattern("xxx")
                .define('x', Ingredient.of(NexiumItems.AMETHYST.get()))
                .unlockedBy(getHasName(NexiumItems.AMETHYST.get()), has(NexiumItems.AMETHYST.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, NexiumItems.AMETHYST_LEGGINGS.get(), 1)
                .pattern("xxx")
                .pattern("x x")
                .pattern("x x")
                .define('x', Ingredient.of(NexiumItems.AMETHYST.get()))
                .unlockedBy(getHasName(NexiumItems.AMETHYST.get()), has(NexiumItems.AMETHYST.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, NexiumItems.AMETHYST_BOOTS.get(), 1)
                .pattern("x x")
                .pattern("x x")
                .define('x', Ingredient.of(NexiumItems.AMETHYST.get()))
                .unlockedBy(getHasName(NexiumItems.AMETHYST.get()), has(NexiumItems.AMETHYST.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, NexiumItems.AMETHYST_SMITHING_TEMPLATE.get(), 2)
                .pattern("xtx")
                .pattern("xdx")
                .pattern("xxx").define('x', Ingredient.of(NexiumItems.AMETHYST.get()))
                .define('d', Ingredient.of(Items.DEEPSLATE))
                .define('t', Ingredient.of(NexiumItems.AMETHYST_SMITHING_TEMPLATE.get()))
                .unlockedBy(getHasName(NexiumItems.AMETHYST_SMITHING_TEMPLATE.get()), has(NexiumItems.AMETHYST_SMITHING_TEMPLATE.get()))
                .save(consumer);
*/
    }

    protected static void stoneCutting(Consumer<FinishedRecipe> consumer, RecipeCategory category, ItemLike result, ItemLike material, int count) {
        SingleItemRecipeBuilder builder = SingleItemRecipeBuilder.stonecutting(Ingredient.of(new ItemLike[]{material}), category, result, count).unlockedBy(getHasName(material), has(material));
        String recipeName = getConversionRecipeName(result, material);
        builder.save(consumer, Nexium.MOD_ID + ":" + recipeName + "_stonecutting");
    }

    protected static void smithingTransform(Consumer<FinishedRecipe> consumer, RecipeCategory category, Item template, Item material, Item catalyst, Item result) {
        SmithingTransformRecipeBuilder builder = SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(material), Ingredient.of(catalyst), category, result)
                .unlocks(getHasName(template), has(template));
        String recipeName = getSimpleRecipeName(result);
        builder.save(consumer, Nexium.MOD_ID + ":" + recipeName + "_smithing-transform");
    }

    protected static void box2x2(Consumer<FinishedRecipe> consumer, Item material, Item result) {
        ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 1)
                .pattern("xx")
                .pattern("xx")
                .define('x', material)
                .unlockedBy(getHasName(material), has(material));
        String recipeName = getSimpleRecipeName(result);
        builder.save(consumer, Nexium.MOD_ID + ":" + recipeName + "_2x2");
    }

    protected static void box3x3(Consumer<FinishedRecipe> consumer, Item material, Item result) {
        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result, 1)
                .requires(material, 9)
                .unlockedBy(getHasName(material), has(material));
        String recipeName = getSimpleRecipeName(result);
        builder.save(consumer, Nexium.MOD_ID + ":" + recipeName + "_3x3");
    }
}
