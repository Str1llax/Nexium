package com.str1llax.nexium.entity.custom;

import com.str1llax.nexium.entity.NexiumEntities;
import com.str1llax.nexium.register.NexiumItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import static com.str1llax.nexium.entity.custom.NexiumBoatEntity.Type.HEVEA;

public class NexiumChestBoatEntity extends ChestBoat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);

    public NexiumChestBoatEntity(EntityType<? extends ChestBoat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public NexiumChestBoatEntity(Level pLevel, double pX, double pY, double pZ) {
        this(NexiumEntities.NEXIUM_CHEST_BOAT.get(), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem() {
        switch (getModVariant()) {
            case HEVEA -> {
                return NexiumItems.HEVEA_CHEST_BOAT.get();
            }
        }
        return super.getDropItem();
    }

    public void setVariant(NexiumBoatEntity.Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, NexiumBoatEntity.Type.HEVEA.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(NexiumBoatEntity.Type.byName(pCompound.getString("Type")));
        }
    }

    public NexiumBoatEntity.Type getModVariant() {
        return NexiumBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }
}
