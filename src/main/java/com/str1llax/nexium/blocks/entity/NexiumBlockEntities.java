package com.str1llax.nexium.blocks.entity;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.register.NexiumBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NexiumBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Nexium.MOD_ID);

    public static final RegistryObject<BlockEntityType<IncubatorBlockEntity>> INCUBATOR_BLOCK_ENTITY = BLOCK_ENTITIES.register("incubator_block_entity", () ->
            BlockEntityType.Builder.of(IncubatorBlockEntity::new, NexiumBlocks.INCUBATOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<NexiumSignBlockEntity>> MOD_SIGN = BLOCK_ENTITIES.register("mod_sign",
            () -> BlockEntityType.Builder.of(NexiumSignBlockEntity::new, NexiumBlocks.HEVEA_SIGN.get(), NexiumBlocks.HEVEA_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<NexiumHangingSignBlockEntity>> MOD_HANGING_SIGN = BLOCK_ENTITIES.register("mod_hanging_sign",
            () -> BlockEntityType.Builder.of(NexiumHangingSignBlockEntity::new, NexiumBlocks.HEVEA_HANGING_SIGN.get(), NexiumBlocks.HEVEA_WALL_HANGING_SIGN.get()).build(null));

    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }
}
