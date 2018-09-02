package com.malong.manaomall.ui.fragment;

import android.app.ProgressDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.malong.manaomall.R;
import com.malong.manaomall.bean.AppInfo;
import com.malong.manaomall.di.component.DaggerTestFragmentComponent;
import com.malong.manaomall.di.component.MyApplicationComponent;
import com.malong.manaomall.di.module.TestFragmentModule;
import com.malong.manaomall.presenter.TestFragmentPresenter;
import com.malong.manaomall.presenter.contract.TestFragmentContract;
import com.malong.manaomall.ui.adapter.TestFragmentAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Malong
 * on 18/6/13.
 * 测试fragment,内有很多雏形，不可删除
 */
public class TestFragment extends ProgressFragment<TestFragmentPresenter> implements TestFragmentContract.View{


    @BindView(R.id.recycle_view)
    RecyclerView recycleView;

    private TestFragmentAdapter testFragmentAdapter;

    @Inject
    ProgressDialog dialog;

    /**
     * 加载布局
     *
     * @return
     */
    @Override
    public int setLayout() {
        return R.layout.fragemnt_test;
    }

    /**
     * dagger2依赖注入
     *
     * @param myApplicationComponent
     */
    @Override
    public void setActivityComponent(MyApplicationComponent myApplicationComponent) {

        DaggerTestFragmentComponent.builder()
                .myApplicationComponent(myApplicationComponent)
                .testFragmentModule(new TestFragmentModule(this))
                .build()
                .inject(this);
    }

    /**
     * 请求数据
     */
    @Override
    public void init() {
//        mPresenter.requestPermission();
        mPresenter.requestDatas();
    }

    /**
     * 请求成功
     */
    @Override
    public void showData(List<AppInfo> datas) {
        //加载数据
        initRecyclerView(datas);
    }

    /**
     * 加载数据
     */
    private void initRecyclerView(List<AppInfo> datas) {

        //创建twoFragmentAdapter
        testFragmentAdapter = new TestFragmentAdapter(getActivity(), datas);
        //设置布局管理器
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置分割线，DividerItemDecoration可以自定义
        recycleView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
        //设置动画
        recycleView.setItemAnimator(new DefaultItemAnimator());
        //绑定设置
        recycleView.setAdapter(testFragmentAdapter);

    }

    /**
     * 请求数据为空
     */
    @Override
    public void showNoData() {
        Toast.makeText(getActivity(), "暂无数据", Toast.LENGTH_SHORT).show();
    }

    /**
     * 请求数据出错
     */
    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(), "出错了  " + msg.toString(), Toast.LENGTH_SHORT).show();
    }

    /*@Override
    public void requestPermissionSuccess() {
        mPresenter.requestDatas();
    }

    @Override
    public void requestPermissionFaield() {
        Toast.makeText(getActivity(), "拒绝授权！", Toast.LENGTH_SHORT).show();
    }*/

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
