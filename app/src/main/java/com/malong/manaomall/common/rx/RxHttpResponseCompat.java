package com.malong.manaomall.common.rx;


import com.malong.manaomall.bean.BaseBean;
import com.malong.manaomall.common.exception.ApiException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Malong
 * on 18/6/25.
 * 返回预处理类
 */
public class RxHttpResponseCompat {

    public static <T> Observable.Transformer<BaseBean<T>, T> compatResult() {
        return new Observable.Transformer<BaseBean<T>, T>() {
            @Override
            public Observable<T> call(Observable<BaseBean<T>> baseBeanObservable) {


                return baseBeanObservable.flatMap(new Func1<BaseBean<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(final BaseBean<T> tBaseBean) {

                        if (tBaseBean.success()) {

                            //成功里面写
                          return Observable.create(new Observable.OnSubscribe<T>() {
                                @Override
                                public void call(Subscriber<? super T> subscriber) {


                                    //左一层错误处理，加try catch
                                    try {
                                        subscriber.onNext(tBaseBean.getData());
                                        subscriber.onCompleted();
                                    } catch (Exception e) {
                                        subscriber.onError(e);
                                    }

                                }
                            });

                        } else {
                            return Observable.error(new ApiException(tBaseBean.getStatus(), tBaseBean.getMessage()));//为了要抛出异常，创建expection包，里面一个基类expection,一个apiexpection
                        }
                    }
                }).subscribeOn(Schedulers.io())//切换到子线程--改变调用它之前代码的线程
                  .observeOn(AndroidSchedulers.mainThread());//切换到主线程--改变调用它之后代码的线程);
            }
        };
    }
}
