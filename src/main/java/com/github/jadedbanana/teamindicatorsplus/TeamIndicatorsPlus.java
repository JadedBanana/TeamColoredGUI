package com.github.jadedbanana.teamindicatorsplus;

import com.github.jadedbanana.teamindicatorsplus.config.Config;
import com.github.jadedbanana.teamindicatorsplus.config.ConfigManager;
import com.github.jadedbanana.teamindicatorsplus.gui.TeamTextureFinder;
import com.github.jadedbanana.teamindicatorsplus.keybinds.KeyBinds;
import net.fabricmc.api.ModInitializer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TeamIndicatorsPlus implements ModInitializer {

	private KeyBinds keyBinds;
	public static final Logger LOGGER = LoggerFactory.getLogger("teamindicators+");
	public static final Gson GSON;
	public static Config CONFIG;


	/*
	OnInitialize function.
	Initializes the various components that make this mod work.
	 */
	@Override
	public void onInitialize() {
		// Initialize config.
		LOGGER.info("[Team Indicators+] Loading config...");
		ConfigManager.initializeConfig();

		// Initialize team texture finder.
		LOGGER.info("[Team Indicators+] Loading team colors...");
		TeamTextureFinder.initialize();

		// Initialize keybinds.
		LOGGER.info("[Team Indicators+] Loading keybinds...");
		this.keyBinds = new KeyBinds();

		// Loaded.
		LOGGER.info("[Team Indicators+] Loaded.");
	}


	/*
	Save config method.
	Logs a message and saves the config.
	 */
	public static void saveConfig() {
		TeamIndicatorsPlus.LOGGER.info("Saving Team Indicators+ config.");
		ConfigManager.save();
	}


	/*
	Static initializer.
	 */
	static {
		GSON = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();
	}
}
