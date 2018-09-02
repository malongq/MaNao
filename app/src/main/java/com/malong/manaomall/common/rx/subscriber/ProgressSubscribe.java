package com.malong.manaomall.common.rx.subscriber;

import android.content.Context;

import com.malong.manaomall.common.exception.BaseException;
import com.malong.manaomall.common.utils.ProgressDialogHandler;
import com.malong.manaomall.ui.BaseView;

/**
 * Created by Malong
 * on 18/6/28.
 * 封装统一的dialog请求加载ui
 */
public abstract class ProgressSubscribe<T> extends ErrorHandlerSubscriber<T> implements ProgressDialogHandler.OnProgressCancelListener {


    private BaseView mView;

    public ProgressSubscribe(Context context, BaseView view) {
        super(context);
        this.mView = view;
    }

    protected boolean isShowProgressDialog() {
        return true;
    }

    @Override
    public void onCancelProgress() {
        unsubscribe();
    }

    @Override
    public void onStart() {
        if (isShowProgressDialog()) {
            mView.showLoading();
        }
    }

    @Override
    public void onCompleted() {
        mView.dismissLoading();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        BaseException baseException = rxErrorHandler.handleError(e);
        if (isShowProgressDialog()) {
            mView.showError_Empty(baseException.getDisplayMessage());
        }
    }

}
