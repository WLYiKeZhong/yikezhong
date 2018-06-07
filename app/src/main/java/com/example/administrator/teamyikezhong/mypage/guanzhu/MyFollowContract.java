package com.example.administrator.teamyikezhong.mypage.guanzhu;

import com.example.administrator.teamyikezhong.bean.FollowUsersBean;

import com.example.administrator.teamyikezhong.ui.base.BaseContract;

/**
 * Created by Administrator on 2018/6/6 0006.
 */

public interface MyFollowContract {
    interface view extends BaseContract.BaseView{
        void getFollowUsers(FollowUsersBean followUsersBean);

    }
    interface presenter extends BaseContract.BasePersenter<view> {
        void getFollowUsers(String uid, String token);

    }
}
