package com.malong.manaomall.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.malong.manaomall.ui.fragment.CategoryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malong
 * on 18/6/13.
 */
public class CategoryViewpagerAdapter extends FragmentStatePagerAdapter {

    /**
     * 封装的思想
     */
    private List<String> titles = new ArrayList<>(3);


    private int category_id;
    private int fmType;
    public CategoryViewpagerAdapter(FragmentManager fm, int category_id, int fmType) {
        super(fm);
        this.category_id = category_id;
        this.fmType = fmType;

        titles.add("精品");
        titles.add("排行");
        titles.add("新品");
    }


    @Override
    public Fragment getItem(int position) {


        return CategoryFragment.newInstance(category_id,position);

    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

}
