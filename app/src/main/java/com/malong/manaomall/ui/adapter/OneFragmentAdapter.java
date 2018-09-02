package com.malong.manaomall.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.malong.manaomall.R;
import com.malong.manaomall.bean.OneFragmentIndexBannerBean;
import com.malong.manaomall.bean.OneFragmentIndexBean;
import com.malong.manaomall.common.imageloader.ImageLoader;
import com.malong.manaomall.ui.widget.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Malong
 * on 18/6/14.
 * 首页多种类型adapter
 */
public class OneFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{ //TODO: 第一步： RecyclerView.Adapter<RecyclerView.ViewHolder>这个继承是RecyclerView自带的，也可以自定义


    //TODO: 第四步：  根据布局类型种数，定义几种常量
    private static final int TYPE_BANNER = 1;
    private static final int TYPE_SHUIPING_ICON = 2;
    private static final int TYPE_APPS = 3;
    private static final int TYPE_GAMES = 4;

    // TODO: 18/7/5 第八步：  因为加载布局的时候需要一个context，所以从构造方法传递过来
    private final LayoutInflater inflater;
    private Context mContext;
    public OneFragmentAdapter(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
    }


    // TODO: 18/7/5 第九步：  由于要传递数据，所以写改方法，将数据传递
    private OneFragmentIndexBean oneFragmentIndexBean;
    public void setData(OneFragmentIndexBean oneFragmentIndexBean) {
        this.oneFragmentIndexBean = oneFragmentIndexBean;
    }

    /**
     * TODO: 第二步：  这是集成后必须实现的吐过有多重布局必须在实现这个方法
     */
    @Override
    public int getItemViewType(int position) {

        // TODO: 18/7/5 第五步
//        return super.getItemViewType(position);//注释掉
        if (position == 0) {

            return TYPE_BANNER;

        } else if (position == 1) {

            return TYPE_SHUIPING_ICON;

        } else if (position == 2) {

            return TYPE_APPS;

        } else if (position == 3) {

            return TYPE_GAMES;

        }

        return 0;
    }

    /**
     * 这是集成后必须实现的
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // TODO: 18/7/5 第七步：  判断viewType,根据对应的类型返回对应item布局
        if (viewType == TYPE_BANNER) {

            return new BannerViewHolder(inflater.inflate(R.layout.one_fragment_banner_item, parent, false));

        } else if (viewType == TYPE_SHUIPING_ICON) {

            return new NavShuiPingIconViewHolder(inflater.inflate(R.layout.one_fragment_shuiping_icon_item, parent, false));

        } else if (viewType == TYPE_APPS) {

            return new OneViewHolder(inflater.inflate(R.layout.one_fragment_apps_games_item, null, false), TYPE_APPS);//此处小细节，将第二个参数parent改为null，否则加载RecyclerView嵌套RecyclerView容易导致加载不完全

        } else if (viewType == TYPE_GAMES) {

            return new OneViewHolder(inflater.inflate(R.layout.one_fragment_apps_games_item, null, false), TYPE_GAMES);//此处小细节，将第二个参数parent改为null，否则加载RecyclerView嵌套RecyclerView容易导致加载不完全

        }

        return null;
    }

    /**
     * 这是集成后必须实现的
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        //这里装载数据，需先把第九步做好
        //TODO  第十步：   判断position属于哪个，便加载哪个布局数据
        if (position == 0) {//也可以把判断条件写成if(holder instanceof BannerViewHolder)...

            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;//将holder强转
            final List<OneFragmentIndexBannerBean> banners = oneFragmentIndexBean.getBanners();
            List<String> urls = new ArrayList<>(banners.size());
            for (OneFragmentIndexBannerBean oneFragmentIndexBannerBean : banners) {
                urls.add(oneFragmentIndexBannerBean.getThumbnail());
            }
            bannerViewHolder.mBanner.setViewUrls(urls);

            //点击事件
            bannerViewHolder.mBanner.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
                @Override
                public void onItemClick(int position) {
//                    OneFragmentIndexBannerBean oneFragmentIndexBannerBean = banners.get(position);
                    Toast.makeText(mContext,"马上完善，请等2000年。。。",Toast.LENGTH_SHORT).show();
                }
            });

        } else if (position == 1) {

            NavShuiPingIconViewHolder bannerViewHolder = (NavShuiPingIconViewHolder) holder;
            bannerViewHolder.mLayoutHotApp.setOnClickListener(this);
            bannerViewHolder.mLayoutHotGame.setOnClickListener(this);
            bannerViewHolder.mLayoutHotSubject.setOnClickListener(this);

        } else {

            OneViewHolder oneViewHolder = (OneViewHolder) holder;

//            OneFragmentChildAdapter childAdapter = new OneFragmentChildAdapter();//建造者模式后，改为下面代码
            OneFragmentChildAdapter childAdapter = OneFragmentChildAdapter.builder().showPosition(false).showCategory(false).showBrief(true).build();

            if(oneViewHolder.type == TYPE_APPS){
                oneViewHolder.mText.setText("法国队：");
                oneViewHolder.mText.setTextColor(Color.parseColor("#ff680a"));
                Log.e("法国队size  ==  ", oneFragmentIndexBean.getRecommendApps().size()+"" );
                childAdapter.addData(oneFragmentIndexBean.getRecommendApps());
            }else{
                oneViewHolder.mText.setText("克罗地亚：");
                oneViewHolder.mText.setTextColor(Color.parseColor("#D500F9"));
                Log.e("克罗地亚size  ==  ", oneFragmentIndexBean.getRecommendGames().size()+"" );
                childAdapter.addData(oneFragmentIndexBean.getRecommendGames());
            }
            oneViewHolder.mRecycler_view_one_holder.setAdapter(childAdapter);
            //点击事件
            oneViewHolder.mRecycler_view_one_holder.addOnItemTouchListener(new OnItemClickListener() {
                @Override
                public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {

                    Toast.makeText(mContext,"马上完善，请等200年。。。",Toast.LENGTH_SHORT).show();

                }
            });

        }

    }

    /**
     * 这是集成后必须实现的
     */
    @Override
    public int getItemCount() {

        //TODO: 第三步：  这个数值表示有几种不同item
        return 4;

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();//拿到点击id，并进行下一步的判断
        if(id == R.id.layout_hot_app){
            Toast.makeText(mContext,"哈哈",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(mContext,"嘿嘿",Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * TODO --> 第六步
     * 有几种不同item,就创建几个viewHolder
     */
    //轮播图holder
    class BannerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.banner)
        BannerLayout mBanner;

        public BannerViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);//ButterKnife在adapter中使用必须按照这个形式，找到的id，放到对应的ViewHolder内部

            mBanner.setImageLoader(new ImgLoader());

        }
    }

    //轮播图下面的横向列表holder
    class NavShuiPingIconViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.layout_hot_app)
        LinearLayout mLayoutHotApp;
        @BindView(R.id.layout_hot_game)
        LinearLayout mLayoutHotGame;
        @BindView(R.id.layout_hot_subject)
        LinearLayout mLayoutHotSubject;

        public NavShuiPingIconViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);//ButterKnife在adapter中使用必须按照这个形式，找到的id，放到对应的ViewHolder内部

        }
    }

    //横向列表下面的第   一 / 二   个列表holder
    class OneViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text)
        TextView mText;
        @BindView(R.id.recycler_view)
        RecyclerView mRecycler_view_one_holder;

        int type;

        public OneViewHolder(View itemView, int type) {
            super(itemView);

            ButterKnife.bind(this,itemView);//ButterKnife在adapter中使用必须按照这个形式，找到的id，放到对应的ViewHolder内部

            this.type = type;

            initRecyclerView();
        }

        private void initRecyclerView() {

            mRecycler_view_one_holder.setLayoutManager(new LinearLayoutManager(mContext){

                @Override
                public boolean canScrollVertically() {//重写这个方法，是因为要在垂直方向上不允许列表滚动
                    //return super.canScrollVertically();//注掉
                    return false;
                }
            });

            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL);
            mRecycler_view_one_holder.addItemDecoration(dividerItemDecoration);

        }
    }

    //自定义一个图片记载类，用于banner
    class ImgLoader implements BannerLayout.ImageLoader{

        @Override
        public void displayImage(Context context, String path, ImageView imageView) {
            ImageLoader.load(path,imageView);
        }
    }

}
