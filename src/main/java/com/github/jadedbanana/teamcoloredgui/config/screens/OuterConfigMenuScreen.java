package com.github.jadedbanana.teamcoloredgui.config.screens;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class OuterConfigMenuScreen extends Screen {

    public OuterConfigMenuScreen() {
        super(Text.of("teamcoloredgui.outerconfig"));
    }


    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
    }

}
