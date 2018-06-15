package com.example.administrator.teamyikezhong.ui.tuijian;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.AdBean;
import com.example.administrator.teamyikezhong.bean.ParsieBean;
import com.example.administrator.teamyikezhong.bean.VideosBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.ui.base.BaseFragment;
import com.example.administrator.teamyikezhong.ui.tuijian.adapter.VideosAdapter;
import com.example.administrator.teamyikezhong.ui.tuijian.contract.RecommendRenMenContract;
import com.example.administrator.teamyikezhong.ui.tuijian.contract.TongYongContract;
import com.example.administrator.teamyikezhong.ui.tuijian.persenter.RenMenPersenter;
import com.example.administrator.teamyikezhong.ui.tuijian.persenter.TongYongPersenter;
import com.example.administrator.teamyikezhong.utils.MyBanner;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class TuiJian_ReMen extends BaseFragment<RenMenPersenter> implements RecommendRenMenContract.View,TongYongContract.View{

    private Banner mReMenbanner;
    private RecyclerView mRMView;
    private View view;
    private SmartRefreshLayout smart_layout;
    private VideosAdapter videosAdapter;
    TongYongPersenter mPersenters;
    @Override
    public int getContentLayout() {
        return R.layout.tuijian_renmen_fragment;
    }

    @Override
    public void inject() {
       DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {

        mReMenbanner = (Banner) view.findViewById(R.id.reMenbanner);
        mRMView = (RecyclerView) view.findViewById(R.id.rM_View);
        smart_layout = (SmartRefreshLayout) view.findViewById(R.id.smart_layout);

        smart_layout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                smart_layout.finishLoadmore();
            }
        });
        smart_layout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                smart_layout.finishRefresh();
            }
        });

        initVideos();

    }

    public void initVideos() {
        String uid = String.valueOf(SharedPreferencesUtils.getParam(getActivity(), "uid", ""));


        String type = "1";
        String page = "1";
        mPersenter.getAd();
        mPersenter.getVideos(uid,type, page);
    }

    /**
     * 轮播图
     *
     * @param adBean
     */
    @Override
    public void onAdSuccess(AdBean adBean) {
        Log.d("ad", adBean.getData().get(0).getTitle());
        List<AdBean.DataBean> data = adBean.getData();
        List<String> imageList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String icon = data.get(i).getIcon();
            imageList.add(icon);
        }
        mReMenbanner.setImageLoader(new MyBanner());
        mReMenbanner.setImages(imageList);
        mReMenbanner.start();
    }

    @Override
    public void onVideosSuccess(VideosBean videosBean) {

        Log.d("videos", videosBean.getMsg());
        videosAdapter = new VideosAdapter(mPersenters,getActivity(), videosBean);
        mRMView.setAdapter(videosAdapter);
        mRMView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }


    @Override
    public void onTongyongSuccess(ParsieBean parsieBean) {

        int code = Integer.parseInt(parsieBean.getCode());
        if (code==0){
            Toast.makeText(getActivity(),parsieBean.getMsg(),Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getActivity(),parsieBean.getMsg(),Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onShouCangSuccess(ParsieBean parsieBean) {
        int code = Integer.parseInt(parsieBean.getCode());
        if (code==0){

            Toast.makeText(getActivity(),parsieBean.getMsg(),Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getActivity(),parsieBean.getMsg(),Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onQuXiaoSuccess(ParsieBean parsieBean) {
        int code = Integer.parseInt(parsieBean.getCode());
        if (code==0){

            Toast.makeText(getActivity(),parsieBean.getMsg(),Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getActivity(),parsieBean.getMsg(),Toast.LENGTH_SHORT).show();

        }
    }


}
