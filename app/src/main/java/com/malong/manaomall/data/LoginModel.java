package com.malong.manaomall.data;

import com.malong.manaomall.bean.BaseBean;
import com.malong.manaomall.bean.LoginBean;
import com.malong.manaomall.bean.requestbean.LoginRequestBean;
import com.malong.manaomall.data.http.ApiService;

import rx.Observable;


/**
 * Created by Malong
 * on 18/7/16.
 * 登录页面Model
 */
public class LoginModel {

    private ApiService apiService;

    public LoginModel(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<BaseBean<LoginBean>> login(String phone, String pwd) {
        LoginRequestBean param = new LoginRequestBean();
        param.setEmail(phone);
        param.setPassword(pwd);
        return apiService.login(param);
    }
}
