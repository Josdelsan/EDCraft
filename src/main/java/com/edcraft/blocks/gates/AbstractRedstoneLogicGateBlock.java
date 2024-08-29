package com.edcraft.blocks.gates;

import net.minecraft.block.AbstractRedstoneGateBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;

public abstract class AbstractRedstoneLogicGateBlock extends AbstractRedstoneGateBlock {

    protected AbstractRedstoneLogicGateBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected int getUpdateDelayInternal(BlockState state) {
        return 0;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, POWERED);
    }
}
