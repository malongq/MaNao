package com.malong.manaomall.presenter.contract;

import com.malong.manaomall.bean.AppInfo;
import com.malong.manaomall.ui.BaseView;

import java.util.List;

/**
 * Created by Malong
 * on 18/7/5.
 * 3：在创建对应请求页面的Contract，里面两个接口继承第 1 & 2 步创建的BaseView  And  BasePresenter  其他代码后续根据需求添加
 *    可在presenter接口中先定义方法，因为这里不用传参，方便下一步调用
 */
public interface TestFragmentContract {

    interface View extends BaseView{

        void showData(List<AppInfo> datas);//展示数据

        void showNoData();//空数据

        void showError(String msg);//错误

        /*void requestPermissionSuccess();

        void requestPermissionFaield();*/

    }

}
