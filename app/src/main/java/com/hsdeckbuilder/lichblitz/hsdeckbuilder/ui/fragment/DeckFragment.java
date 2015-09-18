package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Card;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Deck;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.AppConstants;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter.DeckAdapter;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.listener.DeckBuilderListener;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.listener.SelectCardListener;

/**
 * Created by lichblitz on 30/08/15.
 */
public class DeckFragment extends Fragment implements SelectCardListener{


    private RecyclerView mDeckCards;
    private DeckAdapter mAdapter;
    private DeckBuilderListener callback;
    private TextView mMessageText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mAdapter = new DeckAdapter(getActivity(), callback);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root;

        root = inflater.inflate(R.layout.fragment_deck, container, false);
        mDeckCards = (RecyclerView)root.findViewById(R.id.deck_cards_list);
        mMessageText =(TextView)root.findViewById(R.id.no_cards_message);


        if(callback.getTotalCards()<1){
            mDeckCards.setVisibility(View.GONE);
            mMessageText.setVisibility(View.VISIBLE);
        }

        setupDeckCards();

        return root;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.callback = (DeckBuilderListener) activity;
    }

    private void setupDeckCards(){
        mDeckCards.setLayoutManager(new LinearLayoutManager(getActivity()));
        mDeckCards.setAdapter(mAdapter);

    }


    @Override
    public int onSelectCardListener(Card card) {
        int result = this.mAdapter.addCard(card);
        if(callback.getTotalCards()>0){
            mDeckCards.setVisibility(View.VISIBLE);
            mMessageText.setVisibility(View.GONE);
        }
        return result;
    }

    public void initialize(DeckBuilderListener callback){
        this.callback = callback;
        mAdapter = new DeckAdapter(getActivity(), callback);
    }
}
