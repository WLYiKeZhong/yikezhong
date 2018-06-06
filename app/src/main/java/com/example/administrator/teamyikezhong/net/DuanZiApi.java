package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.DuanZiBean;

import io.reactivex.Observable;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class DuanZiApi {
    private static DuanZiApi duanZiApi;
    private ApiService apiService;

    private DuanZiApi(ApiService apiService) {
        this.apiService = apiService;
    }

    public static DuanZiApi getDuanZiApi(ApiService apiService) {
        if (duanZiApi == null) {
            duanZiApi = new DuanZiApi(apiService);
        }
        return duanZiApi;
    }

    public Observable<DuanZiBean> getJokes(String page,String token) {
        return apiService.getJokes(page,token);
    }
}
