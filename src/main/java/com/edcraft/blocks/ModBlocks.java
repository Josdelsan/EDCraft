package com.edcraft.blocks;

import com.edcraft.EDCraft;
import com.edcraft.blocks.gates.GateNOTBlock;
import com.edcraft.blocks.gates.GateANDBlock;
import com.edcraft.blocks.gates.GateORBlock;
import com.edcraft.blocks.gates.GateXORBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static void initialize() {
        ModItemsGroup.initialize();
    }

    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        Identifier id = Identifier.of(EDCraft.MOD_ID, name);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    /*
    Blocks
     */

    public static final Block EXAMPLE_BLOCK = register(new Block(AbstractBlock.Settings.create()),
            "example_block",
            true);

    public static final Block GATE_NOT = register(new GateNOTBlock(AbstractBlock.Settings.create()),
            "gate_not",
            true);

    public static final Block GATE_AND = register(new GateANDBlock(AbstractBlock.Settings.create()),
            "gate_and",
            true);

    public static final Block GATE_OR = register(new GateORBlock(AbstractBlock.Settings.create()),
            "gate_or",
            true);

    public static final Block GATE_XOR = register(new GateXORBlock(AbstractBlock.Settings.create()),
            "gate_xor",
            true);
}

