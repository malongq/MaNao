package com.malong.manaomall.bean;


/**
 * Created by Malong
 * on 18/6/25.
 * 返回类型统一处理，外层封装
 */
public class BaseBean<T> extends BaseEntity {

    private int status;
    private String message;
    private T data;

    public static final int SUCCESS = 1;

    //定义一个boolean类型的，判断是否成功
    public boolean success(){

        return (status == SUCCESS);

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
