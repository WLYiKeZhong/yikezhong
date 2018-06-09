package com.example.administrator.teamyikezhong.mypage.friends;

import com.example.administrator.teamyikezhong.bean.FriendsBean;
import com.example.administrator.teamyikezhong.bean.MyCollectionBean;
import com.example.administrator.teamyikezhong.bean.SouFriendsBean;
import com.example.administrator.teamyikezhong.mypage.collection.CollectionContract;
import com.example.administrator.teamyikezhong.ui.base.BaseContract;

/**
 * Created by Administrator on 2018/6/8 0008.
 */

public interface FriendsContract {
    interface view extends BaseContract.BaseView{
        void randomFriends(FriendsBean friendsBean);
        void searchFriends(SouFriendsBean souFriendsBean);
    }
    interface presenter extends BaseContract.BasePersenter<view> {
        void randomFriends();
        void searchFriends(String keywords);
    }
}
