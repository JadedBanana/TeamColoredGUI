package com.github.jadedbanana.teamindicatorsplus.gui.screens.widgets;

import com.github.jadedbanana.teamindicatorsplus.TeamIndicatorsPlus;
import com.github.jadedbanana.teamindicatorsplus.TeamTextureFinder;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.util.Identifier;

public enum ColorToggleEntryType {

    HOTBAR(0, 0, 182, 22, new Identifier("textures/gui/widgets.png"), TeamTextureFinder.WIDGETS, TeamIndicatorsPlus.CONFIG.HOTBAR_ENABLEDS),
    ARROW(0, 0, 128, 40, ArrowEntityRenderer.TEXTURE, TeamTextureFinder.ARROWS, TeamIndicatorsPlus.CONFIG.ARROW_ENABLEDS),
    TIPPED_ARROW(0, 0, 128, 40, ArrowEntityRenderer.TIPPED_TEXTURE, TeamTextureFinder.TIPPED_ARROWS, TeamIndicatorsPlus.CONFIG.TIPPED_ARROW_ENABLEDS);

    // Variables to help with stuff.
    public int offsetX;
    public int offsetY;
    public int width;
    public int height;
    public Identifier defaultImage;
    public Identifier[] colorImages;
    public boolean[] configList;

    ColorToggleEntryType(int offsetX, int offsetY, int width, int height, Identifier defaultImage,
                         Identifier[] colorImages, boolean[] configList) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
        this.defaultImage = defaultImage;
        this.colorImages = colorImages;
        this.configList = configList;
    }
}
