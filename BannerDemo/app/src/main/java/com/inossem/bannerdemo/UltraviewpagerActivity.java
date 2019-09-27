package com.inossem.bannerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.inossem.bannerdemo.common.Constans;
import com.inossem.bannerdemo.ultraviewpager.MyOnItemClickListener;
import com.inossem.bannerdemo.ultraviewpager.ScalePageTransformer;
import com.inossem.bannerdemo.ultraviewpager.UltraPagerAdapter;
import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.ultraviewpager.UltraViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class UltraviewpagerActivity extends AppCompatActivity {

//    https://github.com/alibaba/UltraViewPager

    private UltraViewPagerAdapter bannerAdapter;
    UltraViewPager ultraViewpager;
    List<Object> mPics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultraviewpager);

        ultraViewpager = findViewById(R.id.ultra_viewpager);
        mPics = new ArrayList<>();
        setBannerPics();

    }

    private void pretendHttp() {

        String[] picUrls = Constans.picUrls;

        mPics.clear();
        for (String str : picUrls) {
            mPics.add(str);
        }

        ultraViewpager.refresh();
        ultraViewpager.setCurrentItem(1);
    }


    @Override
    public void onPause() {
        super.onPause();
        ultraViewpager.disableAutoScroll();
    }


    @Override
    protected void onResume() {
        super.onResume();
        ultraViewpager.setAutoScroll(2500);
        pretendHttp();
    }

    private void setBannerPics() {

        UltraPagerAdapter myAdapter = new UltraPagerAdapter(true, mPics);
        myAdapter.setOnItemClickListener(new MyOnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Toast.makeText(UltraviewpagerActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        bannerAdapter = new UltraViewPagerAdapter(myAdapter);
        ultraViewpager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        ultraViewpager.setHGap(getResources().getDimensionPixelOffset(R.dimen.dp10));
        ultraViewpager.setMultiScreen(0.9f);

//        ultraViewpager.initIndicator();
//        ultraViewpager.getIndicator()   //  指示器
//                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
//                .setFocusColor(Color.WHITE)
//                .setNormalColor(Color.parseColor("#BB888888"))
//                .setMargin(0, 0, 0, 16)
//                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()));
//        ultraViewpager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
//        ultraViewpager.getIndicator().build();

//        ultraViewpager.setPageTransformer(true, new UltraScaleTransformer());
//        ultraViewpager.setPageTransformer(false, new UltraDepthScaleTransformer());
        ultraViewpager.setPageTransformer(true, new ScalePageTransformer());// 两边缩小变形
        ultraViewpager.setInfiniteLoop(true);
        ultraViewpager.setAutoScroll(2500);
        ultraViewpager.setAdapter(bannerAdapter);
    }


}
