package com.droid.activities.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.droid.R;
import com.droid.activities.WoDouGameBaseFragment;
import com.droid.views.TitleBar;

/**
 * Created by Administrator on 2016/3/9 0009.
 */
public class DetailVideoFragment extends WoDouGameBaseFragment {
    private int mCurrentItem = -1;
    private boolean mIsStarOnState = true;
    public static final String EXTRA_VIDEO_ITEM = DetailVideoFragment.class.getCanonicalName() + ".video_item";
    private static final String TAG = DetailVideoFragment.class.getSimpleName();

    public static DetailVideoFragment newInstance(int currentItem) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_VIDEO_ITEM, currentItem);

        DetailVideoFragment detailVideoFragment = new DetailVideoFragment();
        detailVideoFragment.setArguments(bundle);

        return detailVideoFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCurrentItem = getArguments().getInt(EXTRA_VIDEO_ITEM);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getContext()).inflate(R.layout.fragment_video_view, container, false);
        initView(view);

        return view;
    }

    private String getNameFromItem(int currentItem) {
        return "香港卫视直播频道";
    }

    private void initView(View view) {
        TitleBar titleBar = (TitleBar) view.findViewById(R.id.title_bar_back);
        titleBar.setTitle(getNameFromItem(mCurrentItem));
        titleBar.setBackPressListner(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailVideoFragment.this.getActivity().finish();
            }
        });

        final ImageButton imageButtonPlay = (ImageButton) view.findViewById(R.id.image_button_play);
        imageButtonPlay.requestFocus();
        imageButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Play the video.
            }
        });

        final ImageButton imageButtonStarOnOff = (ImageButton) view.findViewById(R.id.image_button_star_on_off);
        imageButtonStarOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIsStarOnState = !mIsStarOnState;
                imageButtonStarOnOff.setImageDrawable(getActivity().getResources().getDrawable(mIsStarOnState ? R.drawable.ic_star_on :
                R.drawable.ic_start_off));
            }
        });
    }
}
