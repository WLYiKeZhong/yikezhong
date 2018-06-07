package com.example.administrator.teamyikezhong.mypage.collection;

import com.example.administrator.teamyikezhong.bean.FollowUsersBean;
import com.example.administrator.teamyikezhong.bean.MyCollectionBean;
import com.example.administrator.teamyikezhong.mypage.guanzhu.MyFollowContract;
import com.example.administrator.teamyikezhong.ui.base.BaseContract;

/**
 * Created by Administrator on 2018/6/7 0007.
 */

public interface CollectionContract {
    interface view extends BaseContract.BaseView{
        void getFavorites(MyCollectionBean myCollectionBean);

    }
    interface presenter extends BaseContract.BasePersenter<view> {
        void getFavorites(String uid,String token);

    }
}
