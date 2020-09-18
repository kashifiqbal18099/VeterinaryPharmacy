package com.kashif.veterinarypharmacy.imageslider.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.kashif.veterinarypharmacy.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapeter extends PagerAdapter {
    List<String> imgesList;
    Context context;
    private LayoutInflater inflater;
    private boolean doNotifyDataSetChangedOnce = false;

    public ViewPagerAdapeter(List<String> imgesList, Context context) {
        this.imgesList = imgesList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (doNotifyDataSetChangedOnce) {
            doNotifyDataSetChangedOnce = false;
            notifyDataSetChanged();
        }
        return imgesList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        doNotifyDataSetChangedOnce = true;
        View imageLayout = inflater.inflate(R.layout.slidingimages_layout, container, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image);
        Glide.with(context)
                .load(imgesList.get(position))
                .centerCrop()
                .into(imageView);
        container.addView(imageView,0);

        return imageView;

    }


        @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
