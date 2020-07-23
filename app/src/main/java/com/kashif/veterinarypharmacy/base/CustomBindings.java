package com.kashif.veterinarypharmacy.base;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.imageslider.adapter.ViewPagerAdapeter;

import java.util.List;

public class CustomBindings {


    @BindingAdapter("imageurl")
    public static void ImageUrl(ImageView imageView, String url) {

        Glide.with(imageView.getContext()).load(url).diskCacheStrategy(DiskCacheStrategy.RESOURCE).transform(new CircleCrop()).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                return false;
            }
        }).into(imageView);
    }

    @BindingAdapter("customtint")
    public static void CustomTint(ImageView imageView, boolean isFav) {


        if (isFav) {

            imageView.setColorFilter(ContextCompat.getColor(imageView.getContext(), R.color.text_pink), android.graphics.PorterDuff.Mode.SRC_IN);


        } else {
            imageView.setColorFilter(ContextCompat.getColor(imageView.getContext(), R.color.dark_grey), android.graphics.PorterDuff.Mode.SRC_IN);
        }
    }


}
