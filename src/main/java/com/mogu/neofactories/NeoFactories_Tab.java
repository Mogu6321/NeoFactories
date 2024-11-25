package com.mogu.neofactories;

import com.mogu.neofactories.blocks.NeoFactories_Block;
import com.mogu.neofactories.items.NeoFactories_Item;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NeoFactories_Tab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NeoFactories.MODID);

    public static final Supplier<CreativeModeTab> TAB = CREATIVE_MODE_TAB.register("tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(NeoFactories_Item.TERMIUM.get()))
                    .title(Component.translatable("creativetab.neofactories.tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(NeoFactories_Item.TERMIUM);
                        output.accept(NeoFactories_Item.SOLIUM);
                        output.accept(NeoFactories_Block.TERMIUM_ORE);
                        output.accept(NeoFactories_Block.SOLICA_LEAVES);
                        output.accept(NeoFactories_Block.SOLICA_LOG);
                        output.accept(NeoFactories_Block.SOLICA_PLANKS);
                        output.accept(NeoFactories_Block.SOLICA_WOOD);
                        output.accept(NeoFactories_Block.STRIPPED_SOLICA_LOG);
                        output.accept(NeoFactories_Block.STRIPPED_SOLICA_WOOD);
                        output.accept(NeoFactories_Block.SOLICA_BUTTON);
                        output.accept(NeoFactories_Block.SOLICA_DOOR);
                        output.accept(NeoFactories_Block.SOLICA_FENCE);
                        output.accept(NeoFactories_Block.SOLICA_FENCE_GATE);
                        output.accept(NeoFactories_Block.SOLICA_PRESSURE_PLATE);
                        output.accept(NeoFactories_Block.SOLICA_SLAB);
                        output.accept(NeoFactories_Block.SOLICA_STAIRS);
                        output.accept(NeoFactories_Block.SOLICA_TRAPDOOR);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
