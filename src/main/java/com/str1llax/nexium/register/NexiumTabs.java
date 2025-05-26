package com.str1llax.nexium.register;

import com.str1llax.nexium.Nexium;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class NexiumTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Nexium.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAIN_TAB = register("main_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(NexiumItems.DEBUG_ITEM.get()))
                    .title(Component.translatable("tab." + Nexium.MOD_ID + ".main_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(NexiumItems.DEBUG_ITEM.get());
                        pOutput.accept(NexiumBlocks.SOUND_BLOCK.get());
                        pOutput.accept(NexiumItems.RICK_ASTLEY_MUSIC_DISK.get());
                        pOutput.accept(NexiumItems.SHAWARMA.get());
                        pOutput.accept(NexiumItems.PINE_CONE.get());
                        pOutput.accept(NexiumItems.GARLIC.get());
                        pOutput.accept(NexiumItems.GARLIC_SEEDS.get());
                        pOutput.accept(NexiumItems.CORN.get());
                        pOutput.accept(NexiumItems.CORN_SEEDS.get());
                        pOutput.accept(NexiumItems.RETURN_STONE.get());
                        pOutput.accept(NexiumItems.MURASAMA.get());
                        pOutput.accept(NexiumItems.DICE.get());
                        pOutput.accept(NexiumBlocks.DICE_BLOCK.get());
                        pOutput.accept(NexiumBlocks.MATRIX_PORTAL.get());

                        pOutput.accept(NexiumBlocks.NEXIUM_ORE.get());
                        pOutput.accept(NexiumBlocks.DEEPSLATE_NEXIUM_ORE.get());
                        pOutput.accept(NexiumBlocks.NETHER_NEXIUM_ORE.get());
                        pOutput.accept(NexiumBlocks.END_NEXIUM_ORE.get());
                        pOutput.accept(NexiumItems.NEXIUM_DUST.get());

                        pOutput.accept(NexiumItems.AMETHYST_SMITHING_TEMPLATE.get());
                        pOutput.accept(NexiumItems.AMETHYST.get());
                        pOutput.accept(NexiumBlocks.CUT_AMETHYST_BLOCK.get());
                        pOutput.accept(NexiumItems.AMETHYST_SWORD.get());
                        pOutput.accept(NexiumItems.AMETHYST_PICKAXE.get());
                        pOutput.accept(NexiumItems.AMETHYST_AXE.get());
                        pOutput.accept(NexiumItems.AMETHYST_SHOVEL.get());
                        pOutput.accept(NexiumItems.AMETHYST_HOE.get());

                        pOutput.accept(NexiumItems.AMETHYST_HELMET.get());
                        pOutput.accept(NexiumItems.AMETHYST_CHESTPLATE.get());
                        pOutput.accept(NexiumItems.AMETHYST_LEGGINGS.get());
                        pOutput.accept(NexiumItems.AMETHYST_BOOTS.get());

                        pOutput.accept(NexiumBlocks.HEVEA_SAPLING.get());
                        pOutput.accept(NexiumBlocks.HEVEA_LOG.get());
                        pOutput.accept(NexiumBlocks.HEVEA_WOOD.get());
                        pOutput.accept(NexiumBlocks.STRIPPED_HEVEA_LOG.get());
                        pOutput.accept(NexiumBlocks.STRIPPED_HEVEA_WOOD.get());
                        pOutput.accept(NexiumBlocks.HEVEA_PLANKS.get());
                        pOutput.accept(NexiumBlocks.HEVEA_LEAVES.get());
                        pOutput.accept(NexiumBlocks.HEVEA_STAIRS.get());
                        pOutput.accept(NexiumBlocks.HEVEA_SLAB.get());
                        pOutput.accept(NexiumBlocks.HEVEA_PRESSURE_PLATE.get());
                        pOutput.accept(NexiumBlocks.HEVEA_BUTTON.get());
                        pOutput.accept(NexiumBlocks.HEVEA_DOOR.get());
                        pOutput.accept(NexiumBlocks.HEVEA_TRAPDOOR.get());
                        pOutput.accept(NexiumBlocks.HEVEA_FENCE.get());
                        pOutput.accept(NexiumBlocks.HEVEA_FENCE_GATE.get());
                        pOutput.accept(NexiumBlocks.HEVEA_SIGN.get());
                        pOutput.accept(NexiumBlocks.HEVEA_HANGING_SIGN.get());
                        pOutput.accept(NexiumItems.HEVEA_BOAT.get());
                        pOutput.accept(NexiumItems.HEVEA_CHEST_BOAT.get());

                        pOutput.accept(NexiumBlocks.FLOWIE.get());

                        pOutput.accept(NexiumItems.STONY_SPAWN_EGG.get());

                        pOutput.accept(NexiumBlocks.INCUBATOR.get());
                    })
                    .build());

    private static <T extends CreativeModeTab> RegistryObject<T> register(final String name, final Supplier<T> tab) {
        return TABS.register(name, tab);
    }
}
