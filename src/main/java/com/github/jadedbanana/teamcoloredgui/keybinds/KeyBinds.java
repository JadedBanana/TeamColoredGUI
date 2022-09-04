package com.github.jadedbanana.teamcoloredgui.keybinds;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;

public class KeyBinds {

    private KeyBinding[] keyBinding;


    /*
    Constructor.
     */
    public KeyBinds() {
        this.keyBinding = new KeyBinding[2];
        this.setKeybinds();
    }


    /*
    Create keybind objects.
    Openconfig is set to page up by default.
    Toggle is not bound by default.
     */
    public void setKeybinds() {
        this.keyBinding[0] = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.teamcoloredgui.openconfig",
                266,
                "key.teamcoloredgui.category"
        ));
        this.keyBinding[1] = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.teamcoloredgui.toggle",
                -1,
                "key.teamcoloredgui.category"
        ));
    }

}