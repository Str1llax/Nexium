package com.str1llax.nexium.compat.JEI;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.recipes.custom.IncubatorRecipe;
import com.str1llax.nexium.register.NexiumBlocks;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class IncubatorCategory implements IRecipeCategory<IncubatorRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "incubator");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "textures/jei/incubator_jei.png");
    public static final RecipeType<IncubatorRecipe> INCUBATOR_TYPE = new RecipeType<>(UID, IncubatorRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;

    public IncubatorCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 47, 14, 84, 62);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(NexiumBlocks.INCUBATOR.get()));
    }

    @Override
    public RecipeType<IncubatorRecipe> getRecipeType() {
        return INCUBATOR_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.nexium.incubator");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return this.background;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, IncubatorRecipe incubatorRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 6, 8).addIngredients(incubatorRecipe.getIngredients().get(0));

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 11, 42).addIngredients(incubatorRecipe.getIngredients().get(1));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 33, 42).addIngredients(incubatorRecipe.getIngredients().get(2));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 55, 42).addIngredients(incubatorRecipe.getIngredients().get(3));

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 60, 8).addItemStack(incubatorRecipe.getResultItem(null));
    }
}
