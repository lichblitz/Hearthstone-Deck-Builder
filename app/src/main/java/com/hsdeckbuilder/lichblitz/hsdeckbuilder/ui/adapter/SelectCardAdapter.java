package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Card;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter.holder.SelectCardViewHolder;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.listener.SelectCardListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichblitz on 26/08/15.
 * Adapter for SelectCardFragment
 */
public class SelectCardAdapter extends RecyclerView.Adapter<SelectCardViewHolder> {

    SelectCardListener mCardListener;
    ArrayList<Card> cards;
    Context context;


    public void addAll(@NonNull List<Card> cards){
        if(cards == null)
            throw new NullPointerException("Cards must be an array not null");

        this.cards.addAll(cards);

        notifyItemRangeInserted(getItemCount() - 1, cards.size());

    }


    @Override
    public int getItemCount() {
        return cards.size();
    }

    @Override
    public SelectCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_select_card, parent, false);
        return new SelectCardViewHolder(itemView, mCardListener);
    }

    @Override
    public void onBindViewHolder(SelectCardViewHolder holder, int position) {
        Card currentCard = cards.get(position);

        holder.setCardImage(currentCard.getImg());
        holder.setCurrentCard(currentCard);


    }

    public SelectCardAdapter(Context context, SelectCardListener cardListener){
        this.context = context;
        this.cards = new ArrayList<>();
        this.mCardListener = cardListener;
    }



}
