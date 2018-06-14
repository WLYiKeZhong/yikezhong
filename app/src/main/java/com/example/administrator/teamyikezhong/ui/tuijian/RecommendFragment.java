package com.example.administrator.teamyikezhong.ui.tuijian;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.ui.tuijian.adapter.MyAdapter;
import com.example.administrator.teamyikezhong.ui.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class RecommendFragment extends BaseFragment {

    private TabLayout mMainTab;
    private ViewPager mTuijianViewpager;

    @Override
    public int getContentLayout() {
        return R.layout.recommendfragment;
    }

    @Override
    public void inject() {

    }

    @Override
    public void initView(View view) {

        mMainTab = (TabLayout) view.findViewById(R.id.main_tab);
        mTuijianViewpager = (ViewPager) view.findViewById(R.id.tuijian_viewpager);
        initData();
    }
    public  void  initData(){
        ArrayList<Fragment> list = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();

        list.add(new TuiJian_ReMen());
        list.add(new TuiJian_GuanZhu());
        data.add("热门");
        data.add("关注");

        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager(),list,data);
        mTuijianViewpager.setAdapter(myAdapter);
        //final boolean isLogin = CommonUtils.getBoolean("isLogin");
        mMainTab.setupWithViewPager(mTuijianViewpager);
    }
}
