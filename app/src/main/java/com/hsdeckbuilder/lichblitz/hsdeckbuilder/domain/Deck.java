package com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.AppConstants;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lichblitz on 20/08/15.
 */
public class Deck {

    private int deckId;
    private String deckName;
    private ArrayList<Card> cards;
    private HashMap<String,Integer> cardCounter;

    public Deck(){
        this.cards = new ArrayList<>();
        this.cardCounter = new HashMap<>();
    }

    public int addCard(Card card){


        String cardId = card.getCardId();
        String cardRarity = card.getRarity();

        //verify if the card is in the deck, count and rarity.
        if(cardCounter.containsKey(cardId)){
            int cardCount = cardCounter.get(cardId);

            if(cardRarity.equalsIgnoreCase(AppConstants.RARITY_LEGENDARY)){
                if(cardCount == 1) {
                    return AppConstants.ADD_CARD_ERROR_LEGENDARY_LIMIT;
                }else{
                    cards.add(card);
                    cardCounter.put(cardId, 1);
                    return AppConstants.ADD_CARD_SUCCESS;
                }


            }else{
                if(cardCount == 2){
                    return AppConstants.ADD_CARD_ERROR_CARD_LIMIT;

                }else{
                    cards.add(card);
                    cardCounter.put(cardId, cardCount++);
                    return AppConstants.ADD_CARD_SUCCESS;
                }
            }


        }else{

            cards.add(card);
            cardCounter.put(cardId, 1);
            return AppConstants.ADD_CARD_SUCCESS;

        }

    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public HashMap<String,Integer> getcardCounter() {
        return cardCounter;
    }
}
