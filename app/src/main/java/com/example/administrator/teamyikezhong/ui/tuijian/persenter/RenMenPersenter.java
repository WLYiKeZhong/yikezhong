package com.example.administrator.teamyikezhong.ui.tuijian.persenter;

import com.example.administrator.teamyikezhong.bean.AdBean;
import com.example.administrator.teamyikezhong.bean.VideosBean;
import com.example.administrator.teamyikezhong.net.AdApi;
import com.example.administrator.teamyikezhong.net.VideosApi;
import com.example.administrator.teamyikezhong.ui.base.BasePersenter;
import com.example.administrator.teamyikezhong.ui.tuijian.contract.RecommendRenMenContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class RenMenPersenter extends BasePersenter<RecommendRenMenContract.View> implements  RecommendRenMenContract.Persenter  {
    private AdApi adApi;
    private VideosApi videosApi;
          @Inject
    public RenMenPersenter(AdApi adApi, VideosApi videosApi) {
        this.adApi = adApi;
              this.videosApi = videosApi;
    }

    @Override
    public void getAd() {
     adApi.getAd()
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(new Consumer<AdBean>() {
                 @Override
                 public void accept(AdBean adBean) throws Exception {
                     mView.onAdSuccess(adBean);
                 }
             });
    }

    @Override
    public void getVideos( String uid,String type, String page) {
       videosApi.getVideos(uid,type,page)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Consumer<VideosBean>() {
                   @Override
                   public void accept(VideosBean videosBean) throws Exception {
                       mView.onVideosSuccess(videosBean);
                   }
               });
    }
}
