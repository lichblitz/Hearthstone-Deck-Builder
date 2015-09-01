package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment.DeckFragment;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment.SelectCardFragment;

import java.util.ArrayList;

/**
 * Created by lichblitz on 31/08/15.
 */
public class DeckBuilderPagerAdapter extends FragmentStatePagerAdapter{


    int numTabs;
    ArrayList<Fragment> fragments;

    public DeckBuilderPagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.fragments = new ArrayList<>();
        this.numTabs = numTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return fragments.get(0);
            case 1:
                return fragments.get(1);

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }

    public void addFragment(Fragment fragment){
        this.fragments.add(fragment);
    }
}
