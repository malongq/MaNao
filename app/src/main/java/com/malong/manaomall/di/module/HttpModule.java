package com.malong.manaomall.di.module;

import android.content.Context;

import com.google.gson.Gson;
import com.malong.manaomall.MyApplication;
import com.malong.manaomall.common.okhttp.CommonParamsInterceptor;
import com.malong.manaomall.common.rx.RxErrorHandler;
import com.malong.manaomall.data.http.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Malong
 * on 18/6/20.
 */

@Module
public class HttpModule {

    @Provides//配置OKHttp3
    @Singleton
    public OkHttpClient providesOkHttpClient(MyApplication myApplication, Gson gson) {

        //log拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        //开发模式记录整个body，否则只记录基本信息 如返回200,http协议版本等
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //如果使用到HTTPS，需要创建SSLSoketFactory,并设置到client
//        SSLSocketFactory sslSocketFactory = null;

        return new OkHttpClient.Builder()

                //CommonParamsInterceptor，用来往Request Header添加一些业务相关数据，如：APP版本，token信息等
                //添加head头部公共参数
                .addInterceptor(new CommonParamsInterceptor(myApplication,gson))
                //日志拦截信息
                .addInterceptor(logging)
                //链接超时时间设置
                .connectTimeout(10, TimeUnit.SECONDS)
                //读取超时时间设置
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

    }

    @Provides//配置Retrofit
    @Singleton
    public Retrofit providesRetrofit(OkHttpClient okHttpClient) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)//基类地址
                .addConverterFactory(GsonConverterFactory.create())//默认把服务端返回的数据转换成gson
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//rxjava配置
                .client(okHttpClient);
        return builder.build();

    }


    @Provides
    @Singleton
    public ApiService providesApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    public RxErrorHandler providesRxErrorHandler(MyApplication myApplication){
        return new RxErrorHandler(myApplication);
    }


}
