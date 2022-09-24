package com.github.jadedbanana.teamindicatorsplus.config;

import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.github.jadedbanana.teamindicatorsplus.TeamIndicatorsPlus;
import net.fabricmc.loader.api.FabricLoader;

public class ConfigManager {

    private static File file;


    /*
    Method to gather the location of the saved config file for the first time.
     */
    private static void prepareConfigFile() {
        if (ConfigManager.file == null)
            ConfigManager.file = new File(FabricLoader.getInstance().getConfigDir().toString(),
                                          "teamcoloredgui.json");
    }


    /*
    Creates a new config object and stores it in memory.
     */
    public static Config initializeConfig() {
        // If config exists, return it
        if (TeamIndicatorsPlus.CONFIG != null)
            return TeamIndicatorsPlus.CONFIG;

        // If config does not exist, load it and return. If load failed, create new config.
        load();
        if (TeamIndicatorsPlus.CONFIG == null)
            TeamIndicatorsPlus.CONFIG = new Config();
        return TeamIndicatorsPlus.CONFIG;
    }


    /*
    Saves the configuration to the .minecraft folder.
     */
    public static void save() {
        // Get file location
        prepareConfigFile();

        // Get the JSON string generated from the config file
        final String jsonString = TeamIndicatorsPlus.GSON.toJson((Object) TeamIndicatorsPlus.CONFIG);

        // Write that bitch
        try {
            final FileWriter fileWriter = new FileWriter(ConfigManager.file);
            try {
                fileWriter.write(jsonString);
                fileWriter.close();
            }

            // Error happened, suppress and throw
            catch (Throwable t) {
                try {
                    fileWriter.close();
                }
                catch (Throwable exception) {
                    t.addSuppressed(exception);
                }
                throw t;
            }
        }

        // Can't write it for some reason. Wuh oh!
        catch (IOException e) {
            System.err.println("Couldn't save InventoryHUD configuration file");
            e.printStackTrace();
        }
    }


    /*
    Loads the configuration file from the .minecraft folder.
     */
    private static void load() {
        // Get file location
        prepareConfigFile();

        // If the file doesn't exist, write it, then load it (lol)
        try {
            if (!ConfigManager.file.exists())
                save();
            if (ConfigManager.file.exists()) {
                final BufferedReader br = new BufferedReader(new FileReader(ConfigManager.file));
                final Config parsed = (Config) TeamIndicatorsPlus.GSON.fromJson((Reader)br, (Class)Config.class);
                if (parsed != null)
                    TeamIndicatorsPlus.CONFIG = parsed;
            }
        }

        // Can't load it despite saving it? Wuh oh!
        catch (FileNotFoundException e) {
            System.err.println("Couldn't load Team Indicators+ configuration file; reverting to defaults");
            e.printStackTrace();
        }
    }


    /*
    Returns the config object.
     */
    public static Config getConfig() {
        if (TeamIndicatorsPlus.CONFIG == null) {
            TeamIndicatorsPlus.CONFIG = new Config();
        }
        return TeamIndicatorsPlus.CONFIG;
    }
    
}
