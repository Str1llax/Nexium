package com.str1llax.nexium.register;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.entity.NexiumEntities;
import com.str1llax.nexium.entity.custom.NexiumBoatEntity;
import com.str1llax.nexium.items.*;
import com.str1llax.nexium.items.bases.*;
import com.str1llax.nexium.sound.NexiumSounds;
import com.str1llax.nexium.util.ModArmorMaterials;
import com.str1llax.nexium.util.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class NexiumItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Nexium.MOD_ID);

    //  [TEST/CREATIVE]

    public static final RegistryObject<Item> DEBUG_ITEM = register("debug_item",
            () -> new DebugItem(new Item.Properties().stacksTo(1)));

    //  [WOODS]

    public static final RegistryObject<Item> PINE_CONE = register("pine_cone",
            () -> new FuelItem(new Item.Properties(), 400));

    public static final RegistryObject<Item> HEVEA_SIGN = register("hevea_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), NexiumBlocks.HEVEA_SIGN.get(), NexiumBlocks.HEVEA_WALL_SIGN.get()));

    public static final RegistryObject<Item> HEVEA_HANGING_SIGN = register("hevea_hanging_sign",
            () -> new HangingSignItem(NexiumBlocks.HEVEA_HANGING_SIGN.get(), NexiumBlocks.HEVEA_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> HEVEA_BOAT = register("hevea_boat",
            () -> new CustomBoatItem(false, NexiumBoatEntity.Type.HEVEA, new Item.Properties()));

    public static final RegistryObject<Item> HEVEA_CHEST_BOAT = register("hevea_chest_boat",
            () -> new CustomBoatItem(true, NexiumBoatEntity.Type.HEVEA, new Item.Properties()));

    //  [FOODS]

    public static final RegistryObject<Item> SHAWARMA = register("shawarma",
            () -> new GoofyFoodItem(new Item.Properties().food(NexiumFoods.SHAWARMA), "shawarma"));

    public static final RegistryObject<Item> GARLIC = register("garlic",
            () -> new Item(new Item.Properties().food(NexiumFoods.GARLIC)));

    public static final RegistryObject<Item> GARLIC_SEEDS = register("garlic_seeds",
            () -> new ItemNameBlockItem(NexiumBlocks.GARLIC_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> CORN = register("corn",
            () -> new Item(new Item.Properties().food(NexiumFoods.CORN)));

    public static final RegistryObject<Item> CORN_SEEDS = register("corn_seeds",
            () -> new ItemNameBlockItem(NexiumBlocks.CORN_CROP.get(), new Item.Properties()));

    //  [SPAWN EGGS]

    public static final RegistryObject<Item> STONY_SPAWN_EGG = register("stony_spawn_egg",
            () -> new ForgeSpawnEggItem(NexiumEntities.STONY, 0xaaaaaa, 0x7f9fa9, new Item.Properties()));

    //  [MISC]

    public static final RegistryObject<Item> AMETHYST = register("amethyst",
            () -> new BaseItem(new Item.Properties()));

    public static final RegistryObject<Item> RETURN_STONE = register("return_stone",
            () -> new ReturnStoneItem(new Item.Properties(), "return_stone", "return_stone_desc"));

    public static final RegistryObject<Item> RICK_ASTLEY_MUSIC_DISK = register("rick_astley_music_disk",
            () -> new RecordItem(6, NexiumSounds.RICK_ASTLEY, new Item.Properties().stacksTo(1), 20*(3*60+28)));

    public static final RegistryObject<Item> AMETHYST_SMITHING_TEMPLATE = register("amethyst_upgrade_smithing_template",
            () -> new TemplateBaseItem("amethyst", "emerald"));

    public static final RegistryObject<Item> DICE = register("dice",
            () -> new DiceItem(new Item.Properties()));

    public static final RegistryObject<Item> NEXIUM_DUST = register("nexium_dust",
            () -> new BaseItem(new Item.Properties(), "nexium_dust"));

    //  [WEAPONS]

    public static final RegistryObject<Item> MURASAMA = register("murasama",
            () -> new MurasamaItem());

    public static final RegistryObject<Item> YAMATO = register("yamato",
            () -> new YamatoItem());

    public static final RegistryObject<Item> AMETHYST_SWORD = register("amethyst_sword",
            () -> new SwordItem(ModToolTiers.AMETHYST, 3, -2.4f, new Item.Properties()));

    //  [TOOLS]

    public static final RegistryObject<Item> AMETHYST_PICKAXE = register("amethyst_pickaxe",
            () -> new PickaxeItem(ModToolTiers.AMETHYST, 1, -2.8f, new Item.Properties()));

    public static final RegistryObject<Item> AMETHYST_AXE = register("amethyst_axe",
            () -> new AxeItem(ModToolTiers.AMETHYST, 5, -3.0f, new Item.Properties()));

    public static final RegistryObject<Item> AMETHYST_SHOVEL = register("amethyst_shovel",
            () -> new ShovelItem(ModToolTiers.AMETHYST, 1.5f, -3.0f, new Item.Properties()));

    public static final RegistryObject<Item> AMETHYST_HOE = register("amethyst_hoe",
            () -> new HoeItem(ModToolTiers.AMETHYST, -3, 0.0f, new Item.Properties()));

    //  [ARMOR]

    public static final RegistryObject<Item> AMETHYST_HELMET = register("amethyst_helmet",
            () -> new ModArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = register("amethyst_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> AMETHYST_LEGGINGS = register("amethyst_leggings",
            () -> new ModArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> AMETHYST_BOOTS = register("amethyst_boots",
            () -> new ModArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.BOOTS, new Item.Properties()));

    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
