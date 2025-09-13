package com.str1llax.nexium.events;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.items.DebugItem;
import com.str1llax.nexium.util.ModKeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Nexium.MOD_ID, value = Dist.CLIENT)
public class NexiumClientEvents {
    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (ModKeyBindings.activateDebugItemKey.consumeClick()) {
            Minecraft minecraft = Minecraft.getInstance();
            if(minecraft.player == null || minecraft.level == null) return;
            Item mainHandItem = minecraft.player.getItemInHand(InteractionHand.MAIN_HAND).getItem();
            if(mainHandItem instanceof DebugItem debugItem) {
                debugItem.onKeyPressed(minecraft.player, minecraft.player.level());
                minecraft.player.getItemInHand(InteractionHand.MAIN_HAND).setCount(0);
                minecraft.player.addItem(new ItemStack(Items.DIAMOND, 1));
            }
        }
    }
}
