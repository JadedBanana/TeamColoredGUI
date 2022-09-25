package com.github.jadedbanana.teamindicatorsplus.config.screens.widgets;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ElementListWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class ScrollingColorToggleWidget extends ElementListWidget<ScrollingColorToggleWidget.Entry> {

    public static MinecraftClient client;


    public ScrollingColorToggleWidget(MinecraftClient client, int width, int height, int top, int bottom, int itemHeight) {
        super(client, width, height, top, bottom, itemHeight);

        ScrollingColorToggleWidget.client = client;

        for (int i = 0; i < 30; i++)
            this.addEntry(new Entry());
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

    public static class Entry extends ElementListWidget.Entry<Entry> {

        @Override
        public void render(MatrixStack matrices, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
            TextRenderer var10000 = ScrollingColorToggleWidget.client.textRenderer;
            Text var10002 = Text.literal("okay yall");
            float var10003 = (float)(x + 90);
            int var10004 = y + entryHeight / 2;
            var10000.draw(matrices, var10002, var10003, (float)(var10004 - 9 / 2), 16777215);
        }

        @Override
        public List<? extends Selectable> selectableChildren() {
            return null;
        }

        @Override
        public List<? extends Element> children() {
            return null;
        }
    }
}
