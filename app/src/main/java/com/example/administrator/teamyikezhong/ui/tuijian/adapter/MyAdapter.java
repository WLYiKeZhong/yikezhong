package com.example.administrator.teamyikezhong.ui.tuijian.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class MyAdapter extends FragmentPagerAdapter {
    private  List<Fragment> list;
   private List<String> data;

    public MyAdapter(FragmentManager fm, List<Fragment> list,List<String> data) {
        super(fm);
        this.list=list;
        this.data=data;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    public List<Fragment> getList() {
        return list;
    }
    public void setList(List<Fragment> list) {
        this.list = list;
    }
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position);
    }
}
