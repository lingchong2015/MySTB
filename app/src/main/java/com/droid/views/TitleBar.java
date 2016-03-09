package com.droid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.droid.R;

/**
 * Created by Administrator on 2016/3/9 0009.
 */
public class TitleBar extends LinearLayout {
    private TextView mTitleView;
    private OnClickListener mOnClickListener;

    public TitleBar(Context context) {
        this(context, null, 0);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    public TextView getTitleView() {
        return mTitleView;
    }

    public void setTitleView(TextView titleView) {
        mTitleView = titleView;
    }

    public void setTitle(int resID) {
        mTitleView.setText(resID);
    }

    public void setTitle(CharSequence charSequence) {
        mTitleView.setText(charSequence);
    }

    private void init(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.title_bar, this);
        mTitleView = (TextView) findViewById(R.id.text_view_title_bar);
    }

    public void setBackPressListner(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
        findViewById(R.id.image_view_back).setOnClickListener(mOnClickListener);
    }
}
