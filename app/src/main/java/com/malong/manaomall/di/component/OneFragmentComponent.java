package com.malong.manaomall.di.component;

import com.malong.manaomall.di.FragmentScope;
import com.malong.manaomall.di.module.OneFragmentModule;
import com.malong.manaomall.ui.fragment.AaOneFragment;

import dagger.Component;

/**
 * Created by Malong
 * on 18/6/20.
 * 使OneFragemntModel与OneFragmnet关联
 */
                                            //dependencies依赖
@FragmentScope
@Component(modules = OneFragmentModule.class,dependencies = MyApplicationComponent.class)//这行代码使OneFragemntModel与OneFragmentComponet关联
public interface OneFragmentComponent {

    void inject(AaOneFragment fragmnet);//这行代码使OneFragmnet与OneFragmentComponet

}
