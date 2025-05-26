package com.str1llax.nexium.datagen.models;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.blocks.CornCropBlock;
import com.str1llax.nexium.blocks.GarlicCropBlock;
import com.str1llax.nexium.register.NexiumBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

import static net.minecraft.core.Direction.*;

public class NexiumBlockStateProvider extends BlockStateProvider {
    public NexiumBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Nexium.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(NexiumBlocks.CUT_AMETHYST_BLOCK);
        blockWithItem(NexiumBlocks.SOUND_BLOCK);



        simpleFlowerLikeBlock(NexiumBlocks.HEVEA_SAPLING);
        pottedFlowerLikeBlock(NexiumBlocks.POTTED_HEVEA_SAPLING, NexiumBlocks.HEVEA_SAPLING);

        logBlock(((RotatedPillarBlock) NexiumBlocks.HEVEA_LOG.get()));
        blockItem(NexiumBlocks.HEVEA_LOG);

        axisBlock(((RotatedPillarBlock) NexiumBlocks.HEVEA_WOOD.get()), blockTexture(NexiumBlocks.HEVEA_LOG.get()), blockTexture(NexiumBlocks.HEVEA_LOG.get()));
        blockItem(NexiumBlocks.HEVEA_WOOD);

        axisBlock(((RotatedPillarBlock) NexiumBlocks.STRIPPED_HEVEA_LOG.get()), blockTexture(NexiumBlocks.STRIPPED_HEVEA_LOG.get()), blockTexture(NexiumBlocks.HEVEA_LOG.get()));
        blockItem(NexiumBlocks.STRIPPED_HEVEA_LOG);

        axisBlock(((RotatedPillarBlock) NexiumBlocks.STRIPPED_HEVEA_WOOD.get()), blockTexture(NexiumBlocks.STRIPPED_HEVEA_LOG.get()),
                ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "block/stripped_hevea_log_top"));
        blockItem(NexiumBlocks.STRIPPED_HEVEA_WOOD);

        leavesBlock(NexiumBlocks.HEVEA_LEAVES);
        blockWithItem(NexiumBlocks.HEVEA_PLANKS);
        stairsBlock(((StairBlock) NexiumBlocks.HEVEA_STAIRS.get()), blockTexture(NexiumBlocks.HEVEA_PLANKS.get()));
        slabBlock(((SlabBlock) NexiumBlocks.HEVEA_SLAB.get()), blockTexture(NexiumBlocks.HEVEA_PLANKS.get()), blockTexture(NexiumBlocks.HEVEA_PLANKS.get()));
        buttonBlock(((ButtonBlock) NexiumBlocks.HEVEA_BUTTON.get()), blockTexture(NexiumBlocks.HEVEA_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) NexiumBlocks.HEVEA_PRESSURE_PLATE.get()), blockTexture(NexiumBlocks.HEVEA_PLANKS.get()));
        fenceBlock(((FenceBlock) NexiumBlocks.HEVEA_FENCE.get()), blockTexture(NexiumBlocks.HEVEA_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) NexiumBlocks.HEVEA_FENCE_GATE.get()), blockTexture(NexiumBlocks.HEVEA_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) NexiumBlocks.HEVEA_DOOR.get()), modLoc("block/hevea_door_bottom"), modLoc("block/hevea_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) NexiumBlocks.HEVEA_TRAPDOOR.get()), modLoc("block/hevea_trapdoor"), true,"cutout");
        signBlock(((StandingSignBlock) NexiumBlocks.HEVEA_SIGN.get()), ((WallSignBlock) NexiumBlocks.HEVEA_WALL_SIGN.get()), blockTexture(NexiumBlocks.HEVEA_PLANKS.get()));
        hangingSignBlock(NexiumBlocks.HEVEA_HANGING_SIGN.get(), NexiumBlocks.HEVEA_WALL_HANGING_SIGN.get(), blockTexture(NexiumBlocks.HEVEA_PLANKS.get()));



        makeGarlicCrop((CropBlock) NexiumBlocks.GARLIC_CROP.get(), "garlic_stage", "garlic_stage");
        makeCornCrop((CropBlock) NexiumBlocks.CORN_CROP.get(), "corn_stage", "corn_stage");



        simpleFlowerLikeBlock(NexiumBlocks.FLOWIE);
        pottedFlowerLikeBlock(NexiumBlocks.POTTED_FLOWIE, NexiumBlocks.FLOWIE);



        rotatableCustomBlockWithItem(NexiumBlocks.INCUBATOR.get());



        diceBlockState(NexiumBlocks.DICE_BLOCK);



        multiLayeredOre(NexiumBlocks.NEXIUM_ORE, Blocks.STONE, NexiumBlocks.NEXIUM_ORE.get());
        multiLayeredOre(NexiumBlocks.DEEPSLATE_NEXIUM_ORE, Blocks.DEEPSLATE, NexiumBlocks.NEXIUM_ORE.get());
        multiLayeredOre(NexiumBlocks.NETHER_NEXIUM_ORE, Blocks.NETHERRACK, NexiumBlocks.NEXIUM_ORE.get());
        multiLayeredOre(NexiumBlocks.END_NEXIUM_ORE, Blocks.END_STONE, NexiumBlocks.NEXIUM_ORE.get());



        blockWithItem(NexiumBlocks.MATRIX_PORTAL);
    }



    public void simpleFlowerLikeBlock(RegistryObject<Block> blockObj) {
        simpleBlock(blockObj.get(), models().cross(ForgeRegistries.BLOCKS.getKey(blockObj.get()).getPath(), blockTexture(blockObj.get())).renderType("cutout"));
    }

    public void pottedFlowerLikeBlock(RegistryObject<Block> pottedBlock, RegistryObject<Block> originBlock) {
        simpleBlock(pottedBlock.get(), models().singleTexture(name(pottedBlock.get()), ResourceLocation.parse("flower_pot_cross"), "plant", blockTexture(originBlock.get())).renderType("cutout"));
    }

    public void multiLayeredOre(RegistryObject<Block> blockObj, Block base, Block overlay) {
        ModelFile model = models().withExistingParent(name(blockObj.get()), mcLoc("block/block"))
                .texture("base", ResourceLocation.parse("block/" + name(base)))
                .texture("overlay", ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "block/" + name(overlay)))
                .texture("particle", ResourceLocation.parse("block/" + name(base)))
                .renderType("cutout_mipped")
                .element()
                    .from(0, 0 ,0)
                    .to(16, 16, 16)
                    .allFaces((direction, faceBuilder) -> faceBuilder
                        .uvs(0, 0, 16, 16)
                        .texture("#base")
                        .cullface(direction))
                    .end()
                .element()
                    .from(0, 0 ,0)
                    .to(16, 16, 16)
                    .allFaces((direction, faceBuilder) -> faceBuilder
                            .uvs(0, 0 ,16 ,16)
                            .texture("#overlay")
                            .cullface(null))
                    .end();

        simpleBlockWithItem(blockObj.get(), model);
    }

    public void diceBlockState(RegistryObject<Block> blockObj) {
        DirectionProperty NUMBER = DirectionProperty.create("number", NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, UP, DOWN);
        ModelFile model = models().getExistingFile(ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "block/" + name(blockObj.get())));
        simpleBlockItem(blockObj.get(), model);
        getVariantBuilder(blockObj.get()).forAllStates(state -> {
            int XRot = 0;
            int YRot = 0;
            switch (state.getValue(NUMBER)) {
                case UP -> {
                    XRot = 90;
                    YRot = 270;
                }
                case DOWN -> {
                    XRot = 90;
                    YRot = 90;
                }
                case EAST -> XRot = 90;
                case WEST -> XRot = 270;
                case SOUTH -> XRot = 180;
                case NORTH -> XRot = 0;
            }
            return ConfiguredModel.builder()
                .modelFile(model)
                .rotationY(YRot)
                .rotationX(XRot)
                .build();
        });
    }

    public void rotatableCustomBlockWithItem(Block facingBlock) {
        ModelFile modelFile = models().getExistingFile(ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "block/" + name(facingBlock)));
        simpleBlockItem(facingBlock, modelFile);
        horizontalBlock(facingBlock, modelFile);
    }

    public void makeGarlicCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> garlicStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] garlicStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((GarlicCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "block/" + textureName + state.getValue(((GarlicCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeCornCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cornStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] cornStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CornCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "block/" + textureName + state.getValue(((CornCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                ResourceLocation.parse("minecraft:block/leaves"), "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(),
                new ModelFile.UncheckedModelFile(Nexium.MOD_ID + ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
