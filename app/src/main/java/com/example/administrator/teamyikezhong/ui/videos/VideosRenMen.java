package com.example.administrator.teamyikezhong.ui.videos;

import android.content.Intent;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.HotVideosBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.inter.OnItemLinter;
import com.example.administrator.teamyikezhong.ui.base.BaseFragment;
import com.example.administrator.teamyikezhong.ui.detail.VideosDeailActivity;
import com.example.administrator.teamyikezhong.ui.videos.adapter.HotVideosAdapter;
import com.example.administrator.teamyikezhong.ui.videos.contract.VideosRenMenContract;
import com.example.administrator.teamyikezhong.ui.videos.persenter.VideoRenMenPersenter;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 兰昊琼 on 2018/6/6.
 */

public class VideosRenMen extends BaseFragment<VideoRenMenPersenter> implements VideosRenMenContract.View {

    private XRecyclerView videosView;
    private List<HotVideosBean.DataBean> data=new ArrayList<>();
    int page=1;
    @Override
    public int getContentLayout() {
        return R.layout.videos_remen_fragment;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        videosView = view.findViewById(R.id.videosView);
        videosView.setLoadingMoreEnabled(true);
        videosView.setPullRefreshEnabled(true);
        //刷新数据
        videosView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                initVieos(page);
                videosView.refreshComplete();
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

    mPersenter.getHotVideos(String.valueOf(page),token);
}

    @Override
    public void onHotVideosSuccess(HotVideosBean hotVideosBean) {
        videosView.refreshComplete();//关闭刷新
        data = hotVideosBean.getData();
        HotVideosAdapter hotVideosAdapter=new HotVideosAdapter(getActivity(),data);
        videosView.setAdapter(hotVideosAdapter);
        videosView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        hotVideosAdapter.onVideosItemLintenr(new OnItemLinter() {
            @Override
            public void onItemClick(int postion) {
                //跳转详情页面
                Intent intent=new Intent(getActivity(),VideosDeailActivity.class);
                 /* SharedPreferencesUtils.setParam(getActivity(),"wid",data.get(postion).getWid());*/
                 intent.putExtra("wid",data.get(postion).getWid());
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(int postion) {

            }
        });
    }
}
