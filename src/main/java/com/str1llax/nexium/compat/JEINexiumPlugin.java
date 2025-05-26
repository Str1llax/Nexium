package com.str1llax.nexium.compat;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.compat.JEI.IncubatorCategory;
import com.str1llax.nexium.recipes.custom.IncubatorRecipe;
import com.str1llax.nexium.register.NexiumBlocks;
import com.str1llax.nexium.screen.screens.IncubatorScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEINexiumPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new IncubatorCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<IncubatorRecipe> incubatorRecipes = recipeManager.getAllRecipesFor(IncubatorRecipe.Type.INSTANCE);
        registration.addRecipes(IncubatorCategory.INCUBATOR_TYPE, incubatorRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(IncubatorScreen.class, 75, 23, 22, 15, IncubatorCategory.INCUBATOR_TYPE);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(NexiumBlocks.INCUBATOR.get(), IncubatorCategory.INCUBATOR_TYPE);
    }
}
