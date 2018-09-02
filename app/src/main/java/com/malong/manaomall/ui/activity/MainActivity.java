package com.malong.manaomall.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.malong.manaomall.R;
import com.malong.manaomall.bean.User;
import com.malong.manaomall.common.Constant;
import com.malong.manaomall.common.imageloader.GlideCircleTransform;
import com.malong.manaomall.common.imageloader.ImageLoader;
import com.malong.manaomall.common.utils.ACache;
import com.malong.manaomall.common.utils.DrawableUtils;
import com.malong.manaomall.common.utils.IconUtils;
import com.malong.manaomall.di.component.MyApplicationComponent;
import com.malong.manaomall.test.TestIconActivity;
import com.malong.manaomall.test.guide.TestLoginActivity;
import com.malong.manaomall.ui.adapter.ViewpagerAdapter;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.navigation_header_container)
    NavigationView navigationHeaderContainer;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.tool_bar)
    Toolbar toolBar;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private View headerView;
    private ImageView iv_head;
    private TextView tv_head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 加载布局
     *
     * @return
     */
    @Override
    public int setLayout() {
        return R.layout.activity_main2;
    }

    /**
     * 加载dagger2依赖注入
     *
     * @param myApplicationComponent
     * @return
     */
    @Override
    public void setActivityComponent(MyApplicationComponent myApplicationComponent) {
    }

    /**
     * 绘制UI
     */
    @Override
    public void init() {

        /**
         * RxBus注册
         */
        RxBus.get().register(this);

        //加载toolbar+drawerLayout+navigationView方法
        initToolbarAndDrawerLayoutView();

        //加载tTabLayout+ViewPager方法
        initTabLayoutAndViewPagerView();

        //加载用户信息方法
        initUser();
    }

    /**
     * 加载TabLayout+ViewPager方法
     */
    private void initTabLayoutAndViewPagerView() {

        PagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager());//创建ViewpagerAdapter
        viewPager.setOffscreenPageLimit(viewpagerAdapter.getCount());//viewpager预加载页面数量
        viewPager.setAdapter(viewpagerAdapter);//设置adapter
        tabLayout.setupWithViewPager(viewPager);//TabLayout+ViewPager关联

    }

    /**
     * 加载toolbar+drawerLayout+navigationView方法
     */
    private void initToolbarAndDrawerLayoutView() {

        //获取NavigationView顶部view事件
        headerView = navigationHeaderContainer.getHeaderView(0);//获取左侧头部
        // TODO: 18/7/17 为了判断登录后再点击就不能在进去登录页面，所以挪到下面，initUser方法里
//        headerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(MainActivity.this, "左侧头部", Toast.LENGTH_SHORT).show();
//                //进入登录页
//                Intent intent3 = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent3);
//            }
//        });

        //查找左侧头部头像和用户名id
        iv_head = headerView.findViewById(R.id.iv_head);
        iv_head.setImageDrawable(DrawableUtils.drawable(MainActivity.this, IconUtils.Icon.ion_jiaose, Color.parseColor("#ff6800"), 50));
        tv_head = headerView.findViewById(R.id.tv_head);


        //设置菜单栏文字颜色默认
        navigationHeaderContainer.setItemTextColor(null);
        //设置菜单栏图标颜色跟随自身
        navigationHeaderContainer.setItemIconTintList(null);
        //获取NavigationView下面view事件
        navigationHeaderContainer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId) {

                    case R.id.update1:
                        //进入XX页面
                        Toast.makeText(MainActivity.this, "应用更新", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.news1:
                        //进入XX页面
                        Toast.makeText(MainActivity.this, "下载管理", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.one1:
                        //进入XX页面
                        Toast.makeText(MainActivity.this, "应用卸载", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.two1:
                        //进入XX页面
                        Toast.makeText(MainActivity.this, "系统设置", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.set:
                        //退出登录，清空缓存里的保存的token,和用户信息
                        logOut();
                        break;


                    case R.id.update:
                        //进入svg测试页面
                        Intent intent = new Intent(MainActivity.this, TestIconActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.news:
                        //进入动态权限测试页
                        Intent intent2 = new Intent(MainActivity.this, TestLoginActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.one:
                        //进入登录页
                        Intent intent3 = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.two:
                        Toast.makeText(MainActivity.this, "暂未占用页面", Toast.LENGTH_SHORT).show();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);//每点击一个图标就关闭一次菜单栏
                return true;
            }
        });

        toolBar.setTitle("智康1622会议室");
        toolBar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolBar.inflateMenu(R.menu.left_menu);
        setSupportActionBar(toolBar);
        getSupportActionBar().setHomeButtonEnabled(true);//左侧图标滑出滑进变化
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧图标滑出滑进变化
        //创建ActionBarDrawerToggle配合下面使用
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        //设置联动监听
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        //同步一下
        actionBarDrawerToggle.syncState();

    }

    /**
     * 退出登录方法--清空缓存里的保存的token,和用户信息
     */
    private void logOut() {

        Object oToken = ACache.get(this).getAsObject(Constant.TOKEN);
        Object oUser = ACache.get(this).getAsObject(Constant.USER);
        if (oToken != null || oUser != null){
            //直接设置为空，然后将头像，名字还原为未登录状态即可
            ACache aCache = ACache.get(this);
            aCache.put(Constant.TOKEN,"");
            aCache.put(Constant.USER,"");

            iv_head.setImageDrawable(DrawableUtils.drawable(MainActivity.this, IconUtils.Icon.ion_jiaose, Color.parseColor("#ff6800"), 50));
            tv_head.setText("未登录");
            Toast.makeText(MainActivity.this, "您已退出该账号...", Toast.LENGTH_SHORT).show();
            headerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //进入登录页
                    Intent intent3 = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent3);
                }
            });
        }else {
            Toast.makeText(MainActivity.this, "还 T M 没 登 录 呢 ，你 点 个 毛 线 ！ ！ ！", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 返回键
     */
    @Override
    public void onBackPressed() {

        if (drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        super.onBackPressed();

    }

    /**
     * 接收RxBus传递来的数据
     */
    @Subscribe
    public void getuser(User user) {

        //加载用户头像及名字
        if (user != null && user.getLogo_url() != null && user.getUsername() != null){
            initHeadVIew(user);
        }else {
            iv_head.setImageDrawable(DrawableUtils.drawable(MainActivity.this, IconUtils.Icon.ion_jiaose, Color.parseColor("#ff6800"), 50));
            tv_head.setText("未登录");
        }

    }

    /**
     * 抽出复用方法--加载用户头像及名字
     */
    private void initHeadVIew(User user){

        Glide.with(this).load(user.getLogo_url()).transform(new GlideCircleTransform(this)).into(iv_head);//圆形头像
        tv_head.setText(user.getUsername());

    }

    /**
     * 判断缓存里有没有用户信息--有则直接加载用户信息，没有则点击登录先登录
     */
    private void initUser(){
        Object object = ACache.get(this).getAsObject(Constant.USER);
        if(object == null){

            headerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "左侧头部", Toast.LENGTH_SHORT).show();
                    //进入登录页
                    Intent intent3 = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent3);
                }
            });

        }else{

            User user = (User) object;
            //加载用户头像及名字
            initHeadVIew(user);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * RxBus注销
         */
        RxBus.get().unregister(this);
    }
}
