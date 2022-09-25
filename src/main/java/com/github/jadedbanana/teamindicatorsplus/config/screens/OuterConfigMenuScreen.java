package com.github.jadedbanana.teamindicatorsplus.config.screens;

import com.github.jadedbanana.teamindicatorsplus.TeamIndicatorsPlus;
import com.github.jadedbanana.teamindicatorsplus.config.ConfigManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.SkinOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.CyclingButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.scoreboard.Team;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;

public class OuterConfigMenuScreen extends Screen {

    protected ButtonWidget globalToggleButton;

    public OuterConfigMenuScreen() {
        super(Text.of("teamcoloredgui.outerconfig"));
    }

    /*
    Init method.
    Adds all the menu buttons.
     */
    protected void init() {
        TeamIndicatorsPlus.LOGGER.info("" + this.width);

        // Creation of global toggle button, which requires its own instantiator for... workaround reasons :P
        globalToggleButton = new ButtonWidget(
                this.width / 2 - 155, this.height / 6 - 12, 150, 20,
                Text.translatable(TeamIndicatorsPlus.CONFIG.ENABLED ? "teamindicatorsplus.options.globaltoggle.on" : "teamindicatorsplus.options.globaltoggle.off"),
                (button) -> {
                    TeamIndicatorsPlus.CONFIG.ENABLED = !TeamIndicatorsPlus.CONFIG.ENABLED;
                    this.globalToggleButton.setMessage(Text.translatable(TeamIndicatorsPlus.CONFIG.ENABLED ? "teamindicatorsplus.options.globaltoggle.on" : "teamindicatorsplus.options.globaltoggle.off"));
                }
        );
        this.addDrawableChild(globalToggleButton);

    }


    /*
    Removed method, runs when this screen is closed.
     */
    public void removed() {
        TeamIndicatorsPlus.LOGGER.info("Saving Team Indicators+ config.");
        ConfigManager.save();
    }


    /*
    Render method, renders background and all the buttons and stuff.
     */
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
    }

}
