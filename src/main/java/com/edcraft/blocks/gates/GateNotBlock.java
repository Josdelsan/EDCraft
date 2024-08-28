package com.edcraft.blocks.gates;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractRedstoneGateBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;


public class GateNotBlock extends AbstractRedstoneGateBlock {

    public static final MapCodec<GateNotBlock> CODEC = createCodec(GateNotBlock::new);

    @Override
    protected MapCodec<GateNotBlock> getCodec() {
        return CODEC;
    }

    public GateNotBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(POWERED, Boolean.FALSE));
    }

    @Override
    protected int getPower(World world, BlockPos pos, BlockState state) {
        return super.getPower(world, pos, state) == 0 ? 15 : 0;
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
