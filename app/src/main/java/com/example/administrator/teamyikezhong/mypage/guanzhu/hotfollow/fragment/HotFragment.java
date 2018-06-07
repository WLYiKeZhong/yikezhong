package com.example.administrator.teamyikezhong.mypage.guanzhu.hotfollow.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.HotFollowBean;


import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.mypage.guanzhu.hotfollow.HotFollowContract;
import com.example.administrator.teamyikezhong.mypage.guanzhu.hotfollow.HotFollowPresenter;
import com.example.administrator.teamyikezhong.mypage.guanzhu.hotfollow.adapter.RvAdapter;
import com.example.administrator.teamyikezhong.ui.base.BaseFragment;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/6/7 0007.
 */

public class HotFragment extends BaseFragment<HotFollowPresenter> implements HotFollowContract.view {


    private RecyclerView rv;

    @Override
    public int getContentLayout() {
        return R.layout.hotfragment;
    }

    @Override
    public void inject() {

        DaggerHttpComponent.builder().build().inject(this);
    }

    @Override
    public void initView(View view) {
        rv = view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(),RecyclerView.VERTICAL));
        String uid = (String) SharedPreferencesUtils.getParam(getActivity(), "uid", "-1");
        String token = (String) SharedPreferencesUtils.getParam(getActivity(), "token", "");
        mPersenter.getHotVideos("1",token);
    }

    @Override
    public void getHotVideos(HotFollowBean hotFollowBean) {
        List<HotFollowBean.DataBean> data = hotFollowBean.getData();
        RvAdapter adapter = new RvAdapter(getContext(),data);
        rv.setAdapter(adapter);
    }
}
