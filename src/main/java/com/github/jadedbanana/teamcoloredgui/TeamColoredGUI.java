package com.github.jadedbanana.teamcoloredgui;

import com.github.jadedbanana.teamcoloredgui.keybinds.KeyBinds;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TeamColoredGUI implements ModInitializer {

	private KeyBinds keyBinds;
	public static final Logger LOGGER = LoggerFactory.getLogger("teamcoloredgui");

	@Override
	public void onInitialize() {
		// Initialize team texture finder.
		LOGGER.info("[Team Colored GUI] Loading team colors...");
		TeamTextureFinder.initialize();

		// Initialize keybinds.
		LOGGER.info("[Team Colored GUI] Loading keybinds...");
		this.keyBinds = new KeyBinds();

		// Loaded.
		LOGGER.info("[Team Colored GUI] Loaded.");
	}
}
