package com.mogu.neofactories.blocks;


import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NeoFactories_LogBlock extends RotatedPillarBlock{
    public NeoFactories_LogBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState());
    }
    public @Nullable BlockState getToolModifiedState(@NotNull BlockState state, @NotNull UseOnContext context, @NotNull ItemAbility itemAbility, boolean simulate) {
        if (itemAbility == ItemAbilities.AXE_STRIP) {
            if (state.is(NeoFactories_Block.SOLICA_LOG.get())) {
                return(NeoFactories_Block.STRIPPED_SOLICA_LOG.get()).defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
