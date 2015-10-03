package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.listener;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Card;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Deck;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter.SelectCardAdapter;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter.holder.SelectCardViewHolder;

/**
 * Created by lichblitz on 4/09/15.
 */
public interface SelectCardListener {

    int onSelectCard(Card card);

    void notifyDeckAdapter();


    Deck getDeck();



}
