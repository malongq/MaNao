package com.malong.manaomall.di.component;

import com.malong.manaomall.MyApplication;
import com.malong.manaomall.common.rx.RxErrorHandler;
import com.malong.manaomall.data.http.ApiService;
import com.malong.manaomall.di.module.HttpModule;
import com.malong.manaomall.di.module.MyApplicationModule;
import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by Malong
 * on 18/6/20.
 */
@Singleton
@Component(modules = { MyApplicationModule.class, HttpModule.class })
public interface MyApplicationComponent {

    public ApiService getApiService();
    public MyApplication getMyApplication();
    public RxErrorHandler getRxErrorHandler();

}
