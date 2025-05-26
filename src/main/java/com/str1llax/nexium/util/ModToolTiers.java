package com.str1llax.nexium.util;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.register.NexiumItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier AMETHYST = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1024, 7.0F, 2.5f, 16, ModTags.Blocks.NEEDS_AMETHYST_TOOL, () -> Ingredient.of(NexiumItems.AMETHYST.get())),
            ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "amethyst"), List.of(Tiers.IRON), List.of(Tiers.NETHERITE));
}
