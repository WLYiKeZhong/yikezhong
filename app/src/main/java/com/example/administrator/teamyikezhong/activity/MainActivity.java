package com.example.administrator.teamyikezhong.activity;
import com.example.administrator.teamyikezhong.R;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.example.administrator.teamyikezhong.fragment.PhotosFragment;
import com.example.administrator.teamyikezhong.mypage.login.LoginActivity;
import com.example.administrator.teamyikezhong.ui.duanzi.ParagraphFragment;
import com.example.administrator.teamyikezhong.ui.tuijian.RecommendFragment;
import com.example.administrator.teamyikezhong.fragment.VideoFragment;
import com.example.administrator.teamyikezhong.title.TitleActivity;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar mBtbar;
    private DrawerLayout drawerlayout;
    private TitleActivity ta;
    private SimpleDraweeView cesdv;
    private ListView lv;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
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
        SimpleAdapter adapter = new SimpleAdapter(this, list,
                R.layout.drawerlist_item, new String[] { "name", "image" },
                new int[] { R.id.tv_name, R.id.img });
// 3 填充
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this,list.get(position).toString(),Toast.LENGTH_SHORT).show();
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
        String uid = (String) SharedPreferencesUtils.getParam(MainActivity.this, "uid", "-1");
        String name = (String) SharedPreferencesUtils.getParam(MainActivity.this, "name", "");
        String iconUrl = (String) SharedPreferencesUtils.getParam(MainActivity.this, "iconUrl", "");
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

    }
});

    }
}
