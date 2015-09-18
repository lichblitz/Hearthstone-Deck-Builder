package com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain;

/**
 * Created by ${user} on 7/09/15.
 */
public class DrawerItem {
    private String itemText;
    private int iconId;

    public DrawerItem(String itemText, int iconId) {
        this.itemText = itemText;
        this.iconId = iconId;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }
}
