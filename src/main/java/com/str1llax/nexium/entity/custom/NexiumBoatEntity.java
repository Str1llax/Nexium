package com.str1llax.nexium.entity.custom;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.entity.NexiumEntities;
import com.str1llax.nexium.register.NexiumBlocks;
import com.str1llax.nexium.register.NexiumItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.function.IntFunction;

public class NexiumBoatEntity extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);

    public NexiumBoatEntity(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public NexiumBoatEntity(Level level, double x, double y, double z) {
        this(NexiumEntities.NEXIUM_BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    public Item getDropItem() {
        return switch (getModVariant()) {
            case HEVEA -> NexiumItems.HEVEA_BOAT.get();
        };
    }

    public void setVariant(Type variant) {
        this.entityData.set(DATA_ID_TYPE, variant.ordinal());
    }

    public Type getModVariant() {
        return Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, Type.HEVEA.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        if(compound.contains("Type", 8)) {
            this.setVariant(Type.byName(compound.getString("Type")));
        }
    }

    public static enum Type implements StringRepresentable {
        HEVEA(NexiumBlocks.HEVEA_PLANKS.get(), "hevea");

        private final String name;
        private final Block planks;
        public static final StringRepresentable.EnumCodec<NexiumBoatEntity.Type> CODEC = StringRepresentable.fromEnum(NexiumBoatEntity.Type::values);
        private static final IntFunction<NexiumBoatEntity.Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

        private Type(Block pPlanks, String pName) {
            this.name = pName;
            this.planks = pPlanks;
        }

        public String getSerializedName() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        /**
         * Get a boat type by its enum ordinal
         */
        public static NexiumBoatEntity.Type byId(int pId) {
            return BY_ID.apply(pId);
        }

        public static NexiumBoatEntity.Type byName(String pName) {
            return CODEC.byName(pName, HEVEA);
        }
    }
}
