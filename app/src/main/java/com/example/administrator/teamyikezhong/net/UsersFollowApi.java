package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.BaseBean;
import com.example.administrator.teamyikezhong.bean.FollowUsersBean;
import com.example.administrator.teamyikezhong.bean.FriendsBean;
import com.example.administrator.teamyikezhong.bean.HotFollowBean;
import com.example.administrator.teamyikezhong.bean.MyCollectionBean;
import com.example.administrator.teamyikezhong.bean.SouFriendsBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.Part;

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
    public  Observable<FriendsBean> randomFriends(){
        return usersFollowApiService.randomFriends();
    }
    public  Observable<SouFriendsBean> searchFriends(String keywords){
        return usersFollowApiService.searchFriends(keywords);
    }

    public  Observable<BaseBean> publishJoke( String uid,  String token,  String content){
        return usersFollowApiService.publishJoke(uid, token, content);
    }

    public  Observable<BaseBean> publishVideo( RequestBody uid, MultipartBody.Part videoFile, MultipartBody.Part coverFile, RequestBody token){
        return usersFollowApiService.publishVideo(uid, videoFile, coverFile,token);
    }

}
