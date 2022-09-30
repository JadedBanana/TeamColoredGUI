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
    Adds all the scrolling stuff.
     */
    public void init() {

        // HUD button
        this.addDrawableChild(new ButtonWidget(
                5, 20, 80, 20,
                Text.translatable("Hotbar..."), (button) -> {
        }
        ));

        // HUD button
        this.addDrawableChild(new ButtonWidget(
                5, 45, 80, 20,
                Text.translatable("EXP Bar..."), (button) -> {
        }
        ));
        super.init();
        this.currentWidget = new ScrollingColorToggleWidget(
                this.client, this, this.width, this.height, ColorToggleEntryType.HOTBAR
        );
        this.addSelectableChild(this.currentWidget);

    }

}
