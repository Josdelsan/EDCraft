package com.edcraft;

import com.edcraft.blocks.ModBlocks;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EDCraft implements ModInitializer {

	public static final String MOD_ID = "edcraft";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModBlocks.initialize();
	}
}