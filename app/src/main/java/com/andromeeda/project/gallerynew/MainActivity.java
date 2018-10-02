package com.andromeeda.project.gallerynew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.mindorks.placeholderview.PlaceHolderView;

public class MainActivity extends AppCompatActivity {
    PlaceHolderView mGalleryNew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGalleryNew = (PlaceHolderView) findViewById(R.id.galleryView);
        mGalleryNew
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img1)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img2)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img3)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img4)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img5)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img6)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img7)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img8)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img9)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img10)));
        mGalleryNew.getBuilder().setLayoutManager(new GridLayoutManager(this.getApplicationContext(),2));

    }
}
