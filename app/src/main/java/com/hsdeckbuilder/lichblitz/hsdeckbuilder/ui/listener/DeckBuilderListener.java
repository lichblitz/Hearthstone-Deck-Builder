package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.listener;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Card;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Deck;

/**
 * Created by lichblitz on 4/09/15.
 */
public interface DeckBuilderListener {

    Deck getDeck();

    int removeCardFromDeck(Card card);

    int getTotalCards();

    void notifyCardAdapter();
}
