package com.malong.manaomall.presenter;

import com.malong.manaomall.bean.OneFragmentIndexBean;
import com.malong.manaomall.common.rx.RxHttpResponseCompat;
import com.malong.manaomall.common.rx.subscriber.ProgressDialogSubscribe;
import com.malong.manaomall.data.AppInfoModel;
import com.malong.manaomall.presenter.contract.AppInfoFragmentContract;

import javax.inject.Inject;

/**
 * Created by Malong
 * on 18/6/15.
 * 4：在创建对应请求页面的Presenter类，实现第 3 步创建的该页面的Contract中的presenter接口
 * 创建该类的构造，将对应请求页面的Contract中的View接口传递过来
 * 并实现Contract中的presenter接口中的方法
 * 创建对应请求页面的Model类，并用该类调用请求方法
 * 其他代码后续根据需求添加
 */
public class OneFragmentPresenter extends BasePresenter<AppInfoModel, AppInfoFragmentContract.View> {


    @Inject
    public OneFragmentPresenter(AppInfoModel model, AppInfoFragmentContract.View mView) {
        super(model, mView);
    }


    //请求数据
    public void requestDatas() {

        model.getOneFragmentInfos().compose(RxHttpResponseCompat.<OneFragmentIndexBean>compatResult())
                .subscribe(new ProgressDialogSubscribe<OneFragmentIndexBean>(mContext) {
                    @Override
                    public void onNext(OneFragmentIndexBean oneFragmentIndexBean) {
                        mView.showRsult(oneFragmentIndexBean);
                    }
                });

    }

}









































































































//                .subscribe(new Subscriber<BaseBean<PageBean<AppInfo>>>() {//未封装之前的写法,为了解决想要的bean，在common包下创建rx包，里面写一个RxHttpResponseCompat方法
//
//                    @Override
//                    public void onStart() {
//                        mView.showLoading();
//                    }
//
//                    @Override
//                    public void onCompleted() {
//                        mView.dismissLoading();
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        mView.dismissLoading();
//                        mView.showError(t.getMessage().toString());
//                    }
//
//                    @Override
//                    public void onNext(BaseBean<PageBean<AppInfo>> response) {
//                        if (response != null && response.getDatas() != null && response.getDatas().size() > 0) {
//                            mView.showData(response.getDatas());
//                        } else {
//                            mView.showNoData();
//                        }
//                    }

//未封装之前的写法
//                    @Override
//                    public void onNext(PageBean<AppInfo> response) {
//                        if (response != null && response.getDatas() != null && response.getDatas().size() > 0) {
//                            mView.showData(response.getDatas());
//                        } else {
//                            mView.showNoData();
//                        }
//                    }

//                });


//不用RxJava写法
//        mView.showLoading();
//
//        model.getOneFragmentInfos(new Callback<PageBean<AppInfo>>() {
//            @Override
//            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {
//                if (response.body() != null) {
//                    mView.showData(response.body().getDatas());
//                } else {
//                    mView.showNoData();
//                }
//                mView.dismissLoading();
//            }
//
//            @Override
//            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {
//                mView.dismissLoading();
//                mView.showError(t.getMessage().toString());
//            }
//        });


