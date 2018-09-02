package com.malong.manaomall.presenter;

import android.Manifest;
import android.app.Activity;

import com.malong.manaomall.bean.AppInfo;
import com.malong.manaomall.bean.PageBean;
import com.malong.manaomall.common.rx.RxHttpResponseCompat;
import com.malong.manaomall.common.rx.subscriber.ProgressDialogSubscribe;
import com.malong.manaomall.common.rx.subscriber.ProgressSubscribe;
import com.malong.manaomall.data.TestFragmentModel;
import com.malong.manaomall.presenter.contract.TestFragmentContract;
import com.tbruyelle.rxpermissions.RxPermissions;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Malong
 * on 18/7/5.
 * 4：在创建对应请求页面的Presenter类，实现第 3 步创建的该页面的Contract中的presenter接口
 * 创建该类的构造，将对应请求页面的Contract中的View接口传递过来
 * 并实现Contract中的presenter接口中的方法
 * 创建对应请求页面的Model类，并用该类调用请求方法
 * 其他代码后续根据需求添加
 */
public class TestFragmentPresenter extends BasePresenter<TestFragmentModel, TestFragmentContract.View> {


    @Inject
    public TestFragmentPresenter(TestFragmentModel model, TestFragmentContract.View mView) {
        super(model, mView);
    }

    /*public void requestPermission(){
        RxPermissions rxPermissions = new RxPermissions((Activity) mContext);
        rxPermissions.request(Manifest.permission.CAMERA)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean){
                            mView.requestPermissionSuccess();
                        }else {
                            mView.requestPermissionFaield();
                        }
                    }
                });
    }*/

    public void requestDatas() {

        // TODO: 18/7/5 RxPermissions + RxJava版本  这是显示弹窗dialog
//        RxPermissions rxPermissions = new RxPermissions((Activity) mContext);
//        rxPermissions
//                .request(Manifest.permission.CAMERA)
//                .flatMap(new Func1<Boolean, Observable<PageBean<AppInfo>>>() {
//                    @Override
//                    public Observable<PageBean<AppInfo>> call(Boolean aBoolean) {
//                        if (aBoolean){
//                            return model.getTestFragmentInfos().compose(RxHttpResponseCompat.<PageBean<AppInfo>>compatResult());
//                        }else {
//                            return Observable.empty();
//                        }
//                    }
//                }).subscribe(new ProgressDialogSubscribe<PageBean<AppInfo>>(mContext) {
//            @Override
//            public void onNext(PageBean<AppInfo> bean) {
//                if (bean != null && bean.getDatas() != null && bean.getDatas().size() > 0) {
//                    mView.showData(bean.getDatas());
//                } else {
//                    mView.showNoData();
//                }
//            }
//        });


        // TODO: 18/7/5 RxPermissions + RxJava版本  这不是显示弹窗dialog
        RxPermissions rxPermissions = new RxPermissions((Activity) mContext);
        rxPermissions
                .request(Manifest.permission.CAMERA)
                .flatMap(new Func1<Boolean, Observable<PageBean<AppInfo>>>() {
                    @Override
                    public Observable<PageBean<AppInfo>> call(Boolean aBoolean) {
                        if (aBoolean) {
                            return model.getTestFragmentInfos().compose(RxHttpResponseCompat.<PageBean<AppInfo>>compatResult());
                        } else {
                            return Observable.empty();
                        }
                    }
                }).subscribe(new ProgressSubscribe<PageBean<AppInfo>>(mContext, mView) {
            @Override
            public void onNext(PageBean<AppInfo> bean) {
                if (bean != null && bean.getDatas() != null && bean.getDatas().size() > 0) {
                    mView.showData(bean.getDatas());
                } else {
                    mView.showNoData();
                }
            }
        });


        // TODO: 18/6/23 RxJava版本
        /*model.getOneFragmentInfos()
                .compose(RxHttpResponseCompat.<PageBean<AppInfo>>compatResult())
                .subscribe(new ProgressSubscribe<PageBean<AppInfo>>(mContext, mView) {
                    @Override
                    public void onNext(PageBean<AppInfo> bean) {
                        if (bean != null && bean.getDatas() != null && bean.getDatas().size() > 0) {
                            mView.showData(bean.getDatas());
                        } else {
                            mView.showNoData();
                        }
                    }
                });*/
    }

}
