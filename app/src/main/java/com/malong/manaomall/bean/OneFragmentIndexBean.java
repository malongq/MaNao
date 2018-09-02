package com.malong.manaomall.bean;


import java.io.Serializable;
import java.util.List;

/**
 * Created by Malong
 * on 18/7/5.
 */
public class OneFragmentIndexBean implements Serializable{

    private List<OneFragmentIndexBannerBean> banners;
    private List<AppInfo> recommendApps;
    private List<AppInfo> recommendGames;

    public List<OneFragmentIndexBannerBean> getBanners() {
        return banners;
    }

    public void setBanners(List<OneFragmentIndexBannerBean> banners) {
        this.banners = banners;
    }

    public List<AppInfo> getRecommendApps() {
        return recommendApps;
    }

    public void setRecommendApps(List<AppInfo> recommendApps) {
        this.recommendApps = recommendApps;
    }

    public List<AppInfo> getRecommendGames() {
        return recommendGames;
    }

    public void setRecommendGames(List<AppInfo> recommendGames) {
        this.recommendGames = recommendGames;
    }

}
