package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.FollowUsersBean;
import com.example.administrator.teamyikezhong.bean.HotFollowBean;
import com.example.administrator.teamyikezhong.bean.MyCollectionBean;

import io.reactivex.Observable;
import retrofit2.http.Field;

/**
 * Created by Administrator on 2018/6/6 0006.
 */

public class UsersFollowApi {
    private static UsersFollowApi usersFollowApi;
    private UsersFollowApiService usersFollowApiService;
    private UsersFollowApi(UsersFollowApiService usersFollowApiService) {
        this.usersFollowApiService=usersFollowApiService;
    }

    public static UsersFollowApi getUsersFollowApi(UsersFollowApiService usersFollowApiService){
        if (usersFollowApi==null){
            usersFollowApi=new UsersFollowApi(usersFollowApiService);
        }
        return usersFollowApi;
    }

    public Observable<FollowUsersBean> getFollowUsers(String uid, String token){
        return usersFollowApiService.getFollowUsers(uid,token);
    }
    public Observable<HotFollowBean> getHotVideos( String page, String token){
        return usersFollowApiService.getHotVideos(page, token);
    }
    public  Observable<MyCollectionBean> getFavorites(String uid,String token){
        return usersFollowApiService.getFavorites(uid,token);
    }
}
