package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Deck;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.AppConstants;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter.DeckBuilderPagerAdapter;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.listener.DeckBuilderListener;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment.DeckFragment;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment.NoCardFragment;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment.SelectCardFragment;

import java.io.Serializable;

/**
 * Created by lichblitz on 28/08/15.
 */
public class DeckBuilderActivity extends AppCompatActivity implements DeckBuilderListener{

    private static final String TAG_NAME = DeckBuilderActivity.class.getName();
    private SelectCardFragment mCardFragment;
    private DeckFragment mDeckFragment;
    private DeckBuilderPagerAdapter mPager;
    private NoCardFragment mNoCardFragment;
    private Deck mDeck;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_deck_builder);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        if(savedInstanceState == null){

            mDeck = new Deck();
            mCardFragment = new SelectCardFragment();
            mDeckFragment = new DeckFragment();
            mNoCardFragment = new NoCardFragment();

            Bundle b = getIntent().getExtras();
            mCardFragment.setArguments(b);

            mDeckFragment.initialize(this);
            mCardFragment.setCardListener(mDeckFragment);

            setupTabs();

        }

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setupTabs(){


        //configuration of the tablayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.TAB_DECK));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.TAB_SELECT_CARDS));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager pager = (ViewPager) findViewById(R.id.pager);
        mPager = new DeckBuilderPagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount(), this);
        mPager.addFragment(mDeckFragment);
        mPager.addFragment(mCardFragment);
        mPager.addFragment(mNoCardFragment);

        pager.setAdapter(mPager);
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

    @Override
    public Deck getDeck() {
        return this.mDeck;
    }

    @Override
    public int getTotalCards() {
        return mDeck.getCards().size();
    }
}
