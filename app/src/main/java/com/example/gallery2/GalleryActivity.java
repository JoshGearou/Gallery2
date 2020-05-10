package com.example.gallery2;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gallery2.repository.ImagesRepository;


public class GalleryActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImagesRepository repository = ImagesRepository.getInstance();
        repository.getImages();
        RecyclerView recyclerView = findViewById(R.id.recylerView);
        repository.getImagesData().observe(this, lst -> {
            MyAdapter adapter = new MyAdapter();
            recyclerView.setAdapter(adapter);
            adapter.setItems(lst);
        });
    }
}
