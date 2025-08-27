package com.str1llax.nexium.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class YamatoItem extends SwordItem {
    public YamatoItem() {
        super(Tiers.NETHERITE, 495, 2f, new Item.Properties().fireResistant().rarity(Rarity.EPIC).durability(77777));
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {

    }
}
