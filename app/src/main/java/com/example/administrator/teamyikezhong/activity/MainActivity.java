package com.example.administrator.teamyikezhong.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.ui.duanzi.ParagraphFragment;
import com.example.administrator.teamyikezhong.fragment.VideoFragment;
import com.example.administrator.teamyikezhong.ui.tuijian.RecommendFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar mBtbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mBtbar = (BottomTabBar) findViewById(R.id.btbar);
        mBtbar.init(getSupportFragmentManager())
                .setImgSize(80,80)
                .addTabItem(" ",R.drawable.tuijian2,R.drawable.tuijian1, RecommendFragment.class)
                .addTabItem("  ",R.drawable.duanzi2,R.drawable.duanzi1, ParagraphFragment.class)
                .addTabItem("   ",R.drawable.shipin2,R.drawable.shipin1, VideoFragment.class)
               // .addTabItem("趣图",null, PhotosFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                    }
                });


    }
}
