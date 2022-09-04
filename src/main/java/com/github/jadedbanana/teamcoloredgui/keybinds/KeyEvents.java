package com.github.jadedbanana.teamcoloredgui.keybinds;

import com.github.jadedbanana.teamcoloredgui.TeamColoredGUI;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

public class KeyEvents {

    private KeyBinding[] keyBinds;

    /*
    Constructor.
     */
    public KeyEvents(final KeyBinding[] keyBinding) { this.keyBinds = keyBinding; }


    /*
    Responds to when the keybinds are pressed down.
     */
    public void KeyBindsEvents(final MinecraftClient client) {
        // Keybind 0 (Open config)
        if (this.keyBinds[0].wasPressed()) {
            TeamColoredGUI.LOGGER.info("OPEN CONFIG");

        }

        // Keybind 1 (toggle)
        if (this.keyBinds[1].wasPressed()) {
            TeamColoredGUI.LOGGER.info("TOGGLE");
        }
    }

}
