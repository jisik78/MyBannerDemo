package com.inossem.bannerdemo.ultraviewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.inossem.bannerdemo.common.GlideUtil;
import com.inossem.bannerdemo.R;

import java.util.List;

import androidx.viewpager.widget.PagerAdapter;

public class UltraPagerAdapter extends PagerAdapter {
    private boolean isMultiScr;

    MyOnItemClickListener onItemClickListener;
    List<Object> pics;

    public UltraPagerAdapter(boolean isMultiScr, List<Object> pics) {
        this.isMultiScr = isMultiScr;
        this.pics = pics;
    }

    @Override
    public int getCount() {
        if (pics == null) return 0;
        return pics.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public boolean isMultiScr() {
        return isMultiScr;
    }

    public void setMultiScr(boolean multiScr) {
        isMultiScr = multiScr;
    }

    public List<Object> getPics() {
        return pics;
    }

    public void setPics(List<Object> pics) {
        this.pics = pics;
    }

    public MyOnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(MyOnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView = (ImageView) LayoutInflater.from(container.getContext()).inflate(R.layout.item_main_banner, null);

        GlideUtil.getInstance().setPic(container.getContext(), pics.get(position), imageView);
        container.addView(imageView);

        imageView.setTag(imageView.getId(),position);
        // 因为使用 Glide  所以setTag  一定要使用两个参数的方法，否则报错
        // 错误 ： You must not call setTag() on a view Glide is targeting
        imageView.setOnClickListener(onClickListener);

        return imageView;
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = (int) v.getTag(v.getId());   // 因为使用 Glide  使用setTag  一定要使用两个参数的方法，否则报错

            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position);
            }

        }
    };


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageView view = (ImageView) object;
        container.removeView(view);
    }

}