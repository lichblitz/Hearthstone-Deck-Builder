package com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain;

/**
 * Created by lichblitz on 20/08/15.
 *
 * Any card of HS.
 */
public class Card {

    private String cardId;
    private String name;
    private String type;
    private String faction;
    private String rarity;
    private int cost;
    private int attack;
    private int health;
    private String text;
    private String flavor;
    private String artist;
    private boolean collectible;
    private boolean elite;
    private String race;
    private String img;
    private String imgGold;
    private String locale;


    public String getCardId() {
        return cardId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getFaction() {
        return faction;
    }

    public String getRarity() {
        return rarity;
    }

    public int getCost() {
        return cost;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public String getText() {
        return text;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getArtist() {
        return artist;
    }

    public boolean isCollectible() {
        return collectible;
    }

    public boolean isElite() {
        return elite;
    }

    public String getRace() {
        return race;
    }

    public String getImg() {
        return img;
    }

    public String getImgGold() {
        return imgGold;
    }

    public String getLocale() {
        return locale;
    }
}
