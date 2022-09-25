package com.github.jadedbanana.teamindicatorsplus.config.screens;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class HUDConfigMenuScreen extends Screen {

    Screen parent;

    /*
    Constructor.
     */
    public HUDConfigMenuScreen(Screen parent) {
        super(Text.translatable("teamindicatorsplus.options.screen.hud.title"));
        this.parent = parent;
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
        this.renderBackgroundTexture(0);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }

}
