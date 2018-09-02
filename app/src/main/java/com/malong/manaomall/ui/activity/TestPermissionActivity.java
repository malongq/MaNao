package com.malong.manaomall.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.malong.manaomall.R;
import com.malong.manaomall.di.component.MyApplicationComponent;
import com.tbruyelle.rxpermissions.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * Created by Malong
 * on 18/7/4.
 * 登录页
 */
public class TestPermissionActivity extends BaseActivity {


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

        RxPermissions rxPermissions = new RxPermissions(TestPermissionActivity.this);
        rxPermissions.request(Manifest.permission.CAMERA).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                if (aBoolean){//如果授权成功

                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(cameraIntent);

                }else {//授权失败

                    Toast.makeText(TestPermissionActivity.this,"授权失败",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }



}
