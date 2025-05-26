package com.str1llax.nexium.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class NexiumHangingSignBlockEntity extends SignBlockEntity {
    public NexiumHangingSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(NexiumBlockEntities.MOD_HANGING_SIGN.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return NexiumBlockEntities.MOD_HANGING_SIGN.get();
    }
}
