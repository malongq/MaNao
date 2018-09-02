package com.malong.manaomall.common.utils;

import android.content.Context;
import android.graphics.Typeface;

import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Malong
 * on 18/6/14.
 * 自定义svg矢量图工具类
 */
public class IconUtils implements ITypeface {

    private static final String TTF_FILE = "iconfont.ttf";
    private static Typeface typeface = null;
    private static HashMap<String, Character> mChars;

    @Override
    public IIcon getIcon(String key) {
        return Icon.valueOf(key);
    }

    @Override
    public HashMap<String, Character> getCharacters() {
        if (mChars == null) {
            HashMap<String, Character> aChars = new HashMap<String, Character>();
            for (IconUtils.Icon v : IconUtils.Icon.values()) {
                aChars.put(v.name(), v.character);
            }
            mChars = aChars;
        }
        return mChars;
    }

    @Override
    public String getMappingPrefix() {
        return "ion";//前缀：需跟枚举中的起始一致，注意：前缀必须是三个字母
    }

    @Override
    public String getFontName() {
        return "IconUtils";//字体名字：无所谓
    }

    @Override
    public String getVersion() {
        return "1.0.0";//版本：无所谓
    }

    @Override
    public int getIconCount() {
        return mChars.size();
    }

    @Override
    public Collection<String> getIcons() {
        Collection<String> icons = new LinkedList<String>();
        for (IconUtils.Icon value : IconUtils.Icon.values()) {
            icons.add(value.name());
        }
        return icons;
    }

    @Override
    public String getAuthor() {
        return "Malong";//作者：无所谓
    }

    @Override
    public String getUrl() {
        return "http://malong.com/";//域名：无所谓
    }

    @Override
    public String getDescription() {
        return "The premium icon font for Ionic Framework.";//无所谓
    }

    @Override
    public String getLicense() {
        return "MIT Licensed";//无所谓
    }

    @Override
    public String getLicenseUrl() {
        return "https://malong.com";//授权地址：无所谓
    }

    @Override
    public Typeface getTypeface(Context context) {
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), TTF_FILE);//自定义后引用的地址assets里文件名
            } catch (Exception e) {
                return null;
            }
        }
        return typeface;
    }

    public enum Icon implements IIcon {


        /**
         * 这里写自定义的图标uncode
         * 注意：前缀必须是三个字母
         */

        ion_yuwen('\ue603'),
        ion_shuxue('\ue604'),
        ion_wuli('\ue605'),
        ion_liyi('\ue606'),
        ion_youyong('\ue607'),
        ion_taolun('\ue608'),
        ion_putonghua('\ue609'),

        ion_wudao('\ue60a'),
        ion_shetuan('\ue60b'),
        ion_gongchenghuitu('\ue60c'),
        ion_xinlijiankang('\ue60d'),
        ion_kaoyan('\ue60e'),
        ion_chuangye('\ue60f'),
        ion_junshiliun('\ue610'),

        ion_xingshizhengce('\ue611'),
        ion_tongji('\ue612'),
        ion_jingji('\ue613'),
        ion_pingmian('\ue614'),
        ion_dianzijishu('\ue615'),
        ion_dianshang('\ue616'),
        ion_jisuanji('\ue617'),
        ion_shufa('\ue618'),
        ion_guanli('\ue619'),

        ion_xiaoyuzhong('\ue61a'),
        ion_yuedu('\ue61b'),
        ion_banhui('\ue61c'),
        ion_meishu('\ue61d'),
        ion_zixi('\ue61e'),
        ion_yinle('\ue61f'),

        ion_wuli1('\ue620'),
        ion_zhengzhi('\ue621'),
        ion_lishi('\ue622'),
        ion_huaxue('\ue623'),
        ion_tiyu('\ue624'),
        ion_yingyu('\ue625'),
        ion_shengwu('\ue626'),
        ion_hangkonghangtian('\ue627'),
        ion_kongcheng('\ue628'),
        ion_tianwenxue('\ue629'),

        ion_jianshenke('\ue62a'),
        ion_pingpangqiu('\ue62b'),
        ion_wangqiu('\ue62c'),
        ion_yumaoqiu('\ue62d'),
        ion_zuqiu('\ue62e'),
        ion_paiqiu('\ue62f'),

        ion_wangluoke('\ue630'),
        ion_lanqiu('\ue631'),
        ion_jianzhuke('\ue632'),

        ion_dangqian('\ue64a'),
        ion_dianhua('\ue64b'),
        ion_chengshi('\ue649'),
        ion_dingwei('\ue64c'),
        ion_fujin('\ue64d'),
        ion_geren('\ue64e'),
        ion_gengduo('\ue64f'),

        ion_houtui('\ue650'),
        ion_gonghao('\ue651'),
        ion_houtui1('\ue652'),
        ion_huiyishi('\ue653'),
        ion_jinyong('\ue654'),
        ion_jiaose('\ue655'),
        ion_qianjin('\ue656'),
        ion_mima('\ue657'),
        ion_shaixuan('\ue658'),
        ion_rongna('\ue659'),

        ion_qianjin1('\ue65a'),
        ion_shijian('\ue65b'),
        ion_shezhi('\ue65c'),
        ion_shebei('\ue65d'),
        ion_shouqi('\ue65e'),
        ion_shouqi1('\ue65f'),

        ion_shipin('\ue660'),
        ion_sousuo('\ue661'),
        ion_tuichu('\ue662'),
        ion_tupian('\ue663'),
        ion_wancheng('\ue664'),
        ion_xiala('\ue665'),
        ion_xiala1('\ue666'),
        ion_youxiang('\ue667'),
        ion_youhuiquan('\ue668'),
        ion_zhaiyao('\ue669'),

        ion_zhankai('\ue66a'),
        ion_zhiwei('\ue66b'),
        ion_xiangji('\ue66c'),
        ion_guanbimima('\ue66d'),
        ion_bianji('\ue66e'),
        ion_guanbi('\ue66f'),

        ion_tuodong('\ue670'),
        ion_tianjia('\ue671'),
        ion_paixu('\ue672'),
        ion_tianjia1('\ue673'),
        ion_xiazai('\ue674'),
        ion_shanchu('\ue675'),
        ion_zhushi('\ue676'),
        ion_wancheng1('\ue677'),
        ion_shangchuan('\ue678'),
        ion_xianshimima('\ue679');

        char character;

        Icon(char character) {
            this.character = character;
        }

        public String getFormattedName() {
            return "{" + name() + "}";
        }

        public char getCharacter() {
            return character;
        }

        public String getName() {
            return name();
        }

        // remember the typeface so we can use it later
        private static ITypeface typeface;

        public ITypeface getTypeface() {
            if (typeface == null) {
                typeface = new IconUtils();
            }
            return typeface;
        }

    }

}
