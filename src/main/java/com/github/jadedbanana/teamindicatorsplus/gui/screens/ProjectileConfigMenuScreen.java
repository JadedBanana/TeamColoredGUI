package com.github.jadedbanana.teamindicatorsplus.gui.screens;

import com.github.jadedbanana.teamindicatorsplus.gui.screens.widgets.ColorToggleEntryType;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ProjectileConfigMenuScreen extends ScrollingColorConfigScreen {

    /*
    Constructor.
     */
    public ProjectileConfigMenuScreen(Screen parent) {
        super(Text.translatable("teamindicatorsplus.options.screen.projectile.title"), parent);
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
                ColorToggleEntryType.ARROW,
                ColorToggleEntryType.TIPPED_ARROW,
                ColorToggleEntryType.SPECTRAL_ARROW
        });
    }

}
