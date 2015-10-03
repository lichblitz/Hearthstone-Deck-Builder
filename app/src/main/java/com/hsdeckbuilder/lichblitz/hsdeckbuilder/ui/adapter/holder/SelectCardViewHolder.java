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
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Deck;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.AppConstants;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.listener.SelectCardListener;
import com.squareup.picasso.Picasso;

/**
 * Created by lichblitz on 4/09/15.
 */
public class SelectCardViewHolder extends RecyclerView.ViewHolder{


    Card currentCard;
    ImageView mCardView;
    ImageView mCountFrame;
    TextView mCountFrameText;
    Context context;
    SelectCardListener mCardListener;
    Deck myDeck;


    public SelectCardViewHolder(View itemView, SelectCardListener cardListener){
        super(itemView);
        this.mCardListener = cardListener;
        this.context = BuilderApp.getContext();
        myDeck = mCardListener.getDeck();
        mCardView = (ImageView) itemView.findViewById(R.id.card_image);
        mCountFrame = (ImageView) itemView.findViewById(R.id.count_frame);
        mCountFrameText = (TextView) itemView.findViewById(R.id.count_frame_text);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = mCardListener.onSelectCard(currentCard);
                switch (result) {
                    case AppConstants.ADD_CARD_SUCCESS:
                        showCounterFrame();
                        break;
                    case AppConstants.ADD_CARD_ERROR_CARD_LIMIT:
                        Toast.makeText(context, BuilderApp.getStringFromId(R.string.error_limit_card), Toast.LENGTH_SHORT).show();
                        break;
                    case AppConstants.ADD_CARD_ERROR_LEGENDARY_LIMIT:
                        Toast.makeText(context, BuilderApp.getStringFromId(R.string.error_limit_legendary), Toast.LENGTH_SHORT).show();
                        break;
                    case AppConstants.ADD_CARD_FULL_DECK:
                        Toast.makeText(context, BuilderApp.getStringFromId(R.string.full_deck), Toast.LENGTH_SHORT).show();
                        break;
                }


            }
        });
    }

    public void setCardView(String url){
        Picasso.with(context)
                .load(url)
                .placeholder(R.drawable.card)
                .into(mCardView);

    }

    public void setCurrentCard(Card card){
        this.currentCard = card;
        showCounterFrame();
    }

    public void showCounterFrame(){

        if(mCountFrame.getVisibility() == View.GONE){
            mCountFrame.setVisibility(View.VISIBLE);
            mCountFrameText.setVisibility(View.VISIBLE);

        }

        if(myDeck.getCardCounter().get(currentCard.getCardId())!=null){
            mCountFrameText.setText("x"+myDeck.getCardCounter().get(currentCard.getCardId()));
        }else{
            mCountFrame.setVisibility(View.GONE);
            mCountFrameText.setVisibility(View.GONE);
        }

    }





}
