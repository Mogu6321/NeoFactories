package com.mogu.neofactories.datagen;

import com.mogu.neofactories.NeoFactories;
import com.mogu.neofactories.blocks.NeoFactories_Block;
import com.mogu.neofactories.items.NeoFactories_Item;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Locale;

public class NeoFactories_jajpProvider extends LanguageProvider {
    public NeoFactories_jajpProvider(PackOutput output) {
        super(output, NeoFactories.MODID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {

        addBlock(NeoFactories_Block.TERMIUM_ORE,"テルミウム鉱石");
        addBlock(NeoFactories_Block.RED_COBBLESTONE,"赤い丸石");

        addBlock(NeoFactories_Block.SOLICA_LOG,"ソリカの原木");
        addBlock(NeoFactories_Block.STRIPPED_SOLICA_LOG,"樹皮のはがれたソリカの原木");
        addBlock(NeoFactories_Block.SOLICA_WOOD,"ソリカの木");
        addBlock(NeoFactories_Block.STRIPPED_SOLICA_WOOD,"樹皮のはがれたソリカの木");
        addBlock(NeoFactories_Block.SOLICA_PLANKS,"ソリカの板材");
        addBlock(NeoFactories_Block.SOLICA_LEAVES,"ソリカの葉");
        addBlock(NeoFactories_Block.SOLICA_BUTTON,"ソリカのボタン");
        addBlock(NeoFactories_Block.SOLICA_FENCE,"ソリカのフェンス");
        addBlock(NeoFactories_Block.SOLICA_FENCE_GATE,"ソリカのフェンスゲート");
        addBlock(NeoFactories_Block.SOLICA_DOOR,"ソリカのドア");
        addBlock(NeoFactories_Block.SOLICA_PRESSURE_PLATE,"ソリカの感圧版");
        addBlock(NeoFactories_Block.SOLICA_SLAB,"ソリカのハーフブロック");
        addBlock(NeoFactories_Block.SOLICA_STAIRS,"ソリカの階段");
        addBlock(NeoFactories_Block.SOLICA_TRAPDOOR,"ソリカのトラップドア");

        addItem(NeoFactories_Item.TERMIUM,"テルミウム");
        addItem(NeoFactories_Item.SOLIUM,"ソリウム");

        add("creativetab.neofactories.tab","NeoFactories");

    }
}
