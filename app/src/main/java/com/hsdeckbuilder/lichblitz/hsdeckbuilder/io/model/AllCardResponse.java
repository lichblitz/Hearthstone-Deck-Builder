package com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Card;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.CardConstants;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lichblitz on 28/08/15.
 */
public class AllCardResponse {

    @SerializedName(JsonKeys.SET_BASIC)
    ArrayList<Card> basicCards;

    @SerializedName(JsonKeys.SET_CLASSIC)
    ArrayList<Card> classicCards;

    @SerializedName(JsonKeys.SET_BLACKROCK)
    ArrayList<Card> blackrockCards;

    @SerializedName(JsonKeys.SET_GOBLINS_GNOMES)
    ArrayList<Card> goblinsGnomesCards;

    @SerializedName(JsonKeys.SET_NAXXARAMS)
    ArrayList<Card> naxxCards;

    @SerializedName(JsonKeys.SET_TGT)
    ArrayList<Card> tgtCards;

    public ArrayList<Card> getAllCards(){
        ArrayList<Card> allCards = new ArrayList<>();

        allCards.addAll(basicCards);
        allCards.addAll(classicCards);
        allCards.addAll(blackrockCards);
        allCards.addAll(goblinsGnomesCards);
        allCards.addAll(naxxCards);
        allCards.addAll(tgtCards);


        //removing hero cards and card from other heroes
        checkHeroCard(basicCards, "warrior");
        checkHeroCard(classicCards, "warrior");
        checkHeroCard(blackrockCards, "warrior");
        checkHeroCard(goblinsGnomesCards, "warrior");
        checkHeroCard(naxxCards, "warrior");
        checkHeroCard(tgtCards, "warrior");






        return allCards;
    }

    private void checkHeroCard(ArrayList<Card> cards, String heroClass) {
        for(Card card : cards){
            if(card.getCardId().contains("HERO")){
                getAllCards().remove(card);
            }
            if(card.getPlayerClass() != null){
                if(!card.getPlayerClass().contains(heroClass))
                    getAllCards().remove(card);
            }

        }

    }

    public ArrayList<Card> getBasicCards() {
        return basicCards;
    }

    public ArrayList<Card> getClassicCards() {
        return classicCards;
    }

    public ArrayList<Card> getBlackrockCards() {
        return blackrockCards;
    }

    public ArrayList<Card> getGoblinsGnomesCards() {
        return goblinsGnomesCards;
    }

    public ArrayList<Card> getNaxxCards() {
        return naxxCards;
    }

    public ArrayList<Card> getTgtCards() {
        return tgtCards;
    }
}
