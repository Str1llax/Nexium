package com.str1llax.nexium.register;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class NexiumFoods {
    public static final FoodProperties SHAWARMA = new FoodProperties.Builder()
            .alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200), 1f)
            .nutrition(12)
            .saturationMod(1.5f)
            .build();

    public static final FoodProperties GARLIC = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 20), 1f)
            .nutrition(1)
            .saturationMod(0f)
            .build();

    public static final FoodProperties CORN = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.5f)
            .build();
}
