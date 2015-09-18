package com.hsdeckbuilder.lichblitz.hsdeckbuilder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.DrawerItem;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter.DrawerAdapter;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment.SelectHeroFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] mPlaneTitles;
    private DrawerLayout mDrawer;
    private ListView mList;
    private Toolbar mToolbar;


    ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);



        mPlaneTitles = getResources().getStringArray(R.array.drawer_titles);
        mDrawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        mList = (ListView)findViewById(R.id.left_drawer);

        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawer,mToolbar, R.string.open_drawer, R.string.close_drawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        ArrayList<DrawerItem> items = new ArrayList<>();
        items.add(new DrawerItem(mPlaneTitles[0], R.drawable.card));
        items.add(new DrawerItem(mPlaneTitles[1], R.drawable.default_portrait));

        mList.setAdapter(new DrawerAdapter(this, items));

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectDrawerItem(position);
            }
        });


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    private void selectDrawerItem(int position){

        switch (position){
            case 0:

                break;

            case 1:
                SelectHeroFragment selectHeroFragment = new SelectHeroFragment();
                createFragment(selectHeroFragment, position, SelectHeroFragment.FRAGMENT_POSITION);
                break;

            default:
                SelectHeroFragment fragment = new SelectHeroFragment();
                createFragment(fragment, position, SelectHeroFragment.FRAGMENT_POSITION);
                break;
        }

    }

    private void createFragment(Fragment fragment, int position, String bundleKey){

        Bundle args = new Bundle();
        args.putInt(bundleKey, position);
        fragment.setArguments(args);

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.fragment_container,fragment).commit();

        mList.setItemChecked(position, true);
        setTitle(mPlaneTitles[position]);
        mDrawer.closeDrawer(mList);


    }



}
