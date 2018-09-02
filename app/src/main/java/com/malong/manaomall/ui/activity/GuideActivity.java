package com.malong.manaomall.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.malong.manaomall.R;
import com.malong.manaomall.common.Constant;
import com.malong.manaomall.common.utils.ACache;
import com.malong.manaomall.ui.adapter.GuideFragmentAdapter;
import com.malong.manaomall.ui.fragment.GuideFragment;
import com.malong.manaomall.ui.widget.CircleIndicator;
import com.malong.manaomall.ui.widget.DepthPageTransformer;
import com.malong.manaomall.ui.widget.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 引导页
 */
public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    @BindView(R.id.guide_view_pager)
    ViewPager guideViewPager;

    @BindView(R.id.guide_button)
    Button guideButton;

    @BindView(R.id.ll_point)
    CircleIndicator llPoint;

    @BindView(R.id.guide_re)
    RelativeLayout guideRe;

    private GuideFragmentAdapter guideFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

        //加载数据页面
        initData();

    }

    /**
     * 加载数据页面
     */
    private void initData() {

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(GuideFragment.newInstance(R.mipmap.newss, R.color.guide_1, R.string.guide_tv_1));
        fragments.add(GuideFragment.newInstance(R.mipmap.set, R.color.guide_2, R.string.guide_tv_2));
        fragments.add(GuideFragment.newInstance(R.mipmap.update, R.color.guide_3, R.string.guide_tv_3));

        guideFragmentAdapter = new GuideFragmentAdapter(getSupportFragmentManager());

        guideFragmentAdapter.setFragments(fragments);

        guideViewPager.setCurrentItem(0);//制定初始化页面第一个页面为当前页面

        guideViewPager.setOffscreenPageLimit(guideFragmentAdapter.getCount());//限定预加载的页面个数，这里全部加载

        guideViewPager.setAdapter(guideFragmentAdapter);//把adapter设置到viewpager里

        guideViewPager.addOnPageChangeListener(this);//viewpager页面滑动监听

        guideViewPager.setPageTransformer(true,new ZoomOutPageTransformer());//页面滑动动画ZoomOutPageTransformer、DepthPageTransformer

        llPoint.setViewPager(guideViewPager);//指示点变动

    }

    /**
     * 我要体验点击方法
     */
    @OnClick(R.id.guide_button)
    public void onViewClicked() {

        ACache.get(this).put(Constant.IS_SHOW_GUIDE,"0");//存入是否进入过引导页
        startActivity(new Intent(this,MainActivity.class));
        this.finish();

    }

    /**
     * 页面滑动监听操作
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        //最后一个页面时显示立即体验按钮
        guideButton.setVisibility((position == guideFragmentAdapter.getCount() - 1) ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
