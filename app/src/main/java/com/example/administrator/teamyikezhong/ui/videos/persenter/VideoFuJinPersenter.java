package com.example.administrator.teamyikezhong.ui.videos.persenter;

import com.example.administrator.teamyikezhong.bean.VideosNearBean;
import com.example.administrator.teamyikezhong.net.NearVideosApi;
import com.example.administrator.teamyikezhong.ui.base.BasePersenter;
import com.example.administrator.teamyikezhong.ui.videos.contract.VideosFuJinContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 兰昊琼 on 2018/6/7.
 */

public class VideoFuJinPersenter extends BasePersenter<VideosFuJinContract.View> implements  VideosFuJinContract.Persenter {
  private NearVideosApi nearVideosApi;
      @Inject
    public VideoFuJinPersenter(NearVideosApi nearVideosApi) {
        this.nearVideosApi = nearVideosApi;
    }


    @Override
    public void getNearVideos(String page, String token) {
        nearVideosApi.getNearVideos(page,token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<VideosNearBean>() {
                    @Override
                    public void accept(VideosNearBean videosNearBean) throws Exception {
                        mView.onNearVideosSuccess(videosNearBean);
                    }
                });
    }
}
