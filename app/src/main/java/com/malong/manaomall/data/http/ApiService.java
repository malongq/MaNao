package com.malong.manaomall.data.http;

import com.malong.manaomall.bean.AppInfo;
import com.malong.manaomall.bean.BaseBean;
import com.malong.manaomall.bean.Category;
import com.malong.manaomall.bean.LoginBean;
import com.malong.manaomall.bean.OneFragmentIndexBean;
import com.malong.manaomall.bean.PageBean;
import com.malong.manaomall.bean.requestbean.LoginRequestBean;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Malong
 * on 18/6/14.
 * api地址类
 */
public interface ApiService {

    //基础地址
    public static final String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";


    /**
     * 首页-爱智康
     * @return
     */
    @GET("index")
    public Observable<BaseBean<OneFragmentIndexBean>> getOneFragmentInfos();//get请求

    /**
     * 第二页-学而思
     * @return
     */
    @GET("toplist")
    public Observable<BaseBean<PageBean<AppInfo>>> getTwoFragmentInfos(@Query("page") int page);//get请求

    /**
     * 第三页-妈妈帮
     * @return
     */
    @GET("game")
    public Observable<BaseBean<PageBean<AppInfo>>> getThreeFragmentInfos(@Query("page") int page);//get请求

    /**
     * 登录页面
     * @return
     */
    @POST("login")
    public Observable<BaseBean<LoginBean>> login(@Body LoginRequestBean param);//post请求

    /**
     * 第四页-摩比英语
     * @return
     */
    @GET("category")
    public Observable<BaseBean<List<Category>>> getData();//get请求

    /**
     * 第四页-摩比英语条目点击后的列表页面--精品
     * @return
     */
    @GET("category/featured/{category_id}")
    public Observable<BaseBean<PageBean<AppInfo>>> getCategoryFeatured(@Path("int category_id") int category_id, @Query("page") int page);//get请求

    /**
     * 第四页-摩比英语条目点击后的列表页面--排行
     * @return
     */
    @GET("category/toplist/{category_id}")
    public Observable<BaseBean<PageBean<AppInfo>>> getCategoryToplist(@Path("int category_id") int category_id, @Query("page") int page);//get请求

    /**
     * 第四页-摩比英语条目点击后的列表页面--新品
     * @return
     */
    @GET("category/newlist/{category_id}")
    public Observable<BaseBean<PageBean<AppInfo>>> getCategoryNewlist(@Path("int category_id") int category_id, @Query("page") int page);//get请求






















































































    /**
     * 测试页面
     * @param jsonParam
     * @return
     */
    // TODO: 18/6/23 RxJava版本---这个是test，里面有很多封装的步骤雏形
    //@GET("featured2")//原来是用这个字段，后来里面没有数据了，废弃
    @GET("toplist")
    public Observable<BaseBean<PageBean<AppInfo>>> getTestFragmentInfos(@Query("p") String jsonParam);//get请求

//    /**
//     * 首页
//     */
//    @GET("index")
//    public Observable<BaseBean<AppInfo>> index();//get请求-->第一种方式(无参)
//
//    /**
//     * 排行榜
//     */
//    @GET("toplist")
//    public Observable<BaseBean<AppInfo>> toplist(@Query("page") int page);//get请求-->第一种方式（有参）


//    /**
//     * 登录
//     */
//    @FormUrlEncoded
//    @POST("login")
//    public Observable<BaseBean> login(@Body LoginRequestBean bean);//post请求-->第一种方式
//
//    /**
//     * 登录
//     */
//    @FormUrlEncoded
//    @POST("login")
//    public Observable<BaseBean> login2(@Field("phone") String phone);//post请求-->第二种方式

}
