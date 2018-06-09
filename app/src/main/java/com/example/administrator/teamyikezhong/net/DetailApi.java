package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.DetailBean;

import io.reactivex.Observable;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class DetailApi {
    private static DetailApi detailApi;
    private ApiService apiService;

    private DetailApi(ApiService apiService) {
        this.apiService = apiService;
    }

    public static DetailApi getDetailApi(ApiService apiService) {
        if (detailApi == null) {
            detailApi = new DetailApi(apiService);
        }
        return detailApi;
    }

    public Observable<DetailBean> getVideoDetai(String wid) {
        return apiService.getVideoDetai(wid);
    }
}
