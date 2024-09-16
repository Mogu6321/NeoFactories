package com.mogu.neofactories.items;

import com.mogu.neofactories.NeoFactories;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SaplingBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NeoFactories_items {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NeoFactories.MODID);


    public static final DeferredItem<Item> TERMIUM =ITEMS.register("termium", ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SOLIUM =ITEMS.register("solium", ()-> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
