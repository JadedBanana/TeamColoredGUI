package com.github.jadedbanana.teamindicatorsplus.config.screens;

import com.github.jadedbanana.teamindicatorsplus.TeamIndicatorsPlus;
import com.github.jadedbanana.teamindicatorsplus.config.ConfigManager;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class OuterConfigMenuScreen extends Screen {

    public OuterConfigMenuScreen() {
        super(Text.of("teamcoloredgui.outerconfig"));
    }


    public void removed() {
        TeamIndicatorsPlus.LOGGER.info("Saving Team Indicators+ config.");
        ConfigManager.save();
    }


    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
    }

}
