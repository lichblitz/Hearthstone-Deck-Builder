package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.CardConstants;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment.SelectCardFragment;

/**
 * Created by lichblitz on 28/08/15.
 */
public class SelectCardActivity extends AppCompatActivity{

    private static final String TAG_NAME = SelectCardActivity.class.getName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(savedInstanceState == null){

            SelectCardFragment cardFragment = new SelectCardFragment();
            Bundle b = getIntent().getExtras();
            cardFragment.setArguments(b);
            getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, cardFragment)
                .commit();



        }

    }
}
