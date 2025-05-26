package com.str1llax.nexium.blocks.signs;

import com.str1llax.nexium.blocks.entity.NexiumHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class NexiumHangingSignBlock extends CeilingHangingSignBlock {
    public NexiumHangingSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new NexiumHangingSignBlockEntity(pPos, pState);
    }
}
