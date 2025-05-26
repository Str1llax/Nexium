package com.str1llax.nexium.entity;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.entity.custom.DiceProjectileEntity;
import com.str1llax.nexium.entity.custom.NexiumBoatEntity;
import com.str1llax.nexium.entity.custom.NexiumChestBoatEntity;
import com.str1llax.nexium.entity.custom.StonyEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NexiumEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Nexium.MOD_ID);

    public static final RegistryObject<EntityType<StonyEntity>> STONY = ENTITY_TYPES.register("stony",
            () -> EntityType.Builder.of(StonyEntity::new, MobCategory.CREATURE)
                    .sized(1.1f, 1.4f).build("stony"));

    public static final RegistryObject<EntityType<NexiumBoatEntity>> NEXIUM_BOAT = ENTITY_TYPES.register("nexium_boat",
            () -> EntityType.Builder.<NexiumBoatEntity>of(NexiumBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).build("nexium_boat"));

    public static final RegistryObject<EntityType<NexiumChestBoatEntity>> NEXIUM_CHEST_BOAT = ENTITY_TYPES.register("nexium_chest_boat",
            () -> EntityType.Builder.<NexiumChestBoatEntity>of(NexiumChestBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).build("nexium_chest_boat"));

    public static final RegistryObject<EntityType<DiceProjectileEntity>> DICE_PROJECTILE = ENTITY_TYPES.register("dice_projectile",
            () -> EntityType.Builder.<DiceProjectileEntity>of(DiceProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("dice_projectile"));

    public static void register(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }
}
