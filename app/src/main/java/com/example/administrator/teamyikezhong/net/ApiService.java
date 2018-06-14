package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.AdBean;
import com.example.administrator.teamyikezhong.bean.DetailBean;
import com.example.administrator.teamyikezhong.bean.DuanZiBean;
import com.example.administrator.teamyikezhong.bean.HotVideosBean;
import com.example.administrator.teamyikezhong.bean.JokeDetailBean;
import com.example.administrator.teamyikezhong.bean.ParsieBean;
import com.example.administrator.teamyikezhong.bean.VideosBean;
import com.example.administrator.teamyikezhong.bean.VideosNearBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public interface ApiService {
    //轮播图
 @GET("quarter/getAd")
    Observable<AdBean> getAd();
 //推荐的视频
    @GET("quarter/getVideos")
    Observable<VideosBean> getVideos(@Query("uid") String uid, @Query("type") String type, @Query("page") String page);
 //段子
  @GET("quarter/getJokes ")
    Observable<DuanZiBean>  getJokes(@Query("page") String page, @Query("token") String token);
//视频热门
@GET("quarter/getHotVideos")
    Observable<HotVideosBean>getHotVideos(@Query("page") String page,@Query("token") String token);
//视频附近
    @GET("quarter/getNearVideos")
    Observable<VideosNearBean>getNearVideos(@Query("page") String page, @Query("token") String token);
//视频详情
@GET("quarter/getVideoDetail")
    Observable<DetailBean> getVideoDetai(@Query("wid") String wid);
    //段子详情
    @GET("quarter/getJokeDetail")
    Observable<JokeDetailBean> getJokeDetail(@Query("jid") String jid);
       //点赞
    @GET("quarter/praise")
    Observable<ParsieBean> getPraise(@Query("uid") String uid,@Query("wid") String wid,@Query("token") String token);
  //添加收藏
    @GET("quarter/addFavorite")
    Observable<ParsieBean> addFavorite(@Query("uid") String uid,@Query("wid") String wid,@Query("token") String token);
    //取消收藏
    @GET("quarter/cancelFavorite")
    Observable<ParsieBean> cancelFavorite(@Query("uid") String uid,@Query("wid") String wid,@Query("token") String token);
}
