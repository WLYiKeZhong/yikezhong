package com.example.administrator.teamyikezhong.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.mypage.collection.CollectionActivity;
import com.example.administrator.teamyikezhong.mypage.fabu.FaBuActivity;
import com.example.administrator.teamyikezhong.mypage.friends.FriendsActivity;
import com.example.administrator.teamyikezhong.mypage.guanzhu.MyFollowActivity;
import com.example.administrator.teamyikezhong.mypage.login.LoginActivity;
import com.example.administrator.teamyikezhong.mypage.shezhi.ShezhiActivity;
import com.example.administrator.teamyikezhong.mypage.xiaoxi.XiaoXiActivity;
import com.example.administrator.teamyikezhong.mypage.zuopin.MyZuoPinActivity;
import com.example.administrator.teamyikezhong.title.TitleActivity;
import com.example.administrator.teamyikezhong.ui.duanzi.ParagraphFragment;
import com.example.administrator.teamyikezhong.ui.qutu.PhotosFragment;
import com.example.administrator.teamyikezhong.ui.tuijian.RecommendFragment;
import com.example.administrator.teamyikezhong.ui.videos.VideoFragment;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    /**
     * 日间模式
     */
    private final static int DAY_THEME = 1;

    /**
     * 夜间模式
     */
    private final static int NIGHT_THEME = 2;

    private int width;
    private int height;
    private int statusBarHeight;
    private BottomTabBar mBtbar;
    private DrawerLayout drawerlayout;
    private TitleActivity ta;
    private SimpleDraweeView cesdv;
    private ListView lv;
    private TextView tvName;
    //    private String name;
//    private String iconUrl;
    private ImageView mMianDay;
    private ImageView zuopin;
    private ImageView shezhi;
    private Button mMainNone;
    private LinearLayout mLinearNightMode;
    private RelativeLayout left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        getInitData();
        cesdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击了图片",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                drawerlayout.closeDrawer(Gravity.LEFT);
            }
        });

// 1创建数据
        final List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("name", "我的关注");
        map1.put("image", R.drawable.raw_1499933216);

        HashMap<String, Object> map2 = new HashMap<String, Object>();
        map2.put("name", "我的收藏");
        map2.put("image", R.drawable.raw_1499947358);

        HashMap<String, Object> map3 = new HashMap<String, Object>();
        map3.put("name", "搜索好友");
        map3.put("image", R.drawable.raw_1499946865);

        HashMap<String, Object> map4 = new HashMap<String, Object>();
        map4.put("name", "消息通知");
        map4.put("image", R.drawable.raw_1499947389);
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        // 2创建适配器
        final SimpleAdapter adapter = new SimpleAdapter(this, list,
                R.layout.drawerlist_item, new String[] { "name", "image" },
                new int[] { R.id.tv_name, R.id.img });
// 3 填充
        lv.setAdapter(adapter);

        // long itemId = adapter.getItemId(0);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(MainActivity.this,list.get(position).toString(),Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this,"0",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, MyFollowActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this,"1",Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(MainActivity.this, CollectionActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this,"2",Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(MainActivity.this, FriendsActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this,"3",Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(MainActivity.this, XiaoXiActivity.class);
                        startActivity(intent3);
                        break;
                }

            }
        });




    }

    private void initView() {
        mBtbar = (BottomTabBar) findViewById(R.id.btbar);
        drawerlayout = findViewById(R.id.drawerlayout);
        cesdv = findViewById(R.id.cesdv);
        ta = findViewById(R.id.ta);
        lv = findViewById(R.id.lv);
        tvName = findViewById(R.id.tvName);
        shezhi = findViewById(R.id.shezhi);
        zuopin = findViewById(R.id.zuopin);

        mMianDay = (ImageView) findViewById(R.id.mian_day);
        mMainNone =  findViewById(R.id.main_none);
        // mMainNone.setOnClickListener(this);
        mLinearNightMode = (LinearLayout) findViewById(R.id.linear_nightMode);
        left = (RelativeLayout) findViewById(R.id.left);
        String uid = (String) SharedPreferencesUtils.getParam(MainActivity.this, "uid", "-1");
        String name = (String) SharedPreferencesUtils.getParam(MainActivity.this, "name", "");
        String iconUrl = (String) SharedPreferencesUtils.getParam(MainActivity.this, "iconUrl", "");

        //设置夜间模式
        mMainNone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchDayNightTheme();
                //加载当前的主题
                if (getCurrentTheme() == DAY_THEME) {
                    setDayThemeInfo();
                } else if (getCurrentTheme() == NIGHT_THEME) {
                    setNightThemeInfo();
                } else {
                    setDayThemeInfo();
                }
            }
        });

        //设置
        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShezhiActivity.class);
                startActivity(intent);
            }
        });
        //我的作品
        zuopin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyZuoPinActivity.class);
                startActivity(intent);
            }
        });
        if ("-1".equals(uid)){
            //return;
        }else{
            tvName.setText(name);
            cesdv.setImageURI(iconUrl);
        }
        mBtbar.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(15)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("推荐",R.drawable.raw_1500085367,R.drawable.raw_1500083878, RecommendFragment.class)
                .addTabItem("段子",R.drawable.raw_1500085899,R.drawable.raw_1500085327, ParagraphFragment.class)
                .addTabItem("视频",R.drawable.raw_1500086067,R.drawable.raw_1500083686, VideoFragment.class)
                .addTabItem("趣图",R.drawable.raw_1500085367,R.drawable.raw_1500083878, PhotosFragment.class)
                .isShowDivider(true)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        ta.setTitle(name);
                    }
                });

        ta.setOnItemTitleClickListener(new TitleActivity.OnItemTitleClickListener() {
            @Override
            public void onClickleft(View v) {
                drawerlayout.openDrawer(Gravity.LEFT);

            }

            @Override
            public void onClickrigth(View v) {
                Intent intent = new Intent(MainActivity.this, FaBuActivity.class);
                startActivity(intent);
            }
        });

    }

    private void getInitData() {
        WindowManager wm = this.getWindowManager();
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();

        //获取status_bar_height资源的ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
    }

    /**
     * 设置模式
     *
     * @param dayTheme
     */
    private void setMyTheme(int dayTheme) {
        switch (dayTheme) {
            case DAY_THEME:
                setDayTheme();
                break;
            case NIGHT_THEME:
                setNightTheme();
                break;
            default:
                setDayTheme();
                break;
        }
    }

    /**
     * 设置夜间模式
     */
    private void setNightTheme() {
        final ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(width, height - statusBarHeight));

        mLinearNightMode.addView(imageView);
        //设置新主题
        setNightThemeInfo();

    }

    boolean flag = true;

    /**
     * 设置夜间模式具体代码
     */
    private void setNightThemeInfo() {
        drawerlayout.setBackgroundColor(Color.parseColor("#333444"));
        left.setBackgroundColor(Color.parseColor("#333444"));
        mMianDay.setImageResource(R.drawable.a);
        mMainNone.setText("关闭");
        // mMainNone.setImageResource(R.mipmap.select);
    }

    /**
     * 设置日渐模式具体代码
     */
    private void setDayThemeInfo() {
        drawerlayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        left.setBackgroundColor(Color.parseColor("#FFFFFF"));
        mMianDay.setImageResource(R.drawable.yl);
        mMainNone.setText("开启");
        // mMainNone.setImageResource(R.mipmap.none);
    }

    /**
     * 设置日间模式
     */
    private void setDayTheme() {
        final ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(width, height - statusBarHeight));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        mLinearNightMode.addView(imageView);
        //设置新主题
        setDayThemeInfo();


    }


    /**
     * 切换日渐模式或夜间模式
     */
    private void switchDayNightTheme() {
        int curMode = getCurrentTheme();
        switch (curMode) {
            case DAY_THEME:
                saveCurrentTheme(NIGHT_THEME);
                setMyTheme(NIGHT_THEME);
                break;
            case NIGHT_THEME:
                saveCurrentTheme(DAY_THEME);
                setMyTheme(DAY_THEME);
                break;
            default:
                saveCurrentTheme(DAY_THEME);
                setMyTheme(DAY_THEME);
                break;
        }
    }


    /**
     * 保存当前模式
     *
     * @param mode
     */
    private void saveCurrentTheme(int mode) {
        SharedPreferences preferences = getSharedPreferences("AppTheme", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("mode", mode);
        editor.apply();
    }


    /**
     * 获取当前模式
     *
     * @m mode
     */
    private int getCurrentTheme() {
        SharedPreferences preferences = getSharedPreferences("AppTheme", Context.MODE_PRIVATE);
        int currentMode = preferences.getInt("mode", 0);
        return currentMode;
    }

}
