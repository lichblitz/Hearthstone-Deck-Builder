package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter.holder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.app.BuilderApp;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Card;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.AppConstants;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.listener.SelectCardListener;
import com.squareup.picasso.Picasso;

/**
 * Created by lichblitz on 4/09/15.
 */
public class SelectCardViewHolder extends RecyclerView.ViewHolder{

    Card currentCard;
    ImageView cardImage;
    Context context;
    SelectCardListener mCardListener;


    public SelectCardViewHolder(View itemView, SelectCardListener cardListener){
        super(itemView);
        this.mCardListener = cardListener;
        this.context = BuilderApp.getContext();
        cardImage = (ImageView) itemView.findViewById(R.id.card_image);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = mCardListener.onSelectCardListener(currentCard);
                switch (result){
                    case AppConstants.ADD_CARD_SUCCESS:
                        Toast.makeText(context,BuilderApp.getStringFromId(R.string.add_success),Toast.LENGTH_SHORT).show();
                        break;
                    case AppConstants.ADD_CARD_ERROR_CARD_LIMIT:
                        Toast.makeText(context,BuilderApp.getStringFromId(R.string.error_limit_card),Toast.LENGTH_SHORT).show();
                        break;
                    case AppConstants.ADD_CARD_ERROR_LEGENDARY_LIMIT:
                        Toast.makeText(context,BuilderApp.getStringFromId(R.string.error_limit_legendary),Toast.LENGTH_SHORT).show();

                }


            }
        });
    }

    public void setCardImage(String url){
        Picasso.with(context)
                .load(url)
                .placeholder(R.drawable.card)
                .into(cardImage);

    }

    public void setCurrentCard(Card card){
        this.currentCard = card;
    }
}
