package com.malong.manaomall.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.malong.manaomall.MyApplication;
import com.malong.manaomall.di.component.MyApplicationComponent;
import com.malong.manaomall.presenter.BasePresenter;
import javax.inject.Inject;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Malong
 * on 18/6/21.
 * Activity基类抽取公共方法
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity{

    private Unbinder bind;
    private MyApplication myApplication;
    @Inject
    T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        bind = ButterKnife.bind(this);
        this.myApplication = (MyApplication) getApplication();
        setActivityComponent(myApplication.getMyApplicationComponent());
        init();
    }

    /**
     * 抽象类加载布局
     * @return
     */
    public abstract int setLayout();

    /**
     * 抽象类注入dagger2
     * @return
     */
    public abstract void setActivityComponent(MyApplicationComponent myApplicationComponent);

    /**
     * 抽象类绘制UI
     * @return
     */
    public abstract void init();

    /**
     * 页面销毁时取消绑定ButterKnife控件id
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != Unbinder.EMPTY){
            bind.unbind();
        }
    }
}
