package com.example.administrator.teamyikezhong.mypage.guanzhu.hotfollow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.mypage.guanzhu.hotfollow.fragment.HotFragment;
import com.example.administrator.teamyikezhong.mypage.guanzhu.hotfollow.fragment.OtherFragment;

import java.util.ArrayList;
import java.util.List;

public class HotFollowActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout mTabs;
    private ViewPager mPager;
    /**
     * 返回
     */
    private TextView mFanhui;
    /**
     * 输入关键字
     */
    private EditText mRemen;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_follow);

        inittabs();
        initView();
    }

    private void initView() {
        mTabs = (TabLayout) findViewById(R.id.tabs);
        mPager = (ViewPager) findViewById(R.id.pager);
        mFanhui = (TextView) findViewById(R.id.fanhui);
        mFanhui.setOnClickListener(this);
        mRemen = (EditText) findViewById(R.id.remen);

        //设置关联
        mTabs.setupWithViewPager(mPager);
        mPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position==0){
                    Fragment fr01 = new HotFragment();
                    return fr01;
                }else{
                    Fragment fr02 = new OtherFragment();
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
    private void inittabs() {
        list = new ArrayList<>();
        list.add("新闻");
        list.add("爆笑");
        list.add("励志");
        list.add("美食");
        list.add("娱乐");
        list.add("社会");
        list.add("体育");
        list.add("热点");
        list.add("科技");
        list.add("视频");


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
