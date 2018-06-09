package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.HotVideosBean;

import io.reactivex.Observable;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class HotVideosApi {
    private static HotVideosApi hotVideosApi;
    private ApiService apiService;

    private HotVideosApi(ApiService apiService) {
        this.apiService = apiService;
    }

    public static HotVideosApi getHotVideosApi(ApiService apiService) {
        if (hotVideosApi == null) {
            hotVideosApi = new HotVideosApi(apiService);
        }
        return hotVideosApi;
    }

    public Observable<HotVideosBean> getHotVideos(String page,String token) {
        return apiService.getHotVideos(page,token);
    }
}
