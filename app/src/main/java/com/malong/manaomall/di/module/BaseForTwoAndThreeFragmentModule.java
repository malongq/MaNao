package com.malong.manaomall.di.module;


import com.malong.manaomall.data.AppInfoModel;
import com.malong.manaomall.data.http.ApiService;
import com.malong.manaomall.presenter.contract.AppInfoFragmentContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Malong
 * on 18/6/20.
 */

@Module//moudle必须要带@Module
public class BaseForTwoAndThreeFragmentModule {

    private AppInfoFragmentContract.BaseForTwoAndThreeFragmentView mView;

    //传过来view因为new OneFragmentPresenter和ProgressDialog都需要
    public BaseForTwoAndThreeFragmentModule(AppInfoFragmentContract.BaseForTwoAndThreeFragmentView view){
        this.mView = view;
    }

    //将view写一个方法，这样灵活一点
    @Provides
    public AppInfoFragmentContract.BaseForTwoAndThreeFragmentView providesView(){
        return mView;
    }

    //创建OneFragemntModel
    @Provides
    public AppInfoModel providesTwoFragemntModel(ApiService apiService){
        return new AppInfoModel(apiService);
    }

}
