package com.str1llax.nexium.items.bases;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class TemplateBaseItem extends SmithingTemplateItem {
    public TemplateBaseItem(String keyWord, String emptyIcon) {
        super(Component.translatable("description.nexium." + keyWord + "_upgrade_applies_to").withStyle(ChatFormatting.BLUE),
                Component.translatable("description.nexium." + keyWord + "_upgrade_ingredients").withStyle(ChatFormatting.BLUE),
                Component.translatable("description.nexium." + keyWord + "_upgrade").withStyle(ChatFormatting.GRAY),
                Component.translatable("description.nexium." + keyWord + "_upgrade_base_slot_description"),
                Component.translatable("description.nexium." + keyWord + "_upgrade_additions_slot_description"),
                List.of(ResourceLocation.parse("item/empty_armor_slot_helmet"),
                        ResourceLocation.parse("item/empty_armor_slot_chestplate"),
                        ResourceLocation.parse("item/empty_armor_slot_leggings"),
                        ResourceLocation.parse("item/empty_armor_slot_chestplate")),
                List.of(ResourceLocation.parse("item/empty_slot_" + emptyIcon)));
    }
}
