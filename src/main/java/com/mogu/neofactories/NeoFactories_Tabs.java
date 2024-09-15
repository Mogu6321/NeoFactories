package com.mogu.neofactories;

import com.mogu.neofactories.blocks.NeoFactories_blocks;
import com.mogu.neofactories.items.NeoFactories_items;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NeoFactories_Tabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NeoFactories.MODID);

    public static final Supplier<CreativeModeTab> TAB = CREATIVE_MODE_TAB.register("tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(NeoFactories_items.TERMIUM.get()))
                    .title(Component.translatable("creativetab.neofactories.tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(NeoFactories_items.TERMIUM);
                        output.accept(NeoFactories_blocks.TERMIUM_ORE);
                        output.accept(NeoFactories_blocks.SOLICA_LEAVES);
                        output.accept(NeoFactories_blocks.SOLICA_LOG);
                        output.accept(NeoFactories_blocks.SOLICA_PLANKS);
                        output.accept(NeoFactories_blocks.SOLICA_WOOD);
                        output.accept(NeoFactories_blocks.STRIPPED_SOLICA_LOG);
                        output.accept(NeoFactories_blocks.STRIPPED_SOLICA_WOOD);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
