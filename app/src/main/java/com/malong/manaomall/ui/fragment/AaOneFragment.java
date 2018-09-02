package com.malong.manaomall.ui.fragment;

import android.app.ProgressDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.malong.manaomall.R;
import com.malong.manaomall.bean.OneFragmentIndexBean;
import com.malong.manaomall.di.component.DaggerOneFragmentComponent;
import com.malong.manaomall.di.component.MyApplicationComponent;
import com.malong.manaomall.di.module.OneFragmentModule;
import com.malong.manaomall.presenter.OneFragmentPresenter;
import com.malong.manaomall.presenter.contract.AppInfoFragmentContract;
import com.malong.manaomall.ui.adapter.OneFragmentAdapter;

import javax.inject.Inject;
import butterknife.BindView;

/**
 * Created by Malong
 * on 18/6/13.
 * 主页第一个fragment
 */
public class AaOneFragment extends ProgressFragment<OneFragmentPresenter> implements AppInfoFragmentContract.View {

    @BindView(R.id.recycle_view)
    RecyclerView recycleView;

    private OneFragmentAdapter oneFragmentAdapter;

    @Inject
    ProgressDialog dialog;

    /**
     * 加载布局
     */
    @Override
    public int setLayout() {
        return R.layout.templete_fragemnt_recycler_view;
    }

    /**
     * dagger2依赖注入
     */
    @Override
    public void setActivityComponent(MyApplicationComponent myApplicationComponent) {

        DaggerOneFragmentComponent.builder()
                .myApplicationComponent(myApplicationComponent)
                .oneFragmentModule(new OneFragmentModule(this))
                .build()
                .inject(this);
    }

    /**
     * 请求数据
     */
    @Override
    public void init() {

        initRecyclerView();

        mPresenter.requestDatas();

    }

    /**
     * 请求成功
     */
    @Override
    public void showRsult(OneFragmentIndexBean datas) {

        //创建twoFragmentAdapter
        oneFragmentAdapter = new OneFragmentAdapter(getActivity());

        //加载数据
        oneFragmentAdapter.setData(datas);

        //绑定设置
        recycleView.setAdapter(oneFragmentAdapter);

    }

    /**
     * 加载数据
     */
    private void initRecyclerView() {


        //设置布局管理器
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置动画
        recycleView.setItemAnimator(new DefaultItemAnimator());

    }


    /**
     * 错误或无网络点击重新加载
     */
    @Override
    public void reloadEmptyOrNoWifi() {
        mPresenter.requestDatas();
    }

    @Override
    public void showError_Empty(String msg) {
        showEmptyView(msg);
    }

}
