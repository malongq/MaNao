package com.malong.manaomall.common.rx;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonParseException;
import com.malong.manaomall.common.exception.ApiException;
import com.malong.manaomall.common.exception.BaseException;
import com.malong.manaomall.common.exception.ErrorMessageFactory;

import java.net.SocketException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by Malong
 * on 18/6/25.
 * 错误相关的类
 */
public class RxErrorHandler {

    private Context mContext;

    public RxErrorHandler(Context context) {
        this.mContext = context;
    }

    //只实现onError方法
    public BaseException handleError(Throwable e) {

        BaseException exception = new BaseException();

        if (e instanceof ApiException){

            Log.d(exception+"马龙：  ", ((ApiException) e).getCode()+"");
            exception.setCode(((ApiException) e).getCode());

        }else if(e instanceof JsonParseException){

            exception.setCode(BaseException.JSON_ERROR);

        }else if(e instanceof HttpException){

            exception.setCode(((HttpException) e).code());

        }else if(e instanceof SocketTimeoutException){

            exception.setCode(BaseException.SOCKET_TIMEOUT_ERROR);

        }else if(e instanceof SocketException){

            exception.setCode(BaseException.SOCKET_ERROR);

        }else {

            exception.setCode(BaseException.UNKNOWN_ERROR);

        }

        exception.setDisplayMessage(ErrorMessageFactory.create(mContext,exception.getCode()));

        return exception;

    }


    public void showErrorMessage(BaseException e){
        Toast.makeText(mContext,e.getDisplayMessage(),Toast.LENGTH_SHORT).show();
    }

}
