package com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain;

import android.util.Log;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.app.BuilderApp;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.AppConstants;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lichblitz on 20/08/15.
 */
public class Deck {

    private int deckId;
    private int totalCards;
    private String deckName;
    private ArrayList<Card> cards;
    private HashMap<String,Integer> cardCounter;

    public Deck(){
        this.cards = new ArrayList<>();
        this.cardCounter = new HashMap<>();
        this.totalCards= 0;
    }

    /**
     * Adds a card to the deck
     * @param card
     * @return int from 0 to 3.
     */
    public int addCard(Card card){


        String cardId = card.getCardId();
        String cardRarity = card.getRarity();
        Log.d(this.getClass().getName(),String.valueOf(cards.size()));
        if(totalCards<30) {

            //verify if the card is in the deck, count and rarity.
            if (cardCounter.containsKey(cardId)) {
                int cardCount = cardCounter.get(cardId);

                if (cardRarity.equalsIgnoreCase(AppConstants.RARITY_LEGENDARY)) {
                    if (cardCount == 1) {
                        return AppConstants.ADD_CARD_ERROR_LEGENDARY_LIMIT;
                    } else {
                        cards.add(card);
                        cardCounter.put(cardId, 1);
                        totalCards++;
                        return AppConstants.ADD_CARD_SUCCESS;
                    }


                } else {
                    if (cardCount == 2) {
                        return AppConstants.ADD_CARD_ERROR_CARD_LIMIT;

                    } else {

                        cardCounter.put(cardId, cardCount + 1);
                        totalCards++;
                        return AppConstants.ADD_CARD_SUCCESS;
                    }
                }


            } else {

                cards.add(card);
                cardCounter.put(cardId, 1);
                totalCards++;
                return AppConstants.ADD_CARD_SUCCESS;

            }
        }else{
            return AppConstants.ADD_CARD_FULL_DECK;
        }

    }

    public int removeCard(Card card){

        String cardId = card.getCardId();

        if(cardCounter.get(cardId) < 2){
            cards.remove(card);
            cardCounter.remove(cardId);
            return 0;
        }else{
            cardCounter.put(cardId, 1);
            return 1;
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public HashMap<String,Integer> getCardCounter() {
        return cardCounter;
    }
}
