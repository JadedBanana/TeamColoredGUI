package com.github.jadedbanana.teamindicatorsplus;

import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.Arrays;

public class TeamIndicatorsUtil {

    private static ArrayList<Formatting> formatList;

    /*
    GetColorFormats, method to sift through all available formats for Minecraft and only pick out the color ones.
     */
    public static ArrayList<Formatting> getColorFormats() {
        // If this.formatList has been made already, return that.
        if (TeamIndicatorsUtil.formatList != null)
            return TeamIndicatorsUtil.formatList;

        // Instantiate arraylist.
        ArrayList<Formatting> formatList = new ArrayList<Formatting>();

        // Add colors to the array list only.
        Formatting[] formattings = Formatting.values();
        for (int i = 0; i < formattings.length; i++)
            if (formattings[i].getColorIndex() != -1)
                formatList.add(formattings[i]);

        // Set and return.
        TeamIndicatorsUtil.formatList = formatList;
        return formatList;
    }


    /*
    GetDefaultTogglesState, method to return a boolean list of all colors set to the designated state.
     */
    public static boolean[] getDefaultTogglesState(boolean state) {
        // Instantiate, fill, and return.
        boolean[] boolList = new boolean[getColorFormats().size()];
        Arrays.fill(boolList, state);
        return boolList;
    }

}
