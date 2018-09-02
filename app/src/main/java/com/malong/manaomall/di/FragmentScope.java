package com.malong.manaomall.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Scope;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Malong
 * on 18/6/20.
 * 定义一个级别较低的Scope
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface FragmentScope {

}
