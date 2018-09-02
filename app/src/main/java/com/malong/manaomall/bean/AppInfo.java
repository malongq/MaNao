package com.malong.manaomall.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Malong
 * on 18/6/14.
 * 返回的数据Bean
 */
public class AppInfo implements Serializable{

    /**
     * addTime : 0
     * hasSameDevApp : false
     * videoId : 0
     * source :
     * versionName : 4.6.0
     * hdIcon : {"main":"AppStore/084f195cadb1b413e1256e625be6fb0a3fa291bd9"}
     * ratingScore : 5
     * briefShow : 中信产业基金控股
     * developerId : 0
     * fitness : 0
     * id : 96655
     * level1CategoryId : 1
     * releaseKeyHash : f6f9fafe8a7acb40af6c2056df404eb7
     * relateAppHasMore : false
     * rId : 0
     * suitableType : 0
     * briefUseIntro : false
     * ads : 0
     * publisherName : 上海凯岸信息科技有限公司
     * level2CategoryId : 0
     * position : 0
     * favorite : false
     * isFavorite : false
     * appendSize : 0
     * level1CategoryName : 金融理财
     * samDevAppHasMore : false
     * displayName : 麻袋财富
     * icon : AppStore/02b5c25e2d7cc408f3db44a96a024aec699659c65
     * screenshot : AppStore/0b8a15381b75e01ce1d29ed0fe2791d16fa40cfab,AppStore/0ca6a46a8d8268c27efd8ce4b68affe750b429832,AppStore/07ac8843d9ab24e9a385f729dddeddb89a22ab70b,AppStore/07ac8843d9ab24e9b385fd29dd3eddb99a22eb70b
     * ratingTotalCount : 0
     * adType : 0
     * apkSize : 17579710
     * packageName : com.tengniu.p2p.tnp2p
     * updateTime : 1526265124067
     * grantCode : 0
     * versionCode : 78
     * appTags : [{"tagId":249,"link":"sametag/249","tagName":"投资提示"},{"tagId":148,"link":"sametag/148","tagName":"投资"}]
     * diffFileSize : 0
     */

    private int addTime;
    private boolean hasSameDevApp;
    private int videoId;
    private String source;
    private String versionName;
    private HdIconBean hdIcon;
//    private double ratingScore;
    private String briefShow;
    private int developerId;
    private int fitness;
    private int id;
    private int level1CategoryId;
    private String releaseKeyHash;
    private boolean relateAppHasMore;
    private int rId;
    private int suitableType;
    private boolean briefUseIntro;
    private int ads;
    private String publisherName;
    private int level2CategoryId;
    private int position;
    private boolean favorite;
    private boolean isFavorite;
    private int appendSize;
    private String level1CategoryName;
    private boolean samDevAppHasMore;
    private String displayName;
    private String icon;
    private String screenshot;
    private int ratingTotalCount;
    private int adType;
    private int apkSize;
    private String packageName;
    private long updateTime;
    private int grantCode;
    private int versionCode;
    private int diffFileSize;
    private List<AppTagsBean> appTags;

    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    public boolean isHasSameDevApp() {
        return hasSameDevApp;
    }

    public void setHasSameDevApp(boolean hasSameDevApp) {
        this.hasSameDevApp = hasSameDevApp;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public HdIconBean getHdIcon() {
        return hdIcon;
    }

    public void setHdIcon(HdIconBean hdIcon) {
        this.hdIcon = hdIcon;
    }

//    public double getRatingScore() {
//        return ratingScore;
//    }
//
//    public void setRatingScore(double ratingScore) {
//        this.ratingScore = ratingScore;
//    }

    public String getBriefShow() {
        return briefShow;
    }

    public void setBriefShow(String briefShow) {
        this.briefShow = briefShow;
    }

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel1CategoryId() {
        return level1CategoryId;
    }

    public void setLevel1CategoryId(int level1CategoryId) {
        this.level1CategoryId = level1CategoryId;
    }

    public String getReleaseKeyHash() {
        return releaseKeyHash;
    }

    public void setReleaseKeyHash(String releaseKeyHash) {
        this.releaseKeyHash = releaseKeyHash;
    }

    public boolean isRelateAppHasMore() {
        return relateAppHasMore;
    }

    public void setRelateAppHasMore(boolean relateAppHasMore) {
        this.relateAppHasMore = relateAppHasMore;
    }

    public int getRId() {
        return rId;
    }

    public void setRId(int rId) {
        this.rId = rId;
    }

    public int getSuitableType() {
        return suitableType;
    }

    public void setSuitableType(int suitableType) {
        this.suitableType = suitableType;
    }

    public boolean isBriefUseIntro() {
        return briefUseIntro;
    }

    public void setBriefUseIntro(boolean briefUseIntro) {
        this.briefUseIntro = briefUseIntro;
    }

    public int getAds() {
        return ads;
    }

    public void setAds(int ads) {
        this.ads = ads;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getLevel2CategoryId() {
        return level2CategoryId;
    }

    public void setLevel2CategoryId(int level2CategoryId) {
        this.level2CategoryId = level2CategoryId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public int getAppendSize() {
        return appendSize;
    }

    public void setAppendSize(int appendSize) {
        this.appendSize = appendSize;
    }

    public String getLevel1CategoryName() {
        return level1CategoryName;
    }

    public void setLevel1CategoryName(String level1CategoryName) {
        this.level1CategoryName = level1CategoryName;
    }

    public boolean isSamDevAppHasMore() {
        return samDevAppHasMore;
    }

    public void setSamDevAppHasMore(boolean samDevAppHasMore) {
        this.samDevAppHasMore = samDevAppHasMore;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    public int getRatingTotalCount() {
        return ratingTotalCount;
    }

    public void setRatingTotalCount(int ratingTotalCount) {
        this.ratingTotalCount = ratingTotalCount;
    }

    public int getAdType() {
        return adType;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public int getApkSize() {
        return apkSize;
    }

    public void setApkSize(int apkSize) {
        this.apkSize = apkSize;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getGrantCode() {
        return grantCode;
    }

    public void setGrantCode(int grantCode) {
        this.grantCode = grantCode;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public int getDiffFileSize() {
        return diffFileSize;
    }

    public void setDiffFileSize(int diffFileSize) {
        this.diffFileSize = diffFileSize;
    }

    public List<AppTagsBean> getAppTags() {
        return appTags;
    }

    public void setAppTags(List<AppTagsBean> appTags) {
        this.appTags = appTags;
    }

    public static class HdIconBean implements Serializable{
        /**
         * main : AppStore/084f195cadb1b413e1256e625be6fb0a3fa291bd9
         */

        private String main;

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }
    }

    public static class AppTagsBean implements Serializable{
        /**
         * tagId : 249
         * link : sametag/249
         * tagName : 投资提示
         */

        private int tagId;
        private String link;
        private String tagName;

        public int getTagId() {
            return tagId;
        }

        public void setTagId(int tagId) {
            this.tagId = tagId;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getTagName() {
            return tagName;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }
    }
}
