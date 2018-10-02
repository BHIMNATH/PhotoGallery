package com.andromeeda.project.gallerynew;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.mindorks.placeholderview.Animation;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by Aswin on 02-Oct-18.
 */
@Animate(Animation.CARD_LEFT_IN_DESC)
@NonReusable
@Layout(R.layout.gallery_item_big)
public class GalleryItem {

    @View(R.id.imageView)
    private ImageView imageView;

    private Drawable mDrawable;

    public GalleryItem(Drawable drawable){
        mDrawable = drawable;
    }
    @Resolve
    private void onResolved(){
        imageView.setImageDrawable(mDrawable);
    }
}
