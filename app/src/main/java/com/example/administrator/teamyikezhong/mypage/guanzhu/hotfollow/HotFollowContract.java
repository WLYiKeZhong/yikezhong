package com.example.administrator.teamyikezhong.mypage.guanzhu.hotfollow;


import com.example.administrator.teamyikezhong.bean.HotFollowBean;

import com.example.administrator.teamyikezhong.ui.base.BaseContract;

import java.util.List;

/**
 * Created by Administrator on 2018/6/7 0007.
 */

public interface HotFollowContract {
    interface view extends BaseContract.BaseView{
        void getHotVideos(HotFollowBean hotFollowBean);

    }
    interface presenter extends BaseContract.BasePersenter<view> {
        void getHotVideos(String page, String token);

    }
}
