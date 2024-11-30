

package com.mogu.neofactories.datagen;

import com.mogu.neofactories.NeoFactories;
import com.mogu.neofactories.blocks.NeoFactories_Block;
import com.mogu.neofactories.util.NeoFactories_Tag;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class NeoFactoriesBlockTagProvider extends BlockTagsProvider {
    public NeoFactoriesBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,@Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NeoFactories.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(NeoFactories_Block.TERMIUM_ORE.get());
                //.add(NeoFactories_Block.TERMIUM_BLOCK.get());

        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(NeoFactories_Block.SOLICA_LEAVES.get());

        tag(BlockTags.LEAVES)
                .add(NeoFactories_Block.SOLICA_LEAVES.get());

        tag(BlockTags.LOGS)
                .add(NeoFactories_Block.SOLICA_LOG.get())
                .add(NeoFactories_Block.STRIPPED_SOLICA_LOG.get())
                .add(NeoFactories_Block.SOLICA_WOOD.get())
                .add(NeoFactories_Block.STRIPPED_SOLICA_WOOD.get());

        tag(BlockTags.PLANKS)
                .add(NeoFactories_Block.SOLICA_PLANKS.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(NeoFactories_Block.TERMIUM_ORE.get());
                //.add(NeoFactories_Block.TERMIUM_BLOCK.get());

        tag(BlockTags.FENCES)
                .add(NeoFactories_Block.SOLICA_FENCE.get());

        tag(BlockTags.FENCE_GATES)
                .add(NeoFactories_Block.SOLICA_FENCE_GATE.get());

        tag(BlockTags.WOODEN_BUTTONS)
                .add(NeoFactories_Block.SOLICA_BUTTON.get());

        tag(BlockTags.WOODEN_DOORS)
                .add(NeoFactories_Block.SOLICA_DOOR.get());

        tag(BlockTags.WOODEN_FENCES)
                .add(NeoFactories_Block.SOLICA_FENCE.get());

        tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(NeoFactories_Block.SOLICA_PRESSURE_PLATE.get());

        tag(BlockTags.WOODEN_SLABS)
                .add(NeoFactories_Block.SOLICA_SLAB.get());

        tag(BlockTags.WOODEN_STAIRS)
                .add(NeoFactories_Block.SOLICA_STAIRS.get());

        tag(BlockTags.WOODEN_TRAPDOORS)
                .add(NeoFactories_Block.SOLICA_TRAPDOOR.get());

        tag(NeoFactories_Tag.Blocks.SOLICA_LOG)
                .add(NeoFactories_Block.SOLICA_LOG.get())
                .add(NeoFactories_Block.STRIPPED_SOLICA_LOG.get())
                .add(NeoFactories_Block.SOLICA_WOOD.get())
                .add(NeoFactories_Block.STRIPPED_SOLICA_WOOD.get());

    }
}
