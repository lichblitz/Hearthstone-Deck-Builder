package com.hsdeckbuilder.lichblitz.hsdeckbuilder.io;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.app.BuilderApp;

/**
 * Created by lichblitz on 24/08/15.
 */
public final class AppConstants {

    public static final String APP_NAME = BuilderApp.getStringFromId(R.string.app_name);

    public static final String WARRIOR = "HERO_01";
    public static final String SHAMAN = "HERO_02";
    public static final String ROGUE = "HERO_03";
    public static final String PALADIN = "HERO_04";
    public static final String HUNTER = "HERO_05";
    public static final String DRUID = "HERO_06";
    public static final String WARLOCK = "HERO_07";
    public static final String MAGE = "HERO_08";
    public static final String PRIEST = "HERO_09";

    public static final String HERO_CARD = "HERO";
    public static final String BUNDLE_KEY_HEROCLASS = "heroClass";
    public static final String BUNDLE_DECK_CALLBACK = "deckCallbak";

    public static final String RARITY_FREE = "Free";
    public static final String RARITY_COMMON = "Common";
    public static final String RARITY_RARE = "Rare";
    public static final String RARITY_EPIC = "Epic";
    public static final String RARITY_LEGENDARY = "Legendary";


    public static final int ADD_CARD_ERROR_CARD_LIMIT = 1;
    public static final int ADD_CARD_ERROR_LEGENDARY_LIMIT = 2;


    public static final int ADD_CARD_SUCCESS = 0;

}
