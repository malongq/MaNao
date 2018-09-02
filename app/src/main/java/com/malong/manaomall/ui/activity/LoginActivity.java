package com.malong.manaomall.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.malong.manaomall.R;
import com.malong.manaomall.bean.LoginBean;
import com.malong.manaomall.common.utils.DrawableUtils;
import com.malong.manaomall.common.utils.IconUtils;
import com.malong.manaomall.di.component.DaggerLoginComponent;
import com.malong.manaomall.di.component.MyApplicationComponent;
import com.malong.manaomall.di.module.LoginModule;
import com.malong.manaomall.presenter.LoginPresenter;
import com.malong.manaomall.presenter.contract.LoginContract;
import com.malong.manaomall.ui.widget.LoadingButton;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;

/**
 * Created by Malong
 * on 18/7/16.
 * 登录页
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.LoginView, View.OnClickListener {


    @BindView(R.id.iv_back)
    ImageView ivBack;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.iv_right)
    ImageView ivRight;

    @BindView(R.id.btn_login)
    LoadingButton loginIn;

//    @BindView(R.id.btn_login)
//    Button loginIn;

    @BindView(R.id.new_custom)
    Button newCustom;

    @BindView(R.id.number)
    EditText number;

    @BindView(R.id.txt_input_number)
    TextInputLayout txtInputNumber;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.txt_input_password)
    TextInputLayout txtInputPassword;

    @Inject
    ProgressDialog dialog;

    @Override
    public int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void setActivityComponent(MyApplicationComponent myApplicationComponent) {
        DaggerLoginComponent
                .builder()
                .myApplicationComponent(myApplicationComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void init() {

        //初始化title方法
        initTitle();

        //初始化登录操作方法
        initLogin();

        //初始化新用户注册方法
        initNewCustom();

    }

    //初始化新用户注册方法
    private void initNewCustom() {

        newCustom.setOnClickListener(this);

    }

    /**
     * 初始化登录操作方法
     */
    private void initLogin() {

        //rxBinding直接绑定输入
        final Observable<CharSequence> txt_number = RxTextView.textChanges(number);//获取输入账号
        Observable<CharSequence> txt_password = RxTextView.textChanges(password);//获取输入密码

        //通过事件合并方法combineLatest，将输入后的   账号、密码   提取并判断
        Observable.combineLatest(txt_number, txt_password, new Func2<CharSequence, CharSequence, Boolean>() {//第三个参数返回为Boolean，因为要判断输入是否符合规则
            @Override
            public Boolean call(CharSequence txt_number, CharSequence txt_password) {
                return isPhoneValid(txt_number.toString().trim()) && isPasswordValid(txt_password.toString().trim());//判断输入是否符合业务规则
            }
        }).subscribe(new Action1<Boolean>() {//.subscribe方法是在上一步正确的情况下，继续订阅，然后把输入结果跟下一步要操作的步骤绑定到一起
            @Override
            public void call(Boolean aBoolean) {
                RxView.enabled(loginIn).call(aBoolean);//RxView具体实现绑定哪个id，这里跟登录按钮绑定
            }
        });

        //登录按钮点击事件
        RxView.clicks(loginIn).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                //点击登录将获取到的账号密码作为参数请求
                mPresenter.loginRequest(number.getText().toString().trim(), password.getText().toString().trim());
                hintKeyboard();//关闭软键盘
            }
        });

    }

    //关闭软键盘
    private void hintKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm.isActive()&&getCurrentFocus()!=null){
            if (getCurrentFocus().getWindowToken()!=null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    //判断密码位数
    private boolean isPasswordValid(String s) {
        return s.length() >= 6;
    }

    //判断账号位数
    private Boolean isPhoneValid(String s) {
        return s.length() == 11;
    }

    //初始化title方法
    private void initTitle() {

        ivBack.setVisibility(View.VISIBLE);
        ivBack.setImageDrawable(DrawableUtils.drawable(LoginActivity.this, IconUtils.Icon.ion_houtui, Color.parseColor("#ffffff"), 22));
        ivBack.setOnClickListener(this);

        tvTitle.setVisibility(View.VISIBLE);
        tvTitle.setText(getResources().getString(R.string.login_page));

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.new_custom:
                Toast.makeText(LoginActivity.this, "暂不支持注册，请谅解大胸弟们！", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 关闭加载loading
     */
    @Override
    public void dismissLoading() {

        loginIn.showButtonText();

    }

    /**
     * 加载出错或者数据为空
     */
    @Override
    public void showError_Empty(String msg) {

        loginIn.showButtonText();

    }

    /**
     * 打开加载loading
     */
    @Override
    public void showLoading() {

        loginIn.showLoading();

    }

    /**
     * 账号规则错误
     */
    @Override
    public void checkPhoneError() {
        txtInputNumber.setError("手机号格式不正确！");
    }

    /**
     * 账号规则匹配正确
     */
    @Override
    public void checkPhoneSuccess() {
        txtInputNumber.setError("");
        txtInputNumber.setErrorEnabled(false);
    }

    /**
     * 密码规则错误
     */
    @Override
    public void checkPwdError() {
        txtInputPassword.setError("密码格式不正确！");
    }

    /**
     * 密码规则匹配正确
     */
    @Override
    public void checkPwdSuccess() {
        txtInputPassword.setError("");
        txtInputPassword.setErrorEnabled(false);
    }

    /**
     * 登录成功
     */
    @Override
    public void loginSuccess(LoginBean loginBean) {

        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
        this.finish();

    }

    /**
     * 登录失败
     */
    @Override
    public void loginError() {
        Toast.makeText(LoginActivity.this, "账号或密码错误，请重新登录...", Toast.LENGTH_SHORT).show();
    }
}
