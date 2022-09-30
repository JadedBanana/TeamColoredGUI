package com.github.jadedbanana.teamindicatorsplus;

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
    public static Identifier[] ARROWS;
    public static Identifier[] TIPPED_ARROWS;
    public static Identifier[] SPECTRAL_ARROWS;


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
        ARROWS = new Identifier[colorFormats.size()];
        TIPPED_ARROWS = new Identifier[colorFormats.size()];
        SPECTRAL_ARROWS = new Identifier[colorFormats.size()];

        // Iterate through formats and add them to the lists
        for (int i = 0; i < colorFormats.size(); i++) {
            COLORS[i] = colorFormats.get(i).getColorValue();
            TeamIndicatorsPlus.LOGGER.info("" + colorFormats.get(i).getName().toLowerCase());
            // Widgets
            WIDGETS[i] = new Identifier("teamindicatorsplus",
                    "textures/gui/" + colorFormats.get(i).getName().toLowerCase() + "_widgets.png");
            // Arrows
            ARROWS[i] = new Identifier("teamindicatorsplus",
                    "textures/entity/projectiles/" + colorFormats.get(i).getName().toLowerCase() + "_arrow.png");
            // Tipped Arrows
            TIPPED_ARROWS[i] = new Identifier("teamindicatorsplus",
                    "textures/entity/projectiles/" + colorFormats.get(i).getName().toLowerCase() + "_tipped_arrow.png");
            // Spectral Arrows
            ARROWS[i] = new Identifier("teamindicatorsplus",
                    "textures/entity/projectiles/" + colorFormats.get(i).getName().toLowerCase() + "_spectral_arrow.png");
        }
    }


    /*
    Hotbar texture getter.
    Wrapper for getTexture.
     */
    public static Identifier getHotbarTexture(AbstractTeam scoreboardTeam) {
        return getTexture(scoreboardTeam, TeamIndicatorsPlus.CONFIG.HOTBAR_ENABLEDS, WIDGETS);
    }


    /*
    Arrow texture getter.
    Wrapper for getTexture.
     */
    public static Identifier getArrowTexture(AbstractTeam scoreboardTeam) {
        return getTexture(scoreboardTeam, TeamIndicatorsPlus.CONFIG.ARROW_ENABLEDS, ARROWS);
    }


    /*
    Tipped arrow texture getter.
    Wrapper for getTexture.
     */
    public static Identifier getTippedArrowTexture(AbstractTeam scoreboardTeam) {
        return getTexture(scoreboardTeam, TeamIndicatorsPlus.CONFIG.TIPPED_ARROW_ENABLEDS, TIPPED_ARROWS);
    }


    /*
    Spectral arrow texture getter.
    Wrapper for getTexture.
     */
    public static Identifier getSpectralArrowTexture(AbstractTeam scoreboardTeam) {
        return getTexture(scoreboardTeam, TeamIndicatorsPlus.CONFIG.SPECTRAL_ARROW_ENABLEDS, SPECTRAL_ARROWS);
    }


    /*
    Gets the team-colored texture for a given team.
     */
    private static Identifier getTexture(AbstractTeam scoreboardTeam, boolean[] configList, Identifier[] textures) {
        // Get team color
        Integer colorIndex = scoreboardTeam.getColor().getColorIndex();

        // If team color disabled or DNE or exists outside texture range, return null
        if (colorIndex < 0 || colorIndex > textures.length || !configList[colorIndex])
            return null;

        // Return textures at the provided index.
        return textures[colorIndex];
    }

}
