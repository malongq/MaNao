package com.malong.manaomall.presenter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.malong.manaomall.ui.BaseView;

/**
 * Created by Malong
 * on 18/6/15.
 * 2：在创建BasePresenter接口，里面不做任何代码
 */
public class BasePresenter<M,V extends BaseView> {

    protected M model;
    protected V mView;

    protected Context mContext;

    public BasePresenter(M model, V mView) {
        this.model = model;
        this.mView = mView;
        initContext();
    }

    private void initContext(){
        if(mView instanceof Fragment){
            mContext = ((Fragment) mView).getActivity();
        }else{
            mContext = (Activity) mView;
        }
    }

}
