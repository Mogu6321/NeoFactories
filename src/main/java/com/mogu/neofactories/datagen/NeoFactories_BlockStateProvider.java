package com.mogu.neofactories.datagen;

import com.mogu.neofactories.NeoFactories;
import com.mogu.neofactories.blocks.NeoFactories_Block;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.LeavesBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class NeoFactories_BlockStateProvider extends BlockStateProvider {
    public NeoFactories_BlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NeoFactories.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(NeoFactories_Block.SOLICA_PLANKS);
        blockWithItem(NeoFactories_Block.TERMIUM_ORE);
        blockWithItem(NeoFactories_Block.RED_COBBLESTONE);
        //blockWithItem(NeoFactories_Block.TERMIUM_BLOCK);

        stairsBlock(NeoFactories_Block.SOLICA_STAIRS.get(),blockTexture(NeoFactories_Block.SOLICA_PLANKS.get()));
        slabBlock(NeoFactories_Block.SOLICA_SLAB.get(),blockTexture(NeoFactories_Block.SOLICA_PLANKS.get()), blockTexture(NeoFactories_Block.SOLICA_PLANKS.get()));
        buttonBlock(NeoFactories_Block.SOLICA_BUTTON.get(),blockTexture(NeoFactories_Block.SOLICA_PLANKS.get()));
        pressurePlateBlock(NeoFactories_Block.SOLICA_PRESSURE_PLATE.get(),blockTexture(NeoFactories_Block.SOLICA_PLANKS.get()));
        fenceBlock(NeoFactories_Block.SOLICA_FENCE.get(),blockTexture(NeoFactories_Block.SOLICA_PLANKS.get()));
        fenceGateBlock(NeoFactories_Block.SOLICA_FENCE_GATE.get(),blockTexture(NeoFactories_Block.SOLICA_PLANKS.get()));
        doorBlockWithRenderType(NeoFactories_Block.SOLICA_DOOR.get(), modLoc("block/solica_door_bottom"), modLoc("block/solica_door_top"), "cutout");
        trapdoorBlockWithRenderType(NeoFactories_Block.SOLICA_TRAPDOOR.get(), modLoc("block/solica_trapdoor"), true, "cutout");

        logBlock(NeoFactories_Block.SOLICA_LOG.get());
        logBlock(NeoFactories_Block.STRIPPED_SOLICA_LOG.get());
        axisBlock(NeoFactories_Block.SOLICA_WOOD.get(), blockTexture(NeoFactories_Block.SOLICA_LOG.get()), blockTexture(NeoFactories_Block.SOLICA_LOG.get()));
        axisBlock(NeoFactories_Block.STRIPPED_SOLICA_WOOD.get(), blockTexture(NeoFactories_Block.STRIPPED_SOLICA_LOG.get()), blockTexture(NeoFactories_Block.STRIPPED_SOLICA_LOG.get()));

        blockItem(NeoFactories_Block.SOLICA_LOG);
        blockItem(NeoFactories_Block.STRIPPED_SOLICA_LOG);
        blockItem(NeoFactories_Block.SOLICA_WOOD);
        blockItem(NeoFactories_Block.STRIPPED_SOLICA_WOOD);
        blockItem(NeoFactories_Block.SOLICA_STAIRS);
        blockItem(NeoFactories_Block.SOLICA_SLAB);
        blockItem(NeoFactories_Block.SOLICA_PRESSURE_PLATE);
        blockItem(NeoFactories_Block.SOLICA_FENCE_GATE);
        blockItem(NeoFactories_Block.SOLICA_TRAPDOOR, "_bottom");
        leavesBlock(NeoFactories_Block.SOLICA_LEAVES);


    }

    private void leavesBlock(DeferredBlock<LeavesBlock> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(deferredBlock.get())).renderType("cutout"));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("neofactories:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("neofactories:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
