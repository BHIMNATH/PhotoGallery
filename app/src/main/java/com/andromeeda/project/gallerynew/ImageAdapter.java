package com.andromeeda.project.gallerynew;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by Aswin on 02-Oct-18.
 */

public class ImageAdapter extends PagerAdapter {
    private Context mContext;
    private int[] mThumbIds = new int[] {
            R.drawable.home_img1,R.drawable.home_img2,R.drawable.home_img3,R.drawable.home_img4,R.drawable.home_img5,
            R.drawable.home_img6,R.drawable.home_img7,R.drawable.home_img8,R.drawable.home_img9,R.drawable.home_img10,R.drawable.home_img1,R.drawable.home_img2,R.drawable.home_img3,R.drawable.home_img4,R.drawable.home_img5,
            R.drawable.home_img6,R.drawable.home_img7,R.drawable.home_img8,R.drawable.home_img9,R.drawable.home_img10,R.drawable.home_img1,R.drawable.home_img2,R.drawable.home_img3,R.drawable.home_img4,R.drawable.home_img5,
            R.drawable.home_img6,R.drawable.home_img7,R.drawable.home_img8,R.drawable.home_img9,R.drawable.home_img10,
        };

    ImageAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
       return mThumbIds.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(mThumbIds[position]);
        container.addView(imageView,0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);

    }
//
//    @Override
//    public Object getItem(int position) {
////       return mThumbIds[position];
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView imageView = new ImageView(mContext);
//        if (convertView == null){
//            imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new ViewGroup.LayoutParams(300, 400));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        }
//        else {
//            imageView = (ImageView) convertView;
//        }
//        imageView.setImageResource(mThumbIds[position]);
//        return imageView;
//    }
}
