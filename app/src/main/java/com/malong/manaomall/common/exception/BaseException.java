package com.malong.manaomall.common.exception;

/**
 * Created by Malong
 * on 18/6/25.
 * 异常基类
 */
public class BaseException extends Exception {


    //    定义大类型异常
    //api错误
    public static final int API_ERROR = 0x0;
    //网络错误
    public static final int NETWORD_ERROR = 0x1;
    //http错误
    public static final int HTTP_ERROR = 0x2;
    //json错误
    public static final int JSON_ERROR = 0x3;
    //未知错误
    public static final int UNKNOWN_ERROR = 0x4;
    //运行时异常
    public static final int RUNTIME_ERROR = 0x5;
    //无法解析该域名
    public static final int UNKOWNHOST_ERROR = 0x6;
    //网络连接超时
    public static final int SOCKET_TIMEOUT_ERROR = 0x7;
    //网络无连接
    public static final int SOCKET_ERROR = 0x8;



//    定义几个错误，可以自行根据后端变换

    //服务器错误
    public static final int ERROR_API_SYSTEM = 10000;

    //登陆错误，用户名或密码错误
    public static final int ERROR_API_LOGIN = 10001;

    //调用无权限API
    public static final int ERROR_API_NO_PERMISSION = 10002;

    //账户被冻结
    public static final int ERROR_API_ACCOUNT_FREEZE = 10003;


    //token失效，请登录先
    public static final int ERROR_TOKEN = 10010;



//    定义几个系统异常:http级别

    public static final int ERROR_HTTP_400 = 400;
    public static final int ERROR_HTTP_404 = 404;
    public static final int ERROR_HTTP_405 = 405;
    public static final int ERROR_HTTP_500 = 500;


    private int code;
    private String displayMessage;

    //生成构造方法一定要
    public BaseException() {
        this.code = code;
        this.displayMessage = displayMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }



}
