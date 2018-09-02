package com.malong.manaomall.data;

import com.malong.manaomall.bean.AppInfo;
import com.malong.manaomall.bean.BaseBean;
import com.malong.manaomall.bean.PageBean;
import com.malong.manaomall.data.http.ApiService;

import rx.Observable;

/**
 * Created by Malong
 * on 18/7/5.
 */
public class TestFragmentModel {

    private ApiService apiService;

    public TestFragmentModel(ApiService apiService) {
        this.apiService = apiService;
    }

    //不用RxJava写法
//    public void getOneFragmentInfos(Callback<PageBean<AppInfo>> callback){
//
//        apiService.getOneFragmentInfos("{'page':0}").enqueue(callback);
//
//    }

    // TODO: 18/6/23 RxJava版本
    public Observable<BaseBean<PageBean<AppInfo>>> getTestFragmentInfos(){

        return apiService.getTestFragmentInfos("{'page':0}");

    }

}
