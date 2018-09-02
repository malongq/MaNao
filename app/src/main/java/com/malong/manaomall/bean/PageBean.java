package com.malong.manaomall.bean;

import java.util.List;

/**
 * Created by Malong
 * on 18/6/14.
 */
public class PageBean<T> {

    /**
     * hasMore  : false
     * status  :  1
     * message  :  message
     * datas  :  []
     */

    private boolean hasMore;
    private int status;
    private String message;
    private List<T> datas;

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
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

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
