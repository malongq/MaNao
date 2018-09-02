package com.malong.manaomall.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;

import com.eftimoff.androipathview.PathView;
import com.malong.manaomall.R;
import com.malong.manaomall.common.Constant;
import com.malong.manaomall.common.utils.ACache;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Malong
 * on 18/6/23.
 */
public class WelcomeActivity extends AppCompatActivity {

    @BindView(R.id.pathView)
    PathView pathView;
    @BindView(R.id.ll_welcome)
    LinearLayout llWelcome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        //pathview其中一种用法，超简单
        pathView.getPathAnimator()
                .delay(30)
                .duration(2000)
                .interpolator(new AccelerateDecelerateInterpolator())
                .listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                    @Override
                    public void onAnimationEnd() {
                        //动画执行完毕--跳入主页
                        jump_activity();
                    }
                })
                .start();
    }

    /**
     * 跳入主页
     */
    private void jump_activity() {

        String show_or_not = ACache.get(this).getAsString(Constant.IS_SHOW_GUIDE);
        //第一次启动进入引导页面
        if (show_or_not == null){
            startActivity(new Intent(this,GuideActivity.class));
        }else {
            startActivity(new Intent(this,MainActivity.class));
        }
        this.finish();

    }

}
