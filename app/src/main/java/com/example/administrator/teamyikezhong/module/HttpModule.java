package com.example.administrator.teamyikezhong.module;

import com.example.administrator.teamyikezhong.net.AdApi;
import com.example.administrator.teamyikezhong.net.Api;
import com.example.administrator.teamyikezhong.net.ApiService;
import com.example.administrator.teamyikezhong.net.CommonParamsInterceptor;
import com.example.administrator.teamyikezhong.net.DuanZiApi;
import com.example.administrator.teamyikezhong.net.UsersFollowApi;
import com.example.administrator.teamyikezhong.net.UsersFollowApiService;
import com.example.administrator.teamyikezhong.net.VideosApi;
import com.example.administrator.teamyikezhong.net.ProjectApi;
import com.example.administrator.teamyikezhong.net.ProjectApiService;

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
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
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
    ProjectApi provideProjectApi(OkHttpClient.Builder builder){



        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ProjectApiService projectApiService = retrofit.create(ProjectApiService.class);
        return ProjectApi.getProjectApi(projectApiService);


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
        builder.addInterceptor(new CommonParamsInterceptor());//添加拦截器
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        return DuanZiApi.getDuanZiApi(apiService);
    }

    @Provides
    UsersFollowApi provideUsersFollowApi(OkHttpClient.Builder builder){
        builder.addInterceptor(new CommonParamsInterceptor());//添加拦截器
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        UsersFollowApiService usersFollowApiService = retrofit.create(UsersFollowApiService.class);
        return UsersFollowApi.getUsersFollowApi(usersFollowApiService);
    }

}
