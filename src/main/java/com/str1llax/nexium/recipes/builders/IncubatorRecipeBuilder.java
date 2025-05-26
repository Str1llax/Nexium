package com.str1llax.nexium.recipes.builders;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.register.NexiumRecipes;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.apache.commons.compress.utils.Lists;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class IncubatorRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private String group;
    private final List<Ingredient> ingredients = Lists.newArrayList();

    public IncubatorRecipeBuilder(ItemLike result) {
        this.result = result.asItem();
    }

    public static IncubatorRecipeBuilder incubate(ItemLike result) {
        return new IncubatorRecipeBuilder(result);
    }

    public IncubatorRecipeBuilder requires(TagKey<Item> tagKey) {
        return this.requires(Ingredient.of(tagKey));
    }

    public IncubatorRecipeBuilder requires(ItemLike item) {
        return this.requires(Ingredient.of(item));
    }

    public IncubatorRecipeBuilder requires(Ingredient ingredient) {
        this.ingredients.add(ingredient);

        return this;
    }


    @Override
    public RecipeBuilder unlockedBy(String s, CriterionTriggerInstance criterionTriggerInstance) {
        return null;
    }

    @Override
    public RecipeBuilder group(@Nullable String s) {
        this.group = s;
        return this;
    }

    @Override
    public Item getResult() {
        return this.result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation resourceLocation) {
        consumer.accept(new Result(resourceLocation, this.result, this.ingredients));
    }

    public static class Result implements FinishedRecipe {
        private final Item result;
        private final List<Ingredient> ingredients;
        private final ResourceLocation id;

        public Result(ResourceLocation recipeId, Item result, List<Ingredient> ingredients) {
            this.result = result;
            this.ingredients = ingredients;
            this.id = recipeId;
        }

        @Override
        public void serializeRecipeData(JsonObject obj) {
            String ID = Nexium.MOD_ID + ":incubating";
            obj.addProperty("type", ID);

            JsonArray ing = new JsonArray();
            for(Ingredient i : this.ingredients) {
                ing.add(i.toJson());
            }

            obj.add("ingredients", ing);

            JsonObject res = new JsonObject();
            res.addProperty("item", BuiltInRegistries.ITEM.getKey(this.result).toString());

            obj.add("output", res);
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return NexiumRecipes.INCUBATOR_SERIALIZER.get();
        }

        @Override
        public @Nullable JsonObject serializeAdvancement() {
            return null;
        }

        @Override
        public @Nullable ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
