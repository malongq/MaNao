package com.malong.manaomall.bean.requestbean;

import java.io.Serializable;

/**
 * Created by Malong
 * on 18/7/16.
 * 登录请求参数bean，post请求
 */
public class LoginRequestBean implements Serializable {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

}
