package com.kashif.veterinarypharmacy.customviews;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by BD1 on 19-Apr-17.
 */

public class TextViewSeogoeuiRegularStrike extends androidx.appcompat.widget.AppCompatTextView {
    public TextViewSeogoeuiRegularStrike(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewSeogoeuiRegularStrike(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewSeogoeuiRegularStrike(Context context) {
        super(context);
        init();
    }

    public void init() {
        TextView textView  = new TextView(getContext());
        setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
