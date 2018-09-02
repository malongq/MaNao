package com.malong.manaomall.di.component;

import com.malong.manaomall.di.FragmentScope;
import com.malong.manaomall.di.module.BaseForTwoAndThreeFragmentModule;
import com.malong.manaomall.ui.fragment.AaThreeFragment;
import com.malong.manaomall.ui.fragment.AaTwoFragment;

import dagger.Component;

/**
 * Created by Malong
 * on 18/6/20.
 * 使OneFragemntModel与OneFragmnet关联
 */
                                            //dependencies依赖
@FragmentScope
@Component(modules = BaseForTwoAndThreeFragmentModule.class,dependencies = MyApplicationComponent.class)//这行代码使OneFragemntModel与OneFragmentComponet关联
public interface BaseForTwoAndThreeFragmentComponent {

    // TODO: 18/7/13 废弃，改为各自注入
//    void inject(AaTwoFragment fragmnet);//这行代码使AaTwoFragment与TwoFragmentComponent关联

    void injectAaTwoFragment(AaTwoFragment fragmnet);
    void injectAaThreeFragment(AaThreeFragment fragmnet);

}
