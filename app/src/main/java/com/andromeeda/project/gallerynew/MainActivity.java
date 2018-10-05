package com.andromeeda.project.gallerynew;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private GridView gv;
    private Animator mCurrentAnimator;
    private int mShortAnimationDuration;
    private int j = 0;

    private final GestureDetector gestureDetector = new GestureDetector(this, new SwipeGesterDetector());
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPT_THRESHOLD_VELOCITY = 200;

    public int thumb[] = {
            R.drawable.home_img1, R.drawable.home_img2, R.drawable.home_img3, R.drawable.home_img4, R.drawable.home_img5,
            R.drawable.home_img6, R.drawable.home_img7, R.drawable.home_img8, R.drawable.home_img9, R.drawable.home_img10, R.drawable.home_img1, R.drawable.home_img2, R.drawable.home_img3, R.drawable.home_img4, R.drawable.home_img5,
            R.drawable.home_img6, R.drawable.home_img7, R.drawable.home_img8, R.drawable.home_img9, R.drawable.home_img10, R.drawable.home_img1, R.drawable.home_img2, R.drawable.home_img3, R.drawable.home_img4, R.drawable.home_img5,
            R.drawable.home_img6, R.drawable.home_img7, R.drawable.home_img8, R.drawable.home_img9, R.drawable.home_img10
    };

    private ImageView expandedImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv = findViewById(R.id.grid_view);
        gv.setAdapter(new ImageAdapter());
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                j = position;
                zoomImageFromThumb(view, thumb[position]);
            }
        });
        mShortAnimationDuration = getResources().getInteger(R.integer.config_shortAnimTime);
    }


    class ImageAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public ImageAdapter(MainActivity activity) {
            layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return thumb.length;
        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            return super.getItemPosition(object);
        }
        public Object getItem(int pos){
            return pos;
        }
        public long getItemId(int pos){
            return pos;
        }
        public View getView(int pos, View convertView, ViewGroup parent){
            View listItem = convertView;
            int p = pos;
            if(listItem == null){
                listItem = layoutInflater.inflate(R.layout.single_grid_item,null);
            }
            ImageView iv = listItem.findViewById(R.id.thumb);
            iv.setBackgroundResource(thumb[p]);
            return listItem;
        }
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        TouchViewPagerImageView imgDisplay;

            ImageView imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(mThumbIds[position]);
            container.addView(imageView, 0);
            return imageView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((ImageView) object);

        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return false;
        }
    }

//        main = findViewById(R.id.full);
////        scaleListener.onScale(mScaleGestureDetector);
//
//        ViewPager viewPager = findViewById(R.id.viewPager);
//        ImageAdapter mAdapter = new ImageAdapter(this);
//        viewPager.setAdapter(mAdapter);
////        viewPager.onTouchEvent()
//
////        GridView gridView = (GridView) findViewById(R.id.gridview);
////        gridView.setAdapter(new ImageAdapter(this));
////
////        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
////            }
////        });
////        listView = (ListView) findViewById(R.id.image_list);
////        listView.setAdapter(new ImageListAdapter(this));
////        selectedImageView = findViewById(R.id.selectedImage);
////        gallery = findViewById(R.id.Gallery);

//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        main.setPivotX(2f);
//        main.setPivotY(2f);
//        main.setScaleX(0);
//        main.setScaleX(0);
//        return true;
//    }
//    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
//        @Override
//        public boolean onScale(ScaleGestureDetector scaleGestureDetector){
//            float scaleFactor = scaleGestureDetector.getScaleFactor();
//            scaleFactor = Math.max(0.1f,Math.min(scaleFactor,5.0f));
//            matrix.setScale(scaleFactor,scaleFactor);
//            mImageView.setImageMatrix(matrix);
//            return true;
//        }
//    }
////        gallery.setAdapter(new ImageAdapter(getActivity().getApplicationContext()));
//
////        gallery.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                setSelectedImage(selectedImagePosition);
////            }
////        });
////        mGalleryNew = (PlaceHolderView) findViewById(R.id.galleryView);
////        mGalleryNew
////                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img1)))
////                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img2)))
////                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img3)))
////                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img4)))
////                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img5)))
////                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img6)))
////                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img7)))
////                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img8)))
////                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img9)))
////                .addView(new GalleryItem(getResources().getDrawable(R.drawable.home_img10)));
////        mGalleryNew.getBuilder().setLayoutManager(new GridLayoutManager(this.getApplicationContext(),2));
//
////    }
////    private void getDrawablesList(){
////        drawables = new ArrayList<Drawable>();
////        drawables.add(getResources().getDrawable(R.drawable.home_img1));
////        drawables.add(getResources().getDrawable(R.drawable.home_img2));
////        drawables.add(getResources().getDrawable(R.drawable.home_img3));
////        drawables.add(getResources().getDrawable(R.drawable.home_img4));
////        drawables.add(getResources().getDrawable(R.drawable.home_img5));
////        drawables.add(getResources().getDrawable(R.drawable.home_img6));
////    }
////    private void setSelectedImage(int selectedImage){
////        BitmapDrawable bd = (BitmapDrawable) drawables.get(selectedImagePosition);
////        Bitmap b = Bitmap.createScaledBitmap(bd.getBitmap(),(int)(bd.getIntrinsicHeight()*0.9),(int)(bd.getIntrinsicWidth()*0.7),false);
////        selectedImageView.setImageBitmap(b);
////        selectedImageView.setScaleType(ImageView.ScaleType.FIT_XY);
////
////    }
}
