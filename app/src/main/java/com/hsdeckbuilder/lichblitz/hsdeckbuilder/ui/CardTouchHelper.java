package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Card;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter.holder.DeckViewHolder;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.listener.DeckBuilderListener;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.listener.SelectCardListener;

/**
 * Created by ${user} on 3/10/15.
 */
public class CardTouchHelper extends ItemTouchHelper.SimpleCallback {


    private SelectCardListener mSelectCardListener;

    public CardTouchHelper(int dragDirs, int swipeDirs, SelectCardListener selectCardListener) {
        super(dragDirs, swipeDirs);
        this.mSelectCardListener = selectCardListener;

    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        DeckViewHolder deckViewHolder = (DeckViewHolder)viewHolder;
        DeckBuilderListener deckBuilderListener = deckViewHolder.getmDeckListener();
        Card swipedCard = deckViewHolder.getCard();
        deckBuilderListener.removeCardFromDeck(swipedCard);
        mSelectCardListener.notifyDeckAdapter();
    }


}
