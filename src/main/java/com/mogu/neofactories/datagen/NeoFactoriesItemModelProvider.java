package com.mogu.neofactories.datagen;

import com.mogu.neofactories.NeoFactories;
import com.mogu.neofactories.blocks.NeoFactories_Block;
import com.mogu.neofactories.items.NeoFactories_Item;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class NeoFactoriesItemModelProvider extends ItemModelProvider {
    public NeoFactoriesItemModelProvider(PackOutput output,ExistingFileHelper existingFileHelper) {
        super(output, NeoFactories.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(NeoFactories_Item.TERMIUM.get());

        buttonItem(NeoFactories_Block.SOLICA_BUTTON,NeoFactories_Block.SOLICA_PLANKS);
        fenceItem(NeoFactories_Block.SOLICA_FENCE,NeoFactories_Block.SOLICA_PLANKS);

        basicItem(NeoFactories_Block.SOLICA_DOOR.asItem());

    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(NeoFactories.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(NeoFactories.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

}
