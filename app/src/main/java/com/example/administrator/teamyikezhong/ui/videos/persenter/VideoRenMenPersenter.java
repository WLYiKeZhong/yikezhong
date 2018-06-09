package com.example.administrator.teamyikezhong.ui.videos.persenter;

import com.example.administrator.teamyikezhong.bean.HotVideosBean;
import com.example.administrator.teamyikezhong.net.HotVideosApi;
import com.example.administrator.teamyikezhong.ui.base.BasePersenter;
import com.example.administrator.teamyikezhong.ui.videos.contract.VideosRenMenContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 兰昊琼 on 2018/6/7.
 */

public class VideoRenMenPersenter extends BasePersenter<VideosRenMenContract.View> implements  VideosRenMenContract.Persenter {
  private HotVideosApi hotVideosApi;
      @Inject
    public VideoRenMenPersenter(HotVideosApi hotVideosApi) {
        this.hotVideosApi = hotVideosApi;
    }

    @Override
    public void getHotVideos(String page,String token) {
     hotVideosApi.getHotVideos(page,token)
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(new Consumer<HotVideosBean>() {
                 @Override
                 public void accept(HotVideosBean hotVideosBean) throws Exception {
                     mView.onHotVideosSuccess(hotVideosBean);
                 }
             });
    }
}
