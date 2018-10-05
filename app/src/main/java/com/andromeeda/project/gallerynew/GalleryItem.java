package com.andromeeda.project.gallerynew;

import com.mindorks.placeholderview.Animation;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;

/**
 * Created by Aswin on 02-Oct-18.
 */
@Animate(Animation.CARD_LEFT_IN_DESC)
@NonReusable
@Layout(R.layout.single_grid_item)
class GalleryItem {
}
//    @View(R.id.imageView)
//    private ImageView imageView;
//
//    private Drawable mDrawable;
//
//    GalleryItem(Drawable drawable){
//        mDrawable = drawable;
//    }
//    @Resolve
//    private void onResolved(){
//        imageView.setImageDrawable(mDrawable);
//    }
