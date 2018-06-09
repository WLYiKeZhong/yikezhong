package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.VideosNearBean;

import io.reactivex.Observable;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class NearVideosApi {
    private static NearVideosApi nearVideosApi;
    private ApiService apiService;

    private NearVideosApi(ApiService apiService) {
        this.apiService = apiService;
    }

    public static NearVideosApi getNearVideosApi(ApiService apiService) {
        if (nearVideosApi == null) {
            nearVideosApi = new NearVideosApi(apiService);
        }
        return nearVideosApi;
    }

    public Observable<VideosNearBean> getNearVideos(String page, String token) {
        return apiService.getNearVideos(page,token);
    }
}
