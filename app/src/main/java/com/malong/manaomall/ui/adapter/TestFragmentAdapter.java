package com.malong.manaomall.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.malong.manaomall.R;
import com.malong.manaomall.bean.AppInfo;
import com.malong.manaomall.common.utils.DrawableUtils;
import com.malong.manaomall.common.utils.IconUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Malong
 * on 18/6/14.
 */
public class TestFragmentAdapter extends RecyclerView.Adapter<TestFragmentAdapter.ViewHolder> {

    private List<AppInfo> mDatas;
    private LayoutInflater mlayoutInflater;
    private Context mContext;

    public TestFragmentAdapter(Context context, List<AppInfo> datas) {
        this.mDatas = datas;
        this.mContext = context;
        mlayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(mlayoutInflater.inflate(R.layout.fragemnt_test_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AppInfo appInfo = mDatas.get(position);

        holder.ivSvg.setImageDrawable(DrawableUtils.drawable(mContext, IconUtils.Icon.ion_xiazai, Color.parseColor("#989f9d"), 15));

        String baseImgUrl = "http://file.market.xiaomi.com/mfc/thumbnail/png/w150q80/";
        Picasso.with(mContext).load(baseImgUrl + appInfo.getIcon()).into(holder.ivApk);

        holder.tvName.setText(appInfo.getDisplayName());

        holder.tvApkSize.setText((appInfo.getApkSize() / 1024 / 1024) + "M");
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_svg)
        ImageView ivSvg;
        @BindView(R.id.iv_apk)
        ImageView ivApk;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_apk_size)
        TextView tvApkSize;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
