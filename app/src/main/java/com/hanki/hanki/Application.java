package com.hanki.hanki;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Application extends android.app.Application {

    private static Application instance = new Application();
    private NetworkService networkService;
    private String baseUrl = "http://117.17.156.101:8180/";

    public static Application getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        buildNetworkService();
    }

    public void buildNetworkService() {
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        networkService = retrofit.create(NetworkService.class);
    }

    public NetworkService getNetworkService() {
        return networkService;
    }
}
