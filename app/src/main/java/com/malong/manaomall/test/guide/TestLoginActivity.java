package com.malong.manaomall.test.guide;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.widget.Button;
import android.widget.Toast;

import com.malong.manaomall.R;
import com.malong.manaomall.common.utils.DeviceUtils;
import com.malong.manaomall.di.component.MyApplicationComponent;
import com.malong.manaomall.test.TestIconActivity;
import com.malong.manaomall.ui.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Malong
 * on 18/7/4.
 * 登录---该类主要是复习动态权限
 */
public class TestLoginActivity extends BaseActivity {


    private static final int READ_PHONE_STATE_CODE = 1000;//创建一个code，code码随意

    @BindView(R.id.bt_permission)
    Button btPermission;

    @Override
    public int setLayout() {
        return R.layout.activity_login_test;
    }

    @Override
    public void setActivityComponent(MyApplicationComponent myApplicationComponent) {

    }

    @Override
    public void init() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_permission)
    public void onViewClicked() {

        int i = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);//返回一个int值，授权成功与否
        if(i != PackageManager.PERMISSION_GRANTED){//PackageManager.PERMISSION_GRANTED授权成功
            //如果没有授权，则申请授权
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, READ_PHONE_STATE_CODE);
        }else{
            //授权成功，进入页面
            Toast.makeText(this,"已经授权成功"+DeviceUtils.getIMEI(this),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TestLoginActivity.this, TestIconActivity.class);
            startActivity(intent);
        }

    }

    //授权回调
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);//注释掉
        if (requestCode == READ_PHONE_STATE_CODE){//如果相等说明请求的权限正确

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){//如果相等说明授权成功
                Toast.makeText(this,"授权成功"+DeviceUtils.getIMEI(this),Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"用户拒绝，授权失败",Toast.LENGTH_SHORT).show();
            }

        }

    }

}
