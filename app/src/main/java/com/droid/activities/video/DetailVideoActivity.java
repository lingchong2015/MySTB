package com.droid.activities.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.droid.R;
import com.droid.activities.BaseActivity;
import com.droid.activities.SingleFragmentActivity;

/**
 * Created by Administrator on 2016/3/9 0009.
 */
public class DetailVideoActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        int currentItem = getIntent().getIntExtra(DetailVideoFragment.EXTRA_VIDEO_ITEM, 0);

        return DetailVideoFragment.newInstance(currentItem);
    }
}
