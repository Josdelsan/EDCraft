package com.edcraft.blocks.gates;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractRedstoneGateBlock;
import net.minecraft.block.BlockState;

public abstract class AbstractRedstoneDualGateBlock extends AbstractRedstoneGateBlock {

    protected AbstractRedstoneDualGateBlock(Settings settings) {
        super(settings);
    }
}
