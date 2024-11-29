package com.mogu.neofactories.datagen;

import com.mogu.neofactories.blocks.NeoFactories_Block;
import com.mogu.neofactories.items.NeoFactories_Item;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;


import java.util.Set;

public class NeoFactoriesBlockLootTableProvider extends BlockLootSubProvider {
    protected NeoFactoriesBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(NeoFactories_Block.SOLICA_BUTTON.get());
        dropSelf(NeoFactories_Block.SOLICA_FENCE.get());
        dropSelf(NeoFactories_Block.SOLICA_LOG.get());
        dropSelf(NeoFactories_Block.SOLICA_FENCE_GATE.get());
        dropSelf(NeoFactories_Block.SOLICA_PLANKS.get());
        dropSelf(NeoFactories_Block.SOLICA_PRESSURE_PLATE.get());
        dropSelf(NeoFactories_Block.SOLICA_STAIRS.get());
        dropSelf(NeoFactories_Block.SOLICA_WOOD.get());
        dropSelf(NeoFactories_Block.SOLICA_TRAPDOOR.get());
        dropSelf(NeoFactories_Block.STRIPPED_SOLICA_LOG.get());
        dropSelf(NeoFactories_Block.STRIPPED_SOLICA_WOOD.get());
        //dropSelf(NeoFactories_Block.TERMIUM_BLOCK.get());
        add(NeoFactories_Block.SOLICA_DOOR.get(),block ->
                createDoorTable(NeoFactories_Block.SOLICA_DOOR.get()));
        add(NeoFactories_Block.SOLICA_SLAB.get(),block ->
                createSlabItemTable(NeoFactories_Block.SOLICA_SLAB.get()));
        add(NeoFactories_Block.TERMIUM_ORE.get(),block ->
                createOreDrop(NeoFactories_Block.TERMIUM_ORE.get(),NeoFactories_Item.TERMIUM.get()));
        add(NeoFactories_Block.SOLICA_LEAVES.get(), block ->
                createLeavesDrops(block, NeoFactories_Item.SOLIUM.get(), SOLIUM_CHANCES));

    }

    protected LootTable.Builder createLeavesDrops(Block pLeavesBlock, Item pItem, float... pChances) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchOrShearsDispatchTable(
                        pLeavesBlock,
                        ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionCondition(pLeavesBlock, LootItem.lootTableItem(pItem)))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), pChances))
                )
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(this.doesNotHaveShearsOrSilkTouch())
                                .add(
                                        ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                                pLeavesBlock, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
                                        ))
                                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), STICK_CHANCES))
                                )
                );
    }

    private LootItemCondition.Builder doesNotHaveShearsOrSilkTouch() {
        return this.hasShearsOrSilkTouch().invert();
    }

    private LootItemCondition.Builder hasShearsOrSilkTouch() {
        return HAS_SHEARS.or(this.hasSilkTouch());
    }

    private static final float[] STICK_CHANCES = new float[]{0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F};

    private static final float[] SOLIUM_CHANCES = new float[]{0.0007F, 0.00125F, 0.00723333336F, 0.05F};


    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return NeoFactories_Block.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

}
