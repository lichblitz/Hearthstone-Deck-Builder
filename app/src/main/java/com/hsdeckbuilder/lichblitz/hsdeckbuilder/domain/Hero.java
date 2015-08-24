package com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain;

/**
 * Created by lichblitz on 20/08/15
 */
public class Hero {

    private String name;
    private String heroClass;
    private int powerImage;
    private int heroPortrait;
    private String heroId;


    public Hero(String name, String heroClass, int powerImage, int heroPortrait, String heroId) {
        this.name = name;
        this.heroClass = heroClass;
        this.powerImage = powerImage;
        this.heroPortrait = heroPortrait;
        this.heroId = heroId;
    }

    public String getName() {
        return name;
    }

    public int getPowerImage() {
        return powerImage;
    }

    public int getHeroPortrait() {
        return heroPortrait;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public String getHeroId() {
        return heroId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPowerImage(int powerImage) {
        this.powerImage = powerImage;
    }

    public void setHeroPortrait(int heroPortrait) {
        this.heroPortrait = heroPortrait;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public void setHeroId(String heroId) {
        this.heroId = heroId;
    }
}
