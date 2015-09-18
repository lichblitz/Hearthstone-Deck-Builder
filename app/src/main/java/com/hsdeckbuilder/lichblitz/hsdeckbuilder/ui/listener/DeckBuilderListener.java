package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.listener;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Deck;

/**
 * Created by lichblitz on 4/09/15.
 */
public interface DeckBuilderListener {

    abstract Deck getDeck();

    abstract int getTotalCards();
}
