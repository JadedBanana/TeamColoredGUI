package com.github.jadedbanana.teamcoloredgui.gui;

import net.minecraft.scoreboard.AbstractTeam;
import net.minecraft.util.Identifier;
import net.minecraft.util.Formatting;

public class TeamTextureFinder {

    // Colors
    private static int[] COLORS;
    private static Identifier[] WIDGETS;


    /*
    Initialize method.
    Called once, when the mod is loaded for the first time.
     */
    public static void initialize() {
        // Instantiate formatting colors.
        Formatting[] formattingColors = Formatting.values();

        // Set list lengths.
        COLORS = new int[formattingColors.length];
        WIDGETS = new Identifier[formattingColors.length];

        // Iterate through formats and add them to the lists
        for (int i = 0; i < formattingColors.length; i++) {
            if (formattingColors[i].getColorIndex() != -1) {
                COLORS[i] = formattingColors[i].getColorValue();
                WIDGETS[i] = new Identifier("teamcoloredgui",
                        "textures/" + formattingColors[i].getName().toLowerCase() + "_widgets.png");
            }
        }
    }


    /*
    Widget texture getter.
    Widget texture has the hotbar, item selector, offhand, as well as other things.
    Although in this case it's really only used for the hotbar.
     */
    public static Identifier getWidgetTexture(AbstractTeam scoreboardTeam) {
        return getTexture(scoreboardTeam, WIDGETS);
    }


    /*
    Gets the team-colored texture for a given team.
     */
    private static Identifier getTexture(AbstractTeam scoreboardTeam, Identifier[] textures) {
        // Get team color
        Integer teamColor = scoreboardTeam.getColor().getColorValue();

        // Iterate through team colors, and if team found, return that team's texture
        for (int i = 0; i < COLORS.length; i++)
            if (COLORS[i] == teamColor)
                return textures[i];

        // Return null.
        return null;
    }

}
