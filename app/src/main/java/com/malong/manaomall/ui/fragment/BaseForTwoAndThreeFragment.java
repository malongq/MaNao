package com.malong.manaomall.ui.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.malong.manaomall.R;
import com.malong.manaomall.bean.AppInfo;
import com.malong.manaomall.bean.PageBean;
import com.malong.manaomall.presenter.BaseForTwoAndThreeFragmentPresenter;
import com.malong.manaomall.presenter.contract.AppInfoFragmentContract;
import com.malong.manaomall.ui.adapter.OneFragmentChildAdapter;

import butterknife.BindView;

/**
 * Created by Malong
 * on 18/7/13.
 */
public abstract class BaseForTwoAndThreeFragment extends ProgressFragment<BaseForTwoAndThreeFragmentPresenter>
        implements AppInfoFragmentContract.BaseForTwoAndThreeFragmentView
        , BaseQuickAdapter.RequestLoadMoreListener {




    @BindView(R.id.recycle_view)
    RecyclerView recycleView;

    int page = 0;

    private OneFragmentChildAdapter oneFragmentChildAdapter;

    @Override
    public void init() {

        mPresenter.requestDatas(type(), page);

        initRecyclerView();

    }

    private void initRecyclerView() {

        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recycleView.addItemDecoration(dividerItemDecoration);

//        oneFragmentChildAdapter = new OneFragmentChildAdapter();//建造者模式后，改为下面代码
        oneFragmentChildAdapter = buildAdapter();

        oneFragmentChildAdapter.setOnLoadMoreListener(this,recycleView);

        recycleView.setAdapter(oneFragmentChildAdapter);

    }

    // TODO: 18/7/13  adapter提供抽象方法给子类去实现
    abstract OneFragmentChildAdapter buildAdapter();

    // TODO: 18/7/13  type提供抽象方法给子类去实现
    abstract int type();

    @Override
    public int setLayout() {
        return R.layout.templete_fragemnt_recycler_view;
    }

    @Override
    public void showRsult2(final PageBean<AppInfo> bean) {

        oneFragmentChildAdapter.addData(bean.getDatas());

        if (bean.isHasMore()) {
            page++;
        }

        oneFragmentChildAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getActivity(),bean.getDatas().get(position).getDisplayName(),Toast.LENGTH_SHORT).show();
            }
        });

        oneFragmentChildAdapter.setEnableLoadMore(bean.isHasMore());

    }

    /**
     * 加载完毕
     */
    @Override
    public void onLoadDataComplete() {

        oneFragmentChildAdapter.loadMoreComplete();

    }

    /**
     * 上拉加载更多实现方法
     */
    @Override
    public void onLoadMoreRequested() {

        mPresenter.requestDatas(type(),page);

    }

}
