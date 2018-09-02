package com.malong.manaomall.common.rx.subscriber;

import android.content.Context;
import com.malong.manaomall.common.utils.ProgressDialogHandler;

/**
 * Created by Malong
 * on 18/6/26.
 * 封装统一的dialog请求加载ui
 */
public abstract class ProgressDialogSubscribe<T> extends ErrorHandlerSubscriber<T> implements ProgressDialogHandler.OnProgressCancelListener{

    private ProgressDialogHandler mProgressDialogHandler;

    public ProgressDialogSubscribe(Context context) {
        super(context);
        mProgressDialogHandler = new ProgressDialogHandler(context,true,this);
    }

    protected boolean isShowDialog() {
        return true;
    }

    @Override
    public void onCancelProgress() {
        unsubscribe();
    }

    @Override
    public void onStart() {
        if (isShowDialog()) {
            this.mProgressDialogHandler.showProgressDialog();
        }
    }

    @Override
    public void onCompleted() {
        if (isShowDialog()) {
            this.mProgressDialogHandler.dismissProgressDialog();
        }
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        if (isShowDialog()) {
            this.mProgressDialogHandler.dismissProgressDialog();
        }
    }

}
