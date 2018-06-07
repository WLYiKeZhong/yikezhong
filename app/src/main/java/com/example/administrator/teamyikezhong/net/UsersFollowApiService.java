package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.FollowUsersBean;
import com.example.administrator.teamyikezhong.bean.HotFollowBean;
import com.example.administrator.teamyikezhong.bean.MyCollectionBean;
import com.example.administrator.teamyikezhong.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2018/6/6 0006.
 */

public interface UsersFollowApiService {
    @FormUrlEncoded
    @POST("quarter/getFollowUsers")
    Observable<FollowUsersBean> getFollowUsers(@Field("uid") String uid,
                                      @Field("token") String token);
    @FormUrlEncoded
    @POST("quarter/getHotVideos")
    Observable<HotFollowBean> getHotVideos(@Field("page") String page,
                                             @Field("token") String token);

    @FormUrlEncoded
    @POST("quarter/getFavorites")
    Observable<MyCollectionBean> getFavorites(@Field("uid") String uid,@Field("token") String token);

}
