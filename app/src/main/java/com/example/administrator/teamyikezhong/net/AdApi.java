package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.AdBean;

import io.reactivex.Observable;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class AdApi  {
    private static AdApi adApi;
    private ApiService apiService;

    private AdApi(ApiService apiService) {
        this.apiService = apiService;
    }

    public static AdApi getAdApi(ApiService apiService) {
        if (adApi == null) {
            adApi = new AdApi(apiService);
        }
        return adApi;
    }

    public Observable<AdBean> getAd() {
        return apiService.getAd();
    }
}
