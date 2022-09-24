package com.github.jadedbanana.teamindicatorsplus.keybinds;

import com.github.jadedbanana.teamindicatorsplus.TeamIndicatorsPlus;
import com.github.jadedbanana.teamindicatorsplus.config.screens.OuterConfigMenuScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.network.message.MessageType;
import net.minecraft.text.Text;

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
            TeamIndicatorsPlus.CONFIG.ENABLED = !TeamIndicatorsPlus.CONFIG.ENABLED;
            client.player.sendMessage(Text.Serializer.fromJson(
                    "[{\"text\":\"[Team Indicators+] \",\"color\":\"green\"},{\"text\":\"Mod " +
                            (TeamIndicatorsPlus.CONFIG.ENABLED ? "enabled." : "disabled.") +
                            "\",\"color\":\"white\"}]"
            ));
        }
    }

}
