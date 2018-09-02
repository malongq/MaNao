package com.malong.manaomall.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.malong.manaomall.MyApplication;
import com.malong.manaomall.R;
import com.malong.manaomall.di.component.MyApplicationComponent;
import com.malong.manaomall.presenter.BasePresenter;
import com.malong.manaomall.ui.BaseView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Malong
 * on 18/6/28.
 * 统一的请求状态（正常、加载中、出错、无网络）页面设置类
 */
public abstract class ProgressFragment<T extends BasePresenter> extends Fragment implements BaseView {

    private FrameLayout mRoot_view;


    private View view_loading;//加载中布局

    private FrameLayout view_content;//加载成功布局

    private View view_error_empty;//加载失败布局
    private ImageView view_img;//加载失败图片
    private TextView tv_error_empty;//加载失败文案

    private MyApplication myApplication;

    private Unbinder bind;

    @Inject
    T mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot_view = (FrameLayout) inflater.inflate(R.layout.aa_common_status, container, false);

        view_loading = mRoot_view.findViewById(R.id.view_loading);//加载中布局
        view_content = mRoot_view.findViewById(R.id.view_content);//加载成功布局
        view_error_empty = mRoot_view.findViewById(R.id.view_error_empty);//加载失败布局
        view_img = mRoot_view.findViewById(R.id.view_img);//加载失败图片
        tv_error_empty = mRoot_view.findViewById(R.id.tv_error_empty);//加载失败文案

        view_error_empty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //重新加载数据
                reloadEmptyOrNoWifi();
            }
        });

        return mRoot_view;
    }

    //重新加载数据
    public void reloadEmptyOrNoWifi() {

    }


    /**
     * 放置成功的各种布局，切记放到该方法里面，要不然有时会请求还没成功就会绘制UI，防止报错
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.myApplication = (MyApplication) getActivity().getApplication();
        setActivityComponent(myApplication.getMyApplicationComponent());

        setContentView();

        init();

    }

    /**
     * 抽象类绘制UI
     *
     * @return
     */
    public abstract void init();

    /**
     * 抽象类注入dagger2
     *
     * @return
     */
    public abstract void setActivityComponent(MyApplicationComponent myApplicationComponent);

    //放成功后的真正VIEW
    private void setContentView() {

        View real_content_view = LayoutInflater.from(getActivity()).inflate(setLayout(), view_content, true);//true代表把加载后的布局放到view_centent里面
        bind = ButterKnife.bind(this, real_content_view);
    }

    //抽象方法，放成功后的各种布局
    public abstract int setLayout();

    /**
     * 下面三个方法是展示不同的三种状态
     */
    //展示加载中
    public void showProgressView() {
        showTrueView(R.id.view_loading);

    }

    //展示加载成功后的view
    public void showContentView() {
        showTrueView(R.id.view_content);
    }


    //展示加载失败
    public void showEmptyView() {
        showTrueView(R.id.view_error_empty);
    }

    //为了展示不通加载失败原因--1
    public void showEmptyView(int resId) {
        showEmptyView();
        tv_error_empty.setText(resId);
    }

    //为了展示不通加载失败原因--2
    public void showEmptyView(String message) {
        showEmptyView();
        tv_error_empty.setText(message);
    }

    //写一个方法减少重复代码，显示隐藏页面
    public void showTrueView(int viewId) {
        int childCount = mRoot_view.getChildCount();
        //通过for循环拿到每一个子view
        for (int i = 0; i < childCount; i++) {
            if (mRoot_view.getChildAt(i).getId() == viewId) {//判断如果是匹配的id就显示出来该页面，否则隐藏
                mRoot_view.getChildAt(i).setVisibility(View.VISIBLE);
            } else {
                mRoot_view.getChildAt(i).setVisibility(View.GONE);
            }
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bind != Unbinder.EMPTY) {
            bind.unbind();
        }
    }

    @Override
    public void showLoading() {
        showProgressView();
    }

    @Override
    public void showError_Empty(String msg) {
        showEmptyView(msg);
    }

    @Override
    public void dismissLoading() {
        showContentView();
    }
}
