package com.ranzan.sneakership.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
//    private final String BASE_URL = "https://gist.githubusercontent.com/";

    public static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder().baseUrl("https://gist.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient().
                        newBuilder()
                        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build())
                .build();
    }
}
