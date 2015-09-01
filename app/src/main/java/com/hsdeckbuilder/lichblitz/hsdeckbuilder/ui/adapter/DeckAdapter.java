package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Card;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Deck;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by lichblitz on 30/08/15.
 */
public class DeckAdapter extends RecyclerView.Adapter<DeckAdapter.DeckViewHolder>{

    Context context;
    ArrayList<Card> deckCards;
    Deck myDeck;

    public DeckAdapter(Context context, Deck mDeck){
        this.context = context;
        this.myDeck = mDeck;
        this.deckCards = myDeck.getCards();
    }

    /**
     * Adds one card to the deck
     * @param card
     */
    public void addCard(Card card){
        this.deckCards.add(card);
        notifyDataSetChanged();

    }

    public void addAll(@NonNull Deck deck){
        this.deckCards.addAll(deck.getCards());
        notifyItemRangeInserted(getItemCount()-1, deckCards.size());
    }

    /**
     *  Gets the actual deck
     * @return myDeck
     */
    public Deck getMyDeck() {
        return myDeck;
    }

    /**
     * set the deck form modifications
     * @param deck
     */
    public void setDeck(Deck deck) {
        this.myDeck = deck;
        this.deckCards = deck.getCards();
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
        holder.setCount(String.valueOf(myDeck.getcardCounter().get(currentCard.getCardId())));
    }

    @Override
    public DeckViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_deck_card, parent, false);


        return new DeckViewHolder(itemView);
    }



    public class DeckViewHolder extends RecyclerView.ViewHolder {

        ImageView cardPreview;
        TextView manaCost;
        TextView count;
        TextView cardName;


        public DeckViewHolder(View itemView) {
            super(itemView);

            cardPreview = (ImageView)itemView.findViewById(R.id.card_preview);
            manaCost = (TextView)itemView.findViewById(R.id.mana_cost);
            count = (TextView)itemView.findViewById(R.id.card_count);
            cardName = (TextView)itemView.findViewById(R.id.card_name);
        }

        public void setCardPreview(String url) {
            Picasso.with(context)
                    .load(url)
                    .into(cardPreview);
        }

        public void setManaCost(String manaCost) {
            this.manaCost.setText(manaCost);
        }

        public void setCount(String count) {
            this.count.setText(count);
        }

        public void setCardName(String cardName) {
            this.cardName.setText(cardName);
        }

        public void setRarityColor(String rarity){
            cardName.setTextColor(context.getResources().getColor(R.color.legendary));
        }
    }



}
