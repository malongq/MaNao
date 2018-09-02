package com.malong.manaomall.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.malong.manaomall.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Malong
 * on 18/6/23.
 * 引导页fragment
 */
public class GuideFragment extends Fragment {

    @BindView(R.id.guide_fm_img)
    ImageView guideFmImg;

    @BindView(R.id.guide_tv_text)
    TextView guideTvText;

    @BindView(R.id.guide_re_fr)
    RelativeLayout guideReFr;

    private View mView;

    public static final String IMG_ID = "IMG_ID";
    public static final String BG_COLOR_ID = "BG_COLOR_ID";
    public static final String TEXT_ID = "TEXT_ID";

    private Unbinder bind;

    public static GuideFragment newInstance(int imgResId, int bgColorId, int textResId) {

        GuideFragment guideFragment = new GuideFragment();

        Bundle bundle = new Bundle();

        bundle.putInt(IMG_ID, imgResId);
        bundle.putInt(BG_COLOR_ID, bgColorId);
        bundle.putInt(TEXT_ID, textResId);

        guideFragment.setArguments(bundle);

        return guideFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_guide, container, false);

        bind = ButterKnife.bind(this, mView);

        initData();

        return mView;
    }

    private void initData() {

        Bundle arguments = getArguments();

        int img_id = arguments.getInt(IMG_ID);
        int bg_color_id = arguments.getInt(BG_COLOR_ID);
        int text_id = arguments.getInt(TEXT_ID);

        guideReFr.setBackgroundColor(getResources().getColor(bg_color_id));
        guideFmImg.setImageResource(img_id);
        guideTvText.setText(text_id);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (bind != Unbinder.EMPTY) {
            bind.unbind();
        }
    }
}
