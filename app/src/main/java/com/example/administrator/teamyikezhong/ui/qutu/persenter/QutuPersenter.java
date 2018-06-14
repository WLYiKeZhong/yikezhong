package com.example.administrator.teamyikezhong.ui.qutu.persenter;

import com.example.administrator.teamyikezhong.bean.VideosBean;
import com.example.administrator.teamyikezhong.net.VideosApi;
import com.example.administrator.teamyikezhong.ui.base.BasePersenter;
import com.example.administrator.teamyikezhong.ui.qutu.contract.QuTuContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class QutuPersenter extends BasePersenter<QuTuContract.View> implements  QuTuContract.Persenter  {

    private VideosApi videosApi;
          @Inject
    public QutuPersenter( VideosApi videosApi) {

              this.videosApi = videosApi;
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
