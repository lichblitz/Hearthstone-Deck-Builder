package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.app.BuilderApp;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Card;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.AppConstants;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.listener.DeckBuilderListener;
import com.squareup.picasso.Picasso;

/**
 * Created by lichblitz on 4/09/15.
 */
public class DeckViewHolder extends RecyclerView.ViewHolder {

    String cardSrc;
    ImageView cardPreview;
    TextView manaCost;
    TextView count;
    TextView cardName;
    Context context;
    String cardId;
    DeckBuilderListener mDeckListener;
    Card card;


    public DeckViewHolder(View itemView, DeckBuilderListener deckBuilderListener) {
        super(itemView);
        this.mDeckListener = deckBuilderListener;
        this.context = BuilderApp.getContext();
        cardPreview = (ImageView)itemView.findViewById(R.id.card_preview);
        manaCost = (TextView)itemView.findViewById(R.id.mana_cost);
        count = (TextView)itemView.findViewById(R.id.card_count);
        cardName = (TextView)itemView.findViewById(R.id.card_name);


        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(context,"Tocado largo",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "toque", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void setCardId(String cardId){
        this.cardId = cardId;
    }

    public void setCard(Card card){
        this.card = card;
    }

    public void setCardPreview(String url) {
        Picasso.with(context)
                .load(url)
                .into(cardPreview);
    }

    public void setCardSrc(String src){
        this.cardSrc = src;
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

        switch (rarity){
            case AppConstants.RARITY_FREE:
            case AppConstants.RARITY_COMMON:
                cardName.setTextColor(BuilderApp.getColorFromId(R.color.color_default));
                break;
            case AppConstants.RARITY_RARE:
                cardName.setTextColor(BuilderApp.getColorFromId(R.color.rare));
                break;
            case AppConstants.RARITY_EPIC:
                cardName.setTextColor(BuilderApp.getColorFromId(R.color.epic));
                break;
            case AppConstants.RARITY_LEGENDARY:
                cardName.setTextColor(BuilderApp.getColorFromId(R.color.legendary));
        }

    }


    public Card getCard(){
        return this.card;
    }

    public DeckBuilderListener getmDeckListener() {
        return mDeckListener;
    }

}
