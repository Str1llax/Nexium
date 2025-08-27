package com.str1llax.nexium.compat.Jade;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.blocks.entity.IncubatorBlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec2;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElement;
import snownee.jade.api.ui.IElementHelper;

public enum IncubatorComponent implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        if(blockAccessor.getServerData().contains("Progress")) {
            IElementHelper elements = IElementHelper.get();
            IElement icon = elements.item(new ItemStack(Items.EGG), 0.5f).size(new Vec2(10, 10)).translate(new Vec2(0, -1));
            icon.message(null);
            iTooltip.add(icon);
            iTooltip.append(Component.translatable("jade.nexium.incubator", blockAccessor.getServerData().getInt("Progress")));
        }
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        IncubatorBlockEntity incubator = (IncubatorBlockEntity) blockAccessor.getBlockEntity();
        compoundTag.putInt("Progress", incubator.progress);
    }

    @Override
    public ResourceLocation getUid() {
        return ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "incubator");
    }
}
