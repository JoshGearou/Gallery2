package com.example.gallery2.service;

import com.example.gallery2.model.ImagesMetaData;
import com.example.gallery2.network.RetrofitService;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ImagesApiService {

    @GET("photos/")
    Single<List<ImagesMetaData>> getImages();

    static ImagesApiService getInstance() {
        return RetrofitService.getInstance().create(ImagesApiService.class);
    }
}
