package com.str1llax.nexium.blocks.bases;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.worldgen.dimension.NexiumDimensions;
import com.str1llax.nexium.worldgen.portal.NexiumTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.RegistryObject;

public class ModPortalBlock extends Block {
    private final ResourceKey<Level> dimKey;
    private final RegistryObject<Block> teleporter;

    public ModPortalBlock(Properties pProperties, ResourceKey<Level> dimensionKey, RegistryObject<Block> teleporter) {
        super(pProperties);
        this.dimKey = dimensionKey;
        this.teleporter = teleporter;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(pPlayer.canChangeDimensions()) {
            handlePortal(pPlayer, pPos);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.CONSUME;
        }
    }

    private void handlePortal(Entity player, BlockPos pos) {
        if (player.level() instanceof ServerLevel serverlevel) {
            MinecraftServer minecraftserver = serverlevel.getServer();
            ResourceKey<Level> resourcekey = player.level().dimension() == dimKey ?
                    Level.OVERWORLD : dimKey;

            ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);
            if (portalDimension != null && !player.isPassenger()) {
                if(resourcekey == dimKey) {
                    player.changeDimension(portalDimension, new NexiumTeleporter(pos, true, teleporter));
                } else {
                    player.changeDimension(portalDimension, new NexiumTeleporter(pos, false, teleporter));
                }
            }
        }
    }
}
