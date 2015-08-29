package com.hsdeckbuilder.lichblitz.hsdeckbuilder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment.SelectCardFragment;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment.SelectHeroFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //if user change to landscape, savedInstanceState was created so no need to recreate the fragments
        if(savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container, new SelectCardFragment())
                    .commit();
        }
    }

}
