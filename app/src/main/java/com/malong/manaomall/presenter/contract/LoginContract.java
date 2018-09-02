package com.malong.manaomall.presenter.contract;

import com.malong.manaomall.bean.LoginBean;
import com.malong.manaomall.ui.BaseView;


/**
 * Created by Malong
 * on 18/7/16.
 * 登录页面Contract
 */
public interface LoginContract {

    interface LoginView extends BaseView{

        void checkPhoneError();
        void checkPhoneSuccess();
        void checkPwdError();
        void checkPwdSuccess();
        void loginSuccess(LoginBean loginBean);
        void loginError();

    }

}
