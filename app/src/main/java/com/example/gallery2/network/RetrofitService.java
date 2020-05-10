package com.example.gallery2.network;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitService {
    private static Retrofit retrofit;

    private static Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.unsplash.com")
                .client(OkHttpService.getInstance())
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

    }

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = createRetrofit();
        }

        return retrofit;
    }
}
