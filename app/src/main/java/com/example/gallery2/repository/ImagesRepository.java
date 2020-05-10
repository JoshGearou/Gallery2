package com.example.gallery2.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.gallery2.model.ImagesMetaData;
import com.example.gallery2.service.ImagesApiService;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ImagesRepository {
    private MutableLiveData<List<ImagesMetaData>> data = new MutableLiveData<>();
    private static ImagesRepository imagesRepository;

    public void getImages() {
        ImagesApiService.getInstance().getImages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> {
                            data.postValue(it);
                        },
                        error -> {
                            System.out.println("error");
                        });
    }

    public static ImagesRepository getInstance() {
        if (imagesRepository == null) {
            imagesRepository = new ImagesRepository();
        }
        return imagesRepository;
    }

    public MutableLiveData<List<ImagesMetaData>> getImagesData() {
        return data;
    }
}
