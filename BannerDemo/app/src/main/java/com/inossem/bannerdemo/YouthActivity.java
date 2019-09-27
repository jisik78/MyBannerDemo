package com.inossem.bannerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.inossem.bannerdemo.common.Constans;
import com.inossem.bannerdemo.youth.BannerGlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;

public class YouthActivity extends AppCompatActivity {

//    https://github.com/youth5201314/banner
    Banner banner;
    ArrayList<String> mPics = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youth);

        banner = findViewById(R.id.banner);

        banner.setImageLoader(new BannerGlideImageLoader());
        banner.isAutoPlay(true);
        banner.setDelayTime(2000);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setImages(mPics);
        banner.setBannerAnimation(Transformer.BackgroundToForeground);//动画

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(YouthActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

        banner.start();
        pretendHttp();

    }


    private void pretendHttp() {

        String[] picUrls = Constans.picUrls;

        mPics = new ArrayList<>(); // 必须new
        for (String str : picUrls) {
            mPics.add(str);
        }

        if (banner != null) {
            banner.update(mPics);
        }

    }


    @Override
    protected void onPause() {
        super.onPause();
        if (banner != null) {
            banner.stopAutoPlay();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (banner != null) {
            banner.startAutoPlay();
        }
    }
}
