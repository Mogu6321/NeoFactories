package com.mogu.neofactories.blocks;

import com.mogu.neofactories.NeoFactories;
import com.mogu.neofactories.items.NeoFactories_items;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NeoFactories_blocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(NeoFactories.MODID);

    public static final DeferredBlock<Block> TERMIUM_ORE = registerBlock("termium_ore", ()-> new DropExperienceBlock(UniformInt.of(5, 10),BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
//木材系ブロック
    public static final DeferredBlock<LeavesBlock> SOLICA_LEAVES = registerBlock("solica_leaves", ()-> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LEAVES)));
    public static final DeferredBlock<Block> SOLICA_PLANKS = registerBlock("solica_planks", ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<RotatedPillarBlock> SOLICA_LOG = registerBlock("solica_log", ()-> new NeoFactories_LogBlock(Block.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_SOLICA_LOG = registerBlock("stripped_solica_log", ()->new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<RotatedPillarBlock> SOLICA_WOOD = registerBlock("solica_wood", ()-> new NeoFactories_LogBlock(Block.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_SOLICA_WOOD = registerBlock("stripped_solica_wood", ()->new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<StairBlock> SOLICA_STAIRS = registerBlock("solica_stairs", () -> new StairBlock(NeoFactories_blocks.SOLICA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> SOLICA_SLAB = registerBlock("solica_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<PressurePlateBlock> SOLICA_PRESSURE_PLATE = registerBlock("solica_pressure_plate", () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ButtonBlock> SOLICA_BUTTON = registerBlock("solica_button", () -> new ButtonBlock(BlockSetType.OAK, 20, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noCollission()));
    public static final DeferredBlock<FenceBlock> SOLICA_FENCE = registerBlock("solica_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<FenceGateBlock> SOLICA_FENCE_GATE = registerBlock("solica_fence_gate", () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<DoorBlock> SOLICA_DOOR = registerBlock("solica_door", () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> SOLICA_TRAPDOOR = registerBlock("solica_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        NeoFactories_items.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
