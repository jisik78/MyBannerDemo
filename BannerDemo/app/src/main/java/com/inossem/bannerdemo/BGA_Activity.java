package com.inossem.bannerdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import cn.bingoogolapple.bgabanner.BGABanner;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.inossem.bannerdemo.common.Constans;
import com.inossem.bannerdemo.common.GlideUtil;

import java.util.ArrayList;

public class BGA_Activity extends AppCompatActivity {

//    https://github.com/bingoogolapple/BGABanner-Android
    //  作为引导页效果不错
    //  可设置指定类型的数据

    private BGABanner mDefaultBanner;
    private BGABanner.Adapter<ImageView, TestModel> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bga);
        mDefaultBanner = findViewById(R.id.banner_main_default);

        adapter = new BGABanner.Adapter<ImageView, TestModel>() {

            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, @Nullable TestModel model, int position) {
                GlideUtil.getInstance().setPic(BGA_Activity.this, model.picUrl, itemView);
            }
        };
        mDefaultBanner.setAdapter(adapter);
        mDefaultBanner.setDelegate(new BGABanner.Delegate<ImageView, TestModel>() {
            @Override
            public void onBannerItemClick(BGABanner banner, ImageView itemView, @Nullable TestModel model, int position) {
                Toast.makeText(BGA_Activity.this, "", Toast.LENGTH_SHORT).show();
            }
        });

        mDefaultBanner.setAutoPlayAble(true);

        pretendHttp();

    }

    private void pretendHttp() {
        String[] picUrls = Constans.picUrls;

        ArrayList<TestModel> testClasses = new ArrayList<TestModel>();
        for (String str : picUrls) {
            testClasses.add(new TestModel(str, ""));
        }


        /**
         * 设置是否开启自动轮播，需要在 setData 方法之前调用，并且调了该方法后必须再调用一次 setData 方法
         */
        mDefaultBanner.setData(testClasses, null);

    }



    public class TestModel {

        public TestModel(String picUrl, String others) {
            this.picUrl = picUrl;
            this.others = others;
        }

        String picUrl;
        String others;


    }
}
