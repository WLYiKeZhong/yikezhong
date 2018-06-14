package com.example.administrator.teamyikezhong.ui.qutu;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.VideosBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.ui.base.BaseFragment;
import com.example.administrator.teamyikezhong.ui.qutu.contract.QuTuContract;
import com.example.administrator.teamyikezhong.ui.qutu.persenter.QutuPersenter;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class PhotosFragment extends BaseFragment<QutuPersenter>implements QuTuContract.View {


    private XRecyclerView mXrecyView;


    @Override
    public int getContentLayout() {
        return R.layout.photosfragment;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);

    }

    @Override
    public void initView(View view) {

        mXrecyView = (XRecyclerView) view.findViewById(R.id.xrecyView);
        initVideos();
    }

    public void initVideos() {
        String uid = String.valueOf(SharedPreferencesUtils.getParam(getActivity(), "uid", ""));


        //String uid = "10206";

        String type = "1";
        String page = "1";

        mPersenter.getVideos(uid, type, page);
    }


    @Override
    public void onVideosSuccess(VideosBean videosBean) {
        QutuAdapter qutuAdapter = new QutuAdapter(getActivity(), videosBean);
        mXrecyView.setAdapter(qutuAdapter);
        mXrecyView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    }


