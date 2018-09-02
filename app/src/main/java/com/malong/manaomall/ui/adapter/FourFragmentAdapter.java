package com.malong.manaomall.ui.adapter;

import android.graphics.Color;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.malong.manaomall.R;
import com.malong.manaomall.bean.Category;
import com.malong.manaomall.common.Constant;
import com.malong.manaomall.common.imageloader.ImageLoader;
import com.malong.manaomall.common.utils.DrawableUtils;
import com.malong.manaomall.common.utils.IconUtils;

/**
 * Created by Malong
 * on 18/7/18.
 */
public class FourFragmentAdapter extends BaseQuickAdapter<Category,BaseViewHolder> {

    public FourFragmentAdapter() {
        super(R.layout.four_fragment_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, Category item) {

        helper.setText(R.id.text_name,item.getName());

        ImageLoader.load(Constant.BASE_IMG_URL+item.getIcon(), (ImageView) helper.getView(R.id.img_icon));

        ImageView view = helper.getView(R.id.iv_arrow);
        view.setImageDrawable(DrawableUtils.drawable(mContext, IconUtils.Icon.ion_qianjin1, Color.parseColor("#989f9d"), 20));

    }

}
