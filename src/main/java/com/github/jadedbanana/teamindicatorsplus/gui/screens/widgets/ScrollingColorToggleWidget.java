package com.github.jadedbanana.teamindicatorsplus.gui.screens.widgets;

import com.github.jadedbanana.teamindicatorsplus.TeamIndicatorsPlus;
import com.github.jadedbanana.teamindicatorsplus.TeamIndicatorsUtil;
import com.github.jadedbanana.teamindicatorsplus.gui.screens.ScrollingColorConfigScreen;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ElementListWidget;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ScrollingColorToggleWidget extends ElementListWidget<ScrollingColorToggleWidget.ColorToggleEntry> {

    public static MinecraftClient client;
    private final int rowWidth;


    /*
    Constructor.
     */
    public ScrollingColorToggleWidget(MinecraftClient client, Screen parentScreen, int width,
                                      int height, ColorToggleEntryType type) {
        // Call super.
        super(client, width - 40, height, 20, height - 32, Math.max(type.height + 18, 38));

        // Override default attributes.
        this.setLeftPos(40);
        this.rowWidth = 105 + type.width;

        // Copy over attributes.
        ScrollingColorToggleWidget.client = client;

        // Create entries.
        ArrayList<Formatting> formatList = TeamIndicatorsUtil.getColorFormats();
        for (int i = 0; i < formatList.size(); i++)
            this.addEntry(new ColorToggleEntry(parentScreen, type, formatList.get(i), i));
    }


    /*
    Variable overrides.
     */
    protected int getScrollbarPositionX() {
        return super.getScrollbarPositionX() + 80;
    }
    public int getRowWidth() {
        return this.rowWidth;
    }
    public int getLeft() { return this.left; }


    /*
    Narration stuff, I don't know what to do with these so I'll do it later I guess
     */
    @Override
    public boolean isNarratable() { return false; }
    @Override
    public void appendNarrations(NarrationMessageBuilder builder) {}


    /*
    SetAll method.
    Sets all the entries' values and saves.
     */
    public void setAll(boolean changeVal) {
        for (ColorToggleEntry e : this.children())
            e.set(changeVal);
        TeamIndicatorsPlus.saveConfig();
    }


    /*
    Render method.
    Calls the parent method, but also draws a shadow on the left side (at x = ScrollingColorConfigScreen.SIDEBAR_WIDTH).
     */
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        // Call super function first.
        super.render(matrices, mouseX, mouseY, delta);

        // Set up Tesselator, BufferBuilder, and RenderSystem.
        // Set them to fade.
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SrcFactor.ZERO, GlStateManager.DstFactor.ONE);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);

        // Draw left sidebar's dark fade.
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        bufferBuilder.vertex(ScrollingColorConfigScreen.SIDEBAR_WIDTH, this.bottom, 0.0).color(0, 0, 0, 255).next();
        bufferBuilder.vertex(ScrollingColorConfigScreen.SIDEBAR_WIDTH + 4, this.bottom, 0.0).color(0, 0, 0, 0).next();
        bufferBuilder.vertex(ScrollingColorConfigScreen.SIDEBAR_WIDTH + 4, this.top, 0.0).color(0, 0, 0, 0).next();
        bufferBuilder.vertex(ScrollingColorConfigScreen.SIDEBAR_WIDTH, this.top, 0.0).color(0, 0, 0, 255).next();
        tessellator.draw();
    }


    /*
    ColorToggleEntry class, used to populate the ScrollingColorToggleWidget.
     */
    public static class ColorToggleEntry extends ElementListWidget.Entry<ColorToggleEntry> {

        // Config index, used to grab config info.
        private final int configIndex;
        private final boolean[] configList;
        private boolean enabled;

        // Text stuff. Used to draw the text for the config options.
        private final Text titleText;

        // Image stuff.
        private final Identifier coloredImage;
        private final Identifier defaultImage;
        private final int offsetX, offsetY, imageW, imageH;

        // Enable / disable button.
        private final ButtonWidget enableDisableButton;

        // Parent screen.
        public Screen parentScreen;


        /*
        Constructor.
        Creates everything the entry uses.
         */
        public ColorToggleEntry(Screen parentScreen, ColorToggleEntryType type, Formatting formatting, int configIndex) {
            // Set parentScreen.
            this.parentScreen = parentScreen;

            // Copy config stuff.
            this.configIndex = configIndex;
            configList = type.configList;
            enabled = configList[this.configIndex];

            // Copy images + image data.
            coloredImage = type.colorImages[this.configIndex];
            defaultImage = type.defaultImage;
            offsetX = type.offsetX;
            offsetY = type.offsetY;
            imageW = type.width;
            imageH = type.height;

            // Create text objects based on color name
            titleText = Text.translatable("teamindicatorsplus.options.color." + formatting.getName().toLowerCase());

            // Create button.
            this.enableDisableButton = new ButtonWidget(0, 0, 100, 20,
                enabled ? Text.translatable("teamindicatorsplus.options.enabled") :
                Text.translatable("teamindicatorsplus.options.disabled"), (button) -> {
                    this.toggleSet(!this.configList[this.configIndex]);
            });
        }


        /*
        Toggle set.
        Toggles the config option to the provided value and saves.
         */
        public void toggleSet(boolean changeVal) {
            this.set(changeVal);
            TeamIndicatorsPlus.saveConfig();
        }


        /*
        Set.
        Sets the config option to the provided value but does NOT save.
         */
        public void set(boolean changeVal) {
            this.configList[this.configIndex] = changeVal;
            this.enabled = changeVal;
            this.enableDisableButton.setMessage(
                    changeVal ? Text.translatable("teamindicatorsplus.options.enabled") :
                            Text.translatable("teamindicatorsplus.options.disabled"));
        }


        /*
        Render.
        Renders the entry in the list.
         */
        @Override
        public void render(MatrixStack matrices, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
            // Draw text.
            drawCenteredText(matrices, ScrollingColorToggleWidget.client.textRenderer, this.titleText, x + entryWidth / 2, y + 4, 16777215);

            // Draw image.
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderTexture(0, enabled ? coloredImage : defaultImage);
            this.parentScreen.drawTexture(matrices, x, y + 15, offsetX, offsetY, imageW, imageH);

            // Draw button.
            this.enableDisableButton.x = x + entryWidth - 100;
            this.enableDisableButton.y = y + 15 + (imageH > 20 ? (imageH - 20) / 2 : 0);
            this.enableDisableButton.render(matrices, mouseX, mouseY, tickDelta);
        }


        /*
        Methods that need to exist for the buttons to work.
         */
        public List<? extends Element> children() {
            return ImmutableList.of(this.enableDisableButton);
        }
        public List<? extends Selectable> selectableChildren() { return ImmutableList.of(this.enableDisableButton); }
        public boolean mouseClicked(double mouseX, double mouseY, int button) { return this.enableDisableButton.mouseClicked(mouseX, mouseY, button); }
        public boolean mouseReleased(double mouseX, double mouseY, int button) { return this.enableDisableButton.mouseReleased(mouseX, mouseY, button); }
    }
}
