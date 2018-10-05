package com.andromeeda.project.gallerynew;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
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


    class ImageAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;

        public ImageAdapter(MainActivity activity) {
            layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return thumb.length;
        }

        @Override
        public Object getItem(int pos){
            return pos;
        }

        @Override
        public long getItemId(int pos){
            return pos;
        }
        @Override
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
    }
    @SuppressLint("ClickableViewAccessibility")
    private void zoomImageFromThumb(final View thumbView, int imageResId){
        if(mCurrentAnimator != null){
            mCurrentAnimator.cancel();
        }
        expandedImageView = (ImageView) findViewById(R.id.expanded_image);
        expandedImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(gestureDetector.onTouchEvent(event)){
                    return true;
                }
                else {
                    return false;
                }
            }
        });
        expandedImageView.setImageResource(imageResId);

        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();
        thumbView.getGlobalVisibleRect(startBounds);
        findViewById(R.id.container).getGlobalVisibleRect(finalBounds,globalOffset);

        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);
        float startScale;
        if((float) finalBounds.width()/finalBounds.height() > (float) startBounds.width()/startBounds.height()){
            startScale = (float) startBounds.height()/finalBounds.height();

            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width())/2;
            startBounds.left -= deltaWidth;
            startBounds.right -= deltaWidth;
        }
        else {
            startScale = (float) startBounds.width()/finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height())/2;
            startBounds.top -= deltaHeight;
            startBounds.bottom -= deltaHeight;
        }
        thumbView.setAlpha(0f);
        expandedImageView.setVisibility(View.VISIBLE);
        expandedImageView.setPivotX(0f);
        expandedImageView.setPivotY(0f);

        AnimatorSet set = new AnimatorSet();

        set.play()
    }

//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
////        TouchViewPagerImageView imgDisplay;
//
//        ImageView imageView = new ImageView(mContext);
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setImageResource(mThumbIds[position]);
//        container.addView(imageView, 0);
//        return imageView;
//    }
//
//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        container.removeView((ImageView) object);
//
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return false;
//    }
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
