package com.str1llax.nexium.items.bases;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class BaseItem extends Item {
    private String shiftTooltipKey = "tooltip.nexium.shift.";
    private String tooltipKey = "tooltip.nexium.";
    private boolean hasTooltip = false;
    private boolean isShift = false;

    public BaseItem(Properties pProperties) {
        super(pProperties);
    }

    public BaseItem(Properties pProperties, String tooltipKey) {
        super(pProperties);
        this.tooltipKey += tooltipKey;
        this.hasTooltip = true;
    }

    public BaseItem(Properties pProperties, String tooltipKey, String shiftTooltipKey) {
        super(pProperties);
        this.shiftTooltipKey += shiftTooltipKey;
        this.tooltipKey += tooltipKey;
        this.hasTooltip = true;
        this.isShift = true;
    }


    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack pStack, @org.jetbrains.annotations.Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(hasTooltip){
            if(isShift){
                if(!Screen.hasShiftDown()){
                    pTooltipComponents.add(Component.translatable(tooltipKey).withStyle(ChatFormatting.GRAY));
                } else {
                    pTooltipComponents.add(Component.translatable(shiftTooltipKey).withStyle(ChatFormatting.GRAY));
                }
            } else {
                pTooltipComponents.add(Component.translatable(tooltipKey).withStyle(ChatFormatting.GRAY));
            }
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }
}
