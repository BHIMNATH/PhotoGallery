package com.andromeeda.project.gallerynew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by Aswin on 02-Oct-18.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    private Integer[] mThumbIds = {
            R.drawable.home_img1,R.drawable.home_img2,R.drawable.home_img3,R.drawable.home_img4,R.drawable.home_img5,
            R.drawable.home_img6,R.drawable.home_img7,R.drawable.home_img8,R.drawable.home_img9,R.drawable.home_img10
        };
    ImageAdapter(Context context){
        mContext = context;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
       return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ListView.LayoutParams(70,70));
        return imageView;
    }
}
