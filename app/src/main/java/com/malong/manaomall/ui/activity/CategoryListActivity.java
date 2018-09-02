package com.malong.manaomall.ui.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import com.malong.manaomall.R;
import com.malong.manaomall.bean.Category;
import com.malong.manaomall.common.Constant;
import com.malong.manaomall.common.utils.DrawableUtils;
import com.malong.manaomall.common.utils.IconUtils;
import com.malong.manaomall.di.component.MyApplicationComponent;
import com.malong.manaomall.ui.adapter.CategoryViewpagerAdapter;
import com.mikepenz.iconics.IconicsDrawable;

import java.io.Serializable;

import butterknife.BindView;


/**
 * Created by Malong
 * on 18/7/19.
 */
public class CategoryListActivity extends BaseActivity {


    @BindView(R.id.category_toobar)
    Toolbar toolBar;

    @BindView(R.id.category_table_layout)
    TabLayout tabLayout;

    @BindView(R.id.category_view_pager)
    ViewPager viewPager;

    private Category category;

    @Override
    public int setLayout() {
        return R.layout.activity_catrgory;
    }

    @Override
    public void setActivityComponent(MyApplicationComponent myApplicationComponent) {

    }

    @Override
    public void init() {

        //获取上一页面传递的数据
        getIntentData();

        //加载tTabLayout+ViewPager方法
        initTabLayoutAndViewPagerView();

    }

    /**
     * 加载TabLayout+ViewPager方法
     */
    private void initTabLayoutAndViewPagerView() {

        toolBar.setNavigationIcon(DrawableUtils.drawable(this, IconUtils.Icon.ion_houtui,getResources().getColor(R.color.color_w),20));

        CategoryViewpagerAdapter viewpagerAdapter = new CategoryViewpagerAdapter(getSupportFragmentManager(),category.getId(), 0);//创建ViewpagerAdapter
        viewPager.setOffscreenPageLimit(viewpagerAdapter.getCount());//viewpager预加载页面数量
        viewPager.setAdapter(viewpagerAdapter);//设置adapter
        tabLayout.setupWithViewPager(viewPager);//TabLayout+ViewPager关联

    }

    /**
     * 获取上一页面传递的数据
     */
    private void getIntentData(){
        //主页第四个fragment条目点击传来的值
        Intent intent = getIntent();
        category = (Category) intent.getSerializableExtra(Constant.CATRGORY);

    }

}
