package com.malong.manaomall.di.module;

import android.app.ProgressDialog;

import com.malong.manaomall.data.AppInfoModel;
import com.malong.manaomall.data.http.ApiService;
import com.malong.manaomall.presenter.contract.AppInfoFragmentContract;
import com.malong.manaomall.ui.fragment.AaOneFragment;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Malong
 * on 18/6/20.
 */

@Module//moudle必须要带@Module
public class OneFragmentModule {

    private AppInfoFragmentContract.View mView;

    //传过来view因为new OneFragmentPresenter和ProgressDialog都需要
    public OneFragmentModule(AppInfoFragmentContract.View view){
        this.mView = view;
    }

    //将view写一个方法，这样灵活一点
    @Provides
    public AppInfoFragmentContract.View providesView(){
        return mView;
    }

    //创建ProgressDialog
    @Provides
    public ProgressDialog providesProgressDialog(AppInfoFragmentContract.View view){
        return new ProgressDialog(((AaOneFragment)view).getActivity());
    }

    //创建OneFragemntModel
    @Provides
    public AppInfoModel providesOneFragemntModel(ApiService apiService){
        return new AppInfoModel(apiService);
    }

}
