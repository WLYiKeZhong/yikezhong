package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.AdBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public interface ApiService {
 @GET("quarter/getAd")
    Observable<AdBean> getAd();
}
