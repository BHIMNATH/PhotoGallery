package com.andromeeda.project.gallerynew;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.mindorks.placeholderview.PlaceHolderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int selectedImagePosition = 0;
    private ImageView selectedImageView;
    private List<Drawable> drawables;
    private Gallery gallery;
    ScaleListener scaleListener;
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private ImageView mImageView;
    private ListView listView;
    private Matrix matrix = new Matrix();
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scaleListener.onScale(mScaleGestureDetector);

        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageAdapter mAdapter = new ImageAdapter(this);
        viewPager.setAdapter(mAdapter);

//        GridView gridView = (GridView) findViewById(R.id.gridview);
//        gridView.setAdapter(new ImageAdapter(this));
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
//            }
//        });
//        listView = (ListView) findViewById(R.id.image_list);
//        listView.setAdapter(new ImageListAdapter(this));
//        selectedImageView = findViewById(R.id.selectedImage);
//        gallery = findViewById(R.id.Gallery);

    }
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        mScaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector){
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            scaleFactor = Math.max(0.1f,Math.min(scaleFactor,5.0f));
            matrix.setScale(scaleFactor,scaleFactor);
            mImageView.setImageMatrix(matrix);
            return true;
        }
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
