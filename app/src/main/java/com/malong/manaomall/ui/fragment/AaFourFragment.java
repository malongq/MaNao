package com.malong.manaomall.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.malong.manaomall.R;
import com.malong.manaomall.bean.Category;
import com.malong.manaomall.common.Constant;
import com.malong.manaomall.di.component.DaggerFourFragmentComponent;
import com.malong.manaomall.di.component.MyApplicationComponent;
import com.malong.manaomall.di.module.FourFragmentModule;
import com.malong.manaomall.presenter.FourFragmentPresenter;
import com.malong.manaomall.presenter.contract.FourFragmentContract;
import com.malong.manaomall.ui.activity.CategoryListActivity;
import com.malong.manaomall.ui.adapter.FourFragmentAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Malong
 * on 18/6/13.
 * 主页第四个fragment
 */
public class AaFourFragment extends ProgressFragment<FourFragmentPresenter> implements FourFragmentContract.FourFragmentView {


    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    private FourFragmentAdapter fourAdapter;

    @Override
    public int setLayout() {
        return R.layout.templete_fragemnt_recycler_view;
    }

    @Override
    public void setActivityComponent(MyApplicationComponent myApplicationComponent) {

        DaggerFourFragmentComponent.builder().myApplicationComponent(myApplicationComponent).fourFragmentModule(new FourFragmentModule(this)).build().inject(this);

    }

    @Override
    public void init() {

        initRecyclerView();
        mPresenter.requestDatas();

    }

    //初始化recycleView
    private void initRecyclerView() {

        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recycleView.addItemDecoration(dividerItemDecoration);
        fourAdapter = new FourFragmentAdapter();
        recycleView.setAdapter(fourAdapter);

        //条目点击事件方法
        recycleView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                //点击进入第四个页面的分类列表
                Intent intent = new Intent(getActivity(),CategoryListActivity.class);
                intent.putExtra(Constant.CATRGORY,fourAdapter.getData().get(position));
                startActivity(intent);
            }
        });
    }


    /**
     * 数据请求成功
     *
     * @param categories
     */
    @Override
    public void showData(List<Category> categories) {

        fourAdapter.addData(categories);

    }

}
