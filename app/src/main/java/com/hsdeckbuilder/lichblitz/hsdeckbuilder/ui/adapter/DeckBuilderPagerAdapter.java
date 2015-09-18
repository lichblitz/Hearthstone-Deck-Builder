package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Deck;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.AppConstants;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.listener.DeckBuilderListener;

import java.util.ArrayList;

/**
 * Created by lichblitz on 31/08/15.
 */
public class DeckBuilderPagerAdapter extends FragmentStatePagerAdapter{


    int numTabs;
    ArrayList<Fragment> fragments;
    DeckBuilderListener callback;

    public DeckBuilderPagerAdapter(FragmentManager fm, int numTabs, DeckBuilderListener callback) {
        super(fm);
        this.fragments = new ArrayList<>();
        this.numTabs = numTabs;
        this.callback = callback;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(AppConstants.APP_NAME,String.valueOf(callback.getTotalCards()));
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
