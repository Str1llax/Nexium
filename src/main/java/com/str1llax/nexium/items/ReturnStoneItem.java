package com.str1llax.nexium.items;

import com.str1llax.nexium.items.bases.BaseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class ReturnStoneItem extends BaseItem {
    public ReturnStoneItem(Properties pProperties, String tooltipKey, String shiftTooltipKey) {
        super(pProperties.stacksTo(64), tooltipKey, shiftTooltipKey);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide) {
            ServerPlayer sPlayer = (ServerPlayer) pPlayer;
            if(sPlayer.getRespawnPosition() == null) {
                sPlayer.teleportTo(sPlayer.serverLevel(),
                        sPlayer.serverLevel().getSharedSpawnPos().getX()+0.5f,
                        sPlayer.serverLevel().getSharedSpawnPos().getY(),
                        sPlayer.serverLevel().getSharedSpawnPos().getZ()+0.5f,
                        pPlayer.getYRot(), pPlayer.getXRot());
            } else {
                BlockPos validTeleport = searchForNearest(sPlayer, pLevel, blockSurroundings(sPlayer.getRespawnPosition()));
                if(canTeleport(validTeleport)) {
                    sPlayer.teleportTo(sPlayer.serverLevel(),
                            validTeleport.getX()+0.5f,
                            validTeleport.getY(),
                            validTeleport.getZ()+0.5f,
                            pPlayer.getYRot(), pPlayer.getXRot());
                }
            }
        }
        pPlayer.playSound(SoundEvents.LARGE_AMETHYST_BUD_BREAK);
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.addEffect(new MobEffectInstance(MobEffects.GLOWING, 40));
        if(!pPlayer.isCreative()) stack.shrink(1);
        return InteractionResultHolder.success(stack);
    }

    private static boolean canTeleport(BlockPos blockPos) {
        return blockPos != null;
    }

    private static BlockPos searchForNearest(ServerPlayer pPlayer, Level pLevel, int[][] offsets) {
        for(int[] curOff : offsets) {
            BlockPos currBlock = new BlockPos(curOff[0], pPlayer.getRespawnPosition().getY(), curOff[1]);
            if(pLevel.getBlockState(currBlock).is(Blocks.AIR)) return currBlock;
        }
        return null;
    }

    private static int[][] blockSurroundings(BlockPos blockPos) {
        return new int[][]{
                {blockPos.getX()+1, blockPos.getZ()},
                {blockPos.getX()+1, blockPos.getZ()+1},
                {blockPos.getX(), blockPos.getZ()+1},
                {blockPos.getX()-1, blockPos.getZ()+1},
                {blockPos.getX()-1, blockPos.getZ()},
                {blockPos.getX()-1, blockPos.getZ()-1},
                {blockPos.getX(), blockPos.getZ()-1},
                {blockPos.getX()+1, blockPos.getZ()-1},
        };
    }
}
