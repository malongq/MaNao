package com.malong.manaomall.ui.fragment;

import android.annotation.SuppressLint;

import com.malong.manaomall.di.component.MyApplicationComponent;
import com.malong.manaomall.presenter.BaseForTwoAndThreeFragmentPresenter;
import com.malong.manaomall.ui.adapter.OneFragmentChildAdapter;

/**
 * Created by Malong
 * on 18/7/19.
 */
@SuppressLint("ValidFragment")
public class CategoryFragment extends BaseForTwoAndThreeFragment {

    public static final int FEATURE = 0;//精品
    public static final int TOPLIST = 1;//排行
    public static final int NEWLIST = 2;//新品


    private int category_id;
    private int fm_type;

    @SuppressLint("ValidFragment")
    private CategoryFragment(int category_id, int fm_type) {
        this.category_id = category_id;
        this.fm_type = fm_type;
    }

    public static CategoryFragment newInstance(int category_id, int fm_type) {

        return new CategoryFragment(category_id, fm_type);
    }

    @Override
    OneFragmentChildAdapter buildAdapter() {
        return null;
    }

    @Override
    int type() {
        return 0;
    }

    @Override
    public void setActivityComponent(MyApplicationComponent myApplicationComponent) {


    }

    @Override
    public void init() {

    }


    /**
     * 错误或无网络点击重新加载
     */
//    @Override
//    public void reloadEmptyOrNoWifi() {
//        mPresenter.requestDatas(BaseForTwoAndThreeFragmentPresenter.TWO_FRAGMENT,0);
//    }
//
//    @Override
//    public void showError_Empty(String msg) {
//        showEmptyView(msg);
//    }

}
