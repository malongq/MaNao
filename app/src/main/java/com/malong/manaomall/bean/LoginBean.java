package com.malong.manaomall.bean;

/**
 * Created by Malong
 * on 18/7/16.
 * 登录请求返回结果bean
 */
public class LoginBean extends BaseEntity{

    private String token;
    private User user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
