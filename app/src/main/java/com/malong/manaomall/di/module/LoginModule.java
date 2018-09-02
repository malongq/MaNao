package com.malong.manaomall.di.module;


import android.app.ProgressDialog;
import com.malong.manaomall.data.LoginModel;
import com.malong.manaomall.data.http.ApiService;
import com.malong.manaomall.presenter.contract.LoginContract;
import com.malong.manaomall.ui.activity.LoginActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Malong
 * on 18/7/16.
 * 登录页面Module类
 */

@Module//moudle必须要带@Module
public class LoginModule {

    private LoginContract.LoginView mView;

    //传过来view因为new LoginPresenter和ProgressDialog都需要
    public LoginModule(LoginContract.LoginView view){
        this.mView = view;
    }

    //将view写一个方法，这样灵活一点
    @Provides
    public LoginContract.LoginView providesView(){
        return mView;
    }

    //创建ProgressDialog
    @Provides
    public ProgressDialog providesProgressDialog(LoginContract.LoginView view){
        return new ProgressDialog((LoginActivity)view);
    }

    //创建Model
    @Provides
    public LoginModel providesModel(final ApiService apiService){
        return new LoginModel(apiService);
    }

}





































//@Module//moudle必须要带@Module
//public class LoginModule {
//
//    private LoginContract.LoginView mView;
//
//    //传过来view因为new OneFragmentPresenter和ProgressDialog都需要
//    public LoginModule(LoginContract.LoginView view){
//        this.mView = view;
//    }
//
//    //将view写一个方法，这样灵活一点
//    @Provides
//    public LoginContract.LoginView providesView(){
//        return mView;
//    }
//
//    //创建ProgressDialog
//    @Provides
//    public ProgressDialog providesProgressDialog(LoginContract.LoginView view){
//        return new ProgressDialog((LoginActivity)view);
//    }
//
//    //创建Model
//    @Provides
//    public LoginContract.ILoginModel providesModel(final ApiService apiService){
//        return new LoginModel(apiService);
//    }
//
//}
