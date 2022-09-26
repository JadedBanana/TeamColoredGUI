package com.github.jadedbanana.teamindicatorsplus.gui.screens.widgets;

import com.github.jadedbanana.teamindicatorsplus.gui.TeamTextureFinder;
import net.minecraft.util.Identifier;

public enum ColorToggleEntryType {

    HOTBAR(0, 0, 182, 22, new Identifier("textures/gui/widgets.png"), TeamTextureFinder.WIDGETS);

    public int offsetX;
    public int offsetY;
    public int width;
    public int height;
    public Identifier defaultImage;
    public Identifier[] colorImages;

    ColorToggleEntryType(int offsetX, int offsetY, int width, int height, Identifier defaultImage,
                         Identifier[] colorImages) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
        this.defaultImage = defaultImage;
        this.colorImages = colorImages;
    }
}
