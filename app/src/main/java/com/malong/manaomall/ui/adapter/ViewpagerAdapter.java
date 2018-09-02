package com.malong.manaomall.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.malong.manaomall.ui.bean.FragmnetInfo;
import com.malong.manaomall.ui.fragment.AaFourFragment;
import com.malong.manaomall.ui.fragment.AaOneFragment;
import com.malong.manaomall.ui.fragment.AaThreeFragment;
import com.malong.manaomall.ui.fragment.TestFragment;
import com.malong.manaomall.ui.fragment.AaTwoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malong
 * on 18/6/13.
 */
public class ViewpagerAdapter extends FragmentStatePagerAdapter {

    /**
     * 封装的思想
     */
//    private List<FragmnetInfo> mFragments = new ArrayList<>(4);
    private List<FragmnetInfo> mFragments = new ArrayList<>(5);

    public ViewpagerAdapter(FragmentManager fm) {
        super(fm);
        initFragmnet();
    }

    private void initFragmnet() {

        mFragments.add(new FragmnetInfo("爱智康", AaOneFragment.class));
        mFragments.add(new FragmnetInfo("学而思", AaTwoFragment.class));
        mFragments.add(new FragmnetInfo("妈妈帮", AaThreeFragment.class));
        mFragments.add(new FragmnetInfo("摩比英语", AaFourFragment.class));
        mFragments.add(new FragmnetInfo("测试页面", TestFragment.class));//可注销，然后该类 28行 也需跟着注销，后打开 27行

    }

    @Override
    public Fragment getItem(int position) {

        try {
            return (Fragment) mFragments.get(position).getFragmnet().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTitle();
    }

}
