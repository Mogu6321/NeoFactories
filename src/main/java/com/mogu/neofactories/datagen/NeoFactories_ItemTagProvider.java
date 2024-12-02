package com.mogu.neofactories.datagen;

import com.mogu.neofactories.NeoFactories;
import com.mogu.neofactories.blocks.NeoFactories_Block;
import com.mogu.neofactories.util.NeoFactories_Tag;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class NeoFactories_ItemTagProvider extends ItemTagsProvider {
    public NeoFactories_ItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pItemTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pItemTags, NeoFactories.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ItemTags.LEAVES)
                .add(NeoFactories_Block.SOLICA_LEAVES.asItem());

        tag(ItemTags.LOGS)
                .add(NeoFactories_Block.SOLICA_LOG.asItem())
                .add(NeoFactories_Block.STRIPPED_SOLICA_LOG.asItem())
                .add(NeoFactories_Block.SOLICA_WOOD.asItem())
                .add(NeoFactories_Block.STRIPPED_SOLICA_WOOD.asItem());

        tag(ItemTags.PLANKS)
                .add(NeoFactories_Block.SOLICA_PLANKS.asItem());

        tag(ItemTags.FENCES)
                .add(NeoFactories_Block.SOLICA_FENCE.asItem());

        tag(ItemTags.FENCE_GATES)
                .add(NeoFactories_Block.SOLICA_FENCE_GATE.asItem());

        tag(ItemTags.WOODEN_BUTTONS)
                .add(NeoFactories_Block.SOLICA_BUTTON.asItem());

        tag(ItemTags.WOODEN_DOORS)
                .add(NeoFactories_Block.SOLICA_DOOR.asItem());

        tag(ItemTags.WOODEN_FENCES)
                .add(NeoFactories_Block.SOLICA_FENCE.asItem());

        tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(NeoFactories_Block.SOLICA_PRESSURE_PLATE.asItem());

        tag(ItemTags.WOODEN_SLABS)
                .add(NeoFactories_Block.SOLICA_SLAB.asItem());

        tag(ItemTags.WOODEN_STAIRS)
                .add(NeoFactories_Block.SOLICA_STAIRS.asItem());

        tag(ItemTags.WOODEN_TRAPDOORS)
                .add(NeoFactories_Block.SOLICA_TRAPDOOR.asItem());

        tag(NeoFactories_Tag.Items.SOLICA_LOG)
                .add(NeoFactories_Block.SOLICA_LOG.asItem())
                .add(NeoFactories_Block.STRIPPED_SOLICA_LOG.asItem())
                .add(NeoFactories_Block.SOLICA_WOOD.asItem())
                .add(NeoFactories_Block.STRIPPED_SOLICA_WOOD.asItem());
    }
}
