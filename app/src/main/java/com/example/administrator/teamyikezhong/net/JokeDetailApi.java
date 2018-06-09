package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.JokeDetailBean;

import io.reactivex.Observable;

/**
 * 段子详情api
 * Created by 兰昊琼 on 2018/6/5.
 */

public class JokeDetailApi {
    private static JokeDetailApi jokeDetailApi;
    private ApiService apiService;

    private JokeDetailApi(ApiService apiService) {
        this.apiService = apiService;
    }

    public static JokeDetailApi getJokeDetailApi(ApiService apiService) {
        if (jokeDetailApi == null) {
            jokeDetailApi = new JokeDetailApi(apiService);
        }
        return jokeDetailApi;
    }

    public Observable<JokeDetailBean> getJokeDetail(String jid) {
        return apiService.getJokeDetail(jid);
    }
}
