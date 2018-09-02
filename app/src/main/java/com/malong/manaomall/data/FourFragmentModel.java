package com.malong.manaomall.data;

import com.malong.manaomall.bean.BaseBean;
import com.malong.manaomall.bean.Category;
import com.malong.manaomall.data.http.ApiService;

import java.util.List;

import rx.Observable;


/**
 * Created by Malong
 * on 18/7/18.
 */
public class FourFragmentModel {

    private ApiService apiService;

    public FourFragmentModel(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<BaseBean<List<Category>>> getFourFragmentInfos() {
        return apiService.getData();
    }

}
