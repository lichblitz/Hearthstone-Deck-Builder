package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;

/**
 * Created by lichblitz on 4/09/15.
 */
public class NoCardFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_no_cards, container, false);

        return root;
    }
}
