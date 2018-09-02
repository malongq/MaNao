package com.malong.manaomall.di.component;

import com.malong.manaomall.di.FragmentScope;
import com.malong.manaomall.di.module.TestFragmentModule;
import com.malong.manaomall.ui.fragment.TestFragment;

import dagger.Component;

/**
 * Created by Malong
 * on 18/6/20.
 * 使OneFragemntModel与OneFragmnet关联
 */
                                            //dependencies依赖
@FragmentScope
@Component(modules = TestFragmentModule.class,dependencies = MyApplicationComponent.class)//这行代码使TestFragemntModel与TestFragmentComponet关联
public interface TestFragmentComponent {

    void inject(TestFragment fragmnet);//这行代码使TestFragment与TestFragmentComponet关联

}
