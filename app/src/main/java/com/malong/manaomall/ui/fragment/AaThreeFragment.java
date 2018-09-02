package com.malong.manaomall.ui.fragment;

import com.malong.manaomall.di.component.DaggerBaseForTwoAndThreeFragmentComponent;
import com.malong.manaomall.di.component.MyApplicationComponent;
import com.malong.manaomall.di.module.BaseForTwoAndThreeFragmentModule;
import com.malong.manaomall.presenter.BaseForTwoAndThreeFragmentPresenter;
import com.malong.manaomall.ui.adapter.OneFragmentChildAdapter;

/**
 * Created by Malong
 * on 18/6/13.
 * 主页第三个fragment
 */
public class AaThreeFragment extends BaseForTwoAndThreeFragment {


    @Override
    OneFragmentChildAdapter buildAdapter() {
        return OneFragmentChildAdapter.builder().showPosition(false).showCategory(false).showBrief(true).build();
    }

    @Override
    int type() {
        return BaseForTwoAndThreeFragmentPresenter.THREE_FRAGMENT;
    }

    @Override
    public void setActivityComponent(MyApplicationComponent myApplicationComponent) {

        DaggerBaseForTwoAndThreeFragmentComponent
                .builder()
                .myApplicationComponent(myApplicationComponent)
                .baseForTwoAndThreeFragmentModule(new BaseForTwoAndThreeFragmentModule(this))
                .build()
                .injectAaThreeFragment(this);

    }

    /**
     * 错误或无网络点击重新加载
     */
    @Override
    public void reloadEmptyOrNoWifi() {
        mPresenter.requestDatas(BaseForTwoAndThreeFragmentPresenter.THREE_FRAGMENT,0);
    }

    @Override
    public void showError_Empty(String msg) {
        showEmptyView(msg);
    }


}
