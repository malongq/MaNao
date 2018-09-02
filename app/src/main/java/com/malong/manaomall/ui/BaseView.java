package com.malong.manaomall.ui;

/**
 * Created by Malong
 * on 18/6/15.
 * 1：先创建BaseView接口，并在里面加入所有请求的相同之处，比如网络请求的dialog打开和关闭
 */
public interface BaseView {

    void dismissLoading();//dialog关闭

    void showError_Empty(String msg);//加载错误

    void showLoading();//dialog打开
}
