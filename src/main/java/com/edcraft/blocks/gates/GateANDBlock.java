package com.edcraft.blocks.gates;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class GateANDBlock extends AbstractRedstoneLogicGateBlock  {

    public static final MapCodec<GateANDBlock> CODEC = createCodec(GateANDBlock::new);

    @Override
    protected MapCodec<GateANDBlock> getCodec() {
        return CODEC;
    }

    public GateANDBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(POWERED, Boolean.FALSE));
    }

    @Override
    protected int getPower(World world, BlockPos pos, BlockState state) {
        Direction direction = state.get(FACING);
        Direction right = direction.rotateYClockwise();
        Direction left = direction.rotateYCounterclockwise();

        boolean inputRight = world.getEmittedRedstonePower(pos.offset(right), right) > 0;
        boolean inputLeft = world.getEmittedRedstonePower(pos.offset(left), left) > 0;

        return inputRight && inputLeft ? 15 : 0;
    }


}
