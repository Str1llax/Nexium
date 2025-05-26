package com.str1llax.nexium.items;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class MurasamaItem extends SwordItem {
    public MurasamaItem() {
        super(Tiers.NETHERITE, 9995, 6f,
                new Item.Properties()
                        .fireResistant()
                        .rarity(Rarity.EPIC)
                        .durability(999999));
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        pLivingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 2));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.nexium.murasama_1"));
            pTooltipComponents.add(Component.translatable("tooltip.nexium.murasama_2").withStyle(ChatFormatting.BLUE, ChatFormatting.BOLD));
            pTooltipComponents.add(Component.translatable("tooltip.nexium.murasama_3").withStyle(ChatFormatting.GREEN, ChatFormatting.BOLD));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.nexium.murasama_shift"));
        }
    }
}
