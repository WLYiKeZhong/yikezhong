package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.ParsieBean;

import io.reactivex.Observable;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class TongYongApi {
    private static TongYongApi tongYongApi;
    private ApiService apiService;

    private TongYongApi(ApiService apiService) {
        this.apiService = apiService;
    }

    public static TongYongApi getTongYongApi(ApiService apiService) {
        if (tongYongApi == null) {
            tongYongApi = new TongYongApi(apiService);
        }
        return tongYongApi;
    }

    public   Observable<ParsieBean> getTongYong(String uid,String wid,String token) {
        return apiService.getPraise(uid,wid,token);
    }
    public   Observable<ParsieBean> addFavorite(String uid,String wid,String token) {
        return apiService.addFavorite(uid,wid,token);
    }
}
