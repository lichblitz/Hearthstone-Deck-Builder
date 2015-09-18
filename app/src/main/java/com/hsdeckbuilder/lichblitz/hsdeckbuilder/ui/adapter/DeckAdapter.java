package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Card;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Deck;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.AppConstants;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter.holder.DeckViewHolder;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.listener.DeckBuilderListener;

import java.util.ArrayList;

/**
 * Created by lichblitz on 30/08/15.
 */
public class DeckAdapter extends RecyclerView.Adapter<DeckViewHolder>{

    Context context;
    ArrayList<Card> deckCards;
    Deck myDeck;
    DeckBuilderListener callback;

    public DeckAdapter(Context context, DeckBuilderListener callback){
        this.callback = callback;
        this.context = context;
        this.myDeck = callback.getDeck();
        this.deckCards = myDeck.getCards();

    }

    /**
     * Adds one card to the deck
     * @param card
     */
    public int addCard(Card card){
        if(myDeck ==null) Log.d(AppConstants.APP_NAME, "My DECK IS NULL FFS");

        int result = myDeck.addCard(card);
        if(result == AppConstants.ADD_CARD_SUCCESS) {
            notifyDataSetChanged();
        }

        return result;

    }

    public void addAll(@NonNull Deck deck){
        this.myDeck = deck;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return deckCards.size();
    }

    @Override
    public void onBindViewHolder(DeckViewHolder holder, int position) {
        Card currentCard = deckCards.get(position);
        holder.setCardName(currentCard.getName());
        holder.setCardPreview(currentCard.getImg());
        holder.setManaCost(String.valueOf(currentCard.getCost()));
        holder.setCount(String.valueOf(myDeck.getCardCounter().get(currentCard.getCardId())));
        holder.setRarityColor(currentCard.getRarity());
        holder.setCardId(currentCard.getCardId());
        holder.setCardSrc(currentCard.getImg());
    }

    @Override
    public DeckViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_deck_card, parent, false);


        return new DeckViewHolder(itemView,callback);
    }

}
