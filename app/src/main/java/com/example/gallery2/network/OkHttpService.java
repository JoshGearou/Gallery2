package com.example.gallery2.network;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpService {
   private static OkHttpClient okHttpClient;

    private static OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder().addInterceptor(chain -> {
            Request originalRequest = chain.request();
            Request newRequest = originalRequest.newBuilder()
                    .addHeader(
                            "Authorization",
                            "Client-ID " + "MFnJZZvk6YawEs2jMQBrIuKvcrOSik--srIJwRUZQos"
                    )
                    .method(originalRequest.method(), originalRequest.body())
                    .build();
            return chain.proceed(newRequest);
        });

        return builder.build();
    }

    public static OkHttpClient getInstance() {
        if (okHttpClient == null) {
            okHttpClient = createOkHttpClient();
        }
        return okHttpClient;
    }

}
