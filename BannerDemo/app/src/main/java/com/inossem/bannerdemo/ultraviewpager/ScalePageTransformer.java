package com.inossem.bannerdemo.ultraviewpager;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

public class ScalePageTransformer implements ViewPager.PageTransformer {

    public static final float MIN_SCALE = 0.85f;

    @Override
    public void transformPage(View page, float position) {

        if (position < -1) { // [-Infinity,-1)
//                page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);

        } else if (position <= 1) { // [-1,1]
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
//                page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);

        } else { // (1,+Infinity]
//                page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);

        }

    }

}
