package com.malong.manaomall.presenter;

import com.malong.manaomall.bean.Category;
import com.malong.manaomall.common.rx.RxHttpResponseCompat;
import com.malong.manaomall.common.rx.subscriber.ProgressSubscribe;
import com.malong.manaomall.data.FourFragmentModel;
import com.malong.manaomall.presenter.contract.FourFragmentContract;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Malong
 * on 18/7/18.
 */
public class FourFragmentPresenter extends BasePresenter<FourFragmentModel, FourFragmentContract.FourFragmentView> {


    @Inject
    public FourFragmentPresenter(FourFragmentModel model, FourFragmentContract.FourFragmentView mView) {
        super(model, mView);
    }


    //请求数据
    public void requestDatas() {

        //这里调用的是model类中的请求方法
        model.getFourFragmentInfos()
                .compose(RxHttpResponseCompat.<List<Category>>compatResult())
                .subscribe(new ProgressSubscribe<List<Category>>(mContext, mView) {
                    @Override
                    public void onNext(List<Category> categories) {

                        mView.showData(categories);

                    }
                });


    }

}




