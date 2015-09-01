package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter.DeckBuilderPagerAdapter;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment.DeckFragment;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment.SelectCardFragment;

/**
 * Created by lichblitz on 28/08/15.
 */
public class DeckBuilderActivity extends AppCompatActivity{

    private static final String TAG_NAME = DeckBuilderActivity.class.getName();
    private SelectCardFragment cardFragment;
    private DeckFragment deckFragment;
    private DeckBuilderPagerAdapter pagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_builder);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        if(savedInstanceState == null){


            cardFragment= new SelectCardFragment();
            deckFragment = new DeckFragment();

            Bundle b = getIntent().getExtras();
            cardFragment.setArguments(b);
            setupTabs();

        }

    }

    private void setupTabs(){

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.TAB_DECK));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.TAB_SELECT_CARDS));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new DeckBuilderPagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());

        pagerAdapter.addFragment(deckFragment);
        pagerAdapter.addFragment(cardFragment);

        pager.setAdapter(pagerAdapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
