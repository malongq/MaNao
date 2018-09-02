package com.malong.manaomall;

import android.app.Application;
import android.content.Context;
import com.malong.manaomall.common.utils.IconUtils;
import com.malong.manaomall.di.component.DaggerMyApplicationComponent;
import com.malong.manaomall.di.component.MyApplicationComponent;
import com.malong.manaomall.di.module.HttpModule;
import com.malong.manaomall.di.module.MyApplicationModule;
import com.mikepenz.iconics.Iconics;

/**
 * Created by Malong
 * on 18/6/14.
 */
public class MyApplication extends Application{

    private MyApplicationComponent myApplicationComponet;

    public static MyApplication get(Context context){
        return (MyApplication) context.getApplicationContext();
    }

    public MyApplicationComponent getMyApplicationComponent() {
        return myApplicationComponet;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        myApplicationComponet = DaggerMyApplicationComponent.builder().myApplicationModule(new MyApplicationModule(this)).httpModule(new HttpModule()).build();

        /**
         * 注册android-svg-view
         */
        Iconics.init(getApplicationContext());
        Iconics.registerFont(new IconUtils());
    }
}
