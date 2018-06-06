package com.example.administrator.teamyikezhong.module;

import com.example.administrator.teamyikezhong.net.AdApi;
import com.example.administrator.teamyikezhong.net.Api;
import com.example.administrator.teamyikezhong.net.ApiService;
import com.example.administrator.teamyikezhong.net.CommonParamsInterceptor;
import com.example.administrator.teamyikezhong.net.DuanZiApi;
import com.example.administrator.teamyikezhong.net.VideosApi;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */
@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient.Builder()
                .writeTimeout(200, TimeUnit.SECONDS)
                .readTimeout(200, TimeUnit.SECONDS)
               .connectTimeout(100, TimeUnit.SECONDS);
    }
    @Provides
    AdApi provideAdApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        return AdApi.getAdApi(apiService);
    }
    @Provides
    VideosApi provideVideosApi(OkHttpClient.Builder builder) {
        builder.addInterceptor(new CommonParamsInterceptor());//添加拦截器
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        return VideosApi.getVideosApi(apiService);
    }
    @Provides
    DuanZiApi provideDuanZiApi(OkHttpClient.Builder builder) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        return DuanZiApi.getDuanZiApi(apiService);
    }
}
