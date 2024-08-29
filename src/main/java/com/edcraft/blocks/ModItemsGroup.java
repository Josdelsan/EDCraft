package com.edcraft.blocks;

import com.edcraft.EDCraft;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroup {

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(EDCraft.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.EXAMPLE_BLOCK))
            .displayName(Text.translatable("itemGroup.edcraft"))
            .build();

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlocks.EXAMPLE_BLOCK.asItem());
            itemGroup.add(ModBlocks.GATE_NOT.asItem());
            itemGroup.add(ModBlocks.GATE_AND.asItem());
            itemGroup.add(ModBlocks.GATE_OR.asItem());
            itemGroup.add(ModBlocks.GATE_XOR.asItem());
        });
    }

}
