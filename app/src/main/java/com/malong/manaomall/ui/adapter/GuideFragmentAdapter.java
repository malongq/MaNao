package com.malong.manaomall.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malong
 * on 18/6/23.
 * 引导页FragmentAdapter适配器
 */
public class GuideFragmentAdapter extends FragmentPagerAdapter {


    List<Fragment> mFragment;

    public void setFragments(List<Fragment> fragment){
        if (fragment == null){
            mFragment = new ArrayList<>();
        }else {
            mFragment = fragment;
        }
    }

    public GuideFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }
}
