package com.edcraft.blocks;

import com.edcraft.EDCraft;
import com.edcraft.blocks.gates.GateNotBlock;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.RepeaterBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(EDCraft.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.EXAMPLE_BLOCK))
            .displayName(Text.translatable("itemGroup.edcraft"))
            .build();

    public static void initialize() {
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        // Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlocks.EXAMPLE_BLOCK.asItem());
            itemGroup.add(ModBlocks.GATE_NOT.asItem());
        });
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

    public static final Block GATE_NOT = register(new GateNotBlock(AbstractBlock.Settings.create()),
            "gate_not",
            true);

}

