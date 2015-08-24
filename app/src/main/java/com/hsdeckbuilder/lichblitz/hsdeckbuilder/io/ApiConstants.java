package com.hsdeckbuilder.lichblitz.hsdeckbuilder.io;

/**
 * Created by lichblitz on 20/08/15.
 */
public class ApiConstants {

    public static final String MASHAPE_KEY = "18340TpSWtmshXZePn5R6HDMXZgdp1CDdONjsnKtZLs22b1pwS";
    public static final String BASE_URL = "https://omgvamp-hearthstone-v1.p.mashape.com";

    public static final String ENDPOINT_CARD = "/cards";
    public static final String ENDPOINT_SEARCH = "/search/";
    public static final String ENDPOINT_CLASS ="/class/";
    public static final String ENDPOINT_TYPE = "/type/";
    public static final String PARAM_NAME = "name";
    public static final String PARAM_COLLECTIBLE = "collectible=1";
    public static final String PARAM_ATTACK = "attack";
    public static final String PARAM_DURABILITY = "durability";
    public static final String PARAM_COST = "cost";
    public static final String PARAM_LOCALE = "locale";

    public static final String URL_ALL_CARDS = ENDPOINT_CARD + "?" + PARAM_COLLECTIBLE;
    public static final String URL_SEARCH_CARD = ENDPOINT_CARD + ENDPOINT_SEARCH;
    public static final String URL_SEARCH_BY_CLASS = ENDPOINT_CARD  + ENDPOINT_CLASS;
    public static final String URL_SEARCH_BY_TYPE = ENDPOINT_CARD  + ENDPOINT_TYPE;
    public static final String URL_SINGLE_CARD = ENDPOINT_CARD + "/{name}";



}
