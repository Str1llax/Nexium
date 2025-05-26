package com.str1llax.nexium.events;

import com.mojang.blaze3d.vertex.PoseStack;
import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.register.NexiumBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHighlightEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Nexium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class NexiumForgeClientEvents {
/*
    @SubscribeEvent
    public static void onBlockHighlight(RenderHighlightEvent.Block event) {
        // Get the block position and player
        HitResult hitResult = event.getTarget();
        if (hitResult.getType() != HitResult.Type.BLOCK) return;

        BlockPos pos = ((BlockHitResult) hitResult).getBlockPos();
        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        // Get block state from the world
        Level level = player.level();
        BlockState state = level.getBlockState(pos);

        if (state.is(NexiumBlocks.NEXIUM_ORE.get())) { // Replace with your block
            // Cancel default translucent outline
            event.setCanceled(true);

            // Manually render opaque outline
            PoseStack poseStack = event.getPoseStack();
            MultiBufferSource buffers = event.getMultiBufferSource();

            // Get camera position for offset
            Vec3 cameraPos = event.getCamera().getPosition();
            double x = pos.getX() - cameraPos.x;
            double y = pos.getY() - cameraPos.y;
            double z = pos.getZ() - cameraPos.z;

            // Render full cube outline with alpha = 1.0
            LevelRenderer.renderVoxelShape(
                    poseStack,
                    buffers.getBuffer(RenderType.lines()),
                    Shapes.block(), // Full cube shape
                    pos.getX() - event.getCamera().getPosition().x,
                    pos.getY() - event.getCamera().getPosition().y,
                    pos.getZ() - event.getCamera().getPosition().z,
                    0.2f,0.2f, 0.2f, 1f, // RGB color (white)
                    false
            );
        }
    }*/
}
