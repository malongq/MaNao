package com.malong.manaomall.presenter;

import android.util.Log;

import com.hwangjr.rxbus.RxBus;
import com.malong.manaomall.bean.LoginBean;
import com.malong.manaomall.common.Constant;
import com.malong.manaomall.common.rx.RxHttpResponseCompat;
import com.malong.manaomall.common.rx.subscriber.ErrorHandlerSubscriber;
import com.malong.manaomall.common.rx.subscriber.ProgressSubscribe;
import com.malong.manaomall.common.utils.ACache;
import com.malong.manaomall.common.utils.VerificationUtils;
import com.malong.manaomall.data.LoginModel;
import com.malong.manaomall.presenter.contract.LoginContract;

import javax.inject.Inject;

/**
 * Created by Malong
 * on 18/7/16.
 * 登录页面Presenter
 */
public class LoginPresenter extends BasePresenter<LoginModel, LoginContract.LoginView> {

    @Inject
    public LoginPresenter(LoginModel model, LoginContract.LoginView mView) {
        super(model, mView);
    }


    public void loginRequest(String phone, String pwd) {


        Log.d("用户账号  phone =  ", phone);
        Log.d("用户密码  pwd =  ", pwd);

        //先校验账号是否符合规则
        if (!VerificationUtils.matcherPhoneNum(phone)) {
            mView.checkPhoneError();
            return;
        } else {
            mView.checkPhoneSuccess();
        }
        //先校验密码是否符合规则
        if (!VerificationUtils.matcherPassword(pwd)) {
            mView.checkPwdError();
            return;
        } else {
            mView.checkPwdSuccess();
        }

        model.login(phone, pwd).compose(RxHttpResponseCompat.<LoginBean>compatResult())
                .subscribe(new ErrorHandlerSubscriber<LoginBean>(mContext) {

                    @Override
                    public void onStart() {

                        mView.showLoading();
                    }

                    @Override
                    public void onCompleted() {
                        mView.dismissLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
//                        super.onError(e);
                        mView.loginError();
                        mView.dismissLoading();
                    }

                    @Override
                    public void onNext(LoginBean bean) {
                        mView.loginSuccess(bean);
                        saveTokenAndUser(bean);//保存token和用户信息

                        RxBus.get().post(bean.getUser());//将获取到信息，传给用户头像部分，更新UI---mainActivity是接收者，这是发送方
                    }
                });

    }


    //保存token和用户信息
    private void saveTokenAndUser(LoginBean bean) {
        ACache aCache = ACache.get(mContext);
        aCache.put(Constant.TOKEN, bean.getToken());
        aCache.put(Constant.USER, bean.getUser());
    }


}
