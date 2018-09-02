package com.malong.manaomall.ui.bean;

/**
 * Created by Malong
 * on 18/6/13.
 */
public class FragmnetInfo {

    private String title;
    private Class fragmnet;

    public FragmnetInfo(String title, Class fragmnet) {
        this.title = title;
        this.fragmnet = fragmnet;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class getFragmnet() {
        return fragmnet;
    }

    public void setFragmnet(Class fragmnet) {
        this.fragmnet = fragmnet;
    }
}
