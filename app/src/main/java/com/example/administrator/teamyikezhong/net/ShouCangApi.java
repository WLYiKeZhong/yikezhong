package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.ParsieBean;

import io.reactivex.Observable;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class ShouCangApi {
    private static ShouCangApi tongYongApi;
    private ApiService apiService;

    private ShouCangApi(ApiService apiService) {
        this.apiService = apiService;
    }

    public static ShouCangApi getTongYongApi(ApiService apiService) {
        if (tongYongApi == null) {
            tongYongApi = new ShouCangApi(apiService);
        }
        return tongYongApi;
    }

    public   Observable<ParsieBean> addFavorite(String uid,String wid,String token) {
        return apiService.addFavorite(uid,wid,token);
    }
    public   Observable<ParsieBean> cancelFavorite(String uid,String wid,String token) {
        return apiService.cancelFavorite(uid,wid,token);
    }
}
