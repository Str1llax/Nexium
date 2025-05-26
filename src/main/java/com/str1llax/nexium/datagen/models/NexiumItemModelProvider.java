package com.str1llax.nexium.datagen.models;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.register.NexiumBlocks;
import com.str1llax.nexium.register.NexiumItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class NexiumItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public NexiumItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Nexium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(NexiumItems.AMETHYST);
        simpleItem(NexiumItems.PINE_CONE);
        simpleItem(NexiumItems.SHAWARMA);
        simpleItem(NexiumItems.AMETHYST_SMITHING_TEMPLATE);
        simpleItem(NexiumItems.GARLIC);
        simpleItem(NexiumItems.GARLIC_SEEDS);
        simpleItem(NexiumItems.CORN);
        simpleItem(NexiumItems.CORN_SEEDS);
        simpleItem(NexiumItems.RICK_ASTLEY_MUSIC_DISK);
        simpleItem(NexiumItems.RETURN_STONE);

        handHeldItem(NexiumItems.DEBUG_ITEM);

        handHeldItem(NexiumItems.AMETHYST_SWORD);
        handHeldItem(NexiumItems.AMETHYST_PICKAXE);
        handHeldItem(NexiumItems.AMETHYST_AXE);
        handHeldItem(NexiumItems.AMETHYST_SHOVEL);
        handHeldItem(NexiumItems.AMETHYST_HOE);

        trimmedArmorItem(NexiumItems.AMETHYST_HELMET);
        trimmedArmorItem(NexiumItems.AMETHYST_CHESTPLATE);
        trimmedArmorItem(NexiumItems.AMETHYST_LEGGINGS);
        trimmedArmorItem(NexiumItems.AMETHYST_BOOTS);

        simpleBlockItem(NexiumBlocks.HEVEA_DOOR);

        fenceItem(NexiumBlocks.HEVEA_FENCE, NexiumBlocks.HEVEA_PLANKS);

        buttonItem(NexiumBlocks.HEVEA_BUTTON, NexiumBlocks.HEVEA_PLANKS);

        trapdoorItem(NexiumBlocks.HEVEA_TRAPDOOR);

        evenSimplerItem(NexiumBlocks.HEVEA_STAIRS);
        evenSimplerItem(NexiumBlocks.HEVEA_SLAB);
        evenSimplerItem(NexiumBlocks.HEVEA_PRESSURE_PLATE);
        evenSimplerItem(NexiumBlocks.HEVEA_FENCE_GATE);

        simpleItem(NexiumItems.HEVEA_SIGN);
        simpleItem(NexiumItems.HEVEA_HANGING_SIGN);

        itemFromBlock(NexiumBlocks.HEVEA_SAPLING);

        itemFromBlock(NexiumBlocks.FLOWIE);

        withExistingParent(NexiumItems.STONY_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        simpleItem(NexiumItems.HEVEA_BOAT);
        simpleItem(NexiumItems.HEVEA_CHEST_BOAT);

        simpleItem(NexiumItems.DICE);
        simpleItem(NexiumItems.NEXIUM_DUST);
    }

    private ItemModelBuilder itemFromBlock(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "block/" + item.getId().getPath()));
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = Nexium.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.fromNamespaceAndPath(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.fromNamespaceAndPath(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handHeldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerItem(RegistryObject<Block> block) {
        this.withExistingParent(Nexium.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(Nexium.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}
