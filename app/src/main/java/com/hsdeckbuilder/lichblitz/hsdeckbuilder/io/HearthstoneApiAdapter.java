package com.hsdeckbuilder.lichblitz.hsdeckbuilder.io;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by lichblitz on 20/08/15.
 */
public class HearthstoneApiAdapter {
    public static HearthstoneApiService API_SERVICE;

    public static HearthstoneApiService getApiService(){
        if(API_SERVICE == null){
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ApiConstants.BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();

            API_SERVICE = adapter.create(HearthstoneApiService.class);
        }

        return API_SERVICE;
    }

}
