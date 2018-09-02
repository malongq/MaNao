package com.malong.manaomall.di.module;

import android.app.ProgressDialog;

import com.malong.manaomall.data.TestFragmentModel;
import com.malong.manaomall.data.http.ApiService;
import com.malong.manaomall.presenter.contract.TestFragmentContract;
import com.malong.manaomall.ui.fragment.TestFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Malong
 * on 18/6/20.
 */

@Module//moudle必须要带@Module
public class TestFragmentModule {

    private TestFragmentContract.View mView;

    //传过来view因为new OneFragmentPresenter和ProgressDialog都需要
    public TestFragmentModule(TestFragmentContract.View view){
        this.mView = view;
    }

    //将view写一个方法，这样灵活一点
    @Provides
    public TestFragmentContract.View providesView(){
        return mView;
    }

    //创建ProgressDialog
    @Provides
    public ProgressDialog providesProgressDialog(TestFragmentContract.View view){
        return new ProgressDialog(((TestFragment)view).getActivity());
    }

    //创建TestFragemntModel
    @Provides
    public TestFragmentModel providesTwoFragemntModel(ApiService apiService){
        return new TestFragmentModel(apiService);
    }

}
