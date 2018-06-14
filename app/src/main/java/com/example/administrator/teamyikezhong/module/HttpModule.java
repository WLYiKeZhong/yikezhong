package com.example.administrator.teamyikezhong.module;

import com.example.administrator.teamyikezhong.net.AdApi;
import com.example.administrator.teamyikezhong.net.Api;
import com.example.administrator.teamyikezhong.net.ApiService;
import com.example.administrator.teamyikezhong.net.CommonParamsInterceptor;
import com.example.administrator.teamyikezhong.net.DetailApi;
import com.example.administrator.teamyikezhong.net.DuanZiApi;
import com.example.administrator.teamyikezhong.net.HotVideosApi;
import com.example.administrator.teamyikezhong.net.JokeDetailApi;
import com.example.administrator.teamyikezhong.net.NearVideosApi;
import com.example.administrator.teamyikezhong.net.ProjectApi;
import com.example.administrator.teamyikezhong.net.ProjectApiService;
import com.example.administrator.teamyikezhong.net.ShouCangApi;
import com.example.administrator.teamyikezhong.net.TongYongApi;
import com.example.administrator.teamyikezhong.net.UsersFollowApi;
import com.example.administrator.teamyikezhong.net.UsersFollowApiService;
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
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
    }
    //轮播图api
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
//注册api
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
    //推荐视频api
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
    //段子api
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

    @Provides
    HotVideosApi provideHotVideosApi(OkHttpClient.Builder builder) {
        builder.addInterceptor(new CommonParamsInterceptor());//添加拦截器
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        return HotVideosApi.getHotVideosApi(apiService);
    }
    @Provides
    NearVideosApi provideNearVideosApi(OkHttpClient.Builder builder) {
        builder.addInterceptor(new CommonParamsInterceptor());//添加拦截器
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        return NearVideosApi.getNearVideosApi(apiService);
    }
    @Provides
    DetailApi provideDetailApi(OkHttpClient.Builder builder) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        return DetailApi.getDetailApi(apiService);
    }
    @Provides
    JokeDetailApi provideJokeDetailApi(OkHttpClient.Builder builder) {
        builder.addInterceptor(new CommonParamsInterceptor());//添加拦截器
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        return JokeDetailApi.getJokeDetailApi(apiService);
    }
    @Provides
    ShouCangApi provideShouCangApi(OkHttpClient.Builder builder) {
        builder.addInterceptor(new CommonParamsInterceptor());//添加拦截器
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        return ShouCangApi.getTongYongApi(apiService);
    }
    @Provides
    TongYongApi provideTongYongApi(OkHttpClient.Builder builder) {
        builder.addInterceptor(new CommonParamsInterceptor());//添加拦截器
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        return TongYongApi.getTongYongApi(apiService);
    }
}
