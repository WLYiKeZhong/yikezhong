package com.example.administrator.teamyikezhong.ui.videos;

import android.content.Intent;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.VideosNearBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.inter.OnItemLinter;
import com.example.administrator.teamyikezhong.ui.base.BaseFragment;
import com.example.administrator.teamyikezhong.ui.detail.VideosDeailActivity;
import com.example.administrator.teamyikezhong.ui.videos.adapter.NearVideoAdapter;
import com.example.administrator.teamyikezhong.ui.videos.contract.VideosFuJinContract;
import com.example.administrator.teamyikezhong.ui.videos.persenter.VideoFuJinPersenter;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 兰昊琼 on 2018/6/6.
 */

public class VideosFuJin extends BaseFragment<VideoFuJinPersenter> implements VideosFuJinContract.View {

    private XRecyclerView xrecy_view;
    private List<VideosNearBean.DataBean> data=new ArrayList<>();
    int page=1;
    @Override
    public int getContentLayout() {
        return R.layout.videos_fujin_fragment;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        xrecy_view = view.findViewById(R.id.xrecy_view);
        xrecy_view.setLoadingMoreEnabled(true);
        xrecy_view.setPullRefreshEnabled(true);
        //刷新数据
        xrecy_view.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                initVieos(page);
                xrecy_view.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
               initVieos(page);

            }
        });
        initVieos(  page);
    }
    public  void  initVieos( int page){
        String token= String.valueOf(SharedPreferencesUtils.getParam(getActivity(),"token",""));

        mPersenter.getNearVideos(String.valueOf(page),token);
    }
    @Override
    public void onNearVideosSuccess(VideosNearBean videosNearBean) {
        xrecy_view.refreshComplete();//关闭刷新
        data = videosNearBean.getData();
        NearVideoAdapter nearVideoAdapter=new NearVideoAdapter(getActivity(), data);
        xrecy_view.setAdapter(nearVideoAdapter);
        xrecy_view.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        nearVideoAdapter.onVideosItemLintenr(new OnItemLinter() {
            @Override
            public void onItemClick(int postion) {
                //跳转详情页面
                Intent intent=new Intent(getActivity(),VideosDeailActivity.class);
                intent.putExtra("wid",data.get(postion).getWid());
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(int postion) {

            }
        });
    }
}
