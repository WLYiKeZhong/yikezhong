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
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class TuiJian_GuanZhu extends BaseFragment<RenMenPersenter> implements RecommendRenMenContract.View,TongYongContract.View {

    private RecyclerView guanZhurecyView;
    TongYongPersenter mPersenters;
    @Override
    public int getContentLayout() {
        return R.layout.tuijian_guanzhu_fragment;
    }

    @Override
    public void inject() {
       DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        guanZhurecyView = view.findViewById(R.id.guanZhurecyView);
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
    public void onAdSuccess(AdBean adBean) {

    }

    @Override
    public void onVideosSuccess(VideosBean videosBean) {
        Log.d("videos", videosBean.getMsg());

        VideosAdapter videosAdapter = new VideosAdapter(mPersenters,getActivity(), videosBean);
        guanZhurecyView.setAdapter(videosAdapter);
        guanZhurecyView.setLayoutManager(new LinearLayoutManager(getActivity()));
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
