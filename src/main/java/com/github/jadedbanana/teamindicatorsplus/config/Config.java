package com.github.jadedbanana.teamindicatorsplus.config;

import com.github.jadedbanana.teamindicatorsplus.TeamIndicatorsUtil;

import java.util.Arrays;

public class Config {

    // Global toggle
    public boolean ENABLED = true;

    // Item enabled lists
    public boolean[] HOTBAR_ENABLEDS = TeamIndicatorsUtil.getDefaultTogglesState(true);
    public boolean[] ARROW_ENABLEDS = TeamIndicatorsUtil.getDefaultTogglesState(false);
    public boolean[] TIPPED_ARROW_ENABLEDS = TeamIndicatorsUtil.getDefaultTogglesState(false);
    public boolean[] SPECTRAL_ARROW_ENABLEDS = TeamIndicatorsUtil.getDefaultTogglesState(false);

}
