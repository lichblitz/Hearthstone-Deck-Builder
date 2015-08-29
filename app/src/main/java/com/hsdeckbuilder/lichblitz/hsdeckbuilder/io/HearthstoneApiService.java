package com.hsdeckbuilder.lichblitz.hsdeckbuilder.io;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Card;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.model.AllCardResponse;

import java.util.List;


import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Created by lichblitz on 24/08/15.
 */
public interface HearthstoneApiService {

    @Headers({
            "X-Mashape-Key: "+ ApiConstants.MASHAPE_KEY
    })
    @GET(ApiConstants.URL_ALL_CARDS)
    void getAllCards(Callback<AllCardResponse> callback);

    @Headers({
            "X-Mashape-Key: "+ ApiConstants.MASHAPE_KEY,
            "Accept: application/json"
    })
    @GET(ApiConstants.URL_SINGLE_CARD)
    void getSigleCard(@Path("name") String name, Callback<List<Card>> callback);
}
