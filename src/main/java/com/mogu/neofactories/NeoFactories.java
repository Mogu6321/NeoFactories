package com.mogu.neofactories;

import com.mogu.neofactories.blocks.NeoFactories_Block;
import com.mogu.neofactories.items.NeoFactories_Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerStartingEvent;


@Mod(NeoFactories.MODID)

public class NeoFactories {
    public static final String MODID ="neofactories";

        public NeoFactories(IEventBus modEventBus, ModContainer modContainer){

            modEventBus.addListener(this::commonSetup);

            NeoForge.EVENT_BUS.register(this);
            NeoFactories_Tab.register(modEventBus);//タブ
            NeoFactories_Item.register(modEventBus);//アイテム
            NeoFactories_Block.register(modEventBus);//ブロック
        }
    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
