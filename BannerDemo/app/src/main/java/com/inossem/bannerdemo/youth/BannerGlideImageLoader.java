package com.inossem.bannerdemo.youth;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.inossem.bannerdemo.R;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by lnliy on 2018/2/23.
 */

public class BannerGlideImageLoader extends ImageLoader {

    public RequestOptions options = new RequestOptions().placeholder(R.drawable.placeholder).error(R.drawable.placeholder)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        Glide.with(context).load(path).apply(options).into(imageView);
    }


    @Override
    public ImageView createImageView(Context context) {

        ImageView imageView = new ImageView(context);
//        imageView.setScaleType(ImageView.ScaleType.FIT_XY);//xy拉伸
//        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return imageView;
    }
}
