package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.VideosBean;

import io.reactivex.Observable;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class VideosApi {
    private static VideosApi videosApi;
    private ApiService apiService;

    private VideosApi(ApiService apiService) {
        this.apiService = apiService;
    }

    public static VideosApi getVideosApi(ApiService apiService) {
        if (videosApi == null) {
            videosApi = new VideosApi(apiService);
        }
        return videosApi;
    }

    public Observable<VideosBean> getVideos(String uid,String type,String page) {
        return apiService.getVideos(uid,type,page);
    }
}
