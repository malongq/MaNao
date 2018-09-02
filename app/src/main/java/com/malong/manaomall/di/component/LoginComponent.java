package com.malong.manaomall.di.component;

import com.malong.manaomall.di.FragmentScope;
import com.malong.manaomall.di.module.LoginModule;
import com.malong.manaomall.ui.activity.LoginActivity;

import dagger.Component;

/**
 * Created by Malong
 * on 18/7/16.
 * 使LoginModule与LoginActivity关联
 */
                                            //dependencies依赖
@FragmentScope
@Component(modules = LoginModule.class,dependencies = MyApplicationComponent.class)//这行代码使LoginModel与LoginComponet关联
public interface LoginComponent {

    void inject(LoginActivity loginActivity);//这行代码使LoginActivity与LoginComponet关联

}
