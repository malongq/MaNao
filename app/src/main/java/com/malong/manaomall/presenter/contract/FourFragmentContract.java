package com.malong.manaomall.presenter.contract;

import com.malong.manaomall.bean.Category;
import com.malong.manaomall.ui.BaseView;

import java.util.List;


/**
 * Created by Malong
 * on 18/7/18.
 */
public interface FourFragmentContract {

    interface FourFragmentView extends BaseView{

        void showData(List<Category> categories);

    }

}
