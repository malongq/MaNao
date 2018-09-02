package com.malong.manaomall.di.component;

import com.malong.manaomall.di.FragmentScope;
import com.malong.manaomall.di.module.FourFragmentModule;
import com.malong.manaomall.ui.fragment.AaFourFragment;

import dagger.Component;

/**
 * Created by Malong
 * on 18/7/18.
 */
                                            //dependencies依赖
@FragmentScope
@Component(modules = FourFragmentModule.class,dependencies = MyApplicationComponent.class)//这行代码使Model与Componet关联
public interface FourFragmentComponent {

    void inject(AaFourFragment aaFourFragment);//这行代码使Activity/Fragment与Componet关联

}
