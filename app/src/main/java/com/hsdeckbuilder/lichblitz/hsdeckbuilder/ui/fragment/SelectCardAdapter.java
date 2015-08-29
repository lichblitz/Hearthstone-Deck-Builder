package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Card;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.CardConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichblitz on 26/08/15.
 * Adapter for SelectCardFragment
 */
public class SelectCardAdapter extends RecyclerView.Adapter<SelectCardAdapter.SelectCardPlaceHolder> {

    ArrayList<Card> cards;
    Context context;


    public void addAll(@NonNull List<Card> cards){
        if(cards == null)
            throw new NullPointerException("Cards must be an array not null");


        //removing hero cards and card from other heroes


        this.cards.addAll(cards);
        notifyItemRangeInserted(getItemCount() - 1, cards.size());

    }


    @Override
    public int getItemCount() {
        return cards.size();
    }

    @Override
    public SelectCardPlaceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_select_card, parent, false);

        return new SelectCardPlaceHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SelectCardPlaceHolder holder, int position) {
        Card currentCard = cards.get(position);

        holder.setCardImage(currentCard.getImg());

    }

    public SelectCardAdapter(Context context){
        this.context = context;
        this.cards = new ArrayList<>();
    }


    public class SelectCardPlaceHolder extends RecyclerView.ViewHolder{
        ImageView cardImage;

        public SelectCardPlaceHolder(View itemView){
            super(itemView);
            cardImage = (ImageView) itemView.findViewById(R.id.card_image);
        }

        public void setCardImage(String url){
            Picasso.with(context)
                    .load(url)
                    .placeholder(R.drawable.card)
                    .into(cardImage);

        }
    }


}
