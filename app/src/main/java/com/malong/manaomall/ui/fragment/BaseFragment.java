package com.malong.manaomall.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.malong.manaomall.MyApplication;
import com.malong.manaomall.di.component.MyApplicationComponent;
import com.malong.manaomall.presenter.BasePresenter;
import com.malong.manaomall.ui.BaseView;

import javax.inject.Inject;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Malong
 * on 18/6/21.
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView{

    private Unbinder bind;
    private MyApplication myApplication;
    private View mRootView;
    @Inject
    T mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(setLayout(), container, false);
        bind = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    /**
     * dagger2在fragment中注入需写在onActivityCreated方法中
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.myApplication = (MyApplication) getActivity().getApplication();
        setActivityComponent(myApplication.getMyApplicationComponent());
        init();

    }

    /**
     * 抽象类加载布局
     * @return
     */
    public abstract int setLayout();

    /**
     * 抽象类注入dagger2
     * @return
     */
    public abstract void setActivityComponent(MyApplicationComponent myApplicationComponent);

    /**
     * 抽象类绘制UI
     * @return
     */
    public abstract void init();

    /**
     * 页面销毁时取消绑定ButterKnife控件id
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bind != Unbinder.EMPTY) {
            bind.unbind();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError_Empty(String msg) {

    }

    @Override
    public void dismissLoading() {

    }

}
