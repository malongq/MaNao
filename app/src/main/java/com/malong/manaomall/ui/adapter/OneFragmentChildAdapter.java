package com.malong.manaomall.ui.adapter;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.malong.manaomall.R;
import com.malong.manaomall.bean.AppInfo;
import com.malong.manaomall.common.imageloader.ImageLoader;
import com.malong.manaomall.common.utils.DrawableUtils;
import com.malong.manaomall.common.utils.IconUtils;

/**
 * Created by Malong
 * on 18/6/14.
 * 首页嵌套RecyclerView类
 */
public class OneFragmentChildAdapter extends BaseQuickAdapter<AppInfo, BaseViewHolder> {

    String baseImgUrl = "http://file.market.xiaomi.com/mfc/thumbnail/png/w150q80/";


    // TODO: 18/7/12 三个构造方法，根据需求选择用哪一个
//    public OneFragmentChildAdapter(int layoutResId, @Nullable List<AppInfo> data) {
//        super(layoutResId, data);
//    }


    // TODO: 18/7/13 改为下面的模样,建造者模式，需这样改
//    public OneFragmentChildAdapter() {
//        super(R.layout.one_fragment_template_appinfo);
//    }


    // TODO: 18/7/13   建造者模式 2 :
    private Builder mBuilder;

    private OneFragmentChildAdapter(Builder builder) {
        super(R.layout.one_fragment_template_appinfo);
        this.mBuilder = builder;

        openLoadAnimation();//开启动画
    }


    // TODO: 18/7/13   建造者模式 5 : 这里写方法返回build,不然外界调用不了
    public static Builder builder(){
        return new Builder();
    }



//    public OneFragmentChildAdapter(int layoutResId) {
//        super(layoutResId);
//    }

    @Override
    protected void convert(BaseViewHolder helper, AppInfo item) {

        ImageView view = helper.getView(R.id.btn_download);
        view.setImageDrawable(DrawableUtils.drawable(mContext, IconUtils.Icon.ion_xiazai, Color.parseColor("#989f9d"), 20));

        ImageLoader.load(baseImgUrl + item.getIcon(), (ImageView) helper.getView(R.id.img_app_icon));

        helper.setText(R.id.txt_app_name, item.getDisplayName());

        // TODO: 18/7/13   建造者模式 3 :
        TextView tPosition = helper.getView(R.id.txt_position);
        tPosition.setVisibility(mBuilder.showPosition ? View.VISIBLE : View.GONE);
        tPosition.setText(item.getPosition() + 1 + ".");

        TextView tCategory = helper.getView(R.id.txt_category);
        tCategory.setVisibility(mBuilder.showCategory ? View.VISIBLE : View.GONE);
        tCategory.setText(item.getLevel1CategoryName());

        TextView tBrief = helper.getView(R.id.txt_brief);
        tBrief.setVisibility(mBuilder.showBrief ? View.VISIBLE : View.GONE);
        tBrief.setText(item.getBriefShow());

    }


    // TODO: 18/7/13 建造者模式 1 :要显示哪些东西，分别列出
    //建造者模式:写一个类,必须静态，要不然调用不了
    public static class Builder {

        private boolean showPosition;
        private boolean showCategory;
        private boolean showBrief;


        public Builder showPosition(boolean b) {
            this.showPosition = b;
            return this;
        }

        public Builder showCategory(boolean b) {
            this.showCategory = b;
            return this;
        }

        public Builder showBrief(boolean b) {
            this.showBrief = b;
            return this;
        }


        // TODO: 18/7/13   建造者模式 4 :
        //这里由于是私有的，所以在这里提供一个方法，创建出来adapter,给外面使用
        public OneFragmentChildAdapter build(){
            return new OneFragmentChildAdapter(this);
        }


    }


}
