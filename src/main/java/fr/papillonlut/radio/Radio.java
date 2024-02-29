package fr.papillonlut.radio;

import fr.papillonlut.radio.block.ModBlocks;
import fr.papillonlut.radio.item.ModItemGroups;
import fr.papillonlut.radio.item.ModItems;
import fr.papillonlut.radio.rpc.DiscordStatusManager;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Radio implements ModInitializer {
	public static final String MOD_ID = "radio";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		// Initialize Discord Rich Presence
		DiscordStatusManager.init();
	}
}
