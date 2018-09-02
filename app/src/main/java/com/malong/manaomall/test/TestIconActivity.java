package com.malong.manaomall.test;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.malong.manaomall.R;
import com.malong.manaomall.common.utils.DrawableUtils;
import com.malong.manaomall.common.utils.IconUtils;
import com.malong.manaomall.test.guide.TestGuideActivity;
import com.malong.manaomall.ui.activity.MainActivity;
import com.malong.manaomall.ui.activity.TestPermissionActivity;
import com.malong.manaomall.ui.activity.WelcomeActivity;
import com.mikepenz.iconics.context.IconicsLayoutInflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Malong
 * on 18/6/14.
 */
public class TestIconActivity extends AppCompatActivity {

    @BindView(R.id.tv_svg)
    TextView tvSvg;
    @BindView(R.id.iv_svg)
    ImageView ivSvg;
    @BindView(R.id.iv_svg2)
    ImageView ivSvg2;
    @BindView(R.id.iv_svg3)
    ImageView ivSvg3;
    @BindView(R.id.iv_svg4)
    ImageView ivSvg4;
    @BindView(R.id.iv_svg5)
    ImageView ivSvg5;
    @BindView(R.id.iv_svg6)
    ImageView ivSvg6;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_svg7)
    ImageView ivSvg7;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_icon);
        ButterKnife.bind(this);

        //加载TitleBarView
        initTitleBarView();

        //加载view
        initView();

    }

    //加载TitleBarView
    private void initTitleBarView() {
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setImageDrawable(DrawableUtils.drawable(TestIconActivity.this, IconUtils.Icon.ion_houtui, Color.parseColor("#ffffff"), 22));
        tvTitle.setVisibility(View.VISIBLE);
        tvTitle.setText(R.string.test_title);
        ivRight.setVisibility(View.VISIBLE);
        ivRight.setImageDrawable(DrawableUtils.drawable(TestIconActivity.this, IconUtils.Icon.ion_youyong, Color.parseColor("#ffffff"), 24));
    }

    //加载view
    private void initView() {
        ivSvg.setImageDrawable(DrawableUtils.drawable(TestIconActivity.this, IconUtils.Icon.ion_chuangye, Color.parseColor("#ff5700"), 50));
        ivSvg2.setImageDrawable(DrawableUtils.drawable(TestIconActivity.this, IconUtils.Icon.ion_shuxue, Color.parseColor("#ff8000"), 60));
        ivSvg3.setImageDrawable(DrawableUtils.drawable(TestIconActivity.this, IconUtils.Icon.ion_banhui, Color.parseColor("#ff3467"), 70));
        ivSvg4.setImageDrawable(DrawableUtils.drawable(TestIconActivity.this, IconUtils.Icon.ion_chengshi, Color.parseColor("#ff9000"), 80));
        ivSvg5.setImageDrawable(DrawableUtils.drawable(TestIconActivity.this, IconUtils.Icon.ion_dangqian, Color.parseColor("#ff2721"), 90));
        ivSvg6.setImageDrawable(DrawableUtils.drawable(TestIconActivity.this, IconUtils.Icon.ion_zixi, Color.parseColor("#ff5555"), 100));
    }

    private boolean b = false;
    private boolean a = false;

    //点击事件
    @OnClick({R.id.tv_svg, R.id.iv_svg2, R.id.iv_svg4, R.id.iv_back, R.id.iv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_svg:
                if (b) {
                    ivSvg.setVisibility(View.VISIBLE);
                    b = false;
                } else {
                    ivSvg.setVisibility(View.GONE);
                    b = true;
                }
                break;
            case R.id.iv_svg2:
                startActivity(new Intent(this,TestPermissionActivity.class));
                this.finish();
                break;
            case R.id.iv_svg4:
                startActivity(new Intent(this,TestGuideActivity.class));
                this.finish();
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_right:
                startActivity(new Intent(this,WelcomeActivity.class));
                this.finish();
                //Toast.makeText(TestIconActivity.this, "游泳...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
