package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.RegBean;
import com.example.administrator.teamyikezhong.bean.UpdatePassBean;
import com.example.administrator.teamyikezhong.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public interface ProjectApiService {
    @FormUrlEncoded
    @POST("user/login")
    Observable<UserBean> login(@Field("mobile") String mobile,
                               @Field("password") String password);

    //注册
    @FormUrlEncoded
    @POST("quarter/register")
    Observable<RegBean> reg(@Field("mobile") String mobile,
                            @Field("password") String password);

    @FormUrlEncoded
    @POST("quarter/getPass")
    Observable<UpdatePassBean> getPass(@Field("mobile") String mobile, @Field("newPass") String newPass);

}
