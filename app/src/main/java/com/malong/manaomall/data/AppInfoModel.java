package com.malong.manaomall.data;

import com.malong.manaomall.bean.AppInfo;
import com.malong.manaomall.bean.BaseBean;
import com.malong.manaomall.bean.OneFragmentIndexBean;
import com.malong.manaomall.bean.PageBean;
import com.malong.manaomall.common.Constant;
import com.malong.manaomall.data.http.ApiService;
import rx.Observable;

/**
 * Created by Malong
 * on 18/6/15.
 * 5：创建对应请求页面的Model类，将数据请求方法放入其中
 */
public class AppInfoModel {

    private ApiService apiService;

    public AppInfoModel(ApiService apiService) {
        this.apiService = apiService;
    }

    // TODO: 18/6/23 RxJava版本
    public Observable<BaseBean<OneFragmentIndexBean>> getOneFragmentInfos(){

        return apiService.getOneFragmentInfos();

    }


    // TODO: 18/7/13 因为model一样，所以可以写在一起
    public Observable<BaseBean<PageBean<AppInfo>>> getTwoFragmentInfos(int page){

        return apiService.getTwoFragmentInfos(page);

    }

    // TODO: 18/7/13 第三个fragment
    public Observable<BaseBean<PageBean<AppInfo>>> getThreeFragmentInfos(int page){

        return apiService.getThreeFragmentInfos(page);

    }

}
