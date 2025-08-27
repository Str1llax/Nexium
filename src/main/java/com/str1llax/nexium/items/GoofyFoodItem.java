package com.str1llax.nexium.items;

import com.str1llax.nexium.items.bases.BaseItem;
import com.str1llax.nexium.sound.NexiumSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;

public class GoofyFoodItem extends BaseItem {
    public GoofyFoodItem(Properties pProperties, String tooltipKey) {
        super(pProperties, tooltipKey);
    }

    @Override
    public SoundEvent getEatingSound() {
        return NexiumSounds.GOOFY_EATING.get();
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 80;
    }
}
