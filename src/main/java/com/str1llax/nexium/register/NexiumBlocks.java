package com.str1llax.nexium.register;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.blocks.*;
import com.str1llax.nexium.blocks.bases.*;
import com.str1llax.nexium.blocks.signs.NexiumHangingSignBlock;
import com.str1llax.nexium.blocks.signs.NexiumStandingSignBlock;
import com.str1llax.nexium.blocks.signs.NexiumWallHangingSignBlock;
import com.str1llax.nexium.blocks.signs.NexiumWallSignBlock;
import com.str1llax.nexium.util.ModWoodTypes;
import com.str1llax.nexium.worldgen.dimension.NexiumDimensions;
import com.str1llax.nexium.worldgen.tree.HeveaTreeGrower;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class NexiumBlocks {
    //Registers
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,Nexium.MOD_ID);

    //Blocks
    public static final RegistryObject<Block> CUT_AMETHYST_BLOCK = registerBlock("cut_amethyst_block",
            () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));

    public static final RegistryObject<Block> TEST_SPHERE = registerBlock("test_sphere",
            () -> new SphereBlock());

    public static final RegistryObject<Block> DICE_BLOCK = registerBlock("dice_block",
            () -> new DiceBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).noLootTable()));

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));

    public static final RegistryObject<Block> INCUBATOR = registerBlock("incubator",
            () -> new IncubatorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> MATRIX_PORTAL = registerBlock("matrix_portal",
            () -> new ModPortalBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable().noOcclusion(), NexiumDimensions.MATRIX_LEVEL_KEY, NexiumBlocks.MATRIX_PORTAL));

    //ore blocks
    public static final RegistryObject<Block> NEXIUM_ORE = registerBlock("nexium_ore",
            () -> new BaseOreBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));

    public static final RegistryObject<Block> DEEPSLATE_NEXIUM_ORE = registerBlock("deepslate_nexium_ore",
            () -> new BaseOreBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));

    public static final RegistryObject<Block> NETHER_NEXIUM_ORE = registerBlock("nether_nexium_ore",
            () -> new BaseOreBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).sound(SoundType.NETHER_ORE)));

    public static final RegistryObject<Block> END_NEXIUM_ORE = registerBlock("end_nexium_ore",
            () -> new BaseOreBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));

    //hevea blocks
    public static final RegistryObject<Block> HEVEA_LOG = registerBlock("hevea_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_HEVEA_LOG = registerBlock("stripped_hevea_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_HEVEA_WOOD = registerBlock("stripped_hevea_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> HEVEA_WOOD = registerBlock("hevea_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> HEVEA_PLANKS = registerBlock("hevea_planks",
            () -> new PlankBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> HEVEA_LEAVES = registerBlock("hevea_leaves",
            () -> new NexiumLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> HEVEA_BUTTON = registerBlock("hevea_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 20, true));

    public static final RegistryObject<Block> HEVEA_DOOR = registerBlock("hevea_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK));

    public static final RegistryObject<Block> HEVEA_FENCE = registerBlock("hevea_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));

    public static final RegistryObject<Block> HEVEA_FENCE_GATE = registerBlock("hevea_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> HEVEA_PRESSURE_PLATE = registerBlock("hevea_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));

    public static final RegistryObject<Block> HEVEA_SAPLING = registerBlock("hevea_sapling",
            () -> new SaplingBlock(new HeveaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> HEVEA_SLAB = registerBlock("hevea_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));

    public static final RegistryObject<Block> HEVEA_STAIRS = registerBlock("hevea_stairs",
            () -> new StairBlock(() -> NexiumBlocks.HEVEA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

    public static final RegistryObject<Block> HEVEA_TRAPDOOR = registerBlock("hevea_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));

    public static final RegistryObject<Block> HEVEA_SIGN = BLOCKS.register("hevea_sign",
            () -> new NexiumStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.HEVEA));

    public static final RegistryObject<Block> HEVEA_HANGING_SIGN = BLOCKS.register("hevea_hanging_sign",
            () -> new NexiumHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.HEVEA));

    public static final RegistryObject<Block> HEVEA_WALL_HANGING_SIGN = BLOCKS.register("hevea_wall_hanging_sign",
            () -> new NexiumWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.HEVEA));

    public static final RegistryObject<Block> HEVEA_WALL_SIGN = BLOCKS.register("hevea_wall_sign",
            () -> new NexiumWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.HEVEA));

    public static final RegistryObject<Block> POTTED_HEVEA_SAPLING = BLOCKS.register("potted_hevea_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NexiumBlocks.HEVEA_SAPLING, BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));

    public static final RegistryObject<Block> GARLIC_CROP = BLOCKS.register("garlic_crop",
            () -> new GarlicCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop",
            () -> new CornCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> FLOWIE = registerBlock("flowie",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5, BlockBehaviour.Properties.copy(Blocks.ALLIUM).noCollission().noOcclusion()));

    public static final RegistryObject<Block> POTTED_FLOWIE = BLOCKS.register("potted_flowie",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NexiumBlocks.FLOWIE, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    //Registers
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return NexiumItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
