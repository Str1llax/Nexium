package com.str1llax.nexium.blocks.bases;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BaseBlock extends Block {
    private String shiftTooltipKey = "tooltip.nexium.shift.";
    private String tooltipKey = "tooltip.nexium.";
    private boolean hasTooltip = false;
    private boolean isShift = false;


    public BaseBlock(Block.Properties pProperties) {
        super(pProperties);
    }

    public BaseBlock(Block.Properties pProperties, String tooltipKey) {
        super(pProperties);
        this.tooltipKey += tooltipKey;
        this.hasTooltip = true;
    }

    public BaseBlock(Block.Properties pProperties, String tooltipKey, String shiftTooltipKey) {
        super(pProperties);
        this.shiftTooltipKey += shiftTooltipKey;
        this.tooltipKey += tooltipKey;
        this.hasTooltip = true;
        this.isShift = true;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        if(hasTooltip){
            if(isShift){
                if(Screen.hasShiftDown()){
                    pTooltip.add(Component.translatable(tooltipKey).withStyle(ChatFormatting.GRAY));
                } else {
                    pTooltip.add(Component.translatable(shiftTooltipKey).withStyle(ChatFormatting.GRAY));
                }
            } else {
                pTooltip.add(Component.translatable(tooltipKey).withStyle(ChatFormatting.GRAY));
            }
            super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
        }
    }
}
