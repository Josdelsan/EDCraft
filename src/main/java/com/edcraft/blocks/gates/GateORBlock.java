package com.edcraft.blocks.gates;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class GateORBlock extends AbstractRedstoneLogicGateBlock  {

    public static final MapCodec<GateORBlock> CODEC = createCodec(GateORBlock::new);

    @Override
    protected MapCodec<GateORBlock> getCodec() {
        return CODEC;
    }

    public GateORBlock(Settings settings) {
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

        return inputRight || inputLeft ? 15 : 0;
    }


}
