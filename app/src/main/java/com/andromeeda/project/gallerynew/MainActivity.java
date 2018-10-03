package com.andromeeda.project.gallerynew;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ListView;

import com.mindorks.placeholderview.PlaceHolderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int selectedImagePosition = 0;
    private ImageView selectedImageView;
    private List<Drawable> drawables;
    private Gallery gallery;

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        listView = (ListView) findViewById(R.id.image_list);
//        listView.setAdapter(new ImageListAdapter(this));
//        selectedImageView = findViewById(R.id.selectedImage);
//        gallery = findViewById(R.id.Gallery);

    }
//        gallery.setAdapter(new ImageAdapter(getActivity().getApplicationContext()));

//        gallery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setSelectedImage(selectedImagePosition);
//            }
//        });
//        mGalleryNew = (PlaceHolderView) findViewById(R.id.galleryView);
//        mGalleryNew
//                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img1)))
//                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img2)))
//                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img3)))
//                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img4)))
//                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img5)))
//                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img6)))
//                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img7)))
//                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img8)))
//                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img9)))
//                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img10)));
//        mGalleryNew.getBuilder().setLayoutManager(new GridLayoutManager(this.getApplicationContext(),2));

//    }
//    private void getDrawablesList(){
//        drawables = new ArrayList<Drawable>();
//        drawables.add(getResources().getDrawable(R.drawable.home_img1));
//        drawables.add(getResources().getDrawable(R.drawable.home_img2));
//        drawables.add(getResources().getDrawable(R.drawable.home_img3));
//        drawables.add(getResources().getDrawable(R.drawable.home_img4));
//        drawables.add(getResources().getDrawable(R.drawable.home_img5));
//        drawables.add(getResources().getDrawable(R.drawable.home_img6));
//    }
//    private void setSelectedImage(int selectedImage){
//        BitmapDrawable bd = (BitmapDrawable) drawables.get(selectedImagePosition);
//        Bitmap b = Bitmap.createScaledBitmap(bd.getBitmap(),(int)(bd.getIntrinsicHeight()*0.9),(int)(bd.getIntrinsicWidth()*0.7),false);
//        selectedImageView.setImageBitmap(b);
//        selectedImageView.setScaleType(ImageView.ScaleType.FIT_XY);
//
//    }
}
