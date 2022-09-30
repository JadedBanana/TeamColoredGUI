package com.github.jadedbanana.teamindicatorsplus.gui.screens;

import com.github.jadedbanana.teamindicatorsplus.gui.screens.widgets.ColorToggleEntryType;
import com.github.jadedbanana.teamindicatorsplus.gui.screens.widgets.ScrollingColorToggleWidget;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class HUDConfigMenuScreen extends ScrollingColorConfigScreen {

    /*
    Constructor.
     */
    public HUDConfigMenuScreen(Screen parent) {
        super(Text.translatable("teamindicatorsplus.options.screen.hud.title"), parent);
    }


    /*
    Init method.
    Adds all the stuff.
     */
    public void init() {
        // Add normal stuff
        super.init();
        // Add the Color toggles
        super.init(new ColorToggleEntryType[]{
                ColorToggleEntryType.HOTBAR
        });
    }

}
