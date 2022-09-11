package com.github.jadedbanana.teamcoloredgui.config.screens;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.MutableText;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class OuterConfigMenu extends Screen {

    public OuterConfigMenu() {
        super((MutableText) StringVisitable.plain("teamcoloredgui.outerconfig"));
    }

}
