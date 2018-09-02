package com.malong.manaomall.di.module;


import android.app.ProgressDialog;
import com.malong.manaomall.data.FourFragmentModel;
import com.malong.manaomall.data.http.ApiService;
import com.malong.manaomall.presenter.contract.FourFragmentContract;
import com.malong.manaomall.ui.fragment.AaFourFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Malong
 * on 18/7/16.
 */

@Module//moudle必须要带@Module
public class FourFragmentModule {

    private FourFragmentContract.FourFragmentView mView;

    //传过来view因为new XX Presenter和ProgressDialog都需要
    public FourFragmentModule(FourFragmentContract.FourFragmentView view){
        this.mView = view;
    }

    //将view写一个方法，这样灵活一点
    @Provides
    public FourFragmentContract.FourFragmentView providesView(){
        return mView;
    }

    //创建ProgressDialog
    @Provides
    public ProgressDialog providesProgressDialog(FourFragmentContract.FourFragmentView view){
        return new ProgressDialog(((AaFourFragment)view).getActivity());
    }

    //创建Model
    @Provides
    public FourFragmentModel providesModel(final ApiService apiService){
        return new FourFragmentModel(apiService);
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
