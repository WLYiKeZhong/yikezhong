package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.AdBean;
import com.example.administrator.teamyikezhong.bean.DuanZiBean;
import com.example.administrator.teamyikezhong.bean.VideosBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public interface ApiService {
 @GET("quarter/getAd")
    Observable<AdBean> getAd();
    @GET("quarter/getVideos")
    Observable<VideosBean> getVideos(@Query("uid") String uid, @Query("type") String type, @Query("page") String page);
  /* @GET("satinApi")
   Observable<VideosBean> getVideos(@Query("type") String type,@Query("page")String page);*/
  @GET("quarter/getJokes ")
    Observable<DuanZiBean>  getJokes(@Query("page") String page, @Query("token") String token);
}
