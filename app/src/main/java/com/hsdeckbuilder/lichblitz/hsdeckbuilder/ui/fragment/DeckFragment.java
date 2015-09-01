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
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Deck;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter.DeckAdapter;

/**
 * Created by lichblitz on 30/08/15.
 */
public class DeckFragment extends Fragment {

    private Deck mDeck;
    private RecyclerView mDeckCards;
    private DeckAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDeck = new Deck();
        mAdapter = new DeckAdapter(getActivity(), mDeck);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_deck, container, false);

        mDeckCards = (RecyclerView)root.findViewById(R.id.deck_cards_list);

        return root;
    }

    private void setupDeckCards(){
        mDeckCards.setLayoutManager(new LinearLayoutManager(getActivity()));
        mDeckCards.setAdapter(mAdapter);

    }
}
