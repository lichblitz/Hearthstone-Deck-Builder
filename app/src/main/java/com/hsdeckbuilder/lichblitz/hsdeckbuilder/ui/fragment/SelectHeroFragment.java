package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Hero;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.CardConstants;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.ItemOffsetDecoration;

import java.util.ArrayList;

/**
 * Created by lichblitz on 20/08/15.
 */
public class SelectHeroFragment extends Fragment {


    private RecyclerView mClassList;
    private SelectHeroAdapter mAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new SelectHeroAdapter(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_select_class, container,false);

        mClassList = (RecyclerView) root.findViewById(R.id.class_list);

        setupClassList();
    
        return root;

    }

    private void setupClassList(){
        mClassList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mClassList.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.integer.offset));
        mClassList.setAdapter(mAdapter);
        setupElements();
        
    }
    
    public void setupElements(){

        ArrayList<Hero> classes = new ArrayList<>();


        Hero warrior = new Hero(getString(R.string.hero_1), getString(R.string.hero_1), R.drawable.power_1,R.drawable.portrait_1, CardConstants.WARRIOR);
        classes.add(warrior);

        Hero shaman = new Hero(getString(R.string.hero_2), getString(R.string.hero_2), R.drawable.power_2,R.drawable.portrait_2, CardConstants.SHAMAN);
        classes.add(shaman);

        Hero rogue = new Hero(getString(R.string.hero_3), getString(R.string.hero_3), R.drawable.power_3,R.drawable.portrait_3, CardConstants.ROGUE);
        classes.add(rogue);

        Hero paladin = new Hero(getString(R.string.hero_4), getString(R.string.hero_4), R.drawable.power_4,R.drawable.portrait_4, CardConstants.PALADIN);
        classes.add(paladin);

        Hero hunter = new Hero(getString(R.string.hero_5), getString(R.string.hero_5), R.drawable.power_5,R.drawable.portrait_5, CardConstants.HUNTER);
        classes.add(hunter);

        Hero druid = new Hero(getString(R.string.hero_6), getString(R.string.hero_6), R.drawable.power_6,R.drawable.portrait_6, CardConstants.DRUID);
        classes.add(druid);

        Hero warlock = new Hero(getString(R.string.hero_7), getString(R.string.hero_7), R.drawable.power_7,R.drawable.portrait_7, CardConstants.WARLOCK);
        classes.add(warlock);

        Hero mage = new Hero(getString(R.string.hero_8), getString(R.string.hero_8), R.drawable.power_8,R.drawable.portrait_8, CardConstants.MAGE);
        classes.add(mage);

        Hero priest = new Hero(getString(R.string.hero_9), getString(R.string.hero_9), R.drawable.power_9,R.drawable.portrait_9, CardConstants.PRIEST);
        classes.add(priest);

        mAdapter.addAll(classes);
    }
}
