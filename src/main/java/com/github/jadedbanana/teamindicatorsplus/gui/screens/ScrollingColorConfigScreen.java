package com.github.jadedbanana.teamindicatorsplus.gui.screens;

import com.github.jadedbanana.teamindicatorsplus.TeamIndicatorsPlus;
import com.github.jadedbanana.teamindicatorsplus.gui.screens.widgets.ColorToggleEntryType;
import com.github.jadedbanana.teamindicatorsplus.gui.screens.widgets.ScrollingColorToggleWidget;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

import java.util.ArrayList;

public abstract class ScrollingColorConfigScreen extends Screen {


    public static final int SIDEBAR_WIDTH = 90;
    ArrayList<ScrollingColorToggleWidget> toggleWidgets;
    ScrollingColorToggleWidget currentWidget;
    Screen parent;

    /*
    Constructor.
     */
    protected ScrollingColorConfigScreen(Text title, Screen parent) {
        super(title);
        this.parent = parent;
    }


    /*
    Close method, sets the parent as the new screen.
     */
    public void close() {
        this.client.setScreen(this.parent);
    }


    /*
    Init method.
    Resets all the widgets for new use.
     */
    public void init() {
        toggleWidgets = new ArrayList<ScrollingColorToggleWidget>();

        // Find midpoint (max of 2 things)
        int buttonsCenter = Math.max(225, this.width / 2 + 20);

        // Done button
        this.addDrawableChild(new ButtonWidget(
            buttonsCenter - 140, this.height - 27, 60, 20,
            Text.translatable("teamindicatorsplus.options.enable_all"), (button) -> {
                this.client.setScreen(this.parent);
        }));

        // Disable all button
        this.addDrawableChild(new ButtonWidget(
            buttonsCenter - 75, this.height - 27, 60, 20,
            Text.translatable("teamindicatorsplus.options.disable_all"), (button) -> {
                this.client.setScreen(this.parent);
        }));

        // Enable all button
        this.addDrawableChild(new ButtonWidget(
            buttonsCenter - 10, this.height - 27, 150, 20, ScreenTexts.DONE, (button) -> {
                this.client.setScreen(this.parent);
        }));
    }


    /*
    Render method, renders background and all the buttons and stuff.
     */
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.currentWidget.render(matrices, mouseX, mouseY, delta);
        this.renderSidebar(0);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 8, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }


    private void renderSidebar(int vOffset) {
        // Set up Tesselator and BufferBuilder to draw background.
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderTexture(0, OPTIONS_BACKGROUND_TEXTURE);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        // Determine the x position we start with to reduce clashing with the widget's top + bottom texture.
        int leftXPos = this.currentWidget.getLeft();
        leftXPos = leftXPos - ((leftXPos / 32) + 1) * 32;

        // Draw background.
        TeamIndicatorsPlus.LOGGER.info("" + leftXPos);
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        bufferBuilder.vertex(leftXPos, this.height, 0.0).texture(0.0F, (float)this.height / 32.0F + (float)vOffset).color(64, 64, 64, 255).next();
        bufferBuilder.vertex(SIDEBAR_WIDTH, this.height, 0.0).texture((float)(SIDEBAR_WIDTH - leftXPos) / 32.0F, (float)this.height / 32.0F + (float)vOffset).color(64, 64, 64, 255).next();
        bufferBuilder.vertex(SIDEBAR_WIDTH, 0.0, 0.0).texture((float)(SIDEBAR_WIDTH - leftXPos) / 32.0F, (float)vOffset).color(64, 64, 64, 255).next();
        bufferBuilder.vertex(leftXPos, 0.0, 0.0).texture(0.0F, (float)vOffset).color(64, 64, 64, 255).next();
        tessellator.draw();
    }

}
