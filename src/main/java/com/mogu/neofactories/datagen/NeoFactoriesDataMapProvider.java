package com.mogu.neofactories.datagen;

import com.mogu.neofactories.blocks.NeoFactories_Block;
import com.mogu.neofactories.items.NeoFactories_Item;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class NeoFactoriesDataMapProvider extends DataMapProvider {
    protected NeoFactoriesDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(NeoFactories_Block.SOLICA_LEAVES.getId(), new Compostable(0.3f), false)
                .add(NeoFactories_Item.SOLIUM.getId(), new Compostable(0.5f), false);
    }
}
