package com.malong.manaomall.di.module;

import com.google.gson.Gson;
import com.malong.manaomall.MyApplication;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Malong
 * on 18/6/20.
 */

@Module
public class MyApplicationModule {

    private MyApplication myApplication;

    public MyApplicationModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    //创建全局引用context
    @Provides
    @Singleton//因为是单例，所以要加上
    public MyApplication providesMyApplicationModule(){
        return myApplication;
    }

    //创建gson
    @Provides
    @Singleton//因为是单例，所以要加上
    public Gson providesGson(){
        return new Gson();
    }

}
