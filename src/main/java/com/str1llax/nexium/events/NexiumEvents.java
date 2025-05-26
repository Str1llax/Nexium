package com.str1llax.nexium.events;

import com.str1llax.nexium.Nexium;
import com.str1llax.nexium.register.NexiumBlocks;
import com.str1llax.nexium.register.NexiumItems;
import com.str1llax.nexium.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Nexium.MOD_ID)
public class NexiumEvents {

    @SubscribeEvent
    public static void registerCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.ARMORER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            // [LEVEL 1]

            // [LEVEL 2]

            // [LEVEL 3]

            // [LEVEL 4]

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(NexiumItems.AMETHYST_SMITHING_TEMPLATE.get(), 1),
                    4, 8, 0.02f));

            // [LEVEL 5]

        }

        if(event.getType() == VillagerProfession.TOOLSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            // [LEVEL 1]

            // [LEVEL 2]

            // [LEVEL 3]

            // [LEVEL 4]

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(NexiumItems.AMETHYST_SMITHING_TEMPLATE.get(), 1),
                    4, 8, 0.02f));

            // [LEVEL 5]

        }

        if(event.getType() == VillagerProfession.WEAPONSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            // [LEVEL 1]

            // [LEVEL 2]

            // [LEVEL 3]

            // [LEVEL 4]

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(NexiumItems.AMETHYST_SMITHING_TEMPLATE.get(), 1),
                    4, 8, 0.02f));

            // [LEVEL 5]

        }

        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            // [LEVEL 1]

            // [LEVEL 2]

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(NexiumBlocks.FLOWIE.get(), 7),
                    5, 2, 0.02f));

            // [LEVEL 3]

            // [LEVEL 4]

            // [LEVEL 5]

        }

        if(event.getType() == ModVillagers.MUSICIAN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            // [LEVEL 1]

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(NexiumItems.DEBUG_ITEM.get(), 1),
                    1, 10, 0f));

            // [LEVEL 2]

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10),
                    new ItemStack(NexiumBlocks.SOUND_BLOCK.get(), 1),
                    3, 5, 0f));

            // [LEVEL 3]

            // [LEVEL 4]

            // [LEVEL 5]

        }
    }

    @SubscribeEvent
    public static void registerCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 4),
                new ItemStack(NexiumItems.SHAWARMA.get(), 2),
                5, 3, 0.02f));
    }

}
