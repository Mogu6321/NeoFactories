package com.mogu.neofactories.datagen;

import com.mogu.neofactories.NeoFactories;
import com.mogu.neofactories.blocks.NeoFactories_Block;
import com.mogu.neofactories.items.NeoFactories_Item;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Locale;

public class NeoFactories_enusProvider extends LanguageProvider {
    public NeoFactories_enusProvider(PackOutput output) {
        super(output, NeoFactories.MODID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addBlock(NeoFactories_Block.TERMIUM_ORE,"Termium Ore");
        addBlock(NeoFactories_Block.RED_COBBLESTONE,"Red Cobblestone");

        addBlock(NeoFactories_Block.SOLICA_LOG,"Solica Log");
        addBlock(NeoFactories_Block.STRIPPED_SOLICA_LOG,"Stripped Solica Log");
        addBlock(NeoFactories_Block.SOLICA_WOOD,"Solica Wood");
        addBlock(NeoFactories_Block.STRIPPED_SOLICA_WOOD,"Stripped Solica Wood");
        addBlock(NeoFactories_Block.SOLICA_PLANKS,"Solica Planks");
        addBlock(NeoFactories_Block.SOLICA_LEAVES,"Solica Leaves");
        addBlock(NeoFactories_Block.SOLICA_BUTTON,"Solica Button");
        addBlock(NeoFactories_Block.SOLICA_FENCE,"Solica Fence");
        addBlock(NeoFactories_Block.SOLICA_FENCE_GATE,"Solica Fence Gate");
        addBlock(NeoFactories_Block.SOLICA_DOOR,"Solica Door");
        addBlock(NeoFactories_Block.SOLICA_PRESSURE_PLATE,"Solica Pressure Plate");
        addBlock(NeoFactories_Block.SOLICA_SLAB,"Solica Slab");
        addBlock(NeoFactories_Block.SOLICA_STAIRS,"Solica Stairs");
        addBlock(NeoFactories_Block.SOLICA_TRAPDOOR,"Solica Trapdoor");

        addItem(NeoFactories_Item.TERMIUM,"Termium");
        addItem(NeoFactories_Item.SOLIUM,"Solium");

        add("creativetab.neofactories.tab","NeoFactories");

    }
}
