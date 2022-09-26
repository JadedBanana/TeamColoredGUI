package com.github.jadedbanana.teamindicatorsplus.gui;

import com.github.jadedbanana.teamindicatorsplus.TeamIndicatorsPlus;
import com.github.jadedbanana.teamindicatorsplus.TeamIndicatorsUtil;
import net.minecraft.scoreboard.AbstractTeam;
import net.minecraft.util.Identifier;
import net.minecraft.util.Formatting;

import java.util.ArrayList;

public class TeamTextureFinder {

    // Colors
    public static int[] COLORS;
    public static Identifier[] WIDGETS;


    /*
    Initialize method.
    Called once, when the mod is loaded for the first time.
     */
    public static void initialize() {
        // Instantiate formatting colors.
        ArrayList<Formatting> colorFormats = TeamIndicatorsUtil.getColorFormats();

        // Set list lengths.
        COLORS = new int[colorFormats.size()];
        WIDGETS = new Identifier[colorFormats.size()];

        // Iterate through formats and add them to the lists
        for (int i = 0; i < colorFormats.size(); i++) {
            COLORS[i] = colorFormats.get(i).getColorValue();
            TeamIndicatorsPlus.LOGGER.info("" + colorFormats.get(i).getName().toLowerCase());
            WIDGETS[i] = new Identifier("teamindicatorsplus",
                    "textures/" + colorFormats.get(i).getName().toLowerCase() + "_widgets.png");
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

        // If null, return null
        if (teamColor == null)
            return null;

        // Iterate through team colors, and if team found, return that team's texture
        for (int i = 0; i < COLORS.length; i++)
            if (COLORS[i] == teamColor)
                return textures[i];

        // Return null.
        return null;
    }

}
