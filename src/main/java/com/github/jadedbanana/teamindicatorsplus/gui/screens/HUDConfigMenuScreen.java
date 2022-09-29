package com.github.jadedbanana.teamindicatorsplus.gui.screens;

import com.github.jadedbanana.teamindicatorsplus.gui.screens.widgets.ColorToggleEntryType;
import com.github.jadedbanana.teamindicatorsplus.gui.screens.widgets.ScrollingColorToggleWidget;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class HUDConfigMenuScreen extends Screen {

    Screen parent;
    ScrollingColorToggleWidget scrollingColorToggleWidget;

    /*
    Constructor.
     */
    public HUDConfigMenuScreen(Screen parent) {
        super(Text.translatable("teamindicatorsplus.options.screen.hud.title"));
        this.parent = parent;
    }


    /*
    Init method.
    Adds all the scrolling stuff.
     */
    public void init() {
        this.scrollingColorToggleWidget = new ScrollingColorToggleWidget(
                this.client, this, this.width, this.height, ColorToggleEntryType.HOTBAR
        );
        this.addSelectableChild(this.scrollingColorToggleWidget);
    }


    /*
    Close method, sets the parent as the new screen.
     */
    public void close() {
        this.client.setScreen(this.parent);
    }


    /*
    Render method, renders background and all the buttons and stuff.
     */
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.scrollingColorToggleWidget.render(matrices, mouseX, mouseY, delta);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 8, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }

}
