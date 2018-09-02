package com.malong.manaomall.presenter.contract;

import com.malong.manaomall.bean.AppInfo;
import com.malong.manaomall.bean.OneFragmentIndexBean;
import com.malong.manaomall.bean.PageBean;
import com.malong.manaomall.ui.BaseView;

import java.util.List;

/**
 * Created by Malong
 * on 18/6/15.
 * 3：在创建对应请求页面的Contract，里面两个接口继承第 1 & 2 步创建的BaseView  And  BasePresenter  其他代码后续根据需求添加
 *    可在presenter接口中先定义方法，因为这里不用传参，方便下一步调用
 */
public interface AppInfoFragmentContract {

    interface View extends BaseView{

        void showRsult(OneFragmentIndexBean oneFragmentIndexBean);//展示数据

    }


    interface BaseForTwoAndThreeFragmentView extends BaseView{

        void showRsult2(PageBean<AppInfo> bean);//展示数据

        void onLoadDataComplete();//分页数据加载完毕

    }

}
