package com.malong.manaomall.common.rx.subscriber;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.malong.manaomall.common.exception.BaseException;
import com.malong.manaomall.common.rx.RxErrorHandler;
import com.malong.manaomall.ui.activity.LoginActivity;

/**
 * Created by Malong
 * on 18/6/25.
 * 错误处理子类
 */
public abstract class ErrorHandlerSubscriber<T> extends DefualtSubscribe<T> {

    public RxErrorHandler rxErrorHandler = null;
    protected Context context;

    public ErrorHandlerSubscriber(Context context) {
        this.context = context;
        rxErrorHandler = new RxErrorHandler(context);
    }

    //只实现onError方法
    @Override
    public void onError(Throwable e) {

        BaseException baseException = rxErrorHandler.handleError(e);

        if (baseException == null) {

            e.printStackTrace();
            Log.e("ErrorHandlerSubscriber类", e.getMessage());

        } else {

            rxErrorHandler.showErrorMessage(baseException);
            if (baseException.getCode() == BaseException.ERROR_TOKEN){
                //token失效则跳到登录页面
                toLogin();
            }

        }

    }

    //token失效则跳到登录页面
    private void toLogin(){
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

}
