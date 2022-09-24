package com.github.jadedbanana.teamcoloredgui.keybinds;

import com.github.jadedbanana.teamcoloredgui.TeamColoredGUI;
import com.github.jadedbanana.teamcoloredgui.config.Config;
import com.github.jadedbanana.teamcoloredgui.config.screens.OuterConfigMenuScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

public class KeyEvents {

    private final KeyBinding[] keyBinds;

    /*
    Constructor.
     */
    public KeyEvents(final KeyBinding[] keyBinding) { this.keyBinds = keyBinding; }


    /*
    Responds to when the keybinds are pressed down.
     */
    public void KeyBindsEvents(final MinecraftClient client) {
        // Keybind 0 (Open config)
        if (this.keyBinds[0].wasPressed())
            client.setScreenAndRender(new OuterConfigMenuScreen());

        // Keybind 1 (toggle)
        if (this.keyBinds[1].wasPressed()) {
            TeamColoredGUI.CONFIG.ENABLED = !TeamColoredGUI.CONFIG.ENABLED;
            TeamColoredGUI.LOGGER.info("TeamColoredGUI enabled toggle set to " + TeamColoredGUI.CONFIG.ENABLED + ".");
        }
    }

}
