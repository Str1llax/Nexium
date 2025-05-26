package com.str1llax.nexium.register;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.recipes.custom.IncubatorRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NexiumRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Nexium.MOD_ID);

    public static final RegistryObject<RecipeSerializer<IncubatorRecipe>> INCUBATOR_SERIALIZER = SERIALIZERS.register("incubating", () -> IncubatorRecipe.Serializer.INSTANCE);

    public static void register(IEventBus bus) {
        SERIALIZERS.register(bus);
    }
}
