package com.malong.manaomall.data.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Malong
 * on 18/6/14.
 * 网络请求管理类
 * <p>
 * 该类废弃，因为可以使用dagger去配置，单例化,节省开销
 */
public class TestHttpManager {

    //配置OKHttp3
    public OkHttpClient getOkHttpClient() {

        //log拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        //开发模式记录整个body，否则只记录基本信息 如返回200,http协议版本等
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //如果使用到HTTPS，需要创建SSLSoketFactory,并设置到client
//        SSLSocketFactory sslSocketFactory = null;

        return new OkHttpClient.Builder()

                //HeadInterceptor实现了Interceptor，用来往Request Header添加一些业务相关数据，如：APP版本，token信息等
//                .addInterceptor(new HeadInterceptor())
                //日志拦截信息
                .addInterceptor(logging)
                //链接超时时间设置
                .connectTimeout(10, TimeUnit.SECONDS)
                //读取超时时间设置
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    //配置Retrofit
    public Retrofit getRetrofit(OkHttpClient okHttpClient) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)//基类地址
                .addConverterFactory(GsonConverterFactory.create())//默认把服务端返回的数据转换成gson
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//rxjava配置
                .client(okHttpClient);
        return builder.build();
    }

}
