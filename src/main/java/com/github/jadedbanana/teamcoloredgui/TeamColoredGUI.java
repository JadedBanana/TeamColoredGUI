package com.github.jadedbanana.teamcoloredgui;

import com.github.jadedbanana.teamcoloredgui.config.Config;
import com.github.jadedbanana.teamcoloredgui.config.ConfigManager;
import com.github.jadedbanana.teamcoloredgui.gui.TeamTextureFinder;
import com.github.jadedbanana.teamcoloredgui.keybinds.KeyBinds;
import net.fabricmc.api.ModInitializer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TeamColoredGUI implements ModInitializer {

	private KeyBinds keyBinds;
	public static final Logger LOGGER = LoggerFactory.getLogger("teamcoloredgui");
	public static final Gson GSON;
	public static Config CONFIG;


	/*
	OnInitialize function.
	Initializes the various components that make this mod work.
	 */
	@Override
	public void onInitialize() {
		// Initialize config.
		LOGGER.info("[Team Colored GUI] Loading config...");
		ConfigManager.initializeConfig();

		// Initialize team texture finder.
		LOGGER.info("[Team Colored GUI] Loading team colors...");
		TeamTextureFinder.initialize();

		// Initialize keybinds.
		LOGGER.info("[Team Colored GUI] Loading keybinds...");
		this.keyBinds = new KeyBinds();

		// Loaded.
		LOGGER.info("[Team Colored GUI] Loaded.");
	}


	/*
	Static initializer.
	 */
	static {
		GSON = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();
	}
}
