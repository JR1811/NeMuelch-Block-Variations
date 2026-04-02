package net.shirojr.nemuelch;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.shirojr.nemuelch.init.NBVBlocks;
import net.shirojr.nemuelch.init.NBVItemGroups;
import net.shirojr.nemuelch.init.NBVItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NBVMain implements ModInitializer {
	public static final String MOD_ID = "nemuelch";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID + " Block Variations");

	@Override
	public void onInitialize() {
		NBVItems.initialize();
		NBVBlocks.initialize();
		NBVItemGroups.initialize();

		LOGGER.info("Successfully Loaded NeMuelch Mod addition: \"NeMuelch Block Variations (NBV)\"");
	}

	public static Identifier getId(String path) {
		return Identifier.of(MOD_ID, path);
	}
}