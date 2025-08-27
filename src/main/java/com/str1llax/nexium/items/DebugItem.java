package com.str1llax.nexium.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DebugItem extends Item {
    public DebugItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(pPlayer.isCrouching() && pPlayer.getItemInHand(pUsedHand).hasTag()) {
            pPlayer.getItemInHand(pUsedHand).setTag(new CompoundTag());
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide) {
            BlockPos clickedPos = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            BlockState state = pContext.getLevel().getBlockState(clickedPos);
            String id = BuiltInRegistries.ITEM.getKey(state.getBlock().asItem()).toString();
            CompoundTag nbtData = new CompoundTag();

            nbtData.putString("nexium.debug_ore", id);
            pContext.getItemInHand().setTag(nbtData);
            player.sendSystemMessage(Component.translatable("chat.nexium.debug_item", id));
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return pStack.hasTag();
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(pStack.hasTag()) {
            String id = pStack.getTag().getString("nexium.debug_ore");
            pTooltipComponents.add(Component.translatable("chat.nexium.debug_item", id));
        }
    }
}
