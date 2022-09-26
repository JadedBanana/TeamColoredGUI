package com.github.jadedbanana.teamindicatorsplus.gui.screens;

import com.github.jadedbanana.teamindicatorsplus.TeamIndicatorsPlus;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

public class OuterConfigMenuScreen extends Screen {

    protected ButtonWidget globalToggleButton;

    /*
    Constructor.
     */
    public OuterConfigMenuScreen() {
        super(Text.translatable("teamindicatorsplus.options.screen.outer.title"));
    }

    /*
    Init method.
    Adds all the menu buttons.
     */
    protected void init() {
        // Creation of global toggle button, which requires its own reference object for... workaround reasons :P
        globalToggleButton = new ButtonWidget(
            this.width / 2 - 155, this.height / 6 - 12, 150, 20,
            Text.translatable(TeamIndicatorsPlus.CONFIG.ENABLED ? "teamindicatorsplus.options.globaltoggle.on" : "teamindicatorsplus.options.globaltoggle.off"),
            (button) -> {
                // Toggle enabled state and save
                TeamIndicatorsPlus.CONFIG.ENABLED = !TeamIndicatorsPlus.CONFIG.ENABLED;
                TeamIndicatorsPlus.saveConfig();
                // Update button text
                this.globalToggleButton.setMessage(Text.translatable(TeamIndicatorsPlus.CONFIG.ENABLED ? "teamindicatorsplus.options.globaltoggle.on" : "teamindicatorsplus.options.globaltoggle.off"));
            }
        );
        this.addDrawableChild(globalToggleButton);

        // About button
        this.addDrawableChild(new ButtonWidget(
            this.width / 2 + 5, this.height / 6 - 12, 150, 20,
            Text.translatable("teamindicatorsplus.options.outer.about"), (button) -> {
                // TODO: add about screen
            }
        ));

        // HUD button
        this.addDrawableChild(new ButtonWidget(
            this.width / 2 - 155, this.height / 6 + 42, 150, 20,
            Text.translatable("teamindicatorsplus.options.outer.hud"), (button) -> {
                this.client.setScreen(new HUDConfigMenuScreen(this));
            }
        ));

        // Screens button
        this.addDrawableChild(new ButtonWidget(
            this.width / 2 + 5, this.height / 6 + 42, 150, 20,
            Text.translatable("teamindicatorsplus.options.outer.screens"), (button) -> {
                // TODO: add screens options menu
            }
        ));

        // World button
        this.addDrawableChild(new ButtonWidget(
            this.width / 2 - 155, this.height / 6 + 68, 150, 20,
            Text.translatable("teamindicatorsplus.options.outer.world"), (button) -> {
                // TODO: add world options menu
            }
        ));

        // Players button
        this.addDrawableChild(new ButtonWidget(
            this.width / 2 + 5, this.height / 6 + 68, 150, 20,
            Text.translatable("teamindicatorsplus.options.outer.players"), (button) -> {
                // TODO: add player options menu
            }
        ));

        // Done button
        this.addDrawableChild(new ButtonWidget(
            this.width / 2 - 100, this.height / 6 + 168, 200, 20, ScreenTexts.DONE, (button) -> {
                this.client.setScreen(null);
            }
        ));
    }


    /*
    Render method, renders background and all the buttons and stuff.
     */
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }

}
