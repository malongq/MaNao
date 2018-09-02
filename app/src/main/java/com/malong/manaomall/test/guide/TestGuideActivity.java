package com.malong.manaomall.test.guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.malong.manaomall.R;
import com.malong.manaomall.ui.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 引导页
 */
public class TestGuideActivity extends AppCompatActivity {

    @BindView(R.id.guide_view_pager)
    ViewPager guideViewPager;
    @BindView(R.id.guide_button)
    Button guideButton;
    @BindView(R.id.guide_img_1)
    ImageView guideImg1;
    @BindView(R.id.guide_img_2)
    ImageView guideImg2;
    @BindView(R.id.guide_img_3)
    ImageView guideImg3;
    @BindView(R.id.ll_point)
    LinearLayout llPoint;
    @BindView(R.id.guide_re)
    RelativeLayout guideRe;
    private TestGuideFragmentAdapter guideFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_guide);
        ButterKnife.bind(this);


        initData();

    }

    private void initData() {

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(TestGuideFragment.newInstance(R.mipmap.newss, R.color.guide_1, R.string.guide_tv_1));
        fragments.add(TestGuideFragment.newInstance(R.mipmap.set, R.color.guide_2, R.string.guide_tv_2));
        fragments.add(TestGuideFragment.newInstance(R.mipmap.update, R.color.guide_3, R.string.guide_tv_3));

        guideFragmentAdapter = new TestGuideFragmentAdapter(getSupportFragmentManager());

        guideFragmentAdapter.setFragments(fragments);

        guideViewPager.setCurrentItem(0);

        guideViewPager.setOffscreenPageLimit(guideFragmentAdapter.getCount());

        guideViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0) {

                    guideImg1.setImageResource(R.mipmap.small);
                    guideImg2.setImageResource(R.mipmap.newss);
                    guideImg3.setImageResource(R.mipmap.newss);

                    guideButton.setVisibility(View.GONE);

                } else if (position == 1) {

                    guideImg1.setImageResource(R.mipmap.newss);
                    guideImg2.setImageResource(R.mipmap.small);
                    guideImg3.setImageResource(R.mipmap.newss);

                    guideButton.setVisibility(View.GONE);

                } else {

                    guideImg1.setImageResource(R.mipmap.newss);
                    guideImg2.setImageResource(R.mipmap.newss);
                    guideImg3.setImageResource(R.mipmap.small);

                    guideButton.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        guideViewPager.setAdapter(guideFragmentAdapter);

    }

    @OnClick(R.id.guide_button)
    public void onViewClicked() {
        startActivity(new Intent(this,MainActivity.class));
        this.finish();
    }
}
