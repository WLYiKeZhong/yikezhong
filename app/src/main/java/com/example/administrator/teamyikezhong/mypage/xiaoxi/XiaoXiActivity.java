package com.example.administrator.teamyikezhong.mypage.xiaoxi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.mypage.guanzhu.hotfollow.fragment.HotFragment;
import com.example.administrator.teamyikezhong.mypage.guanzhu.hotfollow.fragment.OtherFragment;
import com.example.administrator.teamyikezhong.mypage.xiaoxi.fragment.SiFragment;
import com.example.administrator.teamyikezhong.mypage.xiaoxi.fragment.XiaoFragment;

import java.util.ArrayList;
import java.util.List;

public class XiaoXiActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImg;
    /**
     * 返回
     */
    private TextView mFanhui;
    private TabLayout mTabs;
    private ViewPager mPager;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiao_xi);
        inittabs();
        initView();
    }
    private void inittabs() {
        list = new ArrayList<>();
        list.add("消息");
        list.add("私信");



    }
    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mFanhui = (TextView) findViewById(R.id.fanhui);
        mFanhui.setOnClickListener(this);
        mTabs = (TabLayout) findViewById(R.id.tabs);
        mPager = (ViewPager) findViewById(R.id.pager);

        //设置关联
        mTabs.setupWithViewPager(mPager);
        mPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position==0){
                    Fragment fr01 = new XiaoFragment();
                    return fr01;
                }else{
                    Fragment fr02 = new SiFragment();
                    return fr02;
                }


            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                finish();
                break;
        }
    }
}
