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

    // Constants!
    public static final int SIDEBAR_WIDTH = 90;

    // Widgets.
    // Used to keep track of all the shenanigans.
    protected ScrollingColorToggleWidget[] colorToggleWidgets;
    protected ScrollingColorToggleWidget currentToggleWidget;
    protected ButtonWidget[] colorButtons;

    // Parent screen.
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
    Init method (no arguments).
    Sets all the buttons up that DON'T have much to do about the color toggles.
     */
    public void init() {
        // Find button midpoint (so that buttons do not overlap with sidebar)
        int buttonsCenter = Math.max(SIDEBAR_WIDTH + 145, this.width / 2 + 20);

        // Done button
        this.addDrawableChild(new ButtonWidget(
                buttonsCenter - 140, this.height - 27, 60, 20,
                Text.translatable("teamindicatorsplus.options.enable_all"), (button) -> {
            this.currentToggleWidget.setAll(true);
        }));

        // Disable all button
        this.addDrawableChild(new ButtonWidget(
                buttonsCenter - 75, this.height - 27, 60, 20,
                Text.translatable("teamindicatorsplus.options.disable_all"), (button) -> {
            this.currentToggleWidget.setAll(false);
        }));

        // Enable all button
        this.addDrawableChild(new ButtonWidget(
                buttonsCenter - 10, this.height - 27, 150, 20, ScreenTexts.DONE, (button) -> {
            this.client.setScreen(this.parent);
        }));
    }


    /*
    Init method (one argument).
    Creates all the color toggling shit!
     */
    public void init(ColorToggleEntryType[] entryTypes) {
        // Create lists.
        colorToggleWidgets = new ScrollingColorToggleWidget[entryTypes.length];
        colorButtons = new ButtonWidget[entryTypes.length];

        // Iterate through entry types and create color toggle widgets.
        for (int i = 0; i < entryTypes.length; i++) {
            ScrollingColorToggleWidget scrollWidget = new ScrollingColorToggleWidget(
                this.client, this, this.width, this.height, entryTypes[i]
            );
            colorToggleWidgets[i] = scrollWidget;

            // Create matching button.
            colorButtons[i] = new ButtonWidget(
                5, 20 + i * 25, SIDEBAR_WIDTH - 10, 20,
                Text.translatable("teamindicatorsplus.options.tab." + entryTypes[i].name().toLowerCase()),
                (button) -> {
                    this.setActiveWidget(button, scrollWidget);
            });
            this.addDrawableChild(colorButtons[i]);
        }

        // Set default acive widget.
        this.setActiveWidget(colorButtons[0], colorToggleWidgets[0]);
    }


    /*
    SetActiveWidget method.
    Switches the active widget from one to the other.
     */
    public void setActiveWidget(ButtonWidget button, ScrollingColorToggleWidget colorToggleWidget) {
        // First, remove the existing colorToggleWidget, if it exists.
        if (currentToggleWidget != null)
            this.remove(currentToggleWidget);

        // Add the new color widget as the currentToggleWidget.
        currentToggleWidget = colorToggleWidget;
        this.addSelectableChild(currentToggleWidget);

        // Enable all buttons EXCEPT this one, which gets disabled.
        for (ButtonWidget b : colorButtons)
            if (b == button)
                b.active = false;
            else
                b.active = true;
    }


    /*
    Render method, renders background and all the buttons and stuff.
     */
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        // Draw central widget and sidebar.
        this.currentToggleWidget.render(matrices, mouseX, mouseY, delta);
        this.renderSidebar(0);

        // Draw text and have all drawable buttons drawn.
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 8, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }


    /*
    RenderSidebar method, renders the sidebar background.
     */
    private void renderSidebar(int vOffset) {
        // Set up Tesselator and BufferBuilder to draw background.
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderTexture(0, OPTIONS_BACKGROUND_TEXTURE);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        // Determine the x position we start with to reduce clashing with the widget's top + bottom texture.
        int leftXPos = this.currentToggleWidget.getLeft();
        leftXPos = leftXPos - ((leftXPos / 32) + 1) * 32;

        // Draw background.
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        bufferBuilder.vertex(leftXPos, this.height, 0.0).texture(0.0F, (float)this.height / 32.0F + (float)vOffset).color(64, 64, 64, 255).next();
        bufferBuilder.vertex(SIDEBAR_WIDTH, this.height, 0.0).texture((float)(SIDEBAR_WIDTH - leftXPos) / 32.0F, (float)this.height / 32.0F + (float)vOffset).color(64, 64, 64, 255).next();
        bufferBuilder.vertex(SIDEBAR_WIDTH, 0.0, 0.0).texture((float)(SIDEBAR_WIDTH - leftXPos) / 32.0F, (float)vOffset).color(64, 64, 64, 255).next();
        bufferBuilder.vertex(leftXPos, 0.0, 0.0).texture(0.0F, (float)vOffset).color(64, 64, 64, 255).next();
        tessellator.draw();
    }

}
