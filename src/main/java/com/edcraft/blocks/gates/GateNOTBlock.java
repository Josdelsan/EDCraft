package com.edcraft.blocks.gates;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;


public class GateNOTBlock extends AbstractRedstoneLogicGateBlock {

    public static final MapCodec<GateNOTBlock> CODEC = createCodec(GateNOTBlock::new);

    @Override
    protected MapCodec<GateNOTBlock> getCodec() {
        return CODEC;
    }

    public GateNOTBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(POWERED, Boolean.FALSE));
    }

    @Override
    protected int getPower(World world, BlockPos pos, BlockState state) {
        return super.getPower(world, pos, state) == 0 ? 15 : 0;
    }

}
