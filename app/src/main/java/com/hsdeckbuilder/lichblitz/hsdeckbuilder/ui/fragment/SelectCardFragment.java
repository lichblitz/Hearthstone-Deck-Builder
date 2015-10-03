package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.AppConstants;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.HearthstoneApiAdapter;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.model.AllCardResponse;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.ItemOffsetDecoration;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter.SelectCardAdapter;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.listener.SelectCardListener;


import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by lichblitz on 26/08/15.
 */
public class SelectCardFragment extends Fragment implements Callback<AllCardResponse> {

    private static final int COL_NUM = 4;
    private RecyclerView mCardList;
    private String mHeroClass;

    private SelectCardAdapter mAdapter;
    private SelectCardListener cardListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mHeroClass = getArguments().getString(AppConstants.BUNDLE_KEY_HEROCLASS);

        mAdapter = new SelectCardAdapter(getActivity(), cardListener);
    }

    @Override
    public void onResume() {
        super.onResume();

        HearthstoneApiAdapter.getApiService().getAllCards(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_select_card,container,false);

        mCardList = (RecyclerView) root.findViewById(R.id.select_card_list);

        setupCardList();

        return root;
    }

    private void setupCardList(){

        mCardList.setLayoutManager(new GridLayoutManager(getActivity(), COL_NUM));
        mCardList.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.integer.offset));
        mCardList.setAdapter(mAdapter);
    }

    @Override
    public void success(AllCardResponse allCardResponse, Response response) {
        mAdapter.addAll(allCardResponse.getAllCards(mHeroClass));
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }


    public void setCardListener(SelectCardListener cardListener){

        this.cardListener = cardListener;
    }


    public SelectCardAdapter getmAdapter() {
        return mAdapter;
    }
}
