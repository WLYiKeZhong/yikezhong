package com.example.administrator.teamyikezhong.ui.videos;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.ui.base.BaseFragment;
import com.example.administrator.teamyikezhong.ui.tuijian.adapter.MyAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class VideoFragment extends BaseFragment{
    private TabLayout videos_tab;
    private ViewPager videos_viewpager;

    @Override
    public int getContentLayout() {
        return R.layout.videofragment;
    }

    @Override
    public void inject() {

    }

    @Override
    public void initView(View view) {
        videos_tab = (TabLayout) view.findViewById(R.id.videos_tab);
        videos_viewpager = (ViewPager) view.findViewById(R.id.videos_viewpager);
        initData();
    }

    private void initData() {
        ArrayList<Fragment> list = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();

        list.add(new VideosRenMen());
        list.add(new VideosFuJin());
        data.add("热门");
        data.add("附近");

        MyAdapter myAdapter = new MyAdapter(getFragmentManager(),list,data);
        videos_viewpager.setAdapter(myAdapter);
        //final boolean isLogin = CommonUtils.getBoolean("isLogin");
        videos_tab .setupWithViewPager(videos_viewpager);
    }
}
