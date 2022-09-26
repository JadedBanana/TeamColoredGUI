package com.github.jadedbanana.teamindicatorsplus.gui.screens.widgets;

import com.github.jadedbanana.teamindicatorsplus.TeamIndicatorsUtil;
import com.github.jadedbanana.teamindicatorsplus.gui.TeamTextureFinder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ElementListWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ScrollingColorToggleWidget extends ElementListWidget<ScrollingColorToggleWidget.ColorToggleEntry> {

    public static MinecraftClient client;


    public ScrollingColorToggleWidget(MinecraftClient client, int width, int height, ColorToggleEntryType type) {
        super(client, width, height, 20, height - 32, 15);
        this.setLeftPos(100);

        ScrollingColorToggleWidget.client = client;

        ArrayList<Formatting> formatList = TeamIndicatorsUtil.getColorFormats();
        for (int i = 0; i < formatList.size(); i++)
            this.addEntry(new ColorToggleEntry(type, formatList.get(i), i));
    }

    @Override
    public Optional<Element> hoveredElement(double mouseX, double mouseY) {
        return super.hoveredElement(mouseX, mouseY);
    }

    @Override
    public void mouseMoved(double mouseX, double mouseY) {
        super.mouseMoved(mouseX, mouseY);
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) { return super.keyReleased(keyCode, scanCode, modifiers); }
    @Override
    public boolean charTyped(char chr, int modifiers) { return super.charTyped(chr, modifiers); }
    @Override
    public void setInitialFocus(@Nullable Element element) { super.setInitialFocus(element); }
    @Override
    public void focusOn(@Nullable Element element) { super.focusOn(element); }
    @Override
    public boolean changeFocus(boolean lookForwards) { return super.changeFocus(lookForwards); }


    /*
    Narration stuff, I don't know what to do with these so I'll do it later I guess
     */
    @Override
    public boolean isNarratable() { return false; }
    @Override
    public void appendNarrations(NarrationMessageBuilder builder) {}

    public static class ColorToggleEntry extends ElementListWidget.Entry<ColorToggleEntry> {

        private int configIndex;
        private Text titleText;
        private Style titleStyle;

        public ColorToggleEntry(ColorToggleEntryType type, Formatting formatting, int configIndex) {
            titleText = Text.translatable("color.whatever");
            titleStyle = Style.EMPTY.withColor(formatting);


        }

        @Override
        public void render(MatrixStack matrices, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
            TextRenderer var10000 = ScrollingColorToggleWidget.client.textRenderer;
            float var10003 = (float)(x);
            int var10004 = y + entryHeight / 2;
            var10000.draw(matrices, titleText.getWithStyle(titleStyle).get(0), var10003, (float)(var10004 - 9 / 2), 16777215);
        }

        @Override
        public List<? extends Selectable> selectableChildren() {
            return null;
        }

        @Override
        public List<? extends Element> children() { return Collections.emptyList(); }
    }
}
